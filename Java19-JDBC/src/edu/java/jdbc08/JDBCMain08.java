package edu.java.jdbc08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import edu.java.jdbc03.ContactVO;
import oracle.jdbc.OracleDriver;

public class JDBCMain08 {
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "ex_product";
	public static final String COL_PNO = "product_no";
	public static final String COL_PNAME = "product_name";
	public static final String COL_PPRICE = "product_price";
	public static final String COL_PCOUNT = "product_count";
	public static final String COL_PSELLER = "product_seller";
	public static final String COL_PDATE = "product_date";
	
	// insert into ex_product
	// values (product_seq.nextval, ?, ?, ?, ?, SYSDATE)
	public static final String SQL_INSERT = 
			"insert into ex_product "
			+ "values (product_seq.nextval, ?, ?, ?, ?, SYSDATE)";
	
	// 제품 이름으로 검색
	// select * from ex_product where pname like ?
	public static final String SQL_SELECT_BY_PNAME = 
			"select * from " + TABLE_NAME +
			" where " + COL_PNAME + " like ?";
	
	public static void main(String[] args) {
		System.out.println("JDBC 8 - select by pname");
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			
			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
//			// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
//			pstmt = conn.prepareStatement(SQL_INSERT);
//			
//			pstmt.setString(1, "야채김밥");
//			pstmt.setInt(2, 1000);
//			pstmt.setInt(3, 3);
//			pstmt.setString(4, "김밥천국");
//						
//			int result = pstmt.executeUpdate();
//			System.out.println(result);
			pstmt = conn.prepareStatement(SQL_SELECT_BY_PNAME);
			
			System.out.println("검색할 상품 키워드 입력>");
			String keyword = sc.nextLine();
			// 5. SQL 문장 완성
			pstmt.setString(1, "%" + keyword + "%");
			
			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			rs = pstmt.executeQuery();
			
			// 7. 서버가 보낸 결과 확인/처리
			// ResultSet.next() :
			// ResultSet에서 다음 행(row, record)이 있으면
			// true를 리턴하고, ResultSet이 가리키는 위치를 다음 위치로 변경		
			while(rs.next()) {
				int productNo = rs.getInt(COL_PNO);
				String productName = rs.getString(COL_PNAME);
				int productPrice = rs.getInt(COL_PPRICE);
				int productCount = rs.getInt(COL_PCOUNT);
				String productSeller = rs.getString(COL_PSELLER);
				Timestamp ts = rs.getTimestamp(COL_PDATE);
				// Timestamp를 Date 타입으로 변환
				Date pdate = new Date(ts.getTime());
				ProductVO vo = new ProductVO(productNo, productName, productPrice, productCount, productSeller, pdate);
				System.out.println(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} // end main()	
	

}





