package edu.java.string02;

class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override // 원래 Object의 equals는 주소값을 비교하는 메소드 (String클래스에서 내용비교로 override)
	public boolean equals(Object obj) { 
		boolean result = false;

		if (obj instanceof Point) {
			Point pt = (Point) obj; // 강제 형변환
			if (this.x == pt.x && this.y == pt.y) { // double값을 비교함
				result = true;
			}
		}
		return result;
	}
}

public class StringMain02 {

	public static void main(String[] args) {

		Point pt1 = new Point(1, 2);
		System.out.println(pt1);

		Point pt2 = new Point(1, 2);
		System.out.println(pt1);

		System.out.println(pt1.equals(pt2));

	}

}
