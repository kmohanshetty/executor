package test.program;

import java.io.IOException;

public class CovariantOverride {
	public static void main(String[] args) throws Exception {
		A a = new B();
		a.method1();
	}
}


class A{
	public void method1() throws Exception{//always parent class method should have more generalized class exception.
		System.out.println("A method1");
	}
}

class B extends A{
	public void method1() throws IOException{//child class of overridden method can throw child class of overridden method.
		System.out.println("B method1");
	}
}