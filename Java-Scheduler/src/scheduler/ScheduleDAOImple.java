package scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextArea;

import oracle.jdbc.driver.OracleDriver;

class ScheduleDAOImple implements ScheduleDAO, ScheduleOracleQuery {
	// DB와 데이터를 주고 받을 객체들
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// -------싱글톤 디자인 패턴 적용 시작--------------------
//			클래스 자신 타입의 private static 변수를 선언
	private static ScheduleDAOImple instance = null;

//			생성자는 private 로 선언
	ScheduleDAOImple() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//			public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계 (if_null)
	public static ScheduleDAOImple getInstance() {
		if (instance == null) {
			instance = new ScheduleDAOImple();
		}
		return instance;
	}

	// ------------------------------------------------

	@Override
	public int insert(ScheduleVO vo) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT); // 쿼리문장준비
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getYear());
			pstmt.setInt(3, vo.getMonth());
			pstmt.setInt(4, vo.getDate());
			pstmt.setInt(5, vo.getTime());
			pstmt.setString(6, vo.getText());
			pstmt.setInt(7, vo.getColorIdx());
			result = pstmt.executeUpdate(); // 완성된문장DB전달하여 성공여부리턴
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 1:성공, 0:실패
	}

	@Override
	public ArrayList<ScheduleVO> select(ScheduleVO sVO) {
		ArrayList<ScheduleVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_DATE);
			pstmt.setString(1, sVO.getId());
			pstmt.setInt(2, sVO.getYear());
			pstmt.setInt(3, sVO.getMonth());
			pstmt.setInt(4, sVO.getDate());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int seqNo = rs.getInt(1);
				String id = rs.getString(2);
				int year = rs.getInt(3);
				int month = rs.getInt(4);
				int date = rs.getInt(5);
				int time = rs.getInt(6);
				String text = rs.getString(7);
				int colorIdx = rs.getInt(8);
				String isDone = rs.getString(9);
				ScheduleVO vo = new ScheduleVO(seqNo, id, year, month, date, time, text, colorIdx, isDone);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list; // 전체 ArrayList 통째로 리턴
	}

	@Override
	public ArrayList<ScheduleVO> select(String curId, String Text) {
		ArrayList<ScheduleVO> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_STRING);
			pstmt.setString(1, curId);
			pstmt.setString(2, "%" + Text + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int seqNo = rs.getInt(1);
				String id = rs.getString(2);
				int year = rs.getInt(3);
				int month = rs.getInt(4);
				int date = rs.getInt(5);
				int time = rs.getInt(6);
				String text = rs.getString(7);
				int colorIdx = rs.getInt(8);
				String isDone = rs.getString(9);
				ScheduleVO vo = new ScheduleVO(seqNo, id, year, month, date, time, text, colorIdx, isDone);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(ScheduleVO vo) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setInt(1, vo.getTime());
			pstmt.setString(2, vo.getText());
			pstmt.setInt(3, vo.getColorIdx());
			pstmt.setInt(4, vo.getSeqNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 1:성공, 0:실패
	}

	@Override
	public int delete(int seqNo) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, seqNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; // 1:성공, 0:실패
	}

}
