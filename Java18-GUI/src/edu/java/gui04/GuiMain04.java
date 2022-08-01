package edu.java.gui04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMain04 {

	private JFrame frame;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextArea textArea;
	private double num1, num2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain04 window = new GuiMain04();
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
	public GuiMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		int lblwidth = 100;
		int txtwidth = 220;
		int height = 60;
		int btnlength = 70;
		int Space = 20;
		Font lblFont = new Font("맑은 고딕", Font.ITALIC, 20);
		Font btnFont = new Font("맑은 고딕", Font.BOLD, 40);
		Font outputFont = new Font("맑은 고딕", Font.BOLD, 20);

		JLabel lblNum1 = new JLabel("Number1");
		lblNum1.setFont(lblFont);
		lblNum1.setBounds(Space, Space, lblwidth, height);
		frame.getContentPane().add(lblNum1);

		JLabel lblNum2 = new JLabel("Number2");
		lblNum2.setFont(lblFont);
		lblNum2.setBounds(Space, Space + height, lblwidth, height);
		frame.getContentPane().add(lblNum2);

		txtNum1 = new JTextField();
		txtNum1.setBounds(2 * Space + lblwidth, Space, txtwidth, height);
		txtNum1.setColumns(1);
		txtNum1.setFont(outputFont);
		frame.getContentPane().add(txtNum1);

		txtNum2 = new JTextField();
		txtNum2.setBounds(2 * Space + lblwidth, Space + height, txtwidth, height);
		txtNum2.setColumns(1);
		txtNum2.setFont(outputFont);
		frame.getContentPane().add(txtNum2);

		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(Space, 160, btnlength, btnlength);
		btnPlus.setFont(btnFont);
		btnPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					num1 = Double.parseDouble(txtNum1.getText());
					num2 = Double.parseDouble(txtNum2.getText());
					textArea.append(num1 + " + " + num2 + " = " + (num1 + num2) + "\n");
				} catch (Exception e2) {
					textArea.setText("실수 형태로 입력하세요!\n");
				}
			}
		});
		frame.getContentPane().add(btnPlus);

		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(2 * Space + btnlength, 160, btnlength, btnlength);
		btnMinus.setFont(btnFont);
		btnMinus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					num1 = Double.parseDouble(txtNum1.getText());
					num2 = Double.parseDouble(txtNum2.getText());
					textArea.append(num1 + " - " + num2 + " = " + (num1 - num2) + "\n");
				} catch (Exception e2) {
					textArea.setText("실수 형태로 입력하세요!\n");
				}
			}
		});
		frame.getContentPane().add(btnMinus);

		JButton btnMultiply = new JButton("*");
		btnMultiply.setBounds(3 * Space + 2 * btnlength, 160, btnlength, btnlength);
		btnMultiply.setFont(btnFont);
		btnMultiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					num1 = Double.parseDouble(txtNum1.getText());
					num2 = Double.parseDouble(txtNum2.getText());
					textArea.append(num1 + " * " + num2 + " = " + (num1 * num2) + "\n");
				} catch (Exception e2) {
					textArea.setText("실수 형태로 입력하세요!\n");
				}
			}
		});
		frame.getContentPane().add(btnMultiply);

		JButton btnDevide = new JButton("/");
		btnDevide.setBounds(4 * Space + 3 * btnlength, 160, btnlength, btnlength);
		btnDevide.setFont(btnFont);
		btnDevide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					num1 = Double.parseDouble(txtNum1.getText());
					num2 = Double.parseDouble(txtNum2.getText());
					if (num2 != 0) {
						textArea.append(num1 + " / " + num2 + " = " + (Math.round((num1 / num2) * 100) / 100.0) + "\n");
					} else {
						textArea.setText("분모가 0입니다.\n");
					}
				} catch (Exception e2) {
					textArea.setText("실수 형태로 입력하세요!\n");
				}
			}
		});
		frame.getContentPane().add(btnDevide);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(Space, 160 + btnlength + Space, 340, 180);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setColumns(10);
		textArea.setFont(outputFont);

	}
}