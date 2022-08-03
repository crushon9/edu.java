package edu.java.contact05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class ContactDAOImple implements ContactDAO {

// -------싱글톤 디자인 패턴 적용 시작------------------------------
//	클래스 자신 타입의 private static 변수를 선언
	private static ContactDAOImple instance = null;

//	생성자는 private 로 선언
	private ContactDAOImple(JTextArea textAreaLog) {
		initDataDir(textAreaLog); // 생성자를 불러오면서 폴더생성
		initDataFile(textAreaLog); // 생성자를 불러오면서 파일생성
	}

//	public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계 (if_null)
	public static ContactDAOImple getInstance(JTextArea textAreaLog) {
		if (instance == null) {
			instance = new ContactDAOImple(textAreaLog);
		}
		return instance;
	}

//----------------------------------------------------------
	// 데이터를 저장할 폴더와 파일이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";
	// data 폴더의 contact.data 파일을 관리할 File 객체 선언
	private File dataDir;
	private File dataFile;
	// 연락처 저장 컬렉션 ArrayList
	private ArrayList<ContactVO> list = new ArrayList<>();

	// data 폴더가 있는지 검사하고 없으면 새로 생성하는 메소드
	private void initDataDir(JTextArea textAreaLog) {
		textAreaLog.setText(">> initDataDir() 호출 <<\n");
		dataDir = new File(DATA_DIR);
		textAreaLog.append("폴더경로 : " + dataDir.getPath() + "\n");
		textAreaLog.append("절대경로 : " + dataDir.getAbsolutePath() + "\n");

		if (!dataDir.exists()) { // 폴더가 없으면
			if (dataDir.mkdirs()) {
				textAreaLog.append(">> 폴더 생성 성공 <<\n");
			} else {
				textAreaLog.append(">> 폴더 생성 실패 <<\n");
			}
		} else { // 폴더가 있으면
			textAreaLog.append(">> 폴더가 이미 존재 <<\n");
		}
	} // end initDataDir()

	// contact.data 파일이 있는지 검사하고 없으면 새로 생성하는 메소드
	private void initDataFile(JTextArea textAreaLog) {
		textAreaLog.append(">> initDataFile() 호출 <<\n");
		String filePath = DATA_DIR + File.separator + DATA_FILE;
		dataFile = new File(filePath);
		textAreaLog.append("파일경로 : " + dataFile.getPath() + "\n");
		textAreaLog.append("절대경로 : " + dataFile.getAbsolutePath() + "\n");

		if (!dataFile.exists()) { // 데이터 파일이 없으면 파일을 만든다
			try {
				if (dataFile.createNewFile()) {
					textAreaLog.append(">> 새로운 파일 생성 <<\n");
				} else {
					textAreaLog.append(">> 파일 생성 실패 <<\n");
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else { // 데이터 파일이 있으면 데이터를 가져와서 ArrayList 객체에 집어 넣는다
			textAreaLog.append(">> 기존 데이터 있음 <<\n");
			// 문제가 일어난시점에서 해결하는것이 명확함. if 조건으로는 수행할상황을 주는것이 더나은듯 (0이 아닐때만 읽어온다)
			if (dataFile.length() != 0) { // 빈파일이 아닐때만 읽어옴
				readDataFromFile(textAreaLog);
			}
		}
	} // end initDataFile()

	// 멤버변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	private void writeDataToFile(JTextArea textAreaLog) {
		textAreaLog.append(">> writeDataToFile() 호출 <<\n");

		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream(dataFile); // 매개변수로 File 객체가능, 경로 문자열 가능
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			oout.writeObject(list);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	} // end writeDataToFile()

	// data\contact.data 파일에서 ArrayList 객체를 읽어와서 멤버변수 list에 저장
	private void readDataFromFile(JTextArea textAreaLog) {
		textAreaLog.append(">> readDataFromFile() 호출 <<\n");

		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream(dataFile);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			list = (ArrayList<ContactVO>) oin.readObject();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	} // end readDataFromFile()

	public int getListSize() { // 사이즈 리턴
		return list.size();
	}

	@Override // 연락처 등록
	public int insert(ContactVO vo, JTextArea textAreaLog) {
		list.add(vo);
		writeDataToFile(textAreaLog); // 파일에 저장할때마다 처음부터 다시 덮어쓰기로 저장됨
		// 데이터의 변화가 있을때마다 파일에 덮어쓰기를 하는 이유는 사용자가 강제종료할수도있음
		return 1; // 0:실패, 1:성공
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
	public int update(int index, ContactVO vo, JTextArea textAreaLog) {
		list.get(index).setName(vo.getName());
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		// 전달받은vo객체의 멤버변수를 get하여, 전달받은인덱스객체의 set값으로 넣음
		writeDataToFile(textAreaLog);
		return 1; // 0:실패, 1:성공
	}

	@Override
	public int delete(int index, JTextArea textAreaLog) {
		list.remove(index);
		writeDataToFile(textAreaLog);
		return 1; // 0:실패, 1:성공
	}
}
