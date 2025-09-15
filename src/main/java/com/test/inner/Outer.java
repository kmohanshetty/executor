package com.test.inner;

public class Outer {

	private String x = "Outer variable";
	void doStuff() {
		String z = "local variable";
		class Inner {
			public void seeOuter() {
				System.out.println("Outer x is " + x);
				System.out.println("Local variable z is " + z);
			}
		}
		Inner mi = new Inner();
		mi.seeOuter();
	}
	public static void main(String[] args) {
		Outer out = new Outer();
		out.doStuff();
	}

}


