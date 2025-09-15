package com.test.inner;

public class Outer3 {
	int val = 222;
	class Inner {
		void display() {
			System.out.println("inner accessing outer instance variable: "+val);
		}
	}

	public static void main(String[] args) {
		Outer3 outer3 = new Outer3();
		Inner inner = outer3.new Inner();
		inner.display();
	}

}
