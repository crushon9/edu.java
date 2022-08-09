package edu.java.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;
import edu.java.jdbc03.ContactVO;

public class JDBCMain04 {
	// 1. DB와 연동하기 위해 필요한 상수들을 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static void main(String[] args) {
		System.out.println("JDBC 4 - select by index");

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 4. Connection 객체를 사용하여 Statement 객체 생성
			stmt = conn.createStatement();

			// 5. SQL 문장 작성
			// SELECT * FROM EX_CONTACT WHERE CONTACT_ID = 2;
			String sql_select_by_contact_id = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_CONTACT_ID + " = 2";
			System.out.println(sql_select_by_contact_id);

			// 6. Statement 객체를 사용하여 SQL 문장 실행 (DB 서버로 SQL 문장 전송)
			rs = stmt.executeQuery(sql_select_by_contact_id);

			// 7. DB 서버가 보내준 결과를 확인/처리
			if (rs.next()) {
				int contactId = rs.getInt(1);
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
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
