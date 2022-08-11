package edu.java.contact06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import oracle.jdbc.driver.OracleDriver;

public class ContactDAOImple implements ContactDAO, OracleQuery {
// DB와 데이터를 주고 받을 객체들
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

// -------싱글톤 디자인 패턴 적용 시작------------------------------
//	클래스 자신 타입의 private static 변수를 선언
	private static ContactDAOImple instance = null;

//	생성자는 private 로 선언
	private ContactDAOImple(JTextArea textAreaLog) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			textAreaLog.append(">> DB 연결 성공 <<");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계 (if_null)
	public static ContactDAOImple getInstance(JTextArea textAreaLog) {
		if (instance == null) {
			instance = new ContactDAOImple(textAreaLog);
		}
		return instance;
	}

//----------------------------------------------------------
	@Override // 연락처 등록
	public int insert(ContactVO vo) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT); // 쿼리문장준비
			pstmt.setString(1, vo.getName()); // ? 세팅
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			result = pstmt.executeUpdate(); // 완성된문장DB전달하여 성공여부리턴
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 0:실패, 1:성공
	}

	@Override // 연락처 전체 검색
	public ArrayList<ContactVO> select() {
		// 이전 데이터를 초기화하기 위해 메소드 호출시마다 새로 초기화 하며 생성
		ArrayList<ContactVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT); // 쿼리문장준비
			rs = pstmt.executeQuery(); // DB에 쿼리를 보내고 결과를 rs에 저장
			while (rs.next()) { //rs.next()가 false가 될때까지 반복
				int contactId = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				list.add(vo); // 새롭게 생성되는 vo객체를 list에 추가 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; // 전체 ArrayList 통째로 리턴
	}

	@Override // 연락처 상세 검색
	public ContactVO select(int contactId) {
		ContactVO vo = new ContactVO(); 
		// 멤버변수들을 default값으로 세팅, DB에서 가져오지못하면 default값을 외부로 반환
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
			pstmt.setInt(1, contactId); // 쿼리문장의 contactId를 세팅
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setContactId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setEmail(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo; // 해당 contactId의 ContactVO만 반환
	}

	@Override // 연락처 수정
	public int update(ContactVO vo) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, vo.getContactId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 0:실패, 1:성공
	}

	@Override
	public int delete(int contactId) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, contactId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 0:실패, 1:성공
	}
}
