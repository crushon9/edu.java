package calendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

class CalendarDataManager {
	static final int CAL_COLUMN = 7; // 요일 7개
	static final int CAL_ROW = 6; // 월의 최대행갯수
	int calDates[][] = new int[CAL_ROW][CAL_COLUMN];
	int calYear;
	int calMonth;
	int calDate; // 현재월의날짜
	final int calEndDateArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 월별기본마지막날짜
	int calEndDate; // 윤달을 계산한 실제 마지막 날짜
	Calendar today = Calendar.getInstance();

	// 생성자호출시 오늘날짜 세팅
	public CalendarDataManager() {
		setToday();
	}

	// 오늘의 년도, 월, 날짜를 추출하여 캘린더생성메소드로 넘겨주며 호출
	public void setToday() {
		calYear = today.get(Calendar.YEAR);
		calMonth = today.get(Calendar.MONTH);
		calDate = today.get(Calendar.DATE);
		makeCalData(today);
	} // end setToday()

	// 윤달 체크 계산식 (4로 나누어지고, 100으로 나누어지지 않거나 / 400으로 나누어지면)
	private int leapCheck(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return 1;
		else
			return 0;
	} // end leapCheck()

	// 동적 달력 생성
	private void makeCalData(Calendar cal) {
		// 월의 시작지점 계산
		int StartDayOfMonth = (cal.get(Calendar.DAY_OF_WEEK) - (cal.get(Calendar.DATE) % 7) + 7) % 7;
		if (calMonth == 1) // 인덱스1 = 2월 윤달체크
			calEndDate = calEndDateArray[calMonth] + leapCheck(calYear);
		else
			calEndDate = calEndDateArray[calMonth];

		for (int row = 0; row < CAL_ROW; row++) {
			for (int col = 0; col < CAL_COLUMN; col++) {
				calDates[row][col] = 0; // 0으로 초기화
			}
		}

		for (int row = 0, date = 1, start = 0; row < CAL_ROW; row++) {
			if (row == 0) // 첫번째줄일때는
				start = StartDayOfMonth; // 시작위치를 월시작위치로 설정
			else // 아니라면
				start = 0; // 0번째 시작위치로
			for (int col = start; col < CAL_COLUMN; col++) {
				if (date <= calEndDate)
					calDates[row][col] = date++;
			}
		}
	} // makeCalData()

	public void moveMonth(int mon) {
		calMonth += mon;
		if (calMonth > 11)
			while (calMonth > 11) {
				calYear++;
				calMonth -= 12;
			}
		else if (calMonth < 0)
			while (calMonth < 0) {
				calYear--;
				calMonth += 12;
			}
		Calendar cal = new GregorianCalendar(calYear, calMonth, calDate);
		makeCalData(cal);
	} // end moveMonth()
} // end CalendarDataManager class

public class MemoCalendar extends CalendarDataManager {

