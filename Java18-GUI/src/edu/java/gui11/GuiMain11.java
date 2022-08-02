package edu.java.gui11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.FormatFlagsConversionMismatchException;
import java.awt.event.ActionEvent;

public class GuiMain11 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain11 window = new GuiMain11();
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
	public GuiMain11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 443, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btn1 = new JButton("New Frame");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JFrame myFrame = new JFrame(); // 이렇게 하면 디자인창에서 편집이 불가함
//				myFrame.setBounds(10, 10, 400, 400);
//				myFrame.setVisible(true);

				// 새로운 프레임, 다이얼로그를 생성할 때
				// 각 클래스를 상속받는 자식 클래스를 만들어 사용하는 것이 편의성 좋음
				MyFrame myFrame = new MyFrame();
				myFrame.setVisible(true); // 메인에서 setVisible-true
				frame.setVisible(false); // 메인 프레임을 안보이게
			}
		});
		btn1.setFont(new Font("굴림", Font.BOLD, 30));
		btn1.setBounds(12, 40, 400, 70);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("New Dialog");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 다이얼로그 호출
				MyDialog myDialog = new MyDialog(); // 객체만 생성해도 바로 setVisible-true
			}
		});
		btn2.setFont(new Font("굴림", Font.BOLD, 30));
		btn2.setBounds(12, 150, 400, 70);
		frame.getContentPane().add(btn2);
	}

}
