package scheduler;

class ScheduleVO {

	int seqNo;
	String id;
	int year;
	int month;
	int date;
	int time;
	String text;
	int colorIdx;
	int isDone; // 0이면 미완료, -1이면 완료

	public ScheduleVO() {
	}

	public ScheduleVO(int seqNo, String id, int year, int month, int date, int time, String text, int colorIdx,
			int isDone) {
		super();
		this.seqNo = seqNo;
		this.id = id;
		this.year = year;
		this.month = month;
		this.date = date;
		this.time = time;
		this.text = text;
		this.colorIdx = colorIdx;
		this.isDone = isDone;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getColorIdx() {
		return colorIdx;
	}

	public void setColorIdx(int colorIdx) {
		this.colorIdx = colorIdx;
	}

	public int getIsDone() {
		return isDone;
	}

	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "ScheduleVO [seqNo=" + seqNo + ", id=" + id + ", year=" + year + ", month=" + month + ", date=" + date
				+ ", time=" + time + ", text=" + text + ", colorIdx=" + colorIdx + ", isDone=" + isDone + "]";
	}

}
