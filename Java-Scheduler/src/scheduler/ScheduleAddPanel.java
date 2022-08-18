package scheduler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
	private JToggleButton tglbtnColor0, tglbtnColor1, tglbtnColor2, tglbtnColor3, tglbtnColor4;
	private int whatTglbtnColor;

	public ScheduleAddPanel(String selectDate, ScheduleDAOImple sDAO, ScheduleVO sVO) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setLocationRelativeTo(null);
		scheduleAddPanel = new JPanel();
		scheduleAddPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		scheduleAddPanel.setLayout(null);
		setContentPane(scheduleAddPanel);
		// 정보 이름 라벨
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
		// 클릭한날짜출력
		lblDatePrint = new JLabel(selectDate);
		lblDatePrint.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblDatePrint.setForeground(new Color(255, 0, 51));
		lblDatePrint.setBounds(130, 50, 130, 20);
		scheduleAddPanel.add(lblDatePrint);
		// 시간선택 콤보박스
		comboTime = new JComboBox<String>(times);
		comboTime.setBounds(130, 100, 80, 20);
		scheduleAddPanel.add(comboTime);
		// 일정내용 입력
		textTxt = new JTextField();
		textTxt.setBounds(130, 150, 130, 20);
		scheduleAddPanel.add(textTxt);
		textTxt.setColumns(10);
		// 일정 색상선택 버튼
		ButtonGroup tglGroup = new ButtonGroup();
		tglbtnColor0 = new JToggleButton("");
		tglbtnColor0.setBounds(130, 200, 20, 20);
		tglbtnColor0.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tglbtnColor0.setBackground(new Color(255, 153, 153));
		tglbtnColor0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnColor0.setText("V");
				tglbtnColor1.setText("");
				tglbtnColor2.setText("");
				tglbtnColor3.setText("");
				tglbtnColor4.setText("");
				whatTglbtnColor = 0;
			}
		});
		scheduleAddPanel.add(tglbtnColor0);
		tglbtnColor1 = new JToggleButton("");
		tglbtnColor1.setBounds(150, 200, 20, 20);
		tglbtnColor1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tglbtnColor1.setBackground(new Color(255, 255, 153));
		tglbtnColor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnColor1.setText("V");
				tglbtnColor0.setText("");
				tglbtnColor2.setText("");
				tglbtnColor3.setText("");
				tglbtnColor4.setText("");
				whatTglbtnColor = 1;
			}
		});
		scheduleAddPanel.add(tglbtnColor1);
		tglbtnColor2 = new JToggleButton("");
		tglbtnColor2.setBounds(170, 200, 20, 20);
		tglbtnColor2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tglbtnColor2.setBackground(new Color(153, 255, 170));
		tglbtnColor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnColor2.setText("V");
				tglbtnColor0.setText("");
				tglbtnColor1.setText("");
				tglbtnColor3.setText("");
				tglbtnColor4.setText("");
				whatTglbtnColor = 2;
			}
		});
		scheduleAddPanel.add(tglbtnColor2);
		tglbtnColor3 = new JToggleButton("");
		tglbtnColor3.setBounds(190, 200, 20, 20);
		tglbtnColor3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tglbtnColor3.setBackground(new Color(153, 204, 255));
		tglbtnColor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnColor3.setText("V");
				tglbtnColor0.setText("");
				tglbtnColor1.setText("");
				tglbtnColor2.setText("");
				tglbtnColor4.setText("");
				whatTglbtnColor = 3;
			}
		});
		scheduleAddPanel.add(tglbtnColor3);
		tglbtnColor4 = new JToggleButton("");
		tglbtnColor4.setBounds(210, 200, 20, 20);
		tglbtnColor4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		tglbtnColor4.setBackground(new Color(220, 220, 220));
		tglbtnColor4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnColor4.setText("V");
				tglbtnColor0.setText("");
				tglbtnColor1.setText("");
				tglbtnColor2.setText("");
				tglbtnColor3.setText("");
				whatTglbtnColor = 4;
			}
		});
		scheduleAddPanel.add(tglbtnColor4);
		tglGroup.add(tglbtnColor0);
		tglGroup.add(tglbtnColor1);
		tglGroup.add(tglbtnColor2);
		tglGroup.add(tglbtnColor3);
		tglGroup.add(tglbtnColor4);
		tglGroup.clearSelection();
		// 완료등록버튼
		btnOKAdd = new JButton("OK");
		btnOKAdd.setBounds(150, 270, 80, 30);
		btnOKAdd.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnOKAdd.setBackground(new Color(204, 204, 255));
		btnOKAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectDate.charAt(6) == '-') {
					sVO.setYear(Integer.parseInt(selectDate.substring(0, 4)));
					sVO.setMonth(Integer.parseInt(selectDate.substring(5, 6)));
					sVO.setDate(Integer.parseInt(selectDate.substring(8)));
				} else {
					sVO.setYear(Integer.parseInt(selectDate.substring(0, 4)));
					sVO.setMonth(Integer.parseInt(selectDate.substring(5, 7)));
					sVO.setDate(Integer.parseInt(selectDate.substring(9)));
				}
				sVO.setTime(comboTime.getSelectedIndex());
				sVO.setText(textTxt.getText());
				sVO.setColorIdx(whatTglbtnColor);

				int result = sDAO.insert(sVO);
				if (result == 1) {
					DialogPanel dialogPanel = new DialogPanel("등록 성공!");
					dialogPanel.setVisible(true);
					dispose();
				} else {
					DialogPanel dialogPanel = new DialogPanel("등록 실패");
					dialogPanel.setVisible(true);
				}
			}
		});
		scheduleAddPanel.add(btnOKAdd);

	}
}
