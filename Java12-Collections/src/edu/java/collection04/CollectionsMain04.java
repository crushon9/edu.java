package edu.java.collection04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionsMain04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			System.out.println("수학 점수 입력>");
			int math = sc.nextInt();
			System.out.println("영어 점수 입력>");
			int eng = sc.nextInt();
			System.out.println("이름 입력>");
			String name = sc.next();

			Score score = new Score(math, eng);
			Student student = new Student(name, score);
			list.add(student);
		}

		// 전체 데이터 검색(출력)
		for (Student x : list) {
			System.out.print("이름: " + x.getName());
			System.out.print(" 수학점수: " + x.getScore().getMath());
			System.out.println(" 영어점수: " + x.getScore().getEng());
		}
		System.out.println();

		// 데이터 수정
		// 1번 인덱스의 학생 정보를 변경
		list.set(1, new Student("둘리", new Score(100, 50)));

		// 0번 인덱스 학생의 영어 점수만 변경
		list.get(0).getScore().setEng(77); // get은 Student 객체를 돌려주네

		// 변경된 리스트의 모든 데이터 출력
		for (Student x : list) {
			System.out.println(x);
		}

		// 데이터 삭제 : 1번 인덱스 학생의 모든 정보 삭제
		list.remove(1);

		sc.close();
	}
}
