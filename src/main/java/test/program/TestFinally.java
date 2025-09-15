package test.program;

public class TestFinally {

	public static void main(String[] args) {
		System.out.println("received: "+method1());

	}
	
	private static int method1() {
		try {
			return method2();
		} finally {
			System.out.println("finally");
		}
	}
	
	private static int method2() {
		System.out.println("two");
		return 10;
	}

}
