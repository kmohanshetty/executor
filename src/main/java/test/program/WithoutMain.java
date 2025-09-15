package test.program;

public class WithoutMain {
	
	static {
		test();
	}

	public static void test() {
		System.out.println("Hi");
		System.exit(0);
	}
}
