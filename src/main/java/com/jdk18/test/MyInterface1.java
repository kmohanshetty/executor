package com.jdk18.test;

@FunctionalInterface
public interface MyInterface1 {
    void method2();
//    void method3();//if you uncomment this, it will not be called as @FunctionalInterface
//    @FunctionalInterface is annotation where in there will be only one abstract method per interface.
    default void logg(String str){
		System.out.println("I2 logging::"+str);
	}
    
//    void test();// try uncommenting me.
}
