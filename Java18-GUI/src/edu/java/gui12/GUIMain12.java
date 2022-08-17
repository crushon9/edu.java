package edu.java.gui12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMain12 {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain12 window = new GUIMain12();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * Create the application.
	 */
	public GUIMain12() {
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

		setTextField(new JTextField());
		getTextField().setBounds(12, 37, 408, 103);
		frame.getContentPane().add(getTextField());
		getTextField().setColumns(10);

		JButton btnNewButton = new JButton("New Frame");
		btnNewButton.setBounds(54, 170, 333, 68);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// textField 입력된 데이터를 myFrame - btnNewButton의 text에 적용
				// 매개변수를 text로 해서 생성자에 넘겨서 처리하는 코드
//				String text = getTextField().getText();
//				MyFrame myFrame = new MyFrame(text);
//				textField.setText(text); 
				frame.setVisible(false);

				// 매개변수로 frame을 넘겨서 처리하는 코드
				MyFrame myFrame = new MyFrame(frame);
				myFrame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton);
	}

}
