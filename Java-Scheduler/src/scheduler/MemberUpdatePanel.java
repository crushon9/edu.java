package scheduler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JPanel memberUpdatePanel;
	private int resultPw;

	public MemberUpdatePanel(String id, MemberDAOImple mDao) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		memberUpdatePanel = new JPanel();
		memberUpdatePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		memberUpdatePanel.setLayout(null);
		setContentPane(memberUpdatePanel);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(60, 90, 100, 20);
		memberUpdatePanel.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(60, 130, 100, 20);
		memberUpdatePanel.add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm PW");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw2.setBounds(60, 170, 100, 20);
		memberUpdatePanel.add(lblPw2);

		JLabel lblGetId = new JLabel(id);
		lblGetId.setForeground(new Color(255, 0, 51));
		lblGetId.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblGetId.setBounds(180, 90, 110, 20);
		memberUpdatePanel.add(lblGetId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(180, 130, 110, 20);
		memberUpdatePanel.add(textPw);

		textPw2 = new JTextField();
		textPw2.setColumns(10);
		textPw2.setBounds(180, 170, 110, 20);
		memberUpdatePanel.add(textPw2);

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
		memberUpdatePanel.add(btnPwck);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberUpdate(id, mDao);
			}
		});
		btnUpdate.setBounds(140, 230, 80, 30);
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setBackground(new Color(172, 172, 172));
		btnUpdate.setEnabled(false);
		memberUpdatePanel.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberDelete(id, mDao);
			}
		});
		btnDelete.setBounds(250, 230, 80, 30);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnDelete.setBackground(new Color(172, 172, 172));
		memberUpdatePanel.add(btnDelete);

	} // MemberUpdateFrame 생성자

	private int pwCheck() {
		int resultPw = 0;
		if (textPw.getText().equals(textPw2.getText()) && !textPw2.getText().equals("")) {
			DialogPanel dialogPanel = new DialogPanel("비밀번호 일치");
			dialogPanel.setVisible(true);
			resultPw = 1;
		} else {
			DialogPanel dialogPanel = new DialogPanel("비밀번호가 일치하지 않습니다!");
			dialogPanel.setVisible(true);
		}
		return resultPw;
	} // end pwCheck

	private void memberUpdate(String id, MemberDAOImple memberDao) {
		MemberVO vo = new MemberVO(id, textPw2.getText());
		int result = memberDao.update(vo);
		if (result == 1) {
			DialogPanel dialogPanel = new DialogPanel("비밀번호 수정 성공!");
			dialogPanel.setVisible(true);
			dispose();
		} else {
			DialogPanel dialogPanel = new DialogPanel("수정 실패!");
			dialogPanel.setVisible(true);
		}
	} // end memberUpdate

	private void memberDelete(String id, MemberDAOImple memberDao) {
		int result = memberDao.delete(id);
		if (result == 1) {
			ScheduleDAOImple sDAO = ScheduleDAOImple.getInstance();
			sDAO.delete(id);
			DialogPanel dialogPanel = new DialogPanel("관련 데이터 삭제 성공!");
			dialogPanel.setVisible(true);
			dispose();
		} else {
			DialogPanel dialogPanel = new DialogPanel("삭제 실패!");
			dialogPanel.setVisible(true);
		}
	} // end memberDelete

}
