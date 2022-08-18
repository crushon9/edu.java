package scheduler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

class ScheduleAddPanel extends JFrame {

	private JPanel scheduleAddPanel;
	private JLabel lblDate, lblTime, lblText, lblColor, lblDatePrint;
	private JButton btnOKAdd;
	private JTextField textTxt;
	private JComboBox<String> comboTime;
	private String[] times = { "AM 00", "AM 01", "AM 02", "AM 03", "AM 04", "AM 05", "AM 06", "AM 07", "AM 08", "AM 09",
			"AM 10", "AM 11", "AM 12", "PM 01", "PM 02", "PM 03", "PM 04", "PM 05", "PM 06", "PM 07", "PM 08", "PM 09",
			"PM 10", "PM 11" };
	private JToggleButton tglbtnColor;

	public ScheduleAddPanel() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setLocationRelativeTo(null);
		scheduleAddPanel = new JPanel();
		scheduleAddPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		scheduleAddPanel.setLayout(null);
		setContentPane(scheduleAddPanel);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblDate.setBounds(60, 50, 60, 20);
		scheduleAddPanel.add(lblDate);

		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblTime.setBounds(60, 100, 60, 20);
		scheduleAddPanel.add(lblTime);

		lblText = new JLabel("Text");
		lblText.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblText.setBounds(60, 150, 60, 20);
		scheduleAddPanel.add(lblText);

		lblColor = new JLabel("Color");
		lblColor.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblColor.setBounds(60, 200, 60, 20);
		scheduleAddPanel.add(lblColor);

		lblDatePrint = new JLabel("???");
		lblDatePrint.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblDatePrint.setForeground(new Color(255, 0, 51));
		lblDatePrint.setBounds(130, 50, 100, 20);
		scheduleAddPanel.add(lblDatePrint);

		comboTime = new JComboBox<String>(times);
		comboTime.setBounds(130, 100, 100, 20);
		scheduleAddPanel.add(comboTime);

		textTxt = new JTextField();
		textTxt.setBounds(130, 150, 100, 20);
		scheduleAddPanel.add(textTxt);
		textTxt.setColumns(10);

		tglbtnColor = new JToggleButton("");
		tglbtnColor.setBounds(130, 200, 100, 20);
		scheduleAddPanel.add(tglbtnColor);

		btnOKAdd = new JButton("OK");
		btnOKAdd.setBounds(150, 270, 80, 30);
		scheduleAddPanel.add(btnOKAdd);
	}
}
