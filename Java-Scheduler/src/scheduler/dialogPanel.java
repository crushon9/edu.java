package scheduler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class dialogPanel extends JFrame {

	private JPanel dialogPane;

	public dialogPanel(String txt) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 140);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		dialogPane = new JPanel();
		dialogPane.setBackground(new Color(172, 172, 172));
		dialogPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		dialogPane.setLayout(null);
		setContentPane(dialogPane);

		JLabel lblId = new JLabel(txt);
		lblId.setBounds(32, 25, 200, 20);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		dialogPane.add(lblId);

		JButton btn = new JButton("OK");
		btn.setBounds(97, 65, 70, 20);
		btn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn.setForeground(Color.WHITE);
		btn.setBackground(new Color(160, 160, 255));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		dialogPane.add(btn);

	}
}
