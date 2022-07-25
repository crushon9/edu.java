package edu.java.collection01;

import java.util.ArrayList;

// * List<> 클래스
// 배열과 같은 역할을 Generic 클래스로 생성한 형태
// 배열은 저장되는 한계를 지정해줘야하지만, List는 저장의 한계가 없음
// 추가하는 만큼 저장 공간을 늘려줌
// * 주요 메소드
// add() : 원소추가
// get() : 원소읽기
// set() : 원소변경
// remove() : 원소삭제

public class ListMain01 {

	public static void main(String[] args) {

		int[] list1 = new int[3];
		list1[0] = 1;
		// 배열의 길이는 데이터가 저장된 개수와 상관없이 고정
		// 배열에 저장된 데이터의 개수를 확인하기 어려움

		ArrayList<Integer> list = new ArrayList<>();
		System.out.println("처음 리스트 크기 : " + list.size());

		// ArrayList에 원소(element) 추가 : add() 메소드 사용
		list.add(100); // index = 0
		list.add(200); // index = 1
		list.add(300); // index = 2
		list.add(400); // index = 3
		System.out.println("추가 후 리스트 크기 : " + list.size());

		// ArrayList에 원소 참조(읽기) : get(index) 메소드 사용
		System.out.println("\nget(index)");
		System.out.println(list.get(0));
		System.out.println(list.get(2));
//		System.out.println(list.get(4)); // java.lang.IndexOutOfBoundsException

		// for(원소타입 변수이름 : 배열 또는 컬렉션) {...}
		System.out.println("\nfor-each");
		for (int n : list) {
			System.out.println(n);
		}
		for (Integer n : list) {
			System.out.println(n);
		}

		// ArrayList에서 특정 인덱스의 원소를 변경 : set(index, value)
		System.out.println("\nset(index, value)");
		list.set(0, 1);
		list.set(2, 1234);
		for (int n : list) {
			System.out.println(n);
		}

		// ArrayList에서 특정 인덱스의 원소를 삭제 : remove(index)
		System.out.println("\nremove(index)");
		list.remove(1); // 삭제를 하면 뒤의 리스트 인덱스가 땡겨짐
		for (int i = 0; i < list.size(); i++) {
			System.out.println("index : " + i + ", value : " + list.get(i));
		}
		System.out.println("삭제 후 리스트 크기 : " + list.size());

	}

}
