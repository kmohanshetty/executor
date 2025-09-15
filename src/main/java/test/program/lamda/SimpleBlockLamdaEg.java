package test.program.lamda;

public class SimpleBlockLamdaEg {

	public static void main(String[] args) {
		NumericFunc numericFunc = (int n) -> {
			int result = 1;
				for(int i=1; i<=n; i++){
					result = i * result;
				}
			
			return result;
		};
		System.out.println("factorial of 3: "+numericFunc.func(3));
		System.out.println("factorial of 4: "+numericFunc.func(4));
	}

}

interface NumericFunc {
	int func(int n);
}