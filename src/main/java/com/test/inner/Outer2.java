package com.test.inner;

public class Outer2 {

	private String x = "Outer variable";
	
	void doStuff() {
		String z = "local variable";
		class Inner2 {
			public void seeOuter() {
				System.out.println("Outer x is " + x);
				System.out.println("Local variable z is " + z);
			}
		}
		Inner2 inner2 = new Inner2();
		inner2.seeOuter();
	}

	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		outer.doStuff();
	}

}
