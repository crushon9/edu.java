package scheduler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MemberMainFrame extends JFrame {

	JFrame frame;
	JPanel memberPanel;
	private JTextField textId, textPw;
	private JButton btnLogin, btnJoin, btnUpdate;
	JTextArea textAreaLog;
	MemberDAOImple memberDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMainFrame window = new MemberMainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemberMainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 860, 600);
		frame.setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		frame.setResizable(false); // 창크기 고정

		memberPanel = new JPanel();
		memberPanel.setBackground(SystemColor.control);
		memberPanel.setLayout(null);
		frame.getContentPane().add(memberPanel);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(290, 180, 30, 20);
		memberPanel.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(290, 210, 30, 20);
		memberPanel.add(lblPw);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(330, 180, 130, 20);
		memberPanel.add(textId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(330, 210, 130, 20);
		memberPanel.add(textPw);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBackground(new Color(204, 204, 255));
		btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnLogin.setBounds(480, 180, 80, 50);
		memberPanel.add(btnLogin);

		btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getjoinPanel();
			}
		});
		btnJoin.setBackground(new Color(172, 172, 172));
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnJoin.setBounds(330, 260, 80, 30);
		memberPanel.add(btnJoin);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUpdatePanel();
			}
		});
		btnUpdate.setBackground(new Color(172, 172, 172));
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setBounds(430, 260, 80, 30);
		memberPanel.add(btnUpdate);

		textAreaLog = new JTextArea();
		textAreaLog.setForeground(new Color(0, 0, 204));
		textAreaLog.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textAreaLog.setBackground(SystemColor.control);
		textAreaLog.setBounds(12, 10, 368, 24);
		memberPanel.add(textAreaLog);
		memberDao = MemberDAOImple.getInstance(textAreaLog);

	}

	private void login() {
		if (textId.getText().equals("") || textPw.getText().equals("")) {
			DialogPanel dialogPanel = new DialogPanel("로그인 정보를 입력하세요!");
			dialogPanel.setVisible(true);
			return;
		}
		String inputId = textId.getText();
		String inputPw = textPw.getText();
		ArrayList<MemberVO> list = memberDao.select();
		int IdExistFlag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(inputId)) {
				IdExistFlag = 1;
				break;
			}
		}
		if (IdExistFlag == 1) {
			String DBPw = memberDao.select(textId.getText()).getPw();
			if (DBPw.equals(inputPw)) {
				CalendarPanel calendarPanel = new CalendarPanel(inputId);
				calendarPanel.setVisible(true);
				frame.setVisible(false);

			} else {
				DialogPanel dialogPanel = new DialogPanel("비밀번호를 확인하세요!");
				dialogPanel.setVisible(true);
			}
		} else {
			DialogPanel dialogPanel = new DialogPanel("존재하지 않는 아이디입니다!");
			dialogPanel.setVisible(true);
		}

	} // end login

	private void getjoinPanel() {
		MemberJoinPanel joinPanel = new MemberJoinPanel(memberDao);
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
		ArrayList<MemberVO> list = memberDao.select();
		int IdExistFlag = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(inputId)) {
				IdExistFlag = 1;
				break;
			}
		}
		if (IdExistFlag == 1) {
			String DBPw = memberDao.select(textId.getText()).getPw();
			if (DBPw.equals(inputPw)) {
				MemberUpdatePanel updatePanel = new MemberUpdatePanel(inputId, memberDao);
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
