package scheduler;

import java.util.Date;

class ScheduleVO {

	int seqNo;
	String ID;
	Date date;
	int time;
	String text;
	int colorIdx;
	int isDone;

	public ScheduleVO() {
	}

	public ScheduleVO(int seqNo, String user, Date date, int time, String text, int colorIndex, int isDone) {
		this.seqNo = seqNo;
		this.ID = user;
		this.date = date;
		this.time = time;
		this.text = text;
		this.colorIdx = colorIndex;
		this.isDone = isDone;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getUser() {
		return ID;
	}

	public void setUser(String user) {
		this.ID = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public int getColorIndex() {
		return colorIdx;
	}

	public void setColorIndex(int colorIndex) {
		this.colorIdx = colorIndex;
	}

	public int getIsDone() {
		return isDone;
	}

	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "ScheduleVO [seqNo=" + seqNo + ", user=" + ID + ", date=" + date + ", time=" + time + ", text=" + text
				+ ", colorIndex=" + colorIdx + ", isDone=" + isDone + "]";
	}

}
