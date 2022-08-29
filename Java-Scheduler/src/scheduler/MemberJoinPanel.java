package scheduler;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MemberJoinPanel extends JFrame {

	private JButton btnJoin, btnIdck, btnPwck;
	private JTextField textId, textPw1, textPw2;
	private JPanel memberJoinPanel;
	private int resultId, resultPw;

	public MemberJoinPanel(MemberDAOImple mDao) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		memberJoinPanel = new JPanel();
		memberJoinPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		memberJoinPanel.setLayout(null);
		setContentPane(memberJoinPanel);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(60, 90, 100, 20);
		memberJoinPanel.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(60, 130, 100, 20);
		memberJoinPanel.add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm PW");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw2.setBounds(60, 170, 100, 20);
		memberJoinPanel.add(lblPw2);

		textId = new JTextField();
		textId.setBounds(180, 90, 110, 20);
		memberJoinPanel.add(textId);
		textId.setColumns(10);

		textPw1 = new JTextField();
		textPw1.setColumns(10);
		textPw1.setBounds(180, 130, 110, 20);
		memberJoinPanel.add(textPw1);

		textPw2 = new JTextField();
		textPw2.setColumns(10);
		textPw2.setBounds(180, 170, 110, 20);
		memberJoinPanel.add(textPw2);

		btnJoin = new JButton("Join");
		btnJoin.setEnabled(false);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberJoin(mDao);
			}
		});
		btnJoin.setBounds(190, 230, 80, 30);
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnJoin.setBackground(new Color(172, 172, 172));
		memberJoinPanel.add(btnJoin);

		btnIdck = new JButton("Check");
		btnIdck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultId = idCheck(mDao);
				if (resultId == 1 && resultPw == 1) {
					btnJoin.setEnabled(true);
				}
			}
		});
		btnIdck.setBounds(300, 90, 70, 20);
		btnIdck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnIdck.setBackground(new Color(204, 204, 255));
		memberJoinPanel.add(btnIdck);

		btnPwck = new JButton("Check");
		btnPwck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPw = pwCheck();
				if (resultId == 1 && resultPw == 1) {
					btnJoin.setEnabled(true);
				}
			}
		});
		btnPwck.setBounds(300, 170, 70, 20);
		btnPwck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPwck.setBackground(new Color(204, 204, 255));
		memberJoinPanel.add(btnPwck);
	} // MemberJoinFrame 생성자

	private int idCheck(MemberDAOImple mDao) {
		int resultId = 0;
		String inputId = textId.getText();
		if (inputId.equals("")) {
			DialogPanel dialogPanel = new DialogPanel("아이디를 입력해주세요!");
			dialogPanel.setVisible(true);
			return resultId;
		}
		try {
			MemberVO mVo = mDao.select(inputId);
			if (mVo.getId().equals(inputId)) {
				DialogPanel dialogPanel = new DialogPanel("이미 가입된 아이디입니다!");
				dialogPanel.setVisible(true);
				textId.setText("");
			} else {
				DialogPanel dialogPanel = new DialogPanel("가입 가능한 아이디입니다");
				dialogPanel.setVisible(true);
				resultId = 1;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return resultId;
	} // end idCheck

	private int pwCheck() {
		int resultPw = 0;
		if (textPw1.getText().equals("") || textPw2.getText().equals("")) {
			DialogPanel dialogPanel = new DialogPanel("비밀번호를 입력해주세요!");
			dialogPanel.setVisible(true);
			return resultPw;
		}
		if (textPw1.getText().equals(textPw2.getText())) {
			DialogPanel dialogPanel = new DialogPanel("비밀번호 일치");
			dialogPanel.setVisible(true);
			resultPw = 1;
		} else {
			DialogPanel dialogPanel = new DialogPanel("비밀번호가 일치하지 않습니다!");
			dialogPanel.setVisible(true);
		}
		return resultPw;
	} // end pwCheck

	private void memberJoin(MemberDAOImple mDao) {
		String inputId = textId.getText();
		String inputPw = textPw2.getText();
		MemberVO vo = new MemberVO(inputId, inputPw);
		int result = mDao.insert(vo);
		if (result == 1) {
			DialogPanel dialogPanel = new DialogPanel("가입 성공!");
			dialogPanel.setVisible(true);
			dispose();
		} else {
			DialogPanel dialogPanel = new DialogPanel("가입 실패");
			dialogPanel.setVisible(true);
		}
	} // end memberJoin
}
