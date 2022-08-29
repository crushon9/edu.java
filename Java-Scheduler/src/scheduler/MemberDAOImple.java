package scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import oracle.jdbc.driver.OracleDriver;

class MemberDAOImple implements MemberDAO, MemberOracleQuery {
	// DB와 데이터를 주고 받을 객체들
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// -------싱글톤 디자인 패턴 적용 시작--------------------
//		클래스 자신 타입의 private static 변수를 선언
	private static MemberDAOImple instance = null;

//		생성자는 private 로 선언
	private MemberDAOImple(JTextArea textAreaLog) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			textAreaLog.append("> DB 연결 성공 <");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//		public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계 (if_null)
	public static MemberDAOImple getInstance(JTextArea textAreaLog) {
		if (instance == null) {
			instance = new MemberDAOImple(textAreaLog);
		}
		return instance;
	}

	// ------------------------------------------------

	@Override
	public int insert(MemberVO vo) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT); // 쿼리문장준비
			pstmt.setString(1, vo.getId()); // ? 에 값을 세팅
			pstmt.setString(2, vo.getPw());
			result = pstmt.executeUpdate(); // 완성된문장DB전달하여 성공여부리턴
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 1:성공, 0:실패
	}

	@Override
	public MemberVO select(String ID) {
		MemberVO mVo = new MemberVO();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_ID); // 쿼리문장준비
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery(); // DB에 쿼리를 보내고 결과를 rs에 저장
			if (rs.next()) {
				mVo.setId(rs.getString(1));
				mVo.setPw(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mVo;
	}

	@Override
	public int update(MemberVO vo) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getPw()); // ? 에 값을 세팅
			pstmt.setString(2, vo.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 1:성공, 0:실패
	}

	@Override
	public int delete(String id) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 1:성공, 0:실패
	}

}
