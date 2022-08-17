package scheduler;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MemberUpdateFrame {

	JFrame memberUpdateFrame;
	JButton btnJoin, btnId, btnPw;
	private JButton btnDelete;
	private JButton btnUpdate;
	JTextField textPw, textPw2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUpdateFrame window = new MemberUpdateFrame();
					window.memberUpdateFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemberUpdateFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		memberUpdateFrame = new JFrame();
		memberUpdateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		memberUpdateFrame.setBounds(100, 100, 500, 400);
		memberUpdateFrame.setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		memberUpdateFrame.setResizable(false); // 창크기 고정
		memberUpdateFrame.getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(SystemColor.controlDkShadow);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(60, 90, 100, 20);
		memberUpdateFrame.getContentPane().add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setForeground(SystemColor.controlDkShadow);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(60, 130, 100, 20);
		memberUpdateFrame.getContentPane().add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm PW");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw2.setForeground(SystemColor.controlDkShadow);
		lblPw2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw2.setBounds(60, 170, 100, 20);
		memberUpdateFrame.getContentPane().add(lblPw2);

		JLabel lblGetId = new JLabel("???");
		lblGetId.setBounds(180, 90, 110, 20);
		memberUpdateFrame.getContentPane().add(lblGetId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(180, 130, 110, 20);
		memberUpdateFrame.getContentPane().add(textPw);

		textPw2 = new JTextField();
		textPw2.setColumns(10);
		textPw2.setBounds(180, 170, 110, 20);
		memberUpdateFrame.getContentPane().add(textPw2);

		btnPw = new JButton("Check");
		btnPw.setBounds(300, 170, 70, 20);
		btnPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPw.setForeground(new Color(105, 105, 105));
		btnPw.setBackground(new Color(204, 204, 255));
		memberUpdateFrame.getContentPane().add(btnPw);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(190, 220, 90, 20);
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setForeground(new Color(105, 105, 105));
		btnUpdate.setBackground(new Color(204, 204, 255));
		memberUpdateFrame.getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setBounds(190, 260, 90, 20);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnDelete.setForeground(new Color(105, 105, 105));
		btnDelete.setBackground(new Color(204, 204, 255));
		memberUpdateFrame.getContentPane().add(btnDelete);

	}

}
