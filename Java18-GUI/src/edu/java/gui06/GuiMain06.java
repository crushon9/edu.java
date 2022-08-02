package edu.java.gui06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GuiMain06 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain06 window = new GuiMain06();
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
	public GuiMain06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setBackground(new Color(204, 204, 255));
		textArea.setBounds(12, 95, 410, 144);
		frame.getContentPane().add(textArea);

		JRadioButton rdbtnMale = new JRadioButton("남자");
		rdbtnMale.setBackground(new Color(220, 220, 220));
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdbtnMale.setBounds(54, 16, 100, 23);
		rdbtnMale.setSelected(true);
		frame.getContentPane().add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("여자");
		rdbtnFemale.setBackground(new Color(220, 220, 220));
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		rdbtnFemale.setBounds(298, 16, 100, 23);
		frame.getContentPane().add(rdbtnFemale);

		JButton btnCheck = new JButton("확인");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMale.isSelected()) {
					textArea.setText("성별 : " + rdbtnMale.getText());
				} else {
					textArea.setText("성별 : " + rdbtnFemale.getText());
				}
			}
		});
		btnCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnCheck.setForeground(new Color(0, 0, 0));
		btnCheck.setBackground(new Color(255, 153, 255));
		btnCheck.setBounds(166, 49, 97, 23);
		frame.getContentPane().add(btnCheck);

	}
}
