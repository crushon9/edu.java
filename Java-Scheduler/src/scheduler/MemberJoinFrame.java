package scheduler;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class MemberJoinFrame {

	JFrame memberJoinFrame;
	JButton btnJoin, btnId, btnPw;
	JTextField textId, textPw, textPw2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberJoinFrame window = new MemberJoinFrame();
					window.memberJoinFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemberJoinFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		memberJoinFrame = new JFrame();
		memberJoinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memberJoinFrame.setBounds(100, 100, 500, 400);
		memberJoinFrame.setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		memberJoinFrame.setResizable(false); // 창크기 고정
		memberJoinFrame.getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(SystemColor.controlDkShadow);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(60, 90, 100, 20);
		memberJoinFrame.getContentPane().add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setForeground(SystemColor.controlDkShadow);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(60, 130, 100, 20);
		memberJoinFrame.getContentPane().add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm PW");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw2.setForeground(SystemColor.controlDkShadow);
		lblPw2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw2.setBounds(60, 170, 100, 20);
		memberJoinFrame.getContentPane().add(lblPw2);

		textId = new JTextField();
		textId.setBounds(180, 90, 110, 20);
		memberJoinFrame.getContentPane().add(textId);
		textId.setColumns(10);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(180, 130, 110, 20);
		memberJoinFrame.getContentPane().add(textPw);

		textPw2 = new JTextField();
		textPw2.setColumns(10);
		textPw2.setBounds(180, 170, 110, 20);
		memberJoinFrame.getContentPane().add(textPw2);

		btnJoin = new JButton("Join");
		btnJoin.setBounds(190, 230, 90, 20);
		btnJoin.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnJoin.setForeground(new Color(105, 105, 105));
		btnJoin.setBackground(new Color(204, 204, 255));
		memberJoinFrame.getContentPane().add(btnJoin);

		btnId = new JButton("Check");
		btnId.setBounds(300, 90, 70, 20);
		btnId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnId.setForeground(new Color(105, 105, 105));
		btnId.setBackground(new Color(204, 204, 255));
		memberJoinFrame.getContentPane().add(btnId);

		btnPw = new JButton("Check");
		btnPw.setBounds(300, 170, 70, 20);
		btnPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPw.setForeground(new Color(105, 105, 105));
		btnPw.setBackground(new Color(204, 204, 255));
		memberJoinFrame.getContentPane().add(btnPw);
	}

}
