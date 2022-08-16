package scheduler;

import java.util.ArrayList;

interface ScheduleDAO {

	// 스케줄 등록
	public abstract int insert(ScheduleDAO vo);

	// 스케줄 전체검색
	public abstract ArrayList<ScheduleVO> select();

	// 스케줄 상세검색
	public abstract ScheduleDAO select(String text);

	// 스케줄 수정
	public abstract int update(ScheduleDAO vo);

	// 스케줄 삭제
	public abstract int delete(int seqNo);

}
