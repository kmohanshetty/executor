package com.test.simple.three;

import java.io.IOException;

public class TestSimple {

	public static void main(String[] args) {
		A obj = new B();
		try {
			obj.method1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
