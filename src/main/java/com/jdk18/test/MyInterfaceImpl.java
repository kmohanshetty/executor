package com.jdk18.test;

public class MyInterfaceImpl implements MyInterface1, MyInterface2 {

	@Override
	public void method1(String str) {
		System.out.println("m1");
	}

	@Override
	public void method2() {
		System.out.println("m2");
	}
	
	//try to change logg method to log and see the difference

}
