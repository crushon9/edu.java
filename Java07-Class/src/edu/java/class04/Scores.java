package edu.java.class04;

public class Scores {
	// 멤버 변수(필드, 프로퍼티)
	int kor;
	int eng;
	int math;

	public Scores() {
	}

	// source -> Generate Constructor using Fields (매개변수있는 생성자 자동완성 기능)
	public Scores(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int calcTotal() {
		return this.kor + this.eng + this.math;
	}

	public double calcAverage() {
		return (double) this.calcTotal() / 3;
	}

	public void printScores() {
		System.out.println("--- 점수 출력 ---");
		System.out.println("국어 : " + this.kor);
		System.out.println("영어 : " + this.eng);
		System.out.println("수학 : " + this.math);
		System.out.println("---------------");
	}

}
