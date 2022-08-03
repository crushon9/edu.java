package edu.java.contact05;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContactMain05 {

	private JFrame frame;
	private JTextField textName, textPhone, textEmail, txtIndex;
	private JTextArea txtAreaInfo;
	public JTextArea textAreaLog;
	private ContactDAO dao;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain05 window = new ContactMain05();
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
	public ContactMain05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 670);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		int lblwidth = 55;
		int tfdwidth = 200;
		int lblheight = 30;
		int space = 10;
		int btnheight = 25;
		int btnwidth = 78;
		// 프로그램 제목
		JLabel lblHead = new JLabel("Contact Program ver 0.5");
		lblHead.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblHead.setBounds(150, 20, 400, 40);
		frame.getContentPane().add(lblHead);
		// 로그 테이블
		JScrollPane scrollLog = new JScrollPane();
		scrollLog.setBounds(3 * space, 280, 340, 140);
		frame.getContentPane().add(scrollLog);
		textAreaLog = new JTextArea();
		textAreaLog.setFont(new Font("돋움", Font.PLAIN, 13));
		textAreaLog.setBackground(new Color(255, 204, 255));
		scrollLog.setViewportView(textAreaLog);
		dao = ContactDAOImple.getInstance(textAreaLog);
		// 검색목록 테이블
		JScrollPane scrollInfo = new JScrollPane();
		scrollInfo.setBounds(3 * space, 440, 340, 160);
		frame.getContentPane().add(scrollInfo);
		txtAreaInfo = new JTextArea();
		txtAreaInfo.setFont(new Font("돋움", Font.PLAIN, 13));
		txtAreaInfo.setBackground(new Color(204, 204, 255));
		scrollInfo.setViewportView(txtAreaInfo);
		// J테이블
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setBounds(390, 80, 300, 520);
		frame.getContentPane().add(scrollTable);
		String[] field = { "No", "Name", "Phone", "Email" };
		tableModel = new DefaultTableModel(field, 0);
		table = new JTable(tableModel);
		scrollTable.setViewportView(table);
		JTableRefresh(tableModel);
		table.getColumn("No").setPreferredWidth(10);
		table.getColumn("Name").setPreferredWidth(40);
		// 입력라벨
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 0, 204));
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblName.setBounds(3 * space, 80, lblwidth, lblheight);
		frame.getContentPane().add(lblName);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(0, 0, 204));
		lblPhone.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblPhone.setBounds(3 * space, 80 + lblheight + space, lblwidth, lblheight);
		frame.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 0, 204));
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblEmail.setBounds(3 * space, 80 + 2 * lblheight + 2 * space, lblwidth, lblheight);
		frame.getContentPane().add(lblEmail);
		// 입력 텍스트 박스
		textName = new JTextField("이름을 입력하세요");
		textName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textName.setText("");
			}
		});
		textName.setBounds(4 * space + lblwidth, 80, tfdwidth, lblheight);
		frame.getContentPane().add(textName);
		textName.setColumns(10);

		textPhone = new JTextField("전화번호를 입력하세요");
		textPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textPhone.setText("");
			}
		});
		textPhone.setColumns(10);
		textPhone.setBounds(4 * space + lblwidth, 80 + lblheight + space, tfdwidth, lblheight);
		frame.getContentPane().add(textPhone);

		textEmail = new JTextField("이메일을 입력하세요");
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textEmail.setText("");
			}
		});
		textEmail.setColumns(10);
		textEmail.setBounds(4 * space + lblwidth, 80 + 2 * lblheight + 2 * space, tfdwidth, lblheight);
		frame.getContentPane().add(textEmail);
		// Insert버튼
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertContact();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.PLAIN, 12));
		btnInsert.setBackground(new Color(211, 211, 211));
		btnInsert.setBounds(310, 80, 65, 3 * lblheight + 2 * space);
		frame.getContentPane().add(btnInsert);
		// Index입력 텍스트필드
		txtIndex = new JTextField("Index입력");
		txtIndex.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtIndex.setText("");
			}
		});
		txtIndex.setForeground(new Color(0, 0, 205));
		txtIndex.setFont(new Font("굴림", Font.PLAIN, 12));
		txtIndex.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndex.setBounds(3 * space, 206, btnwidth, btnheight);
		frame.getContentPane().add(txtIndex);
		txtIndex.setColumns(10);
		// Search버튼
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByIndex();
			}
		});
		btnSearch.setBackground(new Color(211, 211, 211));
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btnSearch.setBounds(4 * space + btnwidth, 206, btnwidth, btnheight);
		frame.getContentPane().add(btnSearch);
		// Update 버튼
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateContact();
			}
		});
		btnUpdate.setBackground(new Color(211, 211, 211));
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 12));
		btnUpdate.setBounds(5 * space + 2 * btnwidth, 206, btnwidth, btnheight);
		frame.getContentPane().add(btnUpdate);
		// Delete 버튼
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deleteContact();
			}
		});
		btnDelete.setBackground(new Color(211, 211, 211));
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 12));
		btnDelete.setBounds(6 * space + 3 * btnwidth, 206, btnwidth, btnheight);
		frame.getContentPane().add(btnDelete);
		// All Search 버튼
		JButton btnAllSearch = new JButton("All Search");
		btnAllSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAll();
			}
		});
		btnAllSearch.setBackground(new Color(211, 211, 211));
		btnAllSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btnAllSearch.setBounds(216, 240, 2 * btnwidth, btnheight);
		frame.getContentPane().add(btnAllSearch);

	} // end initialize

	private void JTableRefresh(DefaultTableModel tableModel) {
		Object record[] = new Object[4];
		ArrayList<ContactVO> list = dao.select();
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			ContactVO vo = list.get(i);
			record[0] = i;
			record[1] = vo.getName();
			record[2] = vo.getPhone();
			record[3] = vo.getEmail();
			tableModel.addRow(record);
		}
	} // end JJTableRefresh

	private void insertContact() {
		ContactVO vo = new ContactVO(textName.getText(), textPhone.getText(), textEmail.getText());
		int result = dao.insert(vo, textAreaLog);
		if (result == 1) {
			textAreaLog.setText("저장성공!");
			JTableRefresh(tableModel);
		} else {
			textAreaLog.setText("저장실패!");
		}
	} // end insertContact

	private void selectAll() {
		txtAreaInfo.setText("");
		ArrayList<ContactVO> list = dao.select();
		for (int i = 0; i < list.size(); i++) {
			txtAreaInfo.append("[No." + i + "] " + list.get(i) + "\n");
		}
		txtAreaInfo.append("검색완료!");
		
	} // end selectAll

	private void selectByIndex() {
		try {
			int index = Integer.parseInt(txtIndex.getText());
			int size = ((ContactDAOImple) dao).getListSize();
			if (index >= 0 && index < size) {
				ContactVO vo = dao.select(index); // 한명의 정보만 가져옴
				txtAreaInfo.setText("[No." + index + "] " + vo);
				txtAreaInfo.append("\n검색완료!");
			} else {
				textAreaLog.setText("저장되지 않은 No 입니다!!");
			}
		} catch (Exception e2) {
			textAreaLog.setText("Index는 숫자만 입력하세요!");
			System.out.println(e2.getMessage());
		}
	} // end selectByIndex

	private void updateContact() {
		try {
			int index = Integer.parseInt(txtIndex.getText());
			int size = ((ContactDAOImple) dao).getListSize();
			if (index >= 0 && index < size) {
				ContactVO vo = new ContactVO(textName.getText(), textPhone.getText(), textEmail.getText());
				int result = dao.update(index, vo, textAreaLog);
				if (result == 1) {
					textAreaLog.setText("[No." + index + "] 수정성공!");
					JTableRefresh(tableModel);
				} else {
					textAreaLog.setText("[No." + index + "] 수정실패!");
				}
			} else {
				textAreaLog.setText("저장되지 않은 No 입니다!!");
			}
		} catch (Exception e2) {
			textAreaLog.setText("Index는 숫자만 입력하세요!");
			System.out.println(e2.getMessage());
		}
	} // end updateContact

	private void deleteContact() {
		try {
			int index = Integer.parseInt(txtIndex.getText());
			int size = ((ContactDAOImple) dao).getListSize();
			if (index >= 0 && index < size) {
				int result = dao.delete(index, textAreaLog);
				if (result == 1) {
					textAreaLog.setText("[No." + index + "] 삭제성공!");
					JTableRefresh(tableModel);
				} else {
					textAreaLog.setText("[No." + index + "] 삭제실패!");
				}
			} else {
				textAreaLog.setText("저장되지 않은 No 입니다!!");
			}
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
	} // end deleteContact
}
