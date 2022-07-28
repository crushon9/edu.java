package edu.java.contact04;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import edu.java.file04.MemberVo;

public class ContactDAOImple implements ContactDAO {

// -------싱글톤 디자인 패턴 적용 시작------------------------------
//	클래스 자신 타입의 private static 변수를 선언
	private static ContactDAOImple instance = null;

//	생성자는 private 로 선언
	private ContactDAOImple() {
	}

//	public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계 (if_null)
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

//----------------------------------------------------------

	private ArrayList<ContactVO> list = new ArrayList<>(); // 연락처 저장 컬렉션 ArrayList
	File file = new File("C:\\contact");
	OutputStream out = null;
	ObjectOutputStream oout = null;

	public int getListSize() { // 사이즈 리턴
		return list.size();
	}

	@Override // 연락처 등록
	public int insert(ContactVO vo) {
		list.add(vo);
		if (file.exists()) {
			try {
				out = new FileOutputStream("C:\\contact");
				oout = new ObjectOutputStream(out);
				oout.writeObject(list);
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				try {
					oout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return 1;
		} else {
			System.out.println("중복 파일이 있습니다");
			return 0;
		}
	}

	@Override // 연락처 전체 검색
	public ArrayList<ContactVO> select() {
		return list; // 전체 ArrayList 통째로 리턴
	}

	@Override // 연락처 상세 검색
	public ContactVO select(int index) {
		return list.get(index); // 해당 index의 ContactVO만 반환
	}

	@Override // 연락처 수정
	public int update(int index, ContactVO vo) {
		list.get(index).setName(vo.getName());
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		// 전달받은vo객체의 멤버변수를 get하여, 전달받은인덱스객체의 set값으로 넣음
		return 1; // 0:실패, 1:성공
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		return 1; // 0:실패, 1:성공
	}
}
