package edu.java.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class JDBCMain03_pstmt {

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
		System.out.println("JDBC 3 - select all");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 5. SQL 문장 작성
			// SELECT * FROM EX_CONTACT ORDER BY CONTACT_ID
			String sql_select = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_CONTACT_ID;
			System.out.println(sql_select);
			
			// 4. Connection 객체를 사용하여 Statement 객체 생성
			pstmt = conn.prepareStatement(sql_select);

			// 6. Statement 객체를 사용하여 SQL 문장 실행 (DB 서버로 SQL 문장 전송)
			// executeUpdate() : 자바->DB 방향의 수행. 성공여부를 리턴값 1,0 (INSERT, UPDATE, DELETE)
			// executeQuery() : DB->자바 방향의 수행. 리턴값으로 요구사항을 돌려줌 (SELECT)
			rs = pstmt.executeQuery();

			// 7. DB 서버가 보내준 결과를 확인/처리
			// ResultSet.next() :
			// ResultSet에서 다음행(row, record)이 있으면 true리턴, 가리키는 위치를 다음으로 변경
			ArrayList<ContactVO> list = new ArrayList<>();
			while (rs.next()) { // 레코드가 존재할 때까지 rs위치를 다음행으로 변경시켜줌
				int contactId = rs.getInt(1); // columnIndex 는 1부터 시작하네?
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);

				ContactVO vo = new ContactVO(contactId, name, phone, email);
				list.add(vo);
			}

			for (ContactVO x : list) {
				System.out.println(x);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
