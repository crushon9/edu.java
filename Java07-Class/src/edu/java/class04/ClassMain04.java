package edu.java.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// Scores 클래스의 인스턴스 생성 : 변수명 scores1
		Scores scores1 = new Scores(50, 60, 70);
		Scores scores3 = new Scores();
		// scores1의 모든 점수 출력
		scores1.printScores();
		// 매개변수 있는 생성자 Student 인스턴스 생성
		Student stu1 = new Student(1, "복실이", scores1);
		Student stu2 = new Student(2, "둘리", new Scores(30, 40, 10));
		Student stu3 = new Student(3, "야옹이", scores3);
		// stu1의 학생 정보 출력
		stu1.displayStudentInfo();
		stu2.displayStudentInfo();
		stu3.displayStudentInfo();
		// 총점 출력
		System.out.println("총점 : " + stu2.scores.calcTotal());

	}

}
