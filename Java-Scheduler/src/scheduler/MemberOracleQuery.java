package scheduler;

public interface MemberOracleQuery {

	static final String URL = "jdbc:oracle:thin:@172.16.7.6:1521:xe";
	static final String USER = "scott";
	static final String PASSWORD = "tiger";

	static final String TABLE_NAME = "SIDE_MEMBER";
	static final String MEMBER_ID = "MEMBER_ID";
	static final String MEMBER_PW = "MEMBER_PW";

	static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (?, ?)";
	static final String SQL_SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + MEMBER_ID + " = ?";
	static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + MEMBER_PW + " = ?" + " WHERE MEMBER_ID = ?";
	static final String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE MEMBER_ID = ?";

}
