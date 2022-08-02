package edu.java.gui05;

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

public class GuiMain05 {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain05 window = new GuiMain05();
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
	public GuiMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 26));
		textArea.setBackground(new Color(204, 204, 255));
		textArea.setBounds(12, 57, 410, 182);
		frame.getContentPane().add(textArea);

		JRadioButton rdbtnAgree = new JRadioButton("동의");
		buttonGroup.add(rdbtnAgree);
		rdbtnAgree.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		rdbtnAgree.setBounds(59, 28, 121, 23);
		rdbtnAgree.setSelected(true);
		rdbtnAgree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(rdbtnAgree.getText());
			}
		});
		frame.getContentPane().add(rdbtnAgree);

		JRadioButton rdbtnReject = new JRadioButton("거절");
		buttonGroup.add(rdbtnReject);
		rdbtnReject.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		rdbtnReject.setBounds(274, 28, 121, 23);
		rdbtnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(rdbtnReject.getText());
			}
		});
		frame.getContentPane().add(rdbtnReject);

	}
}