	JFrame mainFrame;
	ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));

	JPanel calOpPanel;
	JButton todayBut;
	JLabel todayLab;
	JButton lYearBut;
	JButton lMonBut;
	JLabel curMMYYYYLab;
	JButton nMonBut;
	JButton nYearBut;
	ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();

	JPanel calPanel;
	JButton weekDaysName[];
	JButton dateButs[][] = new JButton[6][7];
	listenForDateButs lForDateButs = new listenForDateButs();

	JPanel infoPanel;
	JLabel infoClock;

	JPanel memoPanel;
	JLabel selectedDate;
	JTextArea memoArea;
	JScrollPane memoAreaSP;
	JPanel memoSubPanel;
	JButton saveBut;
	JButton delBut;
	JButton clearBut;

	JPanel frameBottomPanel;
	JLabel bottomInfo = new JLabel("Welcome to Memo Calendar!");
	// ���, �޼���
	final String WEEK_DAY_NAME[] = { "SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT" };
	final String title = "�޸� �޷� ver 1.0";
	final String SaveButMsg1 = "�� MemoData������ �����Ͽ����ϴ�.";
	final String SaveButMsg2 = "�޸� ���� �ۼ��� �ּ���.";
	final String SaveButMsg3 = "<html><font color=red>ERROR : ���� ���� ����</html>";
	final String DelButMsg1 = "�޸� �����Ͽ����ϴ�.";
	final String DelButMsg2 = "�ۼ����� �ʾҰų� �̹� ������ memo�Դϴ�.";
	final String DelButMsg3 = "<html><font color=red>ERROR : ���� ���� ����</html>";
	final String ClrButMsg1 = "�Էµ� �޸� ������ϴ�.";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MemoCalendar();
			}
		});
	}

	public MemoCalendar() {

		mainFrame = new JFrame(title);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(700, 400);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setIconImage(icon.getImage());
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(mainFrame);
		} catch (Exception e) {
			bottomInfo.setText("ERROR : LookAndFeel setting failed");
		}

		calOpPanel = new JPanel();
		todayBut = new JButton("Today");
		todayBut.setToolTipText("Today");
		todayBut.addActionListener(lForCalOpButtons);
		todayLab = new JLabel(
				today.get(Calendar.MONTH) + 1 + "/" + today.get(Calendar.DATE) + "/" + today.get(Calendar.YEAR));
		lYearBut = new JButton("<<");
		lYearBut.setToolTipText("Previous Year");
		lYearBut.addActionListener(lForCalOpButtons);
		lMonBut = new JButton("<");
		lMonBut.setToolTipText("Previous Month");
		lMonBut.addActionListener(lForCalOpButtons);
		curMMYYYYLab = new JLabel("<html><table width=100><tr><th><font size=5>" + ((calMonth + 1) < 10 ? "&nbsp;" : "")
				+ (calMonth + 1) + " / " + calYear + "</th></tr></table></html>");
		nMonBut = new JButton(">");
		nMonBut.setToolTipText("Next Month");
		nMonBut.addActionListener(lForCalOpButtons);
		nYearBut = new JButton(">>");
		nYearBut.setToolTipText("Next Year");
		nYearBut.addActionListener(lForCalOpButtons);
		calOpPanel.setLayout(new GridBagLayout());
		GridBagConstraints calOpGC = new GridBagConstraints();
		calOpGC.gridx = 1;
		calOpGC.gridy = 1;
		calOpGC.gridwidth = 2;
		calOpGC.gridheight = 1;
		calOpGC.weightx = 1;
		calOpGC.weighty = 1;
		calOpGC.insets = new Insets(5, 5, 0, 0);
		calOpGC.anchor = GridBagConstraints.WEST;
		calOpGC.fill = GridBagConstraints.NONE;
		calOpPanel.add(todayBut, calOpGC);
		calOpGC.gridwidth = 3;
		calOpGC.gridx = 2;
		calOpGC.gridy = 1;
		calOpPanel.add(todayLab, calOpGC);
		calOpGC.anchor = GridBagConstraints.CENTER;
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 1;
		calOpGC.gridy = 2;
		calOpPanel.add(lYearBut, calOpGC);
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 2;
		calOpGC.gridy = 2;
		calOpPanel.add(lMonBut, calOpGC);
		calOpGC.gridwidth = 2;
		calOpGC.gridx = 3;
		calOpGC.gridy = 2;
		calOpPanel.add(curMMYYYYLab, calOpGC);
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 5;
		calOpGC.gridy = 2;
		calOpPanel.add(nMonBut, calOpGC);
		calOpGC.gridwidth = 1;
		calOpGC.gridx = 6;
		calOpGC.gridy = 2;
		calOpPanel.add(nYearBut, calOpGC);

		calPanel = new JPanel();
		weekDaysName = new JButton[7];
		for (int i = 0; i < CAL_COLUMN; i++) {
			weekDaysName[i] = new JButton(WEEK_DAY_NAME[i]);
			weekDaysName[i].setBorderPainted(false);
			weekDaysName[i].setContentAreaFilled(false);
			weekDaysName[i].setForeground(Color.WHITE);
			if (i == 0)
				weekDaysName[i].setBackground(new Color(200, 50, 50));
			else if (i == 6)
				weekDaysName[i].setBackground(new Color(50, 100, 200));
			else
				weekDaysName[i].setBackground(new Color(150, 150, 150));
			weekDaysName[i].setOpaque(true);
			weekDaysName[i].setFocusPainted(false);
			calPanel.add(weekDaysName[i]);
		}
		for (int i = 0; i < CAL_ROW; i++) {
			for (int j = 0; j < CAL_COLUMN; j++) {
				dateButs[i][j] = new JButton();
				dateButs[i][j].setBorderPainted(false);
				dateButs[i][j].setContentAreaFilled(false);
				dateButs[i][j].setBackground(Color.WHITE);
				dateButs[i][j].setOpaque(true);
				dateButs[i][j].addActionListener(lForDateButs);
				calPanel.add(dateButs[i][j]);
			}
		}
		calPanel.setLayout(new GridLayout(0, 7, 2, 2));
		calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
		showCal();

		infoPanel = new JPanel();
		infoPanel.setLayout(new BorderLayout());
		infoClock = new JLabel("", SwingConstants.RIGHT);
		infoClock.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		infoPanel.add(infoClock, BorderLayout.NORTH);
		selectedDate = new JLabel("<Html><font size=3>" + (today.get(Calendar.MONTH) + 1) + "/"
				+ today.get(Calendar.DATE) + "/" + today.get(Calendar.YEAR) + "&nbsp;(Today)</html>",
				SwingConstants.LEFT);
		selectedDate.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));

		memoPanel = new JPanel();
		memoPanel.setBorder(BorderFactory.createTitledBorder("Memo"));
		memoArea = new JTextArea();
		memoArea.setLineWrap(true);
		memoArea.setWrapStyleWord(true);
		memoAreaSP = new JScrollPane(memoArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		readMemo();

		memoSubPanel = new JPanel();
		saveBut = new JButton("Save");
		saveBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					File f = new File("MemoData");
					if (!f.isDirectory())
						f.mkdir();

					String memo = memoArea.getText();
					if (memo.length() > 0) {
						BufferedWriter out = new BufferedWriter(
								new FileWriter("MemoData/" + calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
										+ (calDate < 10 ? "0" : "") + calDate + ".txt"));
						String str = memoArea.getText();
						out.write(str);
						out.close();
						bottomInfo.setText(calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
								+ (calDate < 10 ? "0" : "") + calDate + ".txt" + SaveButMsg1);
					} else
						bottomInfo.setText(SaveButMsg2);
				} catch (IOException e) {
					bottomInfo.setText(SaveButMsg3);
				}
				showCal();
			}
		});
		delBut = new JButton("Delete");
		delBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memoArea.setText("");
				File f = new File("MemoData/" + calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
						+ (calDate < 10 ? "0" : "") + calDate + ".txt");
				if (f.exists()) {
					f.delete();
					showCal();
					bottomInfo.setText(DelButMsg1);
				} else
					bottomInfo.setText(DelButMsg2);
			}
		});
		clearBut = new JButton("Clear");
		clearBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				memoArea.setText(null);
				bottomInfo.setText(ClrButMsg1);
			}
		});
		memoSubPanel.add(saveBut);
		memoSubPanel.add(delBut);
		memoSubPanel.add(clearBut);
		memoPanel.setLayout(new BorderLayout());
		memoPanel.add(selectedDate, BorderLayout.NORTH);
		memoPanel.add(memoAreaSP, BorderLayout.CENTER);
		memoPanel.add(memoSubPanel, BorderLayout.SOUTH);

		JPanel frameSubPanelWest = new JPanel();
		Dimension calOpPanelSize = calOpPanel.getPreferredSize();
		calOpPanelSize.height = 90;
		calOpPanel.setPreferredSize(calOpPanelSize);
		frameSubPanelWest.setLayout(new BorderLayout());
		frameSubPanelWest.add(calOpPanel, BorderLayout.NORTH);
		frameSubPanelWest.add(calPanel, BorderLayout.CENTER);

		JPanel frameSubPanelEast = new JPanel();
		Dimension infoPanelSize = infoPanel.getPreferredSize();
		infoPanelSize.height = 65;
		infoPanel.setPreferredSize(infoPanelSize);
		frameSubPanelEast.setLayout(new BorderLayout());
		frameSubPanelEast.add(infoPanel, BorderLayout.NORTH);
		frameSubPanelEast.add(memoPanel, BorderLayout.CENTER);

		Dimension frameSubPanelWestSize = frameSubPanelWest.getPreferredSize();
		frameSubPanelWestSize.width = 410;
		frameSubPanelWest.setPreferredSize(frameSubPanelWestSize);

		frameBottomPanel = new JPanel();
		frameBottomPanel.add(bottomInfo);

		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(frameSubPanelWest, BorderLayout.WEST);
		mainFrame.add(frameSubPanelEast, BorderLayout.CENTER);
		mainFrame.add(frameBottomPanel, BorderLayout.SOUTH);
		mainFrame.setVisible(true);

		focusToday();

		ThreadConrol threadCnl = new ThreadConrol();
		threadCnl.start();
	}

	private void focusToday() {
		if (today.get(Calendar.DAY_OF_WEEK) == 1)
			dateButs[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
		else
			dateButs[today.get(Calendar.WEEK_OF_MONTH) - 1][today.get(Calendar.DAY_OF_WEEK) - 1].requestFocusInWindow();
	}

	private void readMemo() {
		try {
			File f = new File("MemoData/" + calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
					+ (calDate < 10 ? "0" : "") + calDate + ".txt");
			if (f.exists()) {
				BufferedReader in = new BufferedReader(
						new FileReader("MemoData/" + calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
								+ (calDate < 10 ? "0" : "") + calDate + ".txt"));
				String memoAreaText = new String();
				while (true) {
					String tempStr = in.readLine();
					if (tempStr == null)
						break;
					memoAreaText = memoAreaText + tempStr + System.getProperty("line.separator");
				}
				memoArea.setText(memoAreaText);
				in.close();
			} else
				memoArea.setText("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void showCal() {
		for (int i = 0; i < CAL_ROW; i++) {
			for (int j = 0; j < CAL_COLUMN; j++) {
				String fontColor = "black";
				if (j == 0)
					fontColor = "red";
				else if (j == 6)
					fontColor = "blue";

				File f = new File("MemoData/" + calYear + ((calMonth + 1) < 10 ? "0" : "") + (calMonth + 1)
						+ (calDates[i][j] < 10 ? "0" : "") + calDates[i][j] + ".txt");
				if (f.exists()) {
					dateButs[i][j]
							.setText("<html><b><font color=" + fontColor + ">" + calDates[i][j] + "</font></b></html>");
				} else
					dateButs[i][j].setText("<html><font color=" + fontColor + ">" + calDates[i][j] + "</font></html>");

				JLabel todayMark = new JLabel("<html><font color=green>*</html>");
				dateButs[i][j].removeAll();
				if (calMonth == today.get(Calendar.MONTH) && calYear == today.get(Calendar.YEAR)
						&& calDates[i][j] == today.get(Calendar.DATE)) {
					dateButs[i][j].add(todayMark);
					dateButs[i][j].setToolTipText("Today");
				}

				if (calDates[i][j] == 0)
					dateButs[i][j].setVisible(false);
				else
					dateButs[i][j].setVisible(true);
			}
		}
	}

	private class ListenForCalOpButtons implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == todayBut) {
				setToday();
				lForDateButs.actionPerformed(e);
				focusToday();
			} else if (e.getSource() == lYearBut)
				moveMonth(-12);
			else if (e.getSource() == lMonBut)
				moveMonth(-1);
			else if (e.getSource() == nMonBut)
				moveMonth(1);
			else if (e.getSource() == nYearBut)
				moveMonth(12);

			curMMYYYYLab.setText("<html><table width=100><tr><th><font size=5>" + ((calMonth + 1) < 10 ? "&nbsp;" : "")
					+ (calMonth + 1) + " / " + calYear + "</th></tr></table></html>");
			showCal();
		}
	}

	private class listenForDateButs implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int k = 0, l = 0;
			for (int i = 0; i < CAL_ROW; i++) {
				for (int j = 0; j < CAL_COLUMN; j++) {
					if (e.getSource() == dateButs[i][j]) {
						k = i;
						l = j;
					}
				}
			}

			if (!(k == 0 && l == 0))
				calDate = calDates[k][l];

			Calendar cal = new GregorianCalendar(calYear, calMonth, calDate);

			String dDayString = new String();
			int dDay = ((int) ((cal.getTimeInMillis() - today.getTimeInMillis()) / 1000 / 60 / 60 / 24));
			if (dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR))
					&& (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
					&& (cal.get(Calendar.DATE) == today.get(Calendar.DATE)))
				dDayString = "Today";
			else if (dDay >= 0)
				dDayString = "D-" + (dDay + 1);
			else if (dDay < 0)
				dDayString = "D+" + (dDay) * (-1);

			selectedDate.setText("<Html><font size=3>" + (calMonth + 1) + "/" + calDate + "/" + calYear + "&nbsp;("
					+ dDayString + ")</html>");

			readMemo();
		}
	}

	private class ThreadConrol extends Thread {
		public void run() {
			boolean msgCntFlag = false;
			int num = 0;
			String curStr = new String();
			while (true) {
				try {
					today = Calendar.getInstance();
					String amPm = (today.get(Calendar.AM_PM) == 0 ? "AM" : "PM");
					String hour;
					if (today.get(Calendar.HOUR) == 0)
						hour = "12";
					else if (today.get(Calendar.HOUR) == 12)
						hour = " 0";
					else
						hour = (today.get(Calendar.HOUR) < 10 ? " " : "") + today.get(Calendar.HOUR);
					String min = (today.get(Calendar.MINUTE) < 10 ? "0" : "") + today.get(Calendar.MINUTE);
					String sec = (today.get(Calendar.SECOND) < 10 ? "0" : "") + today.get(Calendar.SECOND);
					infoClock.setText(amPm + " " + hour + ":" + min + ":" + sec);

					sleep(1000);
					String infoStr = bottomInfo.getText();

					if (infoStr != " " && (msgCntFlag == false || curStr != infoStr)) {
						num = 5;
						msgCntFlag = true;

						curStr = infoStr;
					} else if (infoStr != " " && msgCntFlag == true) {
						if (num > 0)
							num--;
						else {
							msgCntFlag = false;
							bottomInfo.setText(" ");
						}
					}
				} catch (InterruptedException e) {
					System.out.println("Thread:Error");
				}
			}
		}
	}
}