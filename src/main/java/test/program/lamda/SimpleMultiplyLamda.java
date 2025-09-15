package test.program.lamda;

public class SimpleMultiplyLamda {

	public static void main(String[] args) {
		
		ArithmaticActions actions = (int a, int b) ->{
			return a*b;
		};
		
		System.out.println(actions.multiply(10, 2));
		
	}

}

@FunctionalInterface
interface ArithmaticActions{
	int multiply(int a, int b);
}