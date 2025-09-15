package test.program.scalar;

public class Test2 {

	public static void main(String[] args) {
//		int [] A = {1,2,3,2,1};
//		int B = 5;
		
		int [] A = {1,1,1};
		int B = 2;
		
		int count = 0;
		
		for(int i = 0; i < A.length; i++) {
			for(int j = i+1; j < A.length; j++) {
				if(A[i] + A[j] == B) {
					System.out.println(A[i] + " " + A[j]);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
