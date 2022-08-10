package edu.java.jdbc07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.driver.OracleDriver;

public class JDBCMain07 {
	// **자바 -> DB로 쿼리를 전달하는 객체 
	// Statement _ 메소드createStatement() : 그냥 정적 문장을 전달 
	// PreparedStatement _ 메소드prepareStatement(매개변수반드시) : ?를 매개변수로 동적 문장을 전달
	// **쿼리의 메소드별 리턴값
	// executeUpdate(매개변수앞에보냈으면생략) _ 리턴값int0,1 : DB로 일방적 전달
	// executeQuery(매개변수앞에보냈으면생략) _ 리턴값 ResultSet 객체빈그릇 : DB로 요청한 데이터를 돌려받음
	// 즉 SQL문장 매개변수는 전 과정중 한번만 보내지네

	// 1. DB와 연동하기 위해 필요한 상수들을 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static final String SQL_SELECT_BY_CONTACT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_CONTACT_ID
			+ " = ?";

	public static void main(String[] args) {
		System.out.println("JDBC 7 - select by index");

		// 객체들을 null로 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. JDBC 드라이버를 메모리에 로드
			// public static 인가봐 객체생성없이 바로 DriverManager로 사용가능하네
			DriverManager.registerDriver(new OracleDriver()); // oracle.jdbc.driver.OracleDriver; 주의

			// 3. DB와 Connection을 맺음
			// Connection 객체에는 URL과 로그인 상태가 담기나봐
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 4. Connection 객체를 사용하여 Statement 객체 생성
			// prepareStatement 빈객체에 저장한다
			// 로그인상태를담은conn을 통하여, prepareStatement메소드의 리턴값인 SQL문장(SQL_SELECT_BY_CONTACT_ID을
			// 토대로 ?를 입력받을 준비를 한채로)
			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);

			Scanner sc = new Scanner(System.in);
			System.out.println("인덱스 입력>");
			int contactId = sc.nextInt();

			// 5. SQL 문장 작성
			// pstmt객체에 저장된 SQL 문장의 첫번째 ? 를 세팅한다
			pstmt.setInt(1, contactId);

			// 6. Statement 객체를 사용하여 SQL 문장 실행 (DB 서버로 SQL 문장 전송)
			// ResultSet 객체 빈그릇에, pstmt의 SQL문장을, executeQuery메소드를 통하여 DB에 보내고 받아온 리턴값을 담는다
			rs = pstmt.executeQuery();

			// 7. DB 서버가 보내준 결과를 확인/처리
			// DB가 보내준 결과를 담은 rs 객체는 반드시 한번은 next()메소드를 호출해야함
			// 컬럼에 해당하는 데이터를 순서대로(1부터시작) getter로 가져와 빈그릇에 저장한 뒤 ContactVO 객체생성자의 매개변수로 보냄
			// vo의 설정한 toString을 출력하여 결과확인
			if (rs.next()) {
				contactId = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				System.out.println(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 연결된 순서대로 닫음
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end main()
} // end JDBCMain07 class
