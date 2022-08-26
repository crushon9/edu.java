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
import javax.swing.JButton;
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

public class CalendarPanel extends JPanel {

	JPanel CalendarMainPanel;// 메인판넬

	JLabel CurIdLbl; // 접속아이디 표기 라벨

	JButton logOutBtn, todayBtn; // 오늘날짜로 달력이동 버튼
	JLabel todayLbl; // 오늘날짜 표기 라벨
	JButton prevYearBtn, prevMonBtn, nextMonBtn, nextYearBtn; // 달력 이동 버튼
	ListenerMoveDate listenMoveBtn = new ListenerMoveDate(); // 달력 이동 버튼 이벤트 객체
	JLabel curMMYYYYLbl; // 현재 출력중인 달력의 월/년도 라벨

	JPanel calendarGridPanel; // 달력전체판넬
	JLabel weekHeadLbl[] = new JLabel[7]; // 요일제목라벨
	final String WEEK_HEAD[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };

	JPanel cellPanel[][] = new JPanel[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN]; // 하루 단위 cell
	JButton cellDateBtns[][] = new JButton[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN]; // cell의 날짜표기 버튼
	ListenerDateBtns listenDateBtn = new ListenerDateBtns(); // 날짜 버튼 이벤트 객체
	static JButton cellS1Btns[][] = new JButton[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN]; // cell의 일정1 버튼
	static JButton cellS2Btns[][] = new JButton[CalendarSet.CAL_MAX_ROW][CalendarSet.CAL_COLUMN];; // cell의 일정2 버튼
	final static int COLOR_R[] = { 255, 255, 153, 153, 255, 255 };
	final static int COLOR_G[] = { 153, 255, 255, 204, 204, 255 };
	final static int COLOR_B[] = { 153, 103, 170, 255, 255, 255 };

	static JLabel JtableHeadLbl; // 출력된 스케줄의 날짜 표기 라벨
	static int JtableHeadLblFlag = 0;
	static JLabel JtableRowCountLbl; // 출력된 스케줄 행 갯수
	static JTable scheduleJTable; // 스케줄 J테이블
	static DefaultTableModel JtableModel;
	static String[] scheduleJTableColumn = { "Done", "Y", "M", "D", "Time", "Text", "No" };
	static ArrayList<ScheduleVO> monthList;

	private JButton insertBtn, searchBtn, updateBtn; // 스케줄 입력 및 검색 버튼
	private JTextField searchText; // 스케줄 검색 문자열

	static String curId; // 접속아이디

	static ScheduleDAOImple sDAO = ScheduleDAOImple.getInstance();

