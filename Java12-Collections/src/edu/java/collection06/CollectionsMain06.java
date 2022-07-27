package edu.java.collection06;

import java.util.Set;
import java.util.TreeMap;

// List<E>, Set<E> : 한 가지 타입의 데이터를 저장할 수 있는 Collection

// Map<K, V> : key-value 쌍으로 데이터를 저장하는 구조
//	|_ HashMap<K, V>, TreeMap<K, V>
//			1. key는 중복되지 않는 값만 저장 가능
//			2. value는 중복된 값도 저장 가능
//			3. 검색, 수정 삭제할 때 key값을 사용함
// HashMap<K, V> : 검색을 빠르게 하기 위한 Hash 알고리즘이 적용된 Set
// TreeMap<K, V> : 정렬을 빠르게 하기 위한 Tree 알고리즘이 적용된 Set

public class CollectionsMain06 {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();

		// Map<K, V>에 데이터 저장 : put(key, value)
		System.out.println("--- put(key, value) ---");
		map.put(16, "황의조");
		map.put(7, "손흥민");
		map.put(18, "이승우");
		System.out.println(map);

		// Map<K, V>의 데이터 하나 검색 : get(key) 해당 키 값의 value 리턴
		System.out.println("--- get(key) ---");
		System.out.println(map.get(7));

		// Map<K, V>에 데이터 수정 : put(key, value) 덮어씌기
		System.out.println("--- put(key) ---");
		map.put(7, "덮어쓰기");
		System.out.println(map);

		// Map<K, V>의 데이터 삭제 : remove(key)
		System.out.println("--- remove(key) ---");
		map.remove(7);
		System.out.println(map);

		// Map<K, V>의 key들로만 이루어진 Set을 생성 : keySet()
		System.out.println("--- keySet() ---");
		Set<Integer> keySet = map.keySet();
		System.out.println(keySet);

	}

}
