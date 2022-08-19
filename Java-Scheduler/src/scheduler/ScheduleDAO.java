package scheduler;

import java.util.ArrayList;
import java.util.Calendar;

interface ScheduleDAO {

	// 스케줄 등록
	public abstract int insert(ScheduleVO vo);

	// 스케줄 날짜검색
	public abstract ArrayList<ScheduleVO> select(ScheduleVO vo);

	// 스케줄 문자열검색
	public abstract ScheduleVO select(String curId, String Text);

	// 스케줄 수정
	public abstract int update(ScheduleVO vo);

	// 스케줄 삭제
	public abstract int delete(int seqNo);

}
