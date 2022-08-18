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

class DialogPanel extends JFrame {

	private JPanel dialogPanel;

	public DialogPanel(String txt) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 280, 140);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		dialogPanel = new JPanel();
		dialogPanel.setBackground(new Color(200, 200, 200));
		dialogPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		dialogPanel.setLayout(null);
		setContentPane(dialogPanel);

		JLabel lblId = new JLabel(txt);
		lblId.setBounds(32, 25, 200, 20);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		dialogPanel.add(lblId);

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
		dialogPanel.add(btn);

	}
}
