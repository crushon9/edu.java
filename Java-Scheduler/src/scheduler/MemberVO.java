package scheduler;

class MemberVO {

	String id;
	String pw;

	public MemberVO() {
	}

	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + "]";
	}

}
