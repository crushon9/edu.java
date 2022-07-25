package edu.java.collection03;

import java.util.LinkedList;
import java.util.List;

// Collection<E> : 자료(데이터)를 저장하기 위한 Generic 클래스
//	ㄴ List<E>,							/ Set<E>
//		ㄴ ArrayList<E>, LinkedList<E>
// 	ㄴ Map<K, V>

// List<E>
//  ㄴ ArrayList<E>, LinkedList<E>
// 1. 자료들이 저장되는 순서가 중요 -> 인덱스 사용
// 2. 중복된 값들의 저장을 허용

// ArrayList<E>
// 1. 내부적으로 배열 자료구조를 사용
// 2. 저장 용량을 늘리는데 많은 시간이 소요됨
// 3. 저장된 데이터를 삭제하는데 많은 시간이 소요됨
// 4. 데이터 참조(검색)할 때 매우 빠름 / A B C D "인덱스 3번 D"

// LinkedList<E>
// 1. 내부적으로 LinkedList 자료구조를 사용
// 2. 저장 용량을 늘리는 과정이 매우 간단
// 3. 저장된 데이터를 삭제하는 과정도 매우 간단
// 4. 데이터 참조(검색)하는 시간이 매우 느림 / A B C D "A뒤에 B뒤에 C뒤에 있는 D"

// ArrayList<E>, LinkedList<E> 에서 사용되는 메소드들 :
// add(element), get(index), set(index, value), remove(index)

public class CollectionsMain03 {

	public static void main(String[] args) {
		// String을 저장할 수 있는 LinkedList 객체 생성
		List<String> list = new LinkedList<String>(); // 다형성
		list.add("월요일");
		list.add("입니다");
		list.add("내일은");
		list.add("화요일입니다ㅠㅠ");

		for (String x : list) {
			System.out.println(x);
		}
		list.set(3, "금요일입니다ㅎㅎ");
		for (String x : list) {
			System.out.println(x);
		}
	}

}