	public CalendarPanel(JFrame frame, String curId) {
		CalendarPanel.curId = curId; // 접속 아이디 담음
		CalendarMainPanel = new JPanel();
		CalendarMainPanel.setBackground(new Color(230, 230, 230));
		CalendarMainPanel.setLayout(null);
		frame.getContentPane().add(CalendarMainPanel); // 프레임에 판넬 추가
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 완전 종료
		frame.setLocationRelativeTo(null); // 중앙위치
		frame.setBounds(100, 100, 860, 670);
		frame.revalidate(); // 컴퍼넌트 새로고침
		frame.repaint(); // 컴퍼넌트 다시 그림
		// 날짜변수들을 오늘값으로 초기화
		CalendarSet.setToday();
		// 접속아이디 표기
		CurIdLbl = new JLabel(curId + " 님 환영합니다");
		CurIdLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		CurIdLbl.setForeground(new Color(0, 0, 139));
		CurIdLbl.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		CurIdLbl.setBounds(630, 12, 160, 15);
		CalendarMainPanel.add(CurIdLbl);
		logOutBtn = new JButton("X");
		logOutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(CalendarMainPanel);
				frame.revalidate();
				frame.repaint();
				MemberPanel memberPanel = new MemberPanel(frame);
				frame.setLocationRelativeTo(null);
			}
		});
		logOutBtn.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		logOutBtn.setBounds(800, 10, 23, 20);
		logOutBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		logOutBtn.setBorder(new LineBorder(Color.BLACK, 1));
		logOutBtn.setBackground(new Color(255, 140, 140));
		CalendarMainPanel.add(logOutBtn);
		// 상단 today 버튼
		todayBtn = new JButton("Today");
		todayBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		todayBtn.setBackground(new Color(255, 140, 140));
		todayBtn.setBounds(12, 10, 75, 23);
		todayBtn.addActionListener(listenMoveBtn); // 버튼클릭시 이벤트
		CalendarMainPanel.add(todayBtn);
		// 오늘날짜 출력 라벨
		todayLbl = new JLabel(CalendarSet.calYear + "-" + (CalendarSet.calMonth + 1) + "-" + CalendarSet.calDate);
		todayLbl.setForeground(new Color(255, 0, 0));
		todayLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		todayLbl.setBounds(96, 14, 85, 15);
		CalendarMainPanel.add(todayLbl);

		// 월, 년도 변경 버튼
		prevYearBtn = new JButton("<<");
		prevYearBtn.setBackground(new Color(150, 150, 150));
		prevYearBtn.setBounds(20, 54, 50, 24);
		prevYearBtn.setToolTipText("Previous Year"); // 버튼 설명 툴팁
		prevYearBtn.addActionListener(listenMoveBtn);
		CalendarMainPanel.add(prevYearBtn);

		prevMonBtn = new JButton("<");
		prevMonBtn.setBackground(new Color(211, 211, 211));
		prevMonBtn.setBounds(92, 54, 50, 24);
		prevMonBtn.setToolTipText("Previous Month");
		prevMonBtn.addActionListener(listenMoveBtn);
		CalendarMainPanel.add(prevMonBtn);

		nextMonBtn = new JButton(">");
		nextMonBtn.setBackground(new Color(211, 211, 211));
		nextMonBtn.setBounds(368, 54, 50, 24);
		nextMonBtn.setToolTipText("Next Month");
		nextMonBtn.addActionListener(listenMoveBtn);
		CalendarMainPanel.add(nextMonBtn);

		nextYearBtn = new JButton(">>");
		nextYearBtn.setBackground(new Color(150, 150, 150));
		nextYearBtn.setBounds(442, 54, 50, 24);
		nextYearBtn.setToolTipText("Next Year");
		nextYearBtn.addActionListener(listenMoveBtn);
		CalendarMainPanel.add(nextYearBtn);
		// 현재 월, 년도 라벨 출력
		curMMYYYYLbl = new JLabel(((CalendarSet.calMonth + 1) < 10 ? " " : "") + (CalendarSet.calMonth + 1) + " / "
				+ CalendarSet.calYear);
		curMMYYYYLbl.setHorizontalAlignment(SwingConstants.CENTER);
		curMMYYYYLbl.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		curMMYYYYLbl.setBounds(182, 54, 138, 24);
		CalendarMainPanel.add(curMMYYYYLbl);

		// 달력 디자인
		calendarGridPanel = new JPanel();
		calendarGridPanel.setBackground(new Color(230, 230, 230));
		calendarGridPanel.setBounds(12, 86, 490, 530);
		// 달력 요일 제목
		for (int i = 0; i < CalendarSet.CAL_COLUMN; i++) {
			weekHeadLbl[i] = new JLabel(WEEK_HEAD[i]);
			weekHeadLbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			weekHeadLbl[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			weekHeadLbl[i].setForeground(Color.WHITE); // 글자색
			weekHeadLbl[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			if (i == 0) // 일요일은 빨간색
				weekHeadLbl[i].setBackground(new Color(255, 102, 104));
			else if (i == 6) // 토요일은 파란색
				weekHeadLbl[i].setBackground(new Color(102, 150, 255));
			else // 평일은 회색
				weekHeadLbl[i].setBackground(new Color(150, 150, 150));
			weekHeadLbl[i].setOpaque(true); // 불투명도
			calendarGridPanel.add(weekHeadLbl[i]);
		}
		// 달력 날짜 cell
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) { // 날짜 출력할 빈버튼 세팅
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				cellPanel[i][j] = new JPanel();

				cellDateBtns[i][j] = new JButton();
				cellDateBtns[i][j].setBorderPainted(false);
				cellDateBtns[i][j].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				cellDateBtns[i][j].setBackground(Color.white);
				cellDateBtns[i][j].addActionListener(listenDateBtn);

				cellS1Btns[i][j] = new JButton();
				cellS1Btns[i][j].setBorderPainted(false);
				cellS1Btns[i][j].addActionListener(listenDateBtn);

				cellS2Btns[i][j] = new JButton();
				cellS2Btns[i][j].setBorderPainted(false);
				cellS2Btns[i][j].addActionListener(listenDateBtn);

				cellPanel[i][j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				cellPanel[i][j].add(cellDateBtns[i][j]);
				cellPanel[i][j].add(cellS1Btns[i][j]);
				cellPanel[i][j].add(cellS2Btns[i][j]);

				calendarGridPanel.add(cellPanel[i][j]); // 달력 판넬에 날짜 추가
			}
		}
		calendarGridPanel.setLayout(new GridLayout(0, 7, 7, 7)); // 0행 7열 간격20으로 GridLayout 생성
		calendarGridPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // 안쪽 패딩
		CalendarMainPanel.add(calendarGridPanel);
		// 생성된 달력 틀에 텍스트 정보 집어넣는 메소드
		setCalendarDateValue();
		// monthlist에 초기 리스트 담기
		getMonthList();
		// 버튼 색 세팅
		setScheduleBtnColor();

		// Jtable 출력 행 갯수 표기 라벨
		JtableRowCountLbl = new JLabel("");
		JtableRowCountLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		JtableRowCountLbl.setBounds(770, 585, 60, 15);
		JtableRowCountLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		CalendarMainPanel.add(JtableRowCountLbl);
		// Jtable 출력된 스케줄의 날짜 표기 라벨
		JtableHeadLbl = new JLabel();
		JtableHeadLbl.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		JtableHeadLbl.setBounds(520, 93, 100, 23);
		CalendarMainPanel.add(JtableHeadLbl);
		// 스케줄 출력 Jtable
		JScrollPane scrollJTable = new JScrollPane();
		scrollJTable.setBounds(514, 123, 318, 460);
		JtableModel = new DefaultTableModel(scheduleJTableColumn, 0) {// field를 제목으로 하고 줄을 0으로 초기화하며 tableModel 객체 생성
			@Override
			public Class<?> getColumnClass(int column) {
				if (column == 0)
					return Boolean.class;
				else
					return String.class;
			}
		};
		scheduleJTable = new JTable(JtableModel);
		scheduleJTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scheduleJTable.getColumn("Done").setPreferredWidth(2);
		scheduleJTable.getColumn("Y").setPreferredWidth(2);
		scheduleJTable.getColumn("M").setPreferredWidth(2);
		scheduleJTable.getColumn("D").setPreferredWidth(2);
		scheduleJTable.getColumn("Time").setPreferredWidth(2);
		scheduleJTable.getColumn("No").setPreferredWidth(2);
		scrollJTable.setViewportView(scheduleJTable);
		CalendarMainPanel.add(scrollJTable);
		// 오늘 날짜 일정이 비어있지 않으면 Jtable 세팅, 아니라면 0행으로 초기화
		if (scheduleSearchByDate(CalendarSet.calDate).isEmpty() != true) {
			JTableRefresh(JtableModel, scheduleSearchByDate(CalendarSet.calDate));
		} else {
			JtableModel.setRowCount(0);
		}

		// 스케줄 등록 버튼
		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JtableHeadLblFlag == 0) {
					getAddPanel(JtableHeadLbl.getText());
				}else {
					DialogPanel dialogPanel = new DialogPanel("날짜를 선택해주세요!");
					dialogPanel.setVisible(true); 
				}
			}
		});
		insertBtn.setBackground(new Color(204, 204, 255));
		insertBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		insertBtn.setBounds(661, 93, 80, 23);
		CalendarMainPanel.add(insertBtn);

		// 스케줄 검색 입력창
		searchText = new JTextField();
		searchText.setBounds(643, 64, 100, 23);
		searchText.setColumns(10);
		CalendarMainPanel.add(searchText);
		// 스케줄 검색 버튼
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scheduleSearchByString(curId, searchText.getText());
			}
		});
		searchBtn.setBackground(new Color(204, 204, 255));
		searchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		searchBtn.setBounds(750, 64, 80, 23);
		CalendarMainPanel.add(searchBtn);
		// 스케줄 수정 버튼
		updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getUpdatePanel();
				} catch (Exception e2) {
					DialogPanel dialogPanel = new DialogPanel("일정을 선택해주세요!");
					dialogPanel.setVisible(true); 
				}
			}
		});
		updateBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		updateBtn.setBackground(new Color(204, 204, 255));
		updateBtn.setBounds(750, 93, 80, 23);
		CalendarMainPanel.add(updateBtn);
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
				if (CalendarSet.calMonth == CalendarSet.today.get(Calendar.MONTH)
						&& CalendarSet.calYear == CalendarSet.today.get(Calendar.YEAR)
						&& CalendarSet.calDates[i][j] == CalendarSet.today.get(Calendar.DATE)) { // 오늘날짜와같다면
					cellPanel[i][j].setBorder(new LineBorder(Color.red, 1));
				} else {
					cellPanel[i][j].setBorder(new LineBorder(SystemColor.control));
				}

				if (CalendarSet.calDates[i][j] == 0) {// 날짜가 0이라면
					cellPanel[i][j].setBackground(new Color(230, 230, 230));
					cellPanel[i][j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					cellDateBtns[i][j].setVisible(false); // 해당날짜버튼을 보이지않게
					cellS1Btns[i][j].setVisible(false);
					cellS2Btns[i][j].setVisible(false);
				} else {
					cellPanel[i][j].setBackground(Color.white);
					cellDateBtns[i][j].setVisible(true);
					cellS1Btns[i][j].setVisible(true);
					cellS2Btns[i][j].setVisible(true);
				}
			}
		}
	} // end setCalendarDateValue

	public static ArrayList<ScheduleVO> getMonthList() {
		ScheduleVO sVO = new ScheduleVO();
		sVO.setId(curId);
		sVO.setYear(CalendarSet.calYear);
		sVO.setMonth(CalendarSet.calMonth + 1);
		monthList = sDAO.select(sVO);
		return monthList;
	} // getMonthList

	public static void setScheduleBtnColor() {
		for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) {
			for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
				int indexSd1 = getColorIndex(i, j, 0);
				int indexSd2 = getColorIndex(i, j, 1);
				cellS1Btns[i][j].setBackground(new Color(COLOR_R[indexSd1], COLOR_G[indexSd1], COLOR_B[indexSd1]));
				cellS2Btns[i][j].setBackground(new Color(COLOR_R[indexSd2], COLOR_G[indexSd2], COLOR_B[indexSd2]));
			}
		}
	} // end setScheduleBtnColor

	public static int getColorIndex(int i, int j, int btnNo) {
		int result = 5;
		int date = CalendarSet.calDates[i][j];
		ArrayList<ScheduleVO> listBtn = scheduleSearchByDate(date);
		try {
			if (listBtn.isEmpty() != true && listBtn.get(btnNo).getSeqNo() != 0) {
				result = listBtn.get(btnNo).getColorIdx();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return result;
	} // end colorIndex

	private class ListenerMoveDate implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int todayFlag = 0;
			if (e.getSource() == todayBtn) { // today버큰을 누르면
				CalendarSet.setToday(); // 오늘로 날짜 멤버변수 세팅
				todayFlag = 1;
			} else if (e.getSource() == prevYearBtn)
				CalendarSet.moveMonth(-12); // CalendarSet 멤버변수의 값을 변경함
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
			try {
				setCalendarDateValue(); // 날짜 텍스트 다시 세팅
				getMonthList(); // ArrayList 다시 세팅
				setScheduleBtnColor(); // 스케줄 버튼 다시 세팅
				if (todayFlag == 1 && scheduleSearchByDate(CalendarSet.calDate).isEmpty() != true) {
					JTableRefresh(JtableModel, scheduleSearchByDate(CalendarSet.calDate));
				} else if (todayFlag == 1) {
					JtableHeadLbl.setText(
							CalendarSet.calYear + "-" + (CalendarSet.calMonth + 1) + "-" + CalendarSet.calDate);
					JtableModel.setRowCount(0);
					JtableHeadLblFlag = 0;
				}
			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}
	} // end ListenerMoveDate

	private class ListenerDateBtns implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int row = 0, col = 0;
			for (int i = 0; i < CalendarSet.CAL_MAX_ROW; i++) {
				for (int j = 0; j < CalendarSet.CAL_COLUMN; j++) {
					if (e.getSource() == cellDateBtns[i][j]) {
						row = i;
						col = j;
					} else if (e.getSource() == cellS1Btns[i][j]) {
						row = i;
						col = j;
					} else if (e.getSource() == cellS2Btns[i][j]) {
						row = i;
						col = j;
					}
				}
			}
			int date = CalendarSet.calDates[row][col];
			if (scheduleSearchByDate(date).isEmpty() != true) {
				JTableRefresh(JtableModel, scheduleSearchByDate(date));
			} else {
				JtableHeadLbl.setText(CalendarSet.calYear + "-" + (CalendarSet.calMonth + 1) + "-" + date);
				JtableModel.setRowCount(0);
				JtableHeadLblFlag = 0;
			}
		}
	} // end ListenerDateBtns

	private void getAddPanel(String selectDate) {
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
		ScheduleInsertPanel addPanel = new ScheduleInsertPanel(sVOa);
		addPanel.setVisible(true);
	} // end getAddPanel

	private void getUpdatePanel() {
		ScheduleVO sVOu = new ScheduleVO();
		sVOu.setSeqNo((int) scheduleJTable.getValueAt(scheduleJTable.getSelectedRow(), 6));
		sVOu.setId(curId);
		sVOu.setYear((int) scheduleJTable.getValueAt(scheduleJTable.getSelectedRow(), 1));
		sVOu.setMonth((int) scheduleJTable.getValueAt(scheduleJTable.getSelectedRow(), 2));
		sVOu.setDate((int) scheduleJTable.getValueAt(scheduleJTable.getSelectedRow(), 3));
		sVOu.setTime((int) scheduleJTable.getValueAt(scheduleJTable.getSelectedRow(), 4));
		sVOu.setText(String.valueOf(scheduleJTable.getValueAt(scheduleJTable.getSelectedRow(), 5)));
		ScheduleUpdatePanel updatePanel = new ScheduleUpdatePanel(sVOu);
		updatePanel.setVisible(true);
	} // end getAddPanel

	public static ArrayList<ScheduleVO> scheduleSearchByDate(int date) {
		ArrayList<ScheduleVO> listDate = new ArrayList<>();
		for (int i = 0; i < monthList.size(); i++) {
			if (date == monthList.get(i).getDate()) {
				listDate.add(monthList.get(i));
			}
		}
		return listDate;
	} // end scheduleSearchByDate

	public void scheduleSearchByString(String curId, String Text) {
		ArrayList<ScheduleVO> listText = sDAO.select(curId, Text);
		if (listText.isEmpty() != true) {
			JTableRefresh(JtableModel, listText);
			JtableHeadLbl.setText("검색결과 \"" + Text + "\"");
			JtableHeadLbl.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			JtableHeadLblFlag = 1;
		} else {
			DialogPanel dialogPanel = new DialogPanel("존재하지 않는 일정입니다");
			dialogPanel.setVisible(true);
		}
	} // end scheduleSearchByString

	public static void JTableRefresh(DefaultTableModel JtableModel, ArrayList<ScheduleVO> list) {
		JtableModel.setRowCount(0); // 행을 0줄로 초기화
		JtableRowCountLbl.setText("Total : 0");
		JtableHeadLbl.setText(list.get(0).getYear() + "-" + list.get(0).getMonth() + "-" + list.get(0).getDate());
		JtableHeadLblFlag = 0;
		Object record[] = new Object[scheduleJTableColumn.length]; // 다형성으로 Object그릇에는 모든 데이터가 담길수있음
		for (int i = 0; i < list.size(); i++) {
			record[0] = list.get(i).getIsDone();
			record[1] = list.get(i).getYear();
			record[2] = list.get(i).getMonth();
			record[3] = list.get(i).getDate();
			record[4] = list.get(i).getTime();
			record[5] = list.get(i).getText();
			record[6] = list.get(i).getSeqNo();
			JtableModel.addRow(record);
			JtableRowCountLbl.setText("Total : " + (i + 1));
		}
		// J테이블 가운데 정렬
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = scheduleJTable.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(renderer);
		}
	}// end JTableRefresh

	public static void update(int date) {
		scheduleSearchByDate(date);
		getMonthList();
		setScheduleBtnColor();
		if (scheduleSearchByDate(date).isEmpty() != true) {
			JTableRefresh(JtableModel, scheduleSearchByDate(date));
		} else {
			JtableModel.setRowCount(0);
		}
	} // end update
}
