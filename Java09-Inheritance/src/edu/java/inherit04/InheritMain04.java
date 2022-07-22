package edu.java.inherit04;

public class InheritMain04 {

	public static void main(String[] args) {
		Animal animal = new Animal("동물");
		animal.speak();

		Dog dog = new Dog("토토", "시고르자브종");
		dog.speak();
		Cat cat = new Cat();
		cat.speak();

		System.out.println("====배열에 넣기====");
		Animal[] array = new Animal[2];
		// 타입이 Dog,Cat 이지만 Animal을 상속받은 하위타입이기 때문에 Animal배열에 들어감
		array[0] = dog;
		array[1] = cat;
		for (int i = 0; i < array.length; i++) {
			array[i].speak(); // override 됐기때문에 묶어서 호출가능
		}
		// 예를들어 int 배열에도 더 작은 타입이 담김
		int[] arrayInt = new int[3];
		int i = 1;
		short s = 2;
		char c = 3;
		arrayInt[0] = i;
		arrayInt[1] = s;
		arrayInt[2] = c;

	}

}
