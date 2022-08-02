package edu.java.gui09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiMain09 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain09 window = new GuiMain09();
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
	public GuiMain09() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 205, 263, 120);
		frame.getContentPane().add(textArea);

		JLabel lblhead = new JLabel("취미");
		lblhead.setForeground(new Color(51, 51, 255));
		lblhead.setFont(new Font("굴림", Font.PLAIN, 20));
		lblhead.setHorizontalAlignment(SwingConstants.CENTER);
		lblhead.setBounds(12, 10, 263, 42);
		frame.getContentPane().add(lblhead);

		JCheckBox chckbxMusic = new JCheckBox("음악");
		chckbxMusic.setBounds(50, 60, 100, 20);
		chckbxMusic.setFont(new Font("굴림", Font.PLAIN, 12));
		frame.getContentPane().add(chckbxMusic);

		JCheckBox chckbxMovie = new JCheckBox("영화");
		chckbxMovie.setBounds(50, 90, 100, 20);
		chckbxMovie.setFont(new Font("굴림", Font.PLAIN, 12));
		frame.getContentPane().add(chckbxMovie);

		JCheckBox chckbxReading = new JCheckBox("독서");
		chckbxReading.setFont(new Font("굴림", Font.PLAIN, 12));
		chckbxReading.setBounds(50, 120, 100, 20);
		frame.getContentPane().add(chckbxReading);

		JButton btnOutput = new JButton("출력");
		btnOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "음악 : " + chckbxMusic.isSelected() + "\n" + "영화 : " + chckbxMovie.isSelected() + "\n"
						+ "독서 : " + chckbxReading.isSelected() + "\n";
				textArea.setText(result);
			}
		});
		btnOutput.setFont(new Font("굴림", Font.PLAIN, 12));
		btnOutput.setBackground(new Color(204, 255, 255));
		btnOutput.setBounds(94, 160, 97, 30);
		frame.getContentPane().add(btnOutput);

		JCheckBox chckbxTest = new JCheckBox("출력 비활성화");
		chckbxTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxTest.isSelected()) { // 선택되었는지 아닌지
					btnOutput.setEnabled(false); // 활성화, 비활성화
				} else {
					btnOutput.setEnabled(true);
				}
			}
		});
		chckbxTest.setFont(new Font("굴림", Font.PLAIN, 12));
		chckbxTest.setBounds(150, 60, 100, 20);
		frame.getContentPane().add(chckbxTest);

	}
}
