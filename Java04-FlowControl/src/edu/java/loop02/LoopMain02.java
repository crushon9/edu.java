package edu.java.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		System.out.println("랜덤 주사위");
		// 두 개의 주사위를 던져서 나온 값을(x, y)와 같은 형식으로 출력
		// 두 개의 주사위가 같은 숫자가 나오면 종료

		// 무한 루프 사용법
//		while (true) {
//			System.out.println("^ㅎ^");
//		}

//		for (;;) {
//			System.out.println("^ㅎ^");
//		}
		int count = 1;
		while (true) {
			// random() : 0 <= x < 1 사이의 난수 발생
			double rX = Math.random();
			double rY = Math.random();
			int x = (int) 6 * (int) rX + (int) 1;
			int y = (int) (6 * rY + 1);
			System.out.println("x : " + x + " , " + "y : " + y);
			
			if (x == y) {
				System.out.println("같은 수가 나왔습니다.");
				break;
			}
			count++;
		}
		System.out.println(count + "번 만에 두 주사위가 동일해졌습니다.");

	} // end main()
} // end LoopMain02
