package edu.java.lambda01;

// @FunctionalInterface : 추상메소드가 하나뿐인 메소드
// 람다표현식은 @FunctionalInterface만 사용가능

@FunctionalInterface
public interface Adder {
	public abstract double add(double x, double y);
}