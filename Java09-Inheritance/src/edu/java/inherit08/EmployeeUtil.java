package edu.java.inherit08;

public class EmployeeUtil {
	// employee 객체를 전송할 예정
	// employee 객체일 수 있고, manager 객체일 수도 있다
	// 이게 가능한 이유는 employee와 manager가 부모-자식 상속관계이기 때문이다
	// 그래서, 두가지 타입의 인스턴스가 전송되기 때문에
	// 조건문과 insanceof를 이용하여 인스턴스 타입에 따라 다르게 처리해야 한다

	public void printEmpInfo(Employee emp) {
		if (emp instanceof Manager) { // 인스턴스가 자식클래스일때
			Manager temp = (Manager) emp; // 형변환했다가 emp가 변환이 유지되는게 아니니깐 temp변수에 담아놓아야 함
			System.out.println("부모에 선언된 name : " + temp.getName());
			System.out.println("자식에 선언된 type : " + temp.getType());
		} else if (emp instanceof Employee) { // 인스턴스가 부모클래스일때
			System.out.println("부모에 선언된 name : " + emp.getName());
		} else {
			System.out.println("직원이 아닙니다");
		}

	}
}
