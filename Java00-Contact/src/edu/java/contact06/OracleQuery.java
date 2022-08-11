package edu.java.contact06;

// JBDC에서 사용될 상수들, SQL 문장들을 정의
public interface OracleQuery {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";

	// 쿼리를 oracle SQL developer에서 정상작동하는지 미리 확인 한 뒤 자바에서 사용해야 어디서 문제가 생겼는지 파악하기 쉬움
	// A - B - C - D - E - F 단계가 많을때 한단계씩 확인하며 건너가거나, 아니면 단계마다 로그를 찍어야 문제지점을 파악하기 쉬움
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (CONTACT_SEQ.nextval, ?, ?, ?)";
	public static final String SQL_SELECT = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_CONTACT_ID;
	public static final String SQL_SELECT_BY_CONTACT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_CONTACT_ID
			+ " = ?";
	public static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + COL_NAME + " = ?, " + COL_PHONE
			+ " = ?, " + COL_EMAIL + " = ?" + " WHERE CONTACT_ID = ?";
	public static final String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE CONTACT_ID = ?";
}
