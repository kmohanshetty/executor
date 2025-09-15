package com.test.simple.two;

import java.io.IOException;

class Parent {

	public void play() throws Exception {
		System.out.println("parent");
	}

}

class Child extends Parent{
	public void play() throws IOException {
		System.out.println("parent");
	}
}

public class TestException {

	public static void main(String[] args) {
		try {
			new Child().play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
