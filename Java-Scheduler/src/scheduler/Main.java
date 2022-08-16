package scheduler;

import java.awt.EventQueue;

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

public class Main extends CalendarSet {

	JFrame mainFrame;
	JPanel calEtcPanel;
	JButton todayBtn;
	JLabel todayLbl;
	JButton prevYearBtn, prevMonBtn, nextMonBtn, nextYearBtn;
	ListenerMoveDate listenMoveBtn = new ListenerMoveDate(); // 이벤트 컨트롤 객체

	JLabel curMMYYYYLbl;

	JPanel calPanel; // 달력판넬
	JButton weekHeadBtn[];
	JButton dateBtns[][] = new JButton[6][7];
	ListenerDateBtns listenDateBtn = new ListenerDateBtns(); // 이벤트 컨트롤 객체

	JTable Jtable;
	DefaultTableModel JtableModel;
	String[] JtableHead = { "Done", "Time", "Text" };
	JLabel JtableDateLbl;

	final String WEEK_HEAD[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	final String title = "ooo님 환영합니다";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame(title);
		// 자식객체를 생성할때, 부모클래스의 생성자를 명시적으로 호출하지 않으면 부모클래스의 기본생성자 자동 호출
		// 즉 CalendarSet 기본생성자가 자동으로 생성됨
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료시 프로세스까지 완벽하게 닫는 옵션
		mainFrame.setBounds(100, 100, 860, 600);
		mainFrame.setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		mainFrame.setResizable(false); // 창크기 고정

		mainFrame.getContentPane().setLayout(null);
		// 상단 today 버튼
		todayBtn = new JButton("Today");
		todayBtn.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		todayBtn.setBackground(new Color(204, 204, 255));
		todayBtn.setForeground(new Color(0, 0, 0));
		todayBtn.setBounds(12, 10, 75, 23);
		todayBtn.addActionListener(listenMoveBtn); // 버튼클릭시 이벤트
		mainFrame.getContentPane().add(todayBtn);
		// 오늘날짜 출력 라벨
		todayLbl = new JLabel(
				today.get(Calendar.YEAR) + "/" + (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.DATE));
		todayLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		todayLbl.setBounds(100, 14, 85, 15);
		mainFrame.getContentPane().add(todayLbl);

		// 월, 년도 변경 버튼
		prevYearBtn = new JButton("<<");
		prevYearBtn.setBounds(20, 54, 50, 24);
		prevYearBtn.setToolTipText("Previous Year"); // 버튼 설명 툴팁
		prevYearBtn.addActionListener(listenMoveBtn);
		mainFrame.getContentPane().add(prevYearBtn);

		prevMonBtn = new JButton("<");
		prevMonBtn.setBounds(92, 54, 50, 24);
		prevMonBtn.setToolTipText("Previous Month");
		prevMonBtn.addActionListener(listenMoveBtn);
		mainFrame.getContentPane().add(prevMonBtn);

		nextMonBtn = new JButton(">");
		nextMonBtn.setBounds(368, 54, 50, 24);
		nextMonBtn.setToolTipText("Next Month");
		nextMonBtn.addActionListener(listenMoveBtn);
		mainFrame.getContentPane().add(nextMonBtn);

		nextYearBtn = new JButton(">>");
		nextYearBtn.setBounds(442, 54, 50, 24);
		nextYearBtn.setToolTipText("Next Year");
		nextYearBtn.addActionListener(listenMoveBtn);
		mainFrame.getContentPane().add(nextYearBtn);
		// 현재 월, 년도 라벨 출력
		curMMYYYYLbl = new JLabel(((calMonth + 1) < 10 ? " " : "") + (calMonth + 1) + " / " + calYear);
		curMMYYYYLbl.setHorizontalAlignment(SwingConstants.CENTER);
		curMMYYYYLbl.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		curMMYYYYLbl.setBounds(182, 54, 138, 24);
		mainFrame.getContentPane().add(curMMYYYYLbl);

		// 달력 디자인
		calPanel = new JPanel();
		weekHeadBtn = new JButton[7];
		for (int i = 0; i < CAL_COLUMN; i++) {
			weekHeadBtn[i] = new JButton(WEEK_HEAD[i]);
			weekHeadBtn[i].setBorderPainted(false); // 테두리 없음
			weekHeadBtn[i].setContentAreaFilled(true);
			weekHeadBtn[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			weekHeadBtn[i].setForeground(Color.WHITE); // 배경색(글자색)
			if (i == 0) // 일요일은 빨간색
				weekHeadBtn[i].setBackground(new Color(200, 50, 50));
			else if (i == 6) // 토요일은 파란색
				weekHeadBtn[i].setBackground(new Color(50, 100, 200));
			else // 평일은 회색
				weekHeadBtn[i].setBackground(new Color(150, 150, 150));
			weekHeadBtn[i].setOpaque(true); // 불투명도
			weekHeadBtn[i].setFocusPainted(false); // 포커스가 표시되지않음
			calPanel.add(weekHeadBtn[i]); // 달력 판넬에 요일제목 추가
		}
		for (int i = 0; i < CAL_MAX_ROW; i++) { // 날짜 출력할 빈버튼 세팅
			for (int j = 0; j < CAL_COLUMN; j++) {
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
		mainFrame.getContentPane().add(calPanel);
		calPanel.setLayout(new GridLayout(0, 7, 4, 4)); // 0행 7열 간격20으로 GridLayout 생성
		calPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // 안쪽 패딩
		showCal(); // dateBtns의 textSet 메소드

		JScrollPane scrollJTable = new JScrollPane();
		scrollJTable.setBounds(514, 86, 318, 465);
		mainFrame.getContentPane().add(scrollJTable);
		JtableModel = new DefaultTableModel(JtableHead, 0); // field를 제목으로 하고 줄을 0으로 초기화하며 tableModel 객체 생성
		Jtable = new JTable(JtableModel);
		Jtable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Jtable.getColumn("Done").setPreferredWidth(2);
		Jtable.getColumn("Time").setPreferredWidth(2);
		scrollJTable.setViewportView(Jtable);

		JtableDateLbl = new JLabel(
				today.get(Calendar.YEAR) + "/" + (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.DATE));
		JtableDateLbl.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		JtableDateLbl.setBounds(517, 66, 85, 15);
		mainFrame.getContentPane().add(JtableDateLbl);

		focusToday();

	}

	private void focusToday() {
		if (today.get(Calendar.DAY_OF_WEEK) == 1) // 일요일일때
			dateBtns[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
		else
			dateBtns[today.get(Calendar.WEEK_OF_MONTH) - 1][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
	}

	private void showCal() {
		for (int i = 0; i < CAL_MAX_ROW; i++) {
			for (int j = 0; j < CAL_COLUMN; j++) {
				dateBtns[i][j].removeAll(); // 초기화
				String fontColor = "black"; // 평일 폰트색상
				if (j == 0) // 일요일 폰트색상
					fontColor = "red";
				else if (j == 6) // 토요일 폰트색상
					fontColor = "blue";
				dateBtns[i][j].setText("<html><font color=" + fontColor + ">" + calDates[i][j] + "</font></html>\n"
						+ "test\n" + "test\n" + "test\n");

				JLabel todayMark = new JLabel("<html><font color=red>*</html>");
				if (calMonth == today.get(Calendar.MONTH) && calYear == today.get(Calendar.YEAR)
						&& calDates[i][j] == today.get(Calendar.DATE)) { // 오늘날짜와같다면
					dateBtns[i][j].add(todayMark); // dateBtns[i][j]에 todayMark를 추가
				}

				if (calDates[i][j] == 0) // 날짜가 0이라면
					dateBtns[i][j].setVisible(false); // 해당날짜버튼을 보이지않게
				else
					dateBtns[i][j].setVisible(true);
			}
		}
	}

	private class ListenerMoveDate implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == todayBtn) { // today버큰을 누르면
				setToday(); // 오늘로 날짜 멤버변수 세팅
				listenDateBtn.actionPerformed(e); // 날짜버튼이 클릭되면
				focusToday(); // 오늘을 포커스
			} else if (e.getSource() == prevYearBtn)
				moveMonth(-12); // 달을 바꾸며 날짜세팅
			else if (e.getSource() == prevMonBtn)
				moveMonth(-1);
			else if (e.getSource() == nextMonBtn)
				moveMonth(1);
			else if (e.getSource() == nextYearBtn)
				moveMonth(12);

			// 버튼으로 세팅된 날짜를 출력
			curMMYYYYLbl.setText(((calMonth + 1) < 10 ? " " : "") + (calMonth + 1) + " / " + calYear);
			curMMYYYYLbl.setHorizontalAlignment(SwingConstants.CENTER);
			showCal(); // 날짜 텍스트 다시 세팅
		}
	}

	private class ListenerDateBtns implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			int k = 0, l = 0;
//			for (int i = 0; i < CAL_MAX_ROW; i++) {
//				for (int j = 0; j < CAL_COLUMN; j++) {
//					if (e.getSource() == dateBtns[i][j]) {
//						k = i;
//						l = j;
//					}
//				}
//			}
//
//			if (!(k == 0 && l == 0))
//				calDate = calDates[k][l];
//
//			Calendar cal = new GregorianCalendar(calYear, calMonth, calDate);

		}
	}
}
