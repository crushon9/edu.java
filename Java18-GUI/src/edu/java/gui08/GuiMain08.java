package edu.java.gui08;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GuiMain08 {

	private JFrame frame;
	private static final ImageIcon[] IMAGE_ICONS = { new ImageIcon("res/dog1.jpg"), new ImageIcon("res\\dog2.jpg"),
			new ImageIcon("res\\dog3.jpg"), new ImageIcon("res\\dog4.jpg"), new ImageIcon("res\\dog5.jpg"), };
	private int index;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain08 window = new GuiMain08();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // end main()

	/**
	 * Create the application.
	 */
	public GuiMain08() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 432, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOutput = new JLabel();
		lblOutput.setIcon(IMAGE_ICONS[0]);
		lblOutput.setForeground(new Color(255, 0, 204));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(12, 10, 390, 236);
		frame.getContentPane().add(lblOutput);

		JButton btnPrev = new JButton("이전");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index > 0) {
					index--;
				} else {
					index = IMAGE_ICONS.length - 1;
				}
				lblOutput.setIcon(IMAGE_ICONS[index]);
			}
		});
		btnPrev.setBackground(new Color(255, 204, 255));
		btnPrev.setFont(new Font("궁서", Font.BOLD, 42));
		btnPrev.setBounds(12, 270, 120, 100);
		frame.getContentPane().add(btnPrev);

		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index < IMAGE_ICONS.length - 1) {
					index++;
				} else {
					index = 0;
				}
				lblOutput.setIcon(IMAGE_ICONS[index]);
			}
		});
		btnNext.setBackground(new Color(255, 204, 255));
		btnNext.setFont(new Font("궁서", Font.BOLD, 42));
		btnNext.setBounds(282, 270, 120, 100);
		frame.getContentPane().add(btnNext);

		JButton btnRandom = new JButton("랜덤");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = (int) (Math.random() * IMAGE_ICONS.length);
				lblOutput.setIcon(IMAGE_ICONS[index]);
			}
		});
		btnRandom.setBackground(new Color(153, 204, 255));
		btnRandom.setFont(new Font("궁서", Font.BOLD, 42));
		btnRandom.setBounds(148, 270, 120, 100);
		frame.getContentPane().add(btnRandom);
	} // end initialize

}
