package scheduler;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class CalendarPanel extends JFrame {

	JPanel mainPanel;// 메인판넬

	JLabel lblCurId; // 접속아이디 표기 라벨

	JButton todayBtn; // 오늘날짜로 달력이동 버튼
	JLabel todayLbl; // 오늘날짜 표기 라벨
	JButton prevYearBtn, prevMonBtn, nextMonBtn, nextYearBtn; // 달력 이동 버튼
	ListenerMoveDate listenMoveBtn = new ListenerMoveDate(); // 달력 이동 버튼 이벤트 객체

	static JLabel curMMYYYYLbl; // 현재 출력중인 달력의 월/년도 라벨

	JPanel calendarPanel; // 달력전체판넬
	JLabel weekHeadLbl[] = new JLabel[7]; // 요일제목라벨
	final String WEEK_HEAD[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };

	JPanel cellPanel[][] = new JPanel[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN]; // 하루 단위 cell
	JButton cellDateBtns[][] = new JButton[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN]; // cell의 날짜표기 버튼
	static JButton cellSd1Btns[][] = new JButton[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN]; // cell의 일정1 버튼
	static JButton cellSd2Btns[][] = new JButton[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN];; // cell의 일정2 버튼
	ListenerDateBtns listenDateBtn = new ListenerDateBtns(); // 날짜 버튼 이벤트 객체
	final static int CELL_COLOR_R[] = { 255, 255, 153, 153, 255, 240 };
	final static int CELL_COLOR_G[] = { 153, 255, 255, 204, 204, 240 };
	final static int CELL_COLOR_B[] = { 153, 153, 170, 255, 255, 240 };

	static JLabel scheduleDateLbl; // 출력된 스케줄의 날짜 표기 라벨
	static JLabel lblJtableRowCount; // 출력된 스케줄 행 갯수
	static JTable scheduleTable; // 스케줄 J테이블
	static DefaultTableModel JtableModel;
	static JCheckBox isdoneCK;
	static String[] scheduleTableHead = { "Done", "Y", "M", "D", "Time", "Text", "No" };
	static ArrayList<ScheduleVO> monthlist;

	private JButton insertBtn, searchBtn, updateBtn; // 스케줄 입력 및 검색 버튼
	private JTextField searchText; // 스케줄 검색 문자열
	static String curId;

	static ScheduleDAOImple sDAO = ScheduleDAOImple.getInstance();

	public CalendarPanel(String curId) {
		CalendarPanel.curId = curId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 700);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		setContentPane(mainPanel);
		CalendarSet.setToday();
		// 접속아이디 표기
		lblCurId = new JLabel(" > " + curId + " 님 환영합니다 <");
		lblCurId.setForeground(new Color(0, 0, 153));
		lblCurId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblCurId.setBounds(690, 14, 140, 15);
		mainPanel.add(lblCurId);
		// 상단 today 버튼
		todayBtn = new JButton("Today");
		todayBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		todayBtn.setBackground(new Color(255, 204, 204));
		todayBtn.setForeground(new Color(0, 0, 0));
		todayBtn.setBounds(12, 10, 75, 23);
		todayBtn.addActionListener(listenMoveBtn); // 버튼클릭시 이벤트
		mainPanel.add(todayBtn);
		// 오늘날짜 출력 라벨
		todayLbl = new JLabel(CalendarSet.instance.get(Calendar.YEAR) + "-"
				+ (CalendarSet.instance.get(Calendar.MONTH) + 1) + "-" + CalendarSet.instance.get(Calendar.DATE));
		todayLbl.setForeground(new Color(255, 0, 0));
		todayLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		todayLbl.setBounds(96, 14, 85, 15);
		mainPanel.add(todayLbl);

		// 월, 년도 변경 버튼
		prevYearBtn = new JButton("<<");
		prevYearBtn.setBackground(new Color(150, 150, 150));
		prevYearBtn.setBounds(20, 54, 50, 24);
		prevYearBtn.setToolTipText("Previous Year"); // 버튼 설명 툴팁
		prevYearBtn.addActionListener(listenMoveBtn);
		mainPanel.add(prevYearBtn);

		prevMonBtn = new JButton("<");
		prevMonBtn.setBackground(new Color(211, 211, 211));
		prevMonBtn.setBounds(92, 54, 50, 24);
		prevMonBtn.setToolTipText("Previous Month");
		prevMonBtn.addActionListener(listenMoveBtn);
		mainPanel.add(prevMonBtn);

		nextMonBtn = new JButton(">");
		nextMonBtn.setBackground(new Color(211, 211, 211));
		nextMonBtn.setBounds(368, 54, 50, 24);
		nextMonBtn.setToolTipText("Next Month");
		nextMonBtn.addActionListener(listenMoveBtn);
		mainPanel.add(nextMonBtn);

		nextYearBtn = new JButton(">>");
		nextYearBtn.setBackground(new Color(150, 150, 150));
		nextYearBtn.setBounds(442, 54, 50, 24);
		nextYearBtn.setToolTipText("Next Year");
		nextYearBtn.addActionListener(listenMoveBtn);
		mainPanel.add(nextYearBtn);
		// 현재 월, 년도 라벨 출력
		curMMYYYYLbl = new JLabel(((CalendarSet.calMonth + 1) < 10 ? " " : "") + (CalendarSet.calMonth + 1) + " / "
				+ CalendarSet.calYear);
		curMMYYYYLbl.setHorizontalAlignment(SwingConstants.CENTER);
		curMMYYYYLbl.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		curMMYYYYLbl.setBounds(182, 54, 138, 24);
		mainPanel.add(curMMYYYYLbl);

		// 달력 디자인
		calendarPanel = new JPanel();
		calendarPanel.setBounds(12, 86, 490, 550);
		// 달력 요일 제목
		for (int i = 0; i < CalendarSet.CAL_COLUMN; i++) {
			weekHeadLbl[i] = new JLabel(WEEK_HEAD[i]);
			weekHeadLbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			weekHeadLbl[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			weekHeadLbl[i].setForeground(Color.WHITE); // 배경색(글자색)
			if (i == 0) // 일요일은 빨간색
				weekHeadLbl[i].setBackground(new Color(255, 102, 104));
			else if (i == 6) // 토요일은 파란색
				weekHeadLbl[i].setBackground(new Color(102, 150, 255));
			else // 평일은 회색
				weekHeadLbl[i].setBackground(new Color(150, 150, 150));
			weekHeadLbl[i].setOpaque(true); // 불투명도
			calendarPanel.add(weekHeadLbl[i]); // 달력 판넬에 요일버튼 하나씩 반복하며 추가
		}
		// 달력 날짜 cell
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) { // 날짜 출력할 빈버튼 세팅
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				cellPanel[i][j] = new JPanel();

				cellDateBtns[i][j] = new JButton();
				cellDateBtns[i][j].setBorderPainted(false);
				cellDateBtns[i][j].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				cellDateBtns[i][j].setBackground(Color.WHITE);
				cellDateBtns[i][j].addActionListener(listenDateBtn);

				cellSd1Btns[i][j] = new JButton();
				cellSd1Btns[i][j].setBorderPainted(false);
				cellSd1Btns[i][j].setBackground(new Color(240, 240, 240));
				cellSd1Btns[i][j].addActionListener(listenDateBtn);

				cellSd2Btns[i][j] = new JButton();
				cellSd2Btns[i][j].setBorderPainted(false);
				cellSd2Btns[i][j].setBackground(new Color(240, 240, 240));
				cellSd2Btns[i][j].addActionListener(listenDateBtn);

				cellPanel[i][j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				cellPanel[i][j].add(cellDateBtns[i][j]);
				cellPanel[i][j].add(cellSd1Btns[i][j]);
				cellPanel[i][j].add(cellSd2Btns[i][j]);

				calendarPanel.add(cellPanel[i][j]); // 달력 판넬에 날짜 추가
			}
		}
		calendarPanel.setLayout(new GridLayout(0, 7, 4, 4)); // 0행 7열 간격20으로 GridLayout 생성
		calendarPanel.setBorder(BorderFactory.createEmptyBorder(6, 0, 0, 0)); // 안쪽 패딩
		mainPanel.add(calendarPanel);
		// 생성된 달력 틀에 텍스트 정보 집어넣는 메소드
		setCalendarDateValue();
		// monthlist에 초기 리스트 담기
		getMonthList();
		// 버튼 세팅
		setScheduleBtnColor();

		// Jtable 출력 행 갯수 표기 라벨
		lblJtableRowCount = new JLabel("");
		lblJtableRowCount.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblJtableRowCount.setBounds(784, 624, 50, 15);
		mainPanel.add(lblJtableRowCount);
		// Jtable 출력된 스케줄의 날짜 표기 라벨
		scheduleDateLbl = new JLabel();
		scheduleDateLbl.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		scheduleDateLbl.setBounds(520, 93, 100, 23);
		mainPanel.add(scheduleDateLbl);
		// 스케줄 출력 Jtable
		JScrollPane scrollJTable = new JScrollPane();
		scrollJTable.setBounds(514, 123, 318, 500);
		JtableModel = new DefaultTableModel(scheduleTableHead, 0); // field를 제목으로 하고 줄을 0으로 초기화하며 tableModel 객체 생성
		scheduleTable = new JTable(JtableModel);
		scheduleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scheduleTable.getColumn("Done").setPreferredWidth(2);
		scheduleTable.getColumn("Y").setPreferredWidth(2);
		scheduleTable.getColumn("M").setPreferredWidth(2);
		scheduleTable.getColumn("D").setPreferredWidth(2);
		scheduleTable.getColumn("Time").setPreferredWidth(2);
		scheduleTable.getColumn("No").setPreferredWidth(2);
		isdoneCK = new JCheckBox();
		isdoneCK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((boolean) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 0) == true) {
					scheduleTable.setValueAt("V", scheduleTable.getSelectedRow(), 0);
				} else if ((boolean) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 0) == false) {
					scheduleTable.setValueAt("", scheduleTable.getSelectedRow(), 0);
				}
				DefaultTableCellRenderer cellrd = new DefaultTableCellRenderer();
				cellrd.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tcm = scheduleTable.getColumnModel();
				tcm.getColumn(0).setCellRenderer(cellrd);
			}
		});
		scrollJTable.setViewportView(scheduleTable);
		mainPanel.add(scrollJTable);
		JTableRefresh(JtableModel, searchByDate(CalendarSet.instance.get(Calendar.DATE)));
		scheduleTable.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer());
		scheduleTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(isdoneCK));

		// 스케줄 등록 버튼
		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAddPanel(scheduleDateLbl.getText(), sDAO);
			}
		});
		insertBtn.setBackground(new Color(170, 200, 255));
		insertBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		insertBtn.setBounds(661, 93, 80, 23);
		mainPanel.add(insertBtn);
		// 스케줄 검색 입력창
		searchText = new JTextField();
		searchText.setBounds(643, 64, 100, 23);
		searchText.setColumns(10);
		mainPanel.add(searchText);
		// 스케줄 검색 버튼
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchByString(curId, searchText.getText());
			}
		});
		searchBtn.setBackground(new Color(170, 200, 255));
		searchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		searchBtn.setBounds(750, 64, 80, 23);
		mainPanel.add(searchBtn);

		updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getUpdatePanel(sDAO);
			}
		});
		updateBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		updateBtn.setBackground(new Color(170, 200, 255));
		updateBtn.setBounds(750, 93, 80, 23);
		mainPanel.add(updateBtn);

	}

	private void setCalendarDateValue() {
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) {
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				cellDateBtns[i][j].removeAll(); // 초기화
				cellDateBtns[i][j].setText(Integer.toString(CalendarSet.calDates[i][j]));
				if (j == 0) {// 일요일 폰트색상
					cellDateBtns[i][j].setForeground(Color.red);
				} else if (j == 6) {// 토요일 폰트색상
					cellDateBtns[i][j].setForeground(Color.blue);
				} else {
					cellDateBtns[i][j].setForeground(Color.black);
				}
				if (CalendarSet.calMonth == CalendarSet.instance.get(Calendar.MONTH)
						&& CalendarSet.calYear == CalendarSet.instance.get(Calendar.YEAR)
						&& CalendarSet.calDates[i][j] == CalendarSet.instance.get(Calendar.DATE)) { // 오늘날짜와같다면
					cellPanel[i][j].setBorder(new LineBorder(Color.red, 2));
				} else {
					cellPanel[i][j].setBorder(new LineBorder(SystemColor.control));
				}

				if (CalendarSet.calDates[i][j] == 0) {// 날짜가 0이라면
					cellDateBtns[i][j].setVisible(false); // 해당날짜버튼을 보이지않게
					cellSd1Btns[i][j].setVisible(false);
					cellSd2Btns[i][j].setVisible(false);
				} else {
					cellDateBtns[i][j].setVisible(true);
					cellSd1Btns[i][j].setVisible(true);
					cellSd2Btns[i][j].setVisible(true);
				}
			}
		}
	} // end setCalendarDateValue

	public ArrayList<ScheduleVO> getMonthList() {
		ScheduleVO sVO = new ScheduleVO();
		sVO.setId(curId);
		sVO.setYear(curLblToYear());
		sVO.setMonth(curLblToMonth());
		monthlist = sDAO.select(sVO);
		return monthlist;
	}

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
			scheduleDateLbl.setText(todayLbl.getText());
			try {
				setCalendarDateValue(); // 날짜 텍스트 다시 세팅
				getMonthList(); // ArrayList 다시 세팅
				setScheduleBtnColor(); // 스케줄 버튼 다시 세팅
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	} // end ListenerMoveDate

	private class ListenerDateBtns implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int date = selectBtnToDate(e);
			JTableRefresh(JtableModel, searchByDate(date));
		}
	} // end ListenerDateBtns

	private void getAddPanel(String selectDate, ScheduleDAOImple sDAO) {
		int year = Integer.parseInt(selectDate.substring(0, 4));
		int month = 0;
		int date = 0;
		if (selectDate.charAt(6) == '-') {
			month = Integer.parseInt(selectDate.substring(5, 6));
			date = Integer.parseInt(selectDate.substring(7));
		} else {
			month = Integer.parseInt(selectDate.substring(5, 7));
			date = Integer.parseInt(selectDate.substring(8));
		}
		ScheduleVO sVOa = new ScheduleVO();
		sVOa.setId(curId);
		sVOa.setYear(year);
		sVOa.setMonth(month);
		sVOa.setDate(date);
		ScheduleAddPanel addPanel = new ScheduleAddPanel(sDAO, sVOa);
		addPanel.setVisible(true);
	} // end getAddPanel

	private void getUpdatePanel(ScheduleDAOImple sDAO) {
		ScheduleVO sVOu = new ScheduleVO();
		sVOu.setSeqNo((int) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 6));
		sVOu.setId(curId);
		sVOu.setYear((int) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 1));
		sVOu.setMonth((int) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 2));
		sVOu.setDate((int) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 3));
		sVOu.setTime((int) scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 4));
		sVOu.setText(String.valueOf(scheduleTable.getValueAt(scheduleTable.getSelectedRow(), 5)));
		ScheduleUpdatePanel updatePanel = new ScheduleUpdatePanel(sDAO, sVOu);
		updatePanel.setVisible(true);
	} // end getAddPanel

	public static int curLblToYear() {
		int year = Integer.parseInt(curMMYYYYLbl.getText().substring(5));
		return year;
	} // end curLblToYear

	public static int curLblToMonth() {
		int month = 0;
		if (curMMYYYYLbl.getText().charAt(0) == ' ') {
			month = Integer.parseInt(curMMYYYYLbl.getText().substring(1, 2));
		} else {
			month = Integer.parseInt(curMMYYYYLbl.getText().substring(0, 2));
		}
		return month;
	} // end curLblToMonth

	public int selectBtnToDate(ActionEvent e) {
		int row = 0, col = 0;
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) {
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				if (e.getSource() == cellDateBtns[i][j]) {
					row = i;
					col = j;
				} else if (e.getSource() == cellSd1Btns[i][j]) {
					row = i;
					col = j;

				} else if (e.getSource() == cellSd2Btns[i][j]) {
					row = i;
					col = j;
				}
			}
		}
		int date = CalendarSet.calDates[row][col];
		return date;
	} // end selectBtnToDate

	public static ArrayList<ScheduleVO> searchByDate(int date) {
		ArrayList<ScheduleVO> listDate = new ArrayList<>();
		for (int i = 0; i < monthlist.size(); i++) {
			if (date == monthlist.get(i).getDate()) {
				listDate.add(monthlist.get(i));
			}
		}
		return listDate;
	} // end searchByDate

	public void searchByString(String curId, String Text) {
		ArrayList<ScheduleVO> listText = sDAO.select(curId, Text);
		if (listText.isEmpty() != true) {
			JTableRefresh(JtableModel, listText);
			scheduleDateLbl.setText("검색결과 \"" + Text + "\"");
			scheduleDateLbl.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		} else {
			DialogPanel dialogPanel = new DialogPanel("존재하지 않는 일정입니다");
			dialogPanel.setVisible(true);
		}
	} // end selectByString

	public static void JTableRefresh(DefaultTableModel JtableModel, ArrayList<ScheduleVO> list) {
		JtableModel.setRowCount(0); // 행을 0줄로 초기화
		lblJtableRowCount.setText("Total : 0");
		scheduleDateLbl.setText(list.get(0).getYear() + "-" + list.get(0).getMonth() + "-" + list.get(0).getDate());
		Object record[] = new Object[scheduleTableHead.length]; // 다형성으로 Object그릇에는 모든 데이터가 담길수있음
		for (int i = 0; i < list.size(); i++) {
			record[0] = list.get(i).getIsDone();
			record[1] = list.get(i).getYear();
			record[2] = list.get(i).getMonth();
			record[3] = list.get(i).getDate();
			record[4] = list.get(i).getTime();
			record[5] = list.get(i).getText();
			record[6] = list.get(i).getSeqNo();
			JtableModel.addRow(record);
			lblJtableRowCount.setText("Total : " + (i + 1));
		}
		// J테이블 가운데 정렬
		DefaultTableCellRenderer cellrd = new DefaultTableCellRenderer();
		cellrd.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = scheduleTable.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(cellrd);
		}

	} // end JTableRefresh

	public static void setScheduleBtnColor() {
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) {
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				int indexSd1 = colorIndex(i, j, 0);
				int indexSd2 = colorIndex(i, j, 1);
				cellSd1Btns[i][j].setBackground(
						new Color(CELL_COLOR_R[indexSd1], CELL_COLOR_G[indexSd1], CELL_COLOR_B[indexSd1]));
				cellSd2Btns[i][j].setBackground(
						new Color(CELL_COLOR_R[indexSd2], CELL_COLOR_G[indexSd2], CELL_COLOR_B[indexSd2]));
			}
		}
	} // end setScheduleBtnColor

	public static int colorIndex(int i, int j, int btnNo) {
		int result = 5;
		int date = CalendarSet.calDates[i][j];
		ArrayList<ScheduleVO> listBtn = searchByDate(date);
		try {
			if (listBtn.isEmpty() != true && listBtn.get(btnNo).getSeqNo() != 0) {
				result = listBtn.get(btnNo).getColorIdx();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return result;
	} // end colorIndex
}
