package edu.java.contact04;

import java.io.*;
import java.util.ArrayList;


public class ContactDAOImple implements ContactDAO {

// -------싱글톤 디자인 패턴 적용 시작------------------------------
//	클래스 자신 타입의 private static 변수를 선언
	private static ContactDAOImple instance = null;

//	생성자는 private 로 선언
	private ContactDAOImple() {
		initDataDir(); // 생성자를 불러오면서 폴더생성
		initDataFile(); // 생성자를 불러오면서 파일생성
	}

//	public static 메소드를 제공해서 인스턴스를 생성할 수 있도록 설계 (if_null)
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

//----------------------------------------------------------
	// 데이터를 저장할 폴더와 파일이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";
	private static String filePath = DATA_DIR + File.separator + DATA_FILE;

	// data 폴더의 contact.data 파일을 관리할 File 객체 선언
	private File dataDir;
	private File dataFile;

	private ArrayList<ContactVO> list = new ArrayList<>(); // 연락처 저장 컬렉션 ArrayList

	// data 폴더가 있는지 검사하고 없으면 새로 생성하는 코드
	private void initDataDir() {
		System.out.println("initDataDir() 호출");
		dataDir = new File(DATA_DIR);
		System.out.println("폴더경로 : " + dataDir.getPath());
		System.out.println("절대경로 : " + dataDir.getAbsolutePath());

		if (!dataDir.exists()) { // 폴더가 없으면
			if (dataDir.mkdirs()) {
				System.out.println("< 폴더 생성 성공 >");
			} else {
				System.out.println("< 폴더 생성 실패 >");
			}
		} else { // 폴더가 있으면
			System.out.println("< 폴더가 이미 존재 >");
		}
	} // end initDataDir()

	// contact.data 파일이 있는지 검사하고 없으면 새로 생성하는 코트
	private void initDataFile() {
		System.out.println("initDataFile() 호출");
		dataFile = new File(filePath);
		System.out.println("파일경로 : " + dataFile.getPath());
		System.out.println("절대경로 : " + dataFile.getAbsolutePath());

		if (!dataFile.exists()) { // 데이터 파일이 없으면 파일을 만든다
			try {
				if (dataFile.createNewFile()) {
					System.out.println("< 새로운 데이터 파일 생성 >");
				} else {
					System.out.println("< 파일 생성 실패 >");
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} else { // 데이터 파일이 있으면 데이터를 가져와서 ArrayList 객체에 집어 넣는다
			readDataFromFile();
		}
	} // end initDataFile()

	// 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	private void writeDataToFile() {
		System.out.println("writeDataToFile() 호출");

		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream(filePath);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
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
	} // end writeDataToFile()

	// data\contact.data 파일에서 ArrayList 객체를 읽어와서 멤버변수 list에 저장
	private void readDataFromFile() {
		System.out.println("readDataFromFile() 호출");
		System.out.println("< 기존 데이터 있음 >");

		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream(filePath);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			list = (ArrayList<ContactVO>) oin.readObject();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // end readDataFromFile

	public int getListSize() { // 사이즈 리턴
		return list.size();
	}

	@Override // 연락처 등록
	public int insert(ContactVO vo) {
		list.add(vo);
		writeDataToFile();
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
	public int update(int index, ContactVO vo) {
		list.get(index).setName(vo.getName());
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		// 전달받은vo객체의 멤버변수를 get하여, 전달받은인덱스객체의 set값으로 넣음
		writeDataToFile();
		return 1; // 0:실패, 1:성공
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		writeDataToFile();
		return 1; // 0:실패, 1:성공
	}
}
