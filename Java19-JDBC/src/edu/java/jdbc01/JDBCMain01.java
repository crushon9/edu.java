package edu.java.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

// JDBC : Java DataBase Connection
// 0. 데이터베이스 라이브러리를 프로젝트에 추가 (Referenced Libraries)
//		1) 프로젝트에 lib 폴더 생성
//		2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib (11g xe 기준)
//			폴더에 있는 ojdbc6.jar 파일을 프로젝트의 lib 폴더에 복사
//		3) 복사한 jar 파일(라이브러리)를 build path에 추가 (파일에마우스오른쪽 -> Add to build path)
// 1. DB와 연동하기 위해 필요한 상수들을 정의
// 2. JDBC 드라이버를 메모리에 로드
// 3. DB와 Connection을 맺음
// 4. Connection 객체를 사용하여 Statement 객체 생성
// 5. SQL 문장 작성
// 6. Statement 객체를 사용하여 SQL 문장 실행 (DB 서버로 SQL 문장 전송)
// 7. DB 서버가 보내준 결과를 확인/처리

public class JDBCMain01 {
	// 1. DB와 연동하기 위해 필요한 상수들을 정의
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	public static void main(String[] args) {
		System.out.println("JDBC 1 - insert");

		Connection conn = null;
		Statement stmt = null;
		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");

			// 3. DB와 Connection을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			// 4. Connection 객체를 사용하여 Statement 객체 생성
			stmt = conn.createStatement();

			// 5. SQL 문장 작성 (Oracle SQL Developer에서 작성한뒤 붙여넣어 작업)
			// INSERT INTO EX_CONTACT
			// VALUES (CONTACT_SEQ.nextval, 'nametest','000-0000-0000', 'test@test.com');
			String sql_insert = "INSERT INTO " + TABLE_NAME
					+ " VALUES (CONTACT_SEQ.nextval, 'nametest', '000-0000-0000', 'test@test.com')";
			System.out.println(sql_insert);

			// 6. Statement 객체를 사용하여 SQL 문장 실행 (DB 서버로 SQL 문장 전송)
			// executeUpdate() : 자바->DB 방향의 수행. 성공여부를 리턴값 1,0 (INSERT, UPDATE, DELETE)
			// executeQuery() : DB->자바 방향의 수행. 리턴값으로 요구사항을 돌려줌 (SELECT)
			int result = stmt.executeUpdate(sql_insert); // 자동 commit이 포함되어있음

			// 7. DB 서버가 보내준 결과를 확인/처리
			System.out.println(result + " 행이 삽입되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end main()
} // end JDBCMain01 class
