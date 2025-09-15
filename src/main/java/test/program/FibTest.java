package test.program;

public class FibTest {

	public static void main(String[] args) {
		System.out.println(fib(20));
	}

	public static int fib(int n) {
		if(n <= 1) return n;
		return fib(n-1) + fib(n-2);
	}
}
