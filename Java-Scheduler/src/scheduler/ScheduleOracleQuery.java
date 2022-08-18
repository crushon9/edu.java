package scheduler;

interface ScheduleOracleQuery {
	static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String USER = "scott";
	static final String PASSWORD = "tiger";

	static final String TABLE_NAME = "SCHEDULE";
	static final String SCHEDULE_SEQ = "SCHEDULE_SEQ";
	static final String SCHEDULE_ID = "SCHEDULE_ID";
	static final String SCHEDULE_DATE = "SCHEDULE_DATE";
	static final String SCHEDULE_TIME = "SCHEDULE_TIME";
	static final String SCHEDULE_TEXT = "SCHEDULE_TEXT";
	static final String SCHEDULE_COLOR = "SCHEDULE_COLOR";
	static final String SCHEDULE_ISDONE = "SCHEDULE_ISDONE";

	static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME + " VALUES (SCHEDULE_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
	static final String SQL_SELECT = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + SCHEDULE_TIME;
	static final String SQL_SELECT_BY_STRING = "SELECT * FROM " + TABLE_NAME + " WHERE " + SCHEDULE_TEXT + " LIKE '%?%'";
	static final String SQL_UPDATE = "UPDATE " + TABLE_NAME + " SET " + SCHEDULE_DATE + " = ?, " + SCHEDULE_TIME + " = ?, "
			+ SCHEDULE_TEXT + " = ?" + SCHEDULE_COLOR + " = ?" + " WHERE SCHEDULE_SEQ = ?";
	static final String SQL_DELETE = "DELETE " + TABLE_NAME + " WHERE SCHEDULE_SEQ = ?";

}