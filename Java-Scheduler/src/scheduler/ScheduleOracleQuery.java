package scheduler;

interface ScheduleOracleQuery {
	static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String USER = "scott";
	static final String PASSWORD = "tiger";

	static final String TABLE_NAME = "SCHEDULE";
	static final String COL_SEQ = "SCHEDULE_SEQ";
	static final String COL_ID = "SCHEDULE_ID";
	static final String COL_DATE = "SCHEDULE_DATE";
	static final String COL_TIME = "SCHEDULE_TIME";
	static final String COL_TEXT = "SCHEDULE_TEXT";
	static final String COL_COLOR = "SCHEDULE_COLOR";
	static final String COL_ISDONE = "SCHEDULE_ISDONE";

	static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (SCHEDULE_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
	static final String SQL_SELECT = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_TIME;
	static final String SQL_SELECT_BY_STRING = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_TEXT + " LIKE '%?%'";
	static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + COL_DATE + " = ?, " + COL_TIME + " = ?, "
			+ COL_TEXT + " = ?" + COL_COLOR + " = ?" + " WHERE SCHEDULE_SEQ = ?";
	static final String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE SCHEDULE_SEQ = ?";

}
