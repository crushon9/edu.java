package edu.java.gui14;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class GuiMain14 {

	private JFrame frame;
	private JLabel lblDate;
	int count = 100;
	private JProgressBar progressBar;
	private JDialog dialog;
	private Timer timer;

	private int year, month, day, hour, minute, seconds;
	private Calendar cal;
	private JButton btnNewButton2;
	private boolean isStop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain14 window = new GuiMain14();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiMain14() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblDate = new JLabel();
		lblDate.setBounds(12, 22, 410, 50);
		lblDate.setFont(new Font("굴림", Font.BOLD, 30));
		frame.getContentPane().add(lblDate);
		currentDate();
		progressBar = new JProgressBar();
		progressBar.setBounds(12, 0, 410, 20);
		progressBar.setValue(count);
		frame.getContentPane().add(progressBar);

		JButton btnNewButton = new JButton("시작");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTimer();
			}
		});
		btnNewButton.setBounds(162, 116, 97, 23);
		frame.getContentPane().add(btnNewButton);

		btnNewButton2 = new JButton("종료");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStop = true;
			}
		});
		btnNewButton2.setBounds(271, 116, 97, 23);
		frame.getContentPane().add(btnNewButton2);
		dialog = new MyDialog();
		dialog.setVisible(false);

	}

	private void startTimer() {
		isStop = false;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (isStop) {
					timer.cancel();
				}
				if (count > 0) {
					count--;
					progressBar.setValue(count);
				} else {
					dialog.setVisible(true);
					timer.cancel();
				}
			}
		};
		timer = new Timer();
		timer.schedule(timerTask, 1, 1000);
	}

	private void currentDate() {
		cal = GregorianCalendar.getInstance();

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				year = cal.get(Calendar.YEAR);

				month = cal.get(Calendar.MONTH) + 1;

				day = cal.get(Calendar.DAY_OF_MONTH);

				hour = cal.get(Calendar.HOUR_OF_DAY);

				minute = cal.get(Calendar.MINUTE);

				seconds = cal.get(Calendar.SECOND);

				String dateString = String.format("%02d/%02d/%02d %02d:%02d:%02d", year, month, day, hour, minute,
						seconds);
				lblDate.setText(dateString);
				cal.add(Calendar.SECOND, 1);
			}
		};
		timer = new Timer();
		timer.schedule(timerTask, 1, 1000);
	}
}
