package edu.java.class04;

public class Student {
	// 멤버 변수(필드, 프로퍼티)
	int stuNo; // 학생번호 -> 빈그릇을 만들어놓은것. 초기값 0
	String name; // 학생이름 -> 빈그릇을 만들어놓은것. 초기값 null
	Scores scores; // 학생점수 -> 아직 객체화하진않았지만 나중에 객체화한주소를 담을 빈그릇변수를 만들어놓은것. 초기값 null
							// 어랏? 이중포인터랑 비슷한 느낌인가보네?

	public Student() {
	}

	public Student(int stuNo, String name, Scores scores) {
		this.stuNo = stuNo;
		this.name = name;
		this.scores = scores;
	}

	// 출력 메소드
	public void displayStudentInfo() {
		System.out.println("--- 학생 정보 ---");
		System.out.println(this.scores); // 메인메소드에서 인스턴스화하여 할당된 힙주소가 출력될것
		System.out.println("번호 : " + this.stuNo);
		System.out.println("이름 : " + this.name);
		System.out.println("국어점수 : " + this.scores.kor);
		System.out.println("영어점수 : " + this.scores.eng);
		System.out.println("수학점수 : " + this.scores.math);
		System.out.println("총점 : " + this.scores.calcTotal());
		System.out.println("평균 : " + this.scores.calcAverage());
		System.out.println("---------------");
		
	}
}
