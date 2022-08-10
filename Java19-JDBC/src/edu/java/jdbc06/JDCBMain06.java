package edu.java.jdbc06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class JDCBMain06 {
	// 1. DB와 연동하기 위해 필요한 상수들을 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	// SQL 문장 작성
	public static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + COL_NAME + " = ?, " + COL_PHONE
			+ " = ?, " + COL_EMAIL + " = ?" + " WHERE CONTACT_ID = ?";
	public static final String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE CONTACT_ID = ?";

	public static void main(String[] args) {
		System.out.println("JDBC 6 - 데이터 입력받아 update, delete");

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 4. Connection 객체를 사용하여 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(SQL_UPDATE);

			// 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.println("수정ID 입력>");
			int contactId = sc.nextInt();
			System.out.println("이름 입력>");
			String name = sc.next();
			System.out.println("연락처 입력>");
			String phone = sc.next();
			System.out.println("이메일 입력>");
			String email = sc.next();

			// 5. SQL 문장 완성 (SQL_INSERT의 ?를 채워주는 코드)
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			pstmt.setInt(4, contactId);

			// 6. PreparedStatement 객체를 사용하여 SQL 문장 실행 (DB 서버로 SQL 문장 전송)
			int result = pstmt.executeUpdate(); // 매개변수로 SQL_INSERT 넣지 않도록 주의

			// 7. DB 서버가 보내준 결과를 확인/처리
			System.out.println(result + " 행이 수정되었습니다");

			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end main()
} // end JDBCMain06 class
