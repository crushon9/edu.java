package edu.java.contact06;

// 데이터 클래스(번호, 이름, 연락처, 이메일)
public class ContactVO {
	// 멤버변수(필드, 프로퍼티)
	private int contactId;
	private String name;
	private String phone;
	private String email;

	// 기본 생성자
	public ContactVO() {
	}

	// 매개변수 있는 생성자
	public ContactVO(int contactId, String name, String phone, String email) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	// contactId없는 생성자
	public ContactVO(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// getter, setter
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString
	@Override
	public String toString() {
		return "[contactId=" + contactId + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}
