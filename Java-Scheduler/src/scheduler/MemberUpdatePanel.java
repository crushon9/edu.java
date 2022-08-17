package scheduler;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberUpdatePanel extends JFrame {

	private JButton btnPwck;
	private JButton btnDelete, btnUpdate;
	private JTextField textPw, textPw2;
	private JPanel memberUpdatePane;
	private int resultPw;

	public MemberUpdatePanel(String id, MemberDAOImple memberDao) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		memberUpdatePane = new JPanel();
		memberUpdatePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		memberUpdatePane.setLayout(null);
		setContentPane(memberUpdatePane);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(60, 90, 100, 20);
		memberUpdatePane.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(60, 130, 100, 20);
		memberUpdatePane.add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm PW");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw2.setBounds(60, 170, 100, 20);
		memberUpdatePane.add(lblPw2);

		JLabel lblGetId = new JLabel(id);
		lblGetId.setForeground(new Color(255, 0, 51));
		lblGetId.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblGetId.setBounds(180, 90, 110, 20);
		memberUpdatePane.add(lblGetId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(180, 130, 110, 20);
		memberUpdatePane.add(textPw);

		textPw2 = new JTextField();
		textPw2.setColumns(10);
		textPw2.setBounds(180, 170, 110, 20);
		memberUpdatePane.add(textPw2);

		btnPwck = new JButton("Check");
		btnPwck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPw = pwCheck();
				if (resultPw == 1) {
					btnUpdate.setEnabled(true);
				}
			}
		});
		btnPwck.setBounds(300, 170, 70, 20);
		btnPwck.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPwck.setBackground(new Color(204, 204, 255));
		memberUpdatePane.add(btnPwck);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberUpdate(id, memberDao);
			}
		});
		btnUpdate.setBounds(140, 230, 80, 30);
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setBackground(new Color(172, 172, 172));
		btnUpdate.setEnabled(false);
		memberUpdatePane.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberDelete(id, memberDao);
			}
		});
		btnDelete.setBounds(250, 230, 80, 30);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnDelete.setBackground(new Color(172, 172, 172));
		memberUpdatePane.add(btnDelete);

	} // MemberUpdateFrame 생성자

	private int pwCheck() {
		int resultPw = 0;
		if (textPw.getText().equals(textPw2.getText()) && !textPw2.getText().equals("")) {
			dialogPanel dialogPane = new dialogPanel("비밀번호 일치");
			dialogPane.setVisible(true);
			resultPw = 1;
		} else {
			dialogPanel dialogPane = new dialogPanel("비밀번호가 일치하지 않습니다!");
			dialogPane.setVisible(true);
		}
		return resultPw;
	} // end pwCheck

	private void memberUpdate(String id, MemberDAOImple memberDao) {
		MemberVO vo = new MemberVO(id, textPw2.getText());
		int result = memberDao.update(vo);
		if (result == 1) {
			dialogPanel dialogPane = new dialogPanel("비밀번호 수정 성공!");
			dialogPane.setVisible(true);
			dispose();
		} else {
			dialogPanel dialogPane = new dialogPanel("수정 실패!");
			dialogPane.setVisible(true);
		}
	} // end memberUpdate

	private void memberDelete(String id, MemberDAOImple memberDao) {
		int result = memberDao.delete(id);
		if (result == 1) {
			dialogPanel dialogPane = new dialogPanel("삭제 성공!");
			dialogPane.setVisible(true);
			dispose();
		} else {
			dialogPanel dialogPane = new dialogPanel("삭제 실패!");
			dialogPane.setVisible(true);
		}
	} // end memberDelete

}
