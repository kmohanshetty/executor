package test.program.scalar;

//given A, B and C, find (Math.pow(A,B) % C), note reminder on division cannot be negative
public class Test3 {

	public static void main(String[] args) {
//		int A = 2, B = 3, C = 3;
//		int A = 3, B = 3, C = 1;
		int A = -1, B = 1, C = 20;
		// A power(B) % C 
		
		System.out.println(1 % 20);
		System.out.println((int)(Math.pow(Math.abs(A), Math.abs(B)) % Math.abs(C)));
		
//		int A = 5;
//        int B = 3;
//        int C = 7;
        long result = powerMod(A, B, C);
        System.out.println("Result: " + result);
	}
	
	public static int powerMod(int A, int B, int C) {
        if (B == 0) {
            return 1 % C;
        }

        int result;
        if (B % 2 == 0) {
            int temp = powerMod(A, B / 2, C);
            result = (temp * temp) % C;
        } else {
            int temp = powerMod(A, B - 1, C);
            result = (A % C * temp) % C;
        }

        return (result + C) % C; // Ensure the result is non-negative
    }

}
