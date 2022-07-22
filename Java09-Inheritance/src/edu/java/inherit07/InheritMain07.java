package edu.java.inherit07;

class ParentClass {
	private int x;

	public ParentClass(int x) {
		this.x = x;
		System.out.println("ParentClass(x) 생성자");
	}

	public int getX() {
		return x;
	}
} // end ParentClass

class ChildClass extends ParentClass {
	private int y;

	public ChildClass(int x, int y) {
		super(x);
		this.y = y;
		System.out.println("ChildClass(x, y) 생성자");
	}

	public int getY() {
		return y;
	}
} // end ChildClass

public class InheritMain07 {

	public static void main(String[] args) {
		System.out.println("==부모타입에 부모인스턴스생성==");
		ParentClass PnP = new ParentClass(100);
		System.out.println("==자식타입에 자식인스턴스생성==");
		ChildClass CnC = new ChildClass(3, 4);
		System.out.println("==부모타입에 자식인스턴스생성==");
		ParentClass PnC = new ChildClass(100, 200); // 다형성

		System.out.println("==접근하기==");
		System.out.println(CnC.getX()); // 자식은 ParentClass에 접근가능
//		System.out.println(PnP.getY()); // 부모는 ChildClass에 접근불가

		System.out.println(PnC.getX()); // 부모에담긴자식 ParentClass에 접근가능
//		System.out.println(PnC.getY()); // 부모에담긴자식 ChildClass에 접근불가
// PnC는 ParentClass 타입으로 선언했기때문에 ChildClass에서 정의한 getY메소드를 사용할 수 없음
		System.out.println(((ChildClass) PnC).getY());
//		System.out.println(PnC.getY()); // 형변환은 변환이 저장되는게 아니라, 그 순간만 변환됨
		// 다시 자식으로 강제형변환된 자식은 ChildClass에 접근가능 (클래스간형변환은 상속관계에서만가능)

//		instanceof 키워드 (연산자)
//		기본형태 : 참조변수 instanceof 클래스명
//		참조변수에 담긴 인스턴스가 명시한 클래스와 같으면 true, 다르면 false를 리턴
//		특정 인스턴스가 원래 어떤 클래스 소속인지 확인할 때 사용 (현재 담긴 타입에 상관없이)
//		인스턴스 생성될 때 생성자 기준으로 판별하는 듯.. int char 등으로는 연산 안먹힘
		// 사용방법
		System.out.println(PnC instanceof ChildClass);
		if (PnC instanceof ChildClass) {
			System.out.println("x = " + PnC.getX());
			System.out.println("y = " + ((ChildClass) PnC).getY());
		} else {
			System.out.println("x = " + PnC.getX());
		}

	} // end main()
} // end InheritMain07
