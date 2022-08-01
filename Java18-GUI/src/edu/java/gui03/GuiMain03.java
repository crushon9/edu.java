package edu.java.gui03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiMain03 {

	private JFrame frame;
	private JTextField txtName, txtPhone, txtEmail, txtOutput; // 멤버변수로 선언하면 순서상관없이 밑에서 늘 접근가능
	private JButton btnInsert;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain03 window = new GuiMain03();
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
	public GuiMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Absolute layout으로 설정

		// 레이블 디자인
		int lblWidth = 245; // 레이블 넓이
		int lblHeight = 76; // 레이블 높이
		Font lblFont = new Font("굴림", Font.BOLD, 48); // 레이블 폰트

		JLabel lblName = new JLabel("이름"); // 지역변수로 선언하면 선언된 순서에 영향받음
		lblName.setOpaque(true); // 배경색 설정을 위한 세팅 true
		lblName.setBackground(new Color(255, 170, 200));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(lblFont);
		lblName.setBounds(12, 10, lblWidth, lblHeight);
		frame.getContentPane().add(lblName);

		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setOpaque(true);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(lblFont);
		lblPhone.setBackground(new Color(140, 251, 152));
		lblPhone.setBounds(12, 96, lblWidth, lblHeight);
		frame.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(lblFont);
		lblEmail.setBackground(new Color(120, 150, 250));
		lblEmail.setBounds(12, 182, lblWidth, lblHeight);
		frame.getContentPane().add(lblEmail);

		// 텍스트필드 디자인
		int txtWidth = 633;
		int txtHeight = 76;
		Font txtFont = new Font("맑은 고딕", Font.PLAIN, 30);

		txtName = new JTextField();
		txtName.setFont(txtFont);
		txtName.setBounds(269, 10, txtWidth, txtHeight);
		txtName.setColumns(10); // 최대입력갯수
		frame.getContentPane().add(txtName); // 생성한 txtName 프레임에 추가함

		txtPhone = new JTextField();
		txtPhone.setFont(txtFont);
		txtPhone.setBounds(269, 96, txtWidth, txtHeight);
		txtPhone.setColumns(10);
		frame.getContentPane().add(txtPhone);

		txtEmail = new JTextField();
		txtEmail.setFont(txtFont);
		txtEmail.setBounds(269, 182, txtWidth, txtHeight);
		txtEmail.setColumns(10);
		frame.getContentPane().add(txtEmail);

		// 버튼 디자인
		btnInsert = new JButton("정보 출력");
		btnInsert.setBounds(12, 268, 890, 100);
		btnInsert.setFont(txtFont);
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 기능 구현
				String name = txtName.getText();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				String msg = "이름 : " + name + "\n" + "전화번호 : " + phone + "\n" + "이메일 : " + email + "\n"; // 개행적용안됨..
				txtOutput.setText(msg);
				textArea.setText(msg);
			}
		});
		frame.getContentPane().add(btnInsert);

		txtOutput = new JTextField();
		txtOutput.setBounds(12, 378, 890, 100);
		txtOutput.setFont(txtFont);
		txtOutput.setColumns(10);
		frame.getContentPane().add(txtOutput);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 488, 890, 100);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(txtFont);

	}
}
