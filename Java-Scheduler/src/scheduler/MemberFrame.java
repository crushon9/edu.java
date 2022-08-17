package scheduler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MemberFrame extends JFrame {

	JFrame memberFrame;
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
					MemberFrame window = new MemberFrame();
					window.memberFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemberFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		memberFrame = new JFrame();
		memberFrame.getContentPane().setBackground(SystemColor.control);
		memberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memberFrame.setBounds(100, 100, 860, 600);
		memberFrame.setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		memberFrame.setResizable(false); // 창크기 고정
		memberFrame.getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(105, 105, 105));
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(290, 180, 30, 20);
		memberFrame.getContentPane().add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setForeground(new Color(105, 105, 105));
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(290, 210, 30, 20);
		memberFrame.getContentPane().add(lblPw);

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(330, 180, 130, 20);
		memberFrame.getContentPane().add(textId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(330, 210, 130, 20);
		memberFrame.getContentPane().add(textPw);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setForeground(new Color(105, 105, 105));
		btnLogin.setBackground(new Color(204, 204, 255));
		btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnLogin.setBounds(480, 180, 80, 50);
		memberFrame.getContentPane().add(btnLogin);

		btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				joinFrame();
			}
		});
		btnJoin.setForeground(new Color(204, 204, 255));
		btnJoin.setBackground(new Color(128, 128, 128));
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnJoin.setBounds(330, 260, 80, 30);
		memberFrame.getContentPane().add(btnJoin);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFrame();
			}
		});
		btnUpdate.setForeground(new Color(204, 204, 255));
		btnUpdate.setBackground(new Color(128, 128, 128));
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setBounds(430, 260, 80, 30);
		memberFrame.getContentPane().add(btnUpdate);

		textAreaLog = new JTextArea();
		textAreaLog.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textAreaLog.setBackground(SystemColor.control);
		textAreaLog.setBounds(12, 10, 368, 24);
		memberFrame.getContentPane().add(textAreaLog);
		memberDao = MemberDAOImple.getInstance(textAreaLog);

	}

	private void login() {
		if (textId.getText().equals("") || textPw.getText().equals("")) {
			JOptionPane.showMessageDialog(memberFrame, "로그인 정보를 입력하세요");
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
				JOptionPane.showMessageDialog(memberFrame, "로그인 성공");
				// TODO
			} else {
				JOptionPane.showMessageDialog(memberFrame, "비밀번호를 확인하세요");
			}
		} else {
			JOptionPane.showMessageDialog(memberFrame, "존재하지 않는 아이디입니다");
		}

	} // end login

	private void joinFrame() {
		MemberJoinFrame joinFrame = new MemberJoinFrame(memberDao);
		joinFrame.setVisible(true);
	} // end joinFrame

	private void updateFrame() {
		if (textId.getText().equals("") || textPw.getText().equals("")) {
			JOptionPane.showMessageDialog(memberFrame, "로그인 정보를 입력하세요");
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
				MemberUpdateFrame updateFrame = new MemberUpdateFrame(inputId, memberDao);
				updateFrame.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(memberFrame, "비밀번호를 확인하세요");
			}
		} else {
			JOptionPane.showMessageDialog(memberFrame, "존재하지 않는 아이디입니다");
		}
	} // end updateFrame
}
