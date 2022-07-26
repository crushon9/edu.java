package edu.java.contact06;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ContactMain06 {

	private JFrame frame;
	private JTextField textName, textPhone, textEmail, txtContactId;
	private JButton btnInsert, btnSearch, btnAllSearch, btnUpdate, btnDelete;
	private JTextArea txtAreaInfo;
	JTextArea textAreaLog; // (default) 같은 패키지의 다른 클래스에서 사용
	private JTable table;
	private DefaultTableModel tableModel;
	private String[] JtableHead = { "ID", "NAME", "PHONE", "EMAIL" };
	private ContactDAO dao; // 인터페이스 다형성

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactMain06 window = new ContactMain06();
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
	public ContactMain06() {
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

		// 디자인 사이즈
		int lblwidth = 55;
		int tfdwidth = 200;
		int lblheight = 30;
		int space = 10;
		int btnheight = 25;
		int btnwidth = 78;

		// 프로그램 제목
		JLabel lblHead = new JLabel("Contact Program ver 0.6");
		lblHead.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblHead.setBounds(150, 20, 400, 40);
		frame.getContentPane().add(lblHead);

		// 로그출력 테이블
		JScrollPane scrollLog = new JScrollPane();
		scrollLog.setBounds(3 * space, 280, 340, 140);
		frame.getContentPane().add(scrollLog);
		textAreaLog = new JTextArea();
		textAreaLog.setFont(new Font("돋움", Font.PLAIN, 13));
		textAreaLog.setBackground(new Color(153, 190, 250));
		scrollLog.setViewportView(textAreaLog);
		dao = ContactDAOImple.getInstance(textAreaLog); // 위에서 생성하면 null예외땜에 textAreaLog 생성직후 dao인스턴스 생성

		// 검색출력 테이블
		JScrollPane scrollInfo = new JScrollPane();
		scrollInfo.setBounds(3 * space, 440, 340, 160);
		frame.getContentPane().add(scrollInfo);
		txtAreaInfo = new JTextArea();
		txtAreaInfo.setFont(new Font("돋움", Font.PLAIN, 13));
		txtAreaInfo.setBackground(new Color(224, 255, 255));
		scrollInfo.setViewportView(txtAreaInfo);

		// J테이블
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setBounds(390, 80, 300, 520);
		frame.getContentPane().add(scrollTable);
		tableModel = new DefaultTableModel(JtableHead, 0); // field를 제목으로 하고 줄을 0으로 초기화하며 tableModel 객체 생성
		table = new JTable(tableModel);
		table.getColumn("ID").setPreferredWidth(6); // 열 사이즈 조정
		table.getColumn("NAME").setPreferredWidth(30);
		scrollTable.setViewportView(table);
		JTableRefresh(tableModel); // 현재 데이터로 업데이트

		// 입력 데이터 라벨
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
			public void mouseClicked(MouseEvent e) { // 마우스를 클릭하면 공백으로 초기화
				textName.setText("");
			}
		});
		textName.setBounds(4 * space + lblwidth, 80, tfdwidth, lblheight);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		textPhone = new JTextField("전화번호를 입력하세요");
		textPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) { // 포커스를 얻으면 공백으로 초기화
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
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertContact();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.PLAIN, 12));
		btnInsert.setBackground(new Color(211, 211, 211));
		btnInsert.setBounds(306, 80, 65, 3 * lblheight + 2 * space);
		frame.getContentPane().add(btnInsert);

		// ID입력 텍스트필드
		txtContactId = new JTextField("ID입력");
		txtContactId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtContactId.setText("");
			}
		});
		txtContactId.setForeground(new Color(0, 0, 205));
		txtContactId.setFont(new Font("굴림", Font.PLAIN, 12));
		txtContactId.setHorizontalAlignment(SwingConstants.CENTER);
		txtContactId.setBounds(3 * space, 206, btnwidth, btnheight);
		frame.getContentPane().add(txtContactId);
		txtContactId.setColumns(10);

		// Search버튼
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByIdContact();
			}
		});
		btnSearch.setBackground(new Color(211, 211, 211));
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btnSearch.setBounds(4 * space + btnwidth, 206, btnwidth, btnheight);
		frame.getContentPane().add(btnSearch);

		// Update 버튼
		btnUpdate = new JButton("Update");
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
		btnDelete = new JButton("Delete");
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
		btnAllSearch = new JButton("All Search");
		btnAllSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAllContact();
			}
		});
		btnAllSearch.setBackground(new Color(211, 211, 211));
		btnAllSearch.setFont(new Font("굴림", Font.PLAIN, 12));
		btnAllSearch.setBounds(216, 240, 2 * btnwidth, btnheight);
		frame.getContentPane().add(btnAllSearch);

	} // end initialize

	private void insertContact() {
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		// 입력값이 하나라도 입력되지 않으면 경고창을 띄움
		if (name.equals("") || phone.equals("") || email.equals("")) {
			JOptionPane.showMessageDialog(frame, "연락처 정보를 입력하세요");
			return; // 경고조건이 발생하면 메소드 종료 아래 코드 종료
		}
		// contactId는 insert에서 필요없으므로 제외한 생성자를 선언
		ContactVO vo = new ContactVO(name, phone, email);
		int result = dao.insert(vo);
		if (result == 1) {
			textAreaLog.setText("새 연락처 등록 성공!");
			JTableRefresh(tableModel); // 데이터가 변경될 때마다 JTable 리프레쉬
		} else {
			textAreaLog.setText("새 연락처 등록 실패!");
		}
	} // end insertContact

	private void selectAllContact() {
		ArrayList<ContactVO> list = dao.select(); // DB에서 전체 정보를 가져옴
		txtAreaInfo.setText("");
		for (int i = 0; i < list.size(); i++) { // 사이즈만큼 반복하여 한줄씩 출력
			txtAreaInfo.append(list.get(i) + "\n");
		}
		txtAreaInfo.append("전체 검색 완료!");
	} // end selectAllContact

	private void selectByIdContact() {
		try {
			int contactId = Integer.parseInt(txtContactId.getText());
			ContactVO vo = dao.select(contactId); // 한명의 정보만 가져옴
			if (vo.getContactId() != 0) { // DB에서 가져온 contactId값이 0이 아니라면
				txtAreaInfo.setText(vo.toString());
				txtAreaInfo.append("\n검색완료!");
			} else { // 인덱스없을시 vo의 contactId 초기값 0 리턴
				txtAreaInfo.setText("");
				textAreaLog.setText("검색실패_ [ID." + contactId + "] 이(가) 없습니다");
			}
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(frame, "ID는 숫자만 입력하세요!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end selectByIdContact

	private void updateContact() {
		try {
			int contactId = Integer.parseInt(txtContactId.getText());
			String name = textName.getText();
			String phone = textPhone.getText();
			String email = textEmail.getText();
			// 입력값이 하나라도 입력되지 않으면 경고창을 띄움
			if (name.equals("") || phone.equals("") || email.equals("")) {
				JOptionPane.showMessageDialog(frame, "연락처 정보를 입력하세요");
				return;
			}
			ContactVO vo = new ContactVO(contactId, name, phone, email);
			int result = dao.update(vo);
			if (result == 1) {
				textAreaLog.setText("[ID." + contactId + "] 수정성공!");
				JTableRefresh(tableModel); // 데이터가 변경될 때마다 JTable 리프레쉬
			} else {
				txtAreaInfo.setText("");
				textAreaLog.setText("수정실패_ [ID." + contactId + "] 이(가) 없습니다");
			}
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(frame, "ID는 숫자만 입력하세요!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end updateContact

	private void deleteContact() {
		try {
			int contactId = Integer.parseInt(txtContactId.getText());
			int result = dao.delete(contactId);
			if (result == 1) {
				textAreaLog.setText("[ID." + contactId + "] 삭제성공!");
				JTableRefresh(tableModel); // 데이터가 변경될 때마다 JTable 리프레쉬
			} else {
				txtAreaInfo.setText("");
				textAreaLog.setText("삭제실패_ [ID." + contactId + "] 이(가) 없습니다");
			}
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(frame, "ID는 숫자만 입력하세요!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end deleteContact

	private void JTableRefresh(DefaultTableModel tableModel) {
		ArrayList<ContactVO> list = dao.select();
		tableModel.setRowCount(0); // 행을 0줄로 초기화
		Object record[] = new Object[JtableHead.length]; // 다형성으로 Object그릇에는 모든 데이터가 담길수있음
		for (int i = 0; i < list.size(); i++) {
			record[0] = list.get(i).getContactId();
			record[1] = list.get(i).getName();
			record[2] = list.get(i).getPhone();
			record[3] = list.get(i).getEmail();
			tableModel.addRow(record);
		}
	} // end JTableRefresh
}
