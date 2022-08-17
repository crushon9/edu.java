package scheduler;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MemberJoinPanel extends JFrame {

	private JButton btnJoin, btnId, btnPw;
	private JTextField textId, textPw, textPw2;
	private JPanel memberJoinPane;
	private int resultId, resultPw;

	public MemberJoinPanel(MemberDAOImple memberDao) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		memberJoinPane = new JPanel();
		memberJoinPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		memberJoinPane.setLayout(null);
		setContentPane(memberJoinPane);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(SystemColor.controlDkShadow);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(60, 90, 100, 20);
		memberJoinPane.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setForeground(SystemColor.controlDkShadow);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(60, 130, 100, 20);
		memberJoinPane.add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm PW");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw2.setForeground(SystemColor.controlDkShadow);
		lblPw2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw2.setBounds(60, 170, 100, 20);
		memberJoinPane.add(lblPw2);

		textId = new JTextField();
		textId.setBounds(180, 90, 110, 20);
		memberJoinPane.add(textId);
		textId.setColumns(10);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(180, 130, 110, 20);
		memberJoinPane.add(textPw);

		textPw2 = new JTextField();
		textPw2.setColumns(10);
		textPw2.setBounds(180, 170, 110, 20);
		memberJoinPane.add(textPw2);

		btnJoin = new JButton("Join");
		btnJoin.setEnabled(false);
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberJoin(memberDao);
			}
		});
		btnJoin.setBounds(190, 230, 90, 20);
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnJoin.setForeground(new Color(105, 105, 105));
		btnJoin.setBackground(new Color(204, 204, 255));
		memberJoinPane.add(btnJoin);

		btnId = new JButton("Check");
		btnId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultId = idCheck(memberDao);
				if (resultId == 1 && resultPw == 1) {
					btnJoin.setEnabled(true);
				}
			}
		});
		btnId.setBounds(300, 90, 70, 20);
		btnId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnId.setForeground(new Color(105, 105, 105));
		btnId.setBackground(new Color(204, 204, 255));
		memberJoinPane.add(btnId);

		btnPw = new JButton("Check");
		btnPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPw = pwCheck();
				if (resultId == 1 && resultPw == 1) {
					btnJoin.setEnabled(true);
				}
			}
		});
		btnPw.setBounds(300, 170, 70, 20);
		btnPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPw.setForeground(new Color(105, 105, 105));
		btnPw.setBackground(new Color(204, 204, 255));
		memberJoinPane.add(btnPw);
	} // MemberJoinFrame 생성자

	private int idCheck(MemberDAOImple memberDao) {
		int resultId = 0;
		String inputId = textId.getText();
		if (inputId.equals("")) {
			JOptionPane.showMessageDialog(memberJoinPane, "아이디를 입력해주세요");
			return resultId;
		}
		ArrayList<MemberVO> list;
		try {
			list = memberDao.select();
			int IdExistFlag = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId().equals(inputId)) {
					IdExistFlag = 1;
					break;
				}
			}
			if (IdExistFlag == 1) {
				JOptionPane.showMessageDialog(memberJoinPane, "이미 가입된 아이디입니다");
				textId.setText("");
			} else {
				JOptionPane.showMessageDialog(memberJoinPane, "가입 가능한 아이디입니다");
				resultId = 1;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return resultId;
	} // end idCheck

	private int pwCheck() {
		int resultPw = 0;
		if (textPw.getText().equals(textPw2.getText()) && !textPw2.getText().equals("")) {
			JOptionPane.showMessageDialog(memberJoinPane, "비밀번호가 일치합니다");
			resultPw = 1;
		} else {
			JOptionPane.showMessageDialog(memberJoinPane, "비밀번호가 일치하지 않습니다");
		}
		return resultPw;
	} // end pwCheck

	private void memberJoin(MemberDAOImple memberDao) {
		String inputId = textId.getText();
		String inputPw = textPw2.getText();
		MemberVO vo = new MemberVO(inputId, inputPw);
		int result = memberDao.insert(vo);
		if (result == 1) {
			JOptionPane.showMessageDialog(memberJoinPane, "가입 성공");
			dispose();
		} else {
			JOptionPane.showMessageDialog(memberJoinPane, "가입 실패");
		}
	} // end memberJoin
}
