package com.jdk18.test;

//A interface can have only one abstract method if its @FunctionalInterface
@FunctionalInterface
public interface MyInterface2 {
	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
}
