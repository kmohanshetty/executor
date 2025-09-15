package test.program.lamda;

//Demonstrate a constructor reference with a generic class.
//MyFunc is now a generic functional interface.
interface MyFunc<T> {
	MyClass<T> func(T n);
}

class MyClass<T> {
	private T val;
	// A constructor that takes an argument.
	MyClass(T v) {
		val = v; 
		System.out.println("parametrised : "+val);
	}
	
	// This is the default constructor.
	MyClass( ) {
		System.out.println("default");
		val = null; 
	}
	
	T getVal() {
		System.out.println("lamda called");
		return val; 
	}
}
public class LamdaWithConstructor {
	public static void main(String args[]) {
		// Create a reference to the MyClass<T> constructor.
		MyFunc<Integer> myClassCons = MyClass<Integer>::new;
		System.out.println("----------------------");
		// Create an instance of MyClass<T> via that constructor reference.
		MyClass<Integer> mc = myClassCons.func(100);
		System.out.println("----------------------");
		// Use the instance of MyClass<T> just created.
		System.out.println("val in mc is " + mc.getVal( ));
	}
}
