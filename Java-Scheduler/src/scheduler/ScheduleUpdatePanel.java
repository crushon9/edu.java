package scheduler;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

class ScheduleUpdatePanel extends JFrame {
	private JPanel ScheduleUpdatePanel;
	private JLabel lblDate, lblTime, lblText, lblColor, lblDatePrint;
	private JButton btnUpdate, btnDelete;
	private JTextField textTxt;
	private JComboBox<String> comboTime;
	private String[] times = { "AM 00", "AM 01", "AM 02", "AM 03", "AM 04", "AM 05", "AM 06", "AM 07", "AM 08", "AM 09",
			"AM 10", "AM 11", "AM 12", "PM 01", "PM 02", "PM 03", "PM 04", "PM 05", "PM 06", "PM 07", "PM 08", "PM 09",
			"PM 10", "PM 11" };
	private JToggleButton tglbtnColor0, tglbtnColor1, tglbtnColor2, tglbtnColor3, tglbtnColor4;
	private int whatTglbtnColor;
	private ButtonGroup tglGroup = new ButtonGroup();

	public ScheduleUpdatePanel(ScheduleDAOImple sDAO, ScheduleVO sVOu) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setLocationRelativeTo(null);
		ScheduleUpdatePanel = new JPanel();
		ScheduleUpdatePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		ScheduleUpdatePanel.setLayout(null);
		setContentPane(ScheduleUpdatePanel);
		// 정보 이름 라벨
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblDate.setBounds(60, 50, 60, 20);
		ScheduleUpdatePanel.add(lblDate);
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblTime.setBounds(60, 100, 60, 20);
		ScheduleUpdatePanel.add(lblTime);
		lblText = new JLabel("Text");
		lblText.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblText.setBounds(60, 150, 60, 20);
		ScheduleUpdatePanel.add(lblText);
		lblColor = new JLabel("Color");
		lblColor.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblColor.setBounds(60, 200, 60, 20);
		ScheduleUpdatePanel.add(lblColor);
		// 클릭한날짜출력
		lblDatePrint = new JLabel(sVOu.getYear() + "-" + sVOu.getMonth() + "-" + sVOu.getDate());
		lblDatePrint.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblDatePrint.setForeground(new Color(255, 0, 51));
		lblDatePrint.setBounds(130, 50, 130, 20);
		ScheduleUpdatePanel.add(lblDatePrint);
		// 시간선택 콤보박스
		comboTime = new JComboBox<String>(times);
		comboTime.setBounds(130, 100, 80, 20);
		comboTime.setSelectedIndex(sVOu.getTime());
		ScheduleUpdatePanel.add(comboTime);
		// 일정내용 입력
		textTxt = new JTextField(sVOu.getText());
		textTxt.setBounds(130, 150, 130, 20);
		textTxt.setColumns(10);
		textTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (tglGroup.getSelection() != null)
					btnUpdate.setEnabled(true);
			}
		});
		ScheduleUpdatePanel.add(textTxt);
		// 일정 색상선택 버튼

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
				if (!textTxt.getText().equals(""))
					btnUpdate.setEnabled(true);
			}
		});
		ScheduleUpdatePanel.add(tglbtnColor0);
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
				if (!textTxt.getText().equals(""))
					btnUpdate.setEnabled(true);
			}
		});
		ScheduleUpdatePanel.add(tglbtnColor1);
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
				if (!textTxt.getText().equals(""))
					btnUpdate.setEnabled(true);
			}
		});
		ScheduleUpdatePanel.add(tglbtnColor2);
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
				if (!textTxt.getText().equals(""))
					btnUpdate.setEnabled(true);
			}
		});
		ScheduleUpdatePanel.add(tglbtnColor3);
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
				if (!textTxt.getText().equals(""))
					btnUpdate.setEnabled(true);
			}
		});
		ScheduleUpdatePanel.add(tglbtnColor4);
		tglGroup.add(tglbtnColor0);
		tglGroup.add(tglbtnColor1);
		tglGroup.add(tglbtnColor2);
		tglGroup.add(tglbtnColor3);
		tglGroup.add(tglbtnColor4);
		tglGroup.clearSelection();
		// 수정버튼
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(105, 270, 80, 30);
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setBackground(new Color(204, 204, 255));
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sVOu.setTime(comboTime.getSelectedIndex());
				sVOu.setText(textTxt.getText());
				sVOu.setColorIdx(whatTglbtnColor);
				int result = sDAO.update(sVOu);
				if (result == 1) {
					DialogPanel dialogPanel = new DialogPanel("수정 성공!");
					dialogPanel.setVisible(true);
					dispose();
					CalendarPanel.searchByDate(sVOu.getYear(), sVOu.getMonth(), sVOu.getDate());
				} else {
					DialogPanel dialogPanel = new DialogPanel("수정 실패");
					dialogPanel.setVisible(true);
				}
			}
		});
		ScheduleUpdatePanel.add(btnUpdate);
		// 삭제버튼
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(195, 270, 80, 30);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnDelete.setBackground(new Color(204, 204, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = sDAO.delete(sVOu.getSeqNo());
				if (result == 1) {
					DialogPanel dialogPanel = new DialogPanel("삭제 성공!");
					dialogPanel.setVisible(true);
					dispose();
					CalendarPanel.searchByDate(sVOu.getYear(), sVOu.getMonth(), sVOu.getDate());
				} else {
					DialogPanel dialogPanel = new DialogPanel("삭제 실패");
					dialogPanel.setVisible(true);
				}
			}
		});
		ScheduleUpdatePanel.add(btnDelete);

	}

}
