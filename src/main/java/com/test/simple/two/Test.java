package com.test.simple.two;

class A {
	public void method1() {
		System.out.println("A");
	}
}

class B extends A{
	protected void method1() {
		System.out.println("A");
	}
}

public class Test {

	public static void main(String[] args) {
		A ref = new B();
		ref.method1();
	}

}
