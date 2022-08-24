package scheduler;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MemberPanel extends JPanel {

	JPanel memberPanel;
	private JTextField textId, textPw;
	private JButton btnLogin, btnJoin, btnUpdate;
	JTextArea textAreaLog;
	MemberDAOImple mDao;

	public MemberPanel(JFrame frame) {
		memberPanel = new JPanel();
		memberPanel.setBackground(new Color(230, 230, 230));
		memberPanel.setLayout(null);
		frame.getContentPane().add(memberPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 860, 670);
		frame.revalidate();
		frame.repaint();

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(290, 200, 30, 20);
		memberPanel.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(290, 230, 30, 20);
		memberPanel.add(lblPw);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(330, 200, 130, 20);
		memberPanel.add(textId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(330, 230, 130, 20);
		memberPanel.add(textPw);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (login() == 1) {
					frame.getContentPane().remove(memberPanel);
					frame.revalidate();
					frame.repaint();
					CalendarPanel calendarPanel = new CalendarPanel(frame, textId.getText());
					frame.setLocationRelativeTo(null);
				}
			}
		});
		btnLogin.setBackground(new Color(204, 204, 255));
		btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnLogin.setBounds(480, 200, 80, 50);
		memberPanel.add(btnLogin);

		btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getjoinPanel();
			}
		});
		btnJoin.setBackground(new Color(172, 172, 172));
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnJoin.setBounds(330, 300, 80, 30);
		memberPanel.add(btnJoin);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUpdatePanel();
			}
		});
		btnUpdate.setBackground(new Color(172, 172, 172));
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setBounds(430, 300, 80, 30);
		memberPanel.add(btnUpdate);

		textAreaLog = new JTextArea();
		textAreaLog.setForeground(new Color(0, 0, 204));
		textAreaLog.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textAreaLog.setBackground(new Color(230, 230, 230));
		textAreaLog.setBounds(12, 10, 368, 24);
		memberPanel.add(textAreaLog);
		mDao = MemberDAOImple.getInstance(textAreaLog);

	}

	private int login() {
		int result = 0;
		if (textId.getText().equals("") || textPw.getText().equals("")) {
			DialogPanel dialogPanel = new DialogPanel("로그인 정보를 입력하세요!");
			dialogPanel.setVisible(true);
			return result;
		}
		String inputId = textId.getText();
		String inputPw = textPw.getText();
		ArrayList<MemberVO> list = mDao.select();
		int IdExistFlag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(inputId)) {
				IdExistFlag = 1;
				break;
			}
		}
		if (IdExistFlag == 1) {
			String DBPw = mDao.select(textId.getText()).getPw();
			if (DBPw.equals(inputPw)) {
				result = 1;
			} else {
				DialogPanel dialogPanel = new DialogPanel("비밀번호를 확인하세요!");
				dialogPanel.setVisible(true);
			}
		} else {
			DialogPanel dialogPanel = new DialogPanel("존재하지 않는 아이디입니다!");
			dialogPanel.setVisible(true);
		}
		return result;
	} // end login

	private void getjoinPanel() {
		MemberJoinPanel joinPanel = new MemberJoinPanel(mDao);
		joinPanel.setVisible(true);
	} // end getJoinFrame

	private void getUpdatePanel() {
		if (textId.getText().equals("") || textPw.getText().equals("")) {
			DialogPanel dialogPanel = new DialogPanel("로그인 정보를 입력하세요!");
			dialogPanel.setVisible(true);
			return;
		}
		String inputId = textId.getText();
		String inputPw = textPw.getText();
		ArrayList<MemberVO> list = mDao.select();
		int IdExistFlag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(inputId)) {
				IdExistFlag = 1;
				break;
			}
		}
		if (IdExistFlag == 1) {
			String DBPw = mDao.select(textId.getText()).getPw();
			if (DBPw.equals(inputPw)) {
				MemberUpdatePanel updatePanel = new MemberUpdatePanel(inputId, mDao);
				updatePanel.setVisible(true);
			} else {
				DialogPanel dialogPanel = new DialogPanel("비밀번호를 확인하세요1");
				dialogPanel.setVisible(true);
			}
		} else {
			DialogPanel dialogPanel = new DialogPanel("존재하지 않는 아이디입니다!");
			dialogPanel.setVisible(true);
		}
	} // end getUpdateFrame
}
