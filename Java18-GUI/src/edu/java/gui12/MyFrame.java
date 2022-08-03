package edu.java.gui12;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	public MyFrame(JFrame frame) { // 이게 생성자였어;; 매개변수도 가능하네?
		// JFrame.EXIT_ON_CLOSE : 프로그램 전체 종료
		// JFrame.DISPOSE_ON_CLOSE : 현재 창만 종료
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
// frame.getContentPane()과 동일 왜냐면 클래스가 JFrame아니깐 그 밑에 바로 contentPane이 있음
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 매개변수로 받은 frame을 getContentPane 하여, Component중 첫번재로 추가된 textField를 리턴
		// 리턴한 값을 형변환하여 txtfd에 담는다
		JTextField txtfd = (JTextField) frame.getContentPane().getComponent(0);

		JButton btnNewButton = new JButton(txtfd.getText());
		btnNewButton.setText(txtfd.getText());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfd.setText("안녕");
			}
		});
		btnNewButton.setBounds(78, 80, 270, 115);
		contentPane.add(btnNewButton);
	}

}
