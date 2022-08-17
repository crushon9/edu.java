package scheduler;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CalendarPanel extends JFrame {

	JPanel calendarPane;// 메인판넬

	JButton todayBtn;
	JLabel todayLbl;
	JButton prevYearBtn, prevMonBtn, nextMonBtn, nextYearBtn;
	ListenerMoveDate listenMoveBtn = new ListenerMoveDate(); // 이벤트 컨트롤 객체

	JLabel curMMYYYYLbl;

	JPanel calPanel; // 달력판넬
	JButton weekHeadBtn[] = new JButton[7];
	JButton dateBtns[][] = new JButton[6][7];
	ListenerDateBtns listenDateBtn = new ListenerDateBtns(); // 이벤트 컨트롤 객체

	JTable Jtable;
	DefaultTableModel JtableModel;
	String[] JtableHead = { "Done", "Time", "Text", "Update" };
	JLabel JtableDateLbl;

	final String WEEK_HEAD[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	private JButton insertBtn;
	private JTextField searchText;
	private JLabel lblCurId;

	public CalendarPanel(String curId) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 600);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		calendarPane = new JPanel();
		calendarPane.setLayout(null);
		setContentPane(calendarPane);
		CalendarSet.setToday();

		lblCurId = new JLabel(" > " + curId + " 님 환영합니다 <");
		lblCurId.setForeground(new Color(0, 0, 153));
		lblCurId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblCurId.setBounds(690, 14, 140, 15);
		calendarPane.add(lblCurId);

		// 상단 today 버튼
		todayBtn = new JButton("Today");
		todayBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		todayBtn.setBackground(new Color(255, 204, 204));
		todayBtn.setForeground(new Color(0, 0, 0));
		todayBtn.setBounds(12, 10, 75, 23);
		todayBtn.addActionListener(listenMoveBtn); // 버튼클릭시 이벤트
		calendarPane.add(todayBtn);
		// 오늘날짜 출력 라벨
		todayLbl = new JLabel(CalendarSet.today.get(Calendar.YEAR) + "/" + (CalendarSet.today.get(Calendar.MONTH) + 1)
				+ "/" + CalendarSet.today.get(Calendar.DATE));
		todayLbl.setForeground(new Color(255, 0, 0));
		todayLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		todayLbl.setBounds(96, 14, 85, 15);
		calendarPane.add(todayLbl);

		// 월, 년도 변경 버튼
		prevYearBtn = new JButton("<<");
		prevYearBtn.setBackground(new Color(150, 150, 150));
		prevYearBtn.setBounds(20, 54, 50, 24);
		prevYearBtn.setToolTipText("Previous Year"); // 버튼 설명 툴팁
		prevYearBtn.addActionListener(listenMoveBtn);
		calendarPane.add(prevYearBtn);

		prevMonBtn = new JButton("<");
		prevMonBtn.setBackground(new Color(211, 211, 211));
		prevMonBtn.setBounds(92, 54, 50, 24);
		prevMonBtn.setToolTipText("Previous Month");
		prevMonBtn.addActionListener(listenMoveBtn);
		calendarPane.add(prevMonBtn);

		nextMonBtn = new JButton(">");
		nextMonBtn.setBackground(new Color(211, 211, 211));
		nextMonBtn.setBounds(368, 54, 50, 24);
		nextMonBtn.setToolTipText("Next Month");
		nextMonBtn.addActionListener(listenMoveBtn);
		calendarPane.add(nextMonBtn);

		nextYearBtn = new JButton(">>");
		nextYearBtn.setBackground(new Color(150, 150, 150));
		nextYearBtn.setBounds(442, 54, 50, 24);
		nextYearBtn.setToolTipText("Next Year");
		nextYearBtn.addActionListener(listenMoveBtn);
		calendarPane.add(nextYearBtn);
		// 현재 월, 년도 라벨 출력
		curMMYYYYLbl = new JLabel(((CalendarSet.calMonth + 1) < 10 ? " " : "") + (CalendarSet.calMonth + 1) + " / "
				+ CalendarSet.calYear);
		curMMYYYYLbl.setHorizontalAlignment(SwingConstants.CENTER);
		curMMYYYYLbl.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		curMMYYYYLbl.setBounds(182, 54, 138, 24);
		calendarPane.add(curMMYYYYLbl);

		// 달력 디자인
		calPanel = new JPanel();
		for (int i = 0; i < CalendarSet.CAL_COLUMN; i++) {
			weekHeadBtn[i] = new JButton(WEEK_HEAD[i]);
			weekHeadBtn[i].setBorderPainted(false); // 테두리 없음
			weekHeadBtn[i].setContentAreaFilled(true);
			weekHeadBtn[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			weekHeadBtn[i].setForeground(Color.WHITE); // 배경색(글자색)
			if (i == 0) // 일요일은 빨간색
				weekHeadBtn[i].setBackground(new Color(255, 102, 104));
			else if (i == 6) // 토요일은 파란색
				weekHeadBtn[i].setBackground(new Color(102, 150, 255));
			else // 평일은 회색
				weekHeadBtn[i].setBackground(new Color(150, 150, 150));
			weekHeadBtn[i].setOpaque(true); // 불투명도
			weekHeadBtn[i].setFocusPainted(false); // 포커스가 표시되지않음
			calPanel.add(weekHeadBtn[i]); // 달력 판넬에 요일제목 추가
		}
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) { // 날짜 출력할 빈버튼 세팅
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				dateBtns[i][j] = new JButton();
				dateBtns[i][j].setBorderPainted(false);
				dateBtns[i][j].setContentAreaFilled(false);
				dateBtns[i][j].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				dateBtns[i][j].setBackground(Color.WHITE);
				dateBtns[i][j].setOpaque(true);
				dateBtns[i][j].addActionListener(listenDateBtn);
				calPanel.add(dateBtns[i][j]); // 달력 판넬에 날짜 추가
			}
		}
		calPanel.setBounds(12, 86, 490, 465);
		calPanel.setLayout(new GridLayout(0, 7, 4, 4)); // 0행 7열 간격20으로 GridLayout 생성
		calPanel.setBorder(BorderFactory.createEmptyBorder(6, 0, 0, 0)); // 안쪽 패딩
		calendarPane.add(calPanel);
		showCal(); // dateBtns의 textSet 메소드

		JScrollPane scrollJTable = new JScrollPane();
		scrollJTable.setBounds(514, 123, 318, 413);
		JtableModel = new DefaultTableModel(JtableHead, 0); // field를 제목으로 하고 줄을 0으로 초기화하며 tableModel 객체 생성
		Jtable = new JTable(JtableModel);
		Jtable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Jtable.getColumn("Done").setPreferredWidth(7);
		Jtable.getColumn("Time").setPreferredWidth(7);
		Jtable.getColumn("Text").setPreferredWidth(70);
		Jtable.getColumn("Update").setPreferredWidth(10);
		scrollJTable.setViewportView(Jtable);
		calendarPane.add(scrollJTable);

		JtableDateLbl = new JLabel(CalendarSet.today.get(Calendar.YEAR) + "/"
				+ (CalendarSet.today.get(Calendar.MONTH) + 1) + "/" + CalendarSet.today.get(Calendar.DATE));
		JtableDateLbl.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		JtableDateLbl.setBounds(520, 100, 85, 15);
		calendarPane.add(JtableDateLbl);

		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		insertBtn.setBackground(new Color(170, 200, 255));
		insertBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		insertBtn.setBounds(670, 92, 75, 23);
		calendarPane.add(insertBtn);

		searchText = new JTextField();
		searchText.setBounds(752, 66, 77, 21);
		searchText.setColumns(10);
		calendarPane.add(searchText);

		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		searchBtn.setBackground(new Color(170, 200, 255));
		searchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		searchBtn.setBounds(752, 92, 75, 23);
		calendarPane.add(searchBtn);

	}

	private void showCal() {
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) {
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				dateBtns[i][j].removeAll(); // 초기화
				String fontColor = "black"; // 평일 폰트색상
				if (j == 0) // 일요일 폰트색상
					fontColor = "red";
				else if (j == 6) // 토요일 폰트색상
					fontColor = "blue";
				dateBtns[i][j].setText("<html><font color=" + fontColor + ">" + CalendarSet.calDates[i][j]
						+ "</font></html>\n" + "test\n" + "test\n" + "test\n");

				JLabel todayMark = new JLabel("<html><font color=red>*</html>");
				if (CalendarSet.calMonth == CalendarSet.today.get(Calendar.MONTH)
						&& CalendarSet.calYear == CalendarSet.today.get(Calendar.YEAR)
						&& CalendarSet.calDates[i][j] == CalendarSet.today.get(Calendar.DATE)) { // 오늘날짜와같다면
					dateBtns[i][j].add(todayMark); // dateBtns[i][j]에 todayMark를 추가
				}

				if (CalendarSet.calDates[i][j] == 0) // 날짜가 0이라면
					dateBtns[i][j].setVisible(false); // 해당날짜버튼을 보이지않게
				else
					dateBtns[i][j].setVisible(true);
			}
		}
	}

	private void JTableRefresh(DefaultTableModel tableModel) {
//		ArrayList<ScheduleVO> list = dao.select;
//		tableModel.setRowCount(0); // 행을 0줄로 초기화
//		Object record[] = new Object[JtableHead.length]; // 다형성으로 Object그릇에는 모든 데이터가 담길수있음
//		for (int i = 0; i < list.size(); i++) {
//			record[0] = list.get(i).getIsDone();
//			record[1] = list.get(i).getTime();
//			record[2] = list.get(i).getText();
//			record[3] = ;
//			tableModel.addRow(record);
//		}
	} // end JTableRefresh

	private class ListenerMoveDate implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == todayBtn) { // today버큰을 누르면
				CalendarSet.setToday(); // 오늘로 날짜 멤버변수 세팅
				listenDateBtn.actionPerformed(e); // 날짜버튼이 클릭되면
			} else if (e.getSource() == prevYearBtn)
				CalendarSet.moveMonth(-12); // 달을 바꾸며 날짜세팅
			else if (e.getSource() == prevMonBtn)
				CalendarSet.moveMonth(-1);
			else if (e.getSource() == nextMonBtn)
				CalendarSet.moveMonth(1);
			else if (e.getSource() == nextYearBtn)
				CalendarSet.moveMonth(12);
			// 버튼으로 세팅된 날짜를 출력
			curMMYYYYLbl.setText(((CalendarSet.calMonth + 1) < 10 ? " " : "") + (CalendarSet.calMonth + 1) + " / "
					+ CalendarSet.calYear);
			curMMYYYYLbl.setHorizontalAlignment(SwingConstants.CENTER);
			showCal(); // 날짜 텍스트 다시 세팅
		}
	}

	private class ListenerDateBtns implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO

//			Calendar cal = new GregorianCalendar(calYear, calMonth, calDate);
//			curMMYYYYLbl = new JLabel(((cal.calMonth + 1) < 10 ? " " : "") + (cal.calMonth + 1) + " / " + cal.calYear);

		}
	}
}
