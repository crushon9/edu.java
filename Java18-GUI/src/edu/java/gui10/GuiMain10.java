package edu.java.gui10;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class GuiMain10 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMain10 window = new GuiMain10();
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
	public GuiMain10() {
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

		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 30, 410, 180);
		frame.getContentPane().add(textArea);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("굴림", Font.PLAIN, 12));
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFileChooser : 파일을 선택할 수 있는 팝업창
				JFileChooser chooser = new JFileChooser();
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) { // 확인버튼 클릭시
					textArea.setText("파일선택\n");
					File selected = chooser.getSelectedFile();
					textArea.append(selected.getAbsolutePath());
				} else { // 취소버튼 클릭시
					textArea.setText("파일열기취소");
				}
			}
		});
		mntmOpen.setFont(new Font("굴림", Font.PLAIN, 12));
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("저장은 안되는뎅");
			}
		});
		mntmSave.setFont(new Font("굴림", Font.PLAIN, 12));
		mnFile.add(mntmSave);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ConfirmDialog :
				// yes - no - cancel 버튼을 갖는 다이얼로그
				int result = JOptionPane.showConfirmDialog(frame.getContentPane(), "종료하시겠습니까?");
				// showConfirmDialog(Component parentComponent, Object message)
				// parentComponent : 부모컴퍼넌트를 매개변수로 넣으면, 그에 따라 현재 컴터넌트의 보여줄 위치를 설정한다
				System.out.println("Exit선택결과 : " + result);
				if (result == JOptionPane.YES_NO_OPTION) {
					// 프로그램 종료 :
					// System.exit(0); 정상종료
					// System.exit(0 이외의 숫자); 비정상종료
					System.exit(0);
				} else {
					textArea.setText("종료취소");
				}
			}
		});
		mntmExit.setFont(new Font("굴림", Font.PLAIN, 12));
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("굴림", Font.PLAIN, 12));
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 메시지와 ok버튼만 있는 다이얼로그 : MessageDialog
				JOptionPane.showMessageDialog(frame, "버전 1.0");
			}
		});
		mntmAbout.setFont(new Font("굴림", Font.PLAIN, 12));
		mnHelp.add(mntmAbout);
	}
}
