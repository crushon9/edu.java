package scheduler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MemberFrame {

	JFrame memberFrame;
	JTextField textId, textPw;
	JButton btnLogin, btnJoin, btnUpdate;

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
		btnLogin.setForeground(new Color(105, 105, 105));
		btnLogin.setBackground(new Color(204, 204, 255));
		btnLogin.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnLogin.setBounds(480, 180, 80, 50);
		memberFrame.getContentPane().add(btnLogin);

		btnJoin = new JButton("Join");
		btnJoin.setForeground(new Color(204, 204, 255));
		btnJoin.setBackground(new Color(128, 128, 128));
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnJoin.setBounds(330, 260, 80, 30);
		memberFrame.getContentPane().add(btnJoin);

		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(204, 204, 255));
		btnUpdate.setBackground(new Color(128, 128, 128));
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnUpdate.setBounds(430, 260, 80, 30);
		memberFrame.getContentPane().add(btnUpdate);

	}
}
