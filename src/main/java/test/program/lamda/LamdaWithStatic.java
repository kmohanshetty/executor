package test.program.lamda;

//Demonstrate a method reference for a static method.
//A functional interface for string operations.
interface StringFuncs {
	String func(String n);
}

interface PrintFuncs {
	void printAnything();
}

//This class defines a static method called strReverse().
class MyStringOps2 {
	//A static method that reverses a string.
	static String strReverse(String str) {
		String result = "";
		int i;
		for(i = str.length()-1; i >= 0; i--)
			result += str.charAt(i);
		return result;
	}
	
	static void printAnything() {
		System.out.println("another method which is static");
	}
}

public class LamdaWithStatic {
	// This method has a functional interface as the type of
	// its first parameter. Thus, it can be passed any instance
	// of that interface, including a method reference.
	static String stringOp(StringFuncs sf, String s) {
		return sf.func(s);
	}
	public static void main(String args[]) {
		String inStr = "Lambdas add power to Java";
		String outStr;
		// Here, a method reference to strReverse is passed to stringOp().
		outStr = stringOp(MyStringOps2::strReverse, inStr);
		System.out.println("Original string: " + inStr);
		System.out.println("String reversed: " + outStr);
		
		StringFuncs sf = MyStringOps2::strReverse;
		System.out.println(sf.func("mohan"));
		
		PrintFuncs pf = MyStringOps2::printAnything;
		System.out.println(" print method called \n");
		pf.printAnything();
	}
}
