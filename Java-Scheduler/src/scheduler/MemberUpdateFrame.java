package scheduler;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberUpdateFrame extends JFrame {

	private JButton btnPw;
	private JButton btnDelete, btnUpdate;
	private JTextField textPw, textPw2;
	private JPanel contentPane;
	private int resultPw;

	public MemberUpdateFrame(String Id, MemberDAOImple memberDao) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null); // 화면중앙에 창 띄우기
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(SystemColor.controlDkShadow);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblId.setBounds(60, 90, 100, 20);
		contentPane.add(lblId);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setForeground(SystemColor.controlDkShadow);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw.setBounds(60, 130, 100, 20);
		contentPane.add(lblPw);

		JLabel lblPw2 = new JLabel("Confirm PW");
		lblPw2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw2.setForeground(SystemColor.controlDkShadow);
		lblPw2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblPw2.setBounds(60, 170, 100, 20);
		contentPane.add(lblPw2);

		JLabel lblGetId = new JLabel(Id);
		lblGetId.setBounds(180, 90, 110, 20);
		contentPane.add(lblGetId);

		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(180, 130, 110, 20);
		contentPane.add(textPw);

		textPw2 = new JTextField();
		textPw2.setColumns(10);
		textPw2.setBounds(180, 170, 110, 20);
		contentPane.add(textPw2);

		btnPw = new JButton("Check");
		btnPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPw = pwCheck();
				if (resultPw == 1) {
					btnUpdate.setEnabled(true);
				}
			}
		});
		btnPw.setBounds(300, 170, 70, 20);
		btnPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPw.setForeground(new Color(105, 105, 105));
		btnPw.setBackground(new Color(204, 204, 255));
		contentPane.add(btnPw);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberUpdate(memberDao);
			}
		});
		btnUpdate.setBounds(140, 230, 90, 20);
		btnUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnUpdate.setForeground(new Color(105, 105, 105));
		btnUpdate.setBackground(new Color(204, 204, 255));
		btnUpdate.setEnabled(false);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberDelete(memberDao);
			}
		});
		btnDelete.setBounds(250, 230, 90, 20);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnDelete.setForeground(new Color(105, 105, 105));
		btnDelete.setBackground(new Color(204, 204, 255));
		contentPane.add(btnDelete);

	} // MemberUpdateFrame 생성자

	private int pwCheck() {
		int resultPw = 0;
		if (textPw.getText().equals(textPw2.getText()) && !textPw2.getText().equals("")) {
			JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치합니다");
			resultPw = 1;
		} else {
			JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다");
		}
		return resultPw;
	} // end pwCheck

	private void memberUpdate(MemberDAOImple memberDao) {
		String inputId = textId.getText();
		String inputPw = textPw2.getText();
		MemberVO vo = new MemberVO(inputId, inputPw);
		System.out.println(inputId);
		System.out.println(inputPw);
		int result = memberDao.insert(vo);
		if (result == 1) {
			JOptionPane.showMessageDialog(contentPane, "가입 성공");
		} else {
			JOptionPane.showMessageDialog(contentPane, "가입 실패");
		}
	} // end memberUpdate

	private void memberDelete(MemberDAOImple memberDao) {
		String inputId = textId.getText();
		String inputPw = textPw2.getText();
		MemberVO vo = new MemberVO(inputId, inputPw);
		System.out.println(inputId);
		System.out.println(inputPw);
		int result = memberDao.insert(vo);
		if (result == 1) {
			JOptionPane.showMessageDialog(contentPane, "가입 성공");
		} else {
			JOptionPane.showMessageDialog(contentPane, "가입 실패");
		}
	} // end memberDelete

}
