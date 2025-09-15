package test.program.scalar;

public class Test1 {

	public static void main(String[] args) {
//		int A[] = {0, 2, 9};
		int A[] = {5, 17, 100, 1};
		
		//need to find maximum of all even numbers minus minimum of all odd numbers
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<A.length;i++) {
			if((A[i] % 2 == 0) && A[i] > max) {
				max = A[i];
			}
			if((A[i] % 2 != 0) && A[i] < min) {
				min = A[i];
			}
		}
		
		System.out.println(max);
		System.out.println(min);
//		return  max - min;
	}

}
