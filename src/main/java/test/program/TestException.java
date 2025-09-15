package test.program;

public class TestException {
//multi catch
	public static void main(String[] args) {
		int i = 0;
		try {
			i = 2 / i;
			
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e2) {
			System.out.println("exception "+e2);
		}

	}

}
