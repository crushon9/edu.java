package edu.java.gui07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class GuiMain07 {

	private JFrame frame;
	private static final String[] STRINGS = { "L1. 심청미", "L2. 유훈재", "L3-1. 이호", "L3-2. 백운종", "L4. 임희지", "R0-1. 김승현",
			"R0-2. 조성환", "R0-3. 최진홍", "R1-1. 이충호", "R1-2. 공봉석", "R2-1. 김병훈", "R2-2. 김성현", "R3. 한병훈", "R4-1. 이소연",
			"R4-2. 김시원", };
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain07 window = new GuiMain07();
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
	public GuiMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOutput = new JLabel("New label");
		lblOutput.setText(STRINGS[0]);
		lblOutput.setForeground(new Color(255, 0, 204));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("궁서", Font.BOLD, 42));
		lblOutput.setBounds(12, 10, 400, 100);
		frame.getContentPane().add(lblOutput);

		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 0) {
					index--;
				} else {
					index = STRINGS.length - 1;
				}
				lblOutput.setText(STRINGS[index]);
			}
		});
		btnPrev.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		btnPrev.setBackground(new Color(255, 204, 255));
		btnPrev.setFont(new Font("궁서", Font.BOLD, 42));
		btnPrev.setBounds(14, 135, 120, 100);
		frame.getContentPane().add(btnPrev);

		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < STRINGS.length - 1) {
					index++;
				} else {
					index = 0;
				}
				lblOutput.setText(STRINGS[index]);
			}
		});
		btnNext.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		btnNext.setBackground(new Color(255, 204, 255));
		btnNext.setFont(new Font("궁서", Font.BOLD, 42));
		btnNext.setBounds(282, 135, 120, 100);
		frame.getContentPane().add(btnNext);

		JButton btnRandom = new JButton("랜덤");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = (int) (Math.random() * 15);
				lblOutput.setText(STRINGS[index]);
			}
		});
		btnRandom.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		btnRandom.setFont(new Font("궁서", Font.BOLD, 42));
		btnRandom.setBackground(new Color(153, 204, 255));
		btnRandom.setBounds(148, 135, 120, 100);
		frame.getContentPane().add(btnRandom);
	}
}
