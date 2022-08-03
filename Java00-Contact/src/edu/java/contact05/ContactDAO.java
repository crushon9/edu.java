package edu.java.contact05;

import java.util.ArrayList;

import javax.swing.JTextArea;

public interface ContactDAO {

	// 연락처 등록
	public abstract int insert(ContactVO vo, JTextArea textAreaLog);

	// 연락처 전체검색
	public abstract ArrayList<ContactVO> select();

	// 연락처 상세검색 overloading
	public abstract ContactVO select(int index);

	// 연락처 수정
	public abstract int update(int index, ContactVO vo, JTextArea textAreaLog);

	// 연락처 삭제
	public abstract int delete(int index, JTextArea textAreaLog);

}
