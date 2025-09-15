package test.program.scalar;

import java.util.HashSet;
import java.util.Set;

//given an array of integers A, 
//find and return whether the given array contains non-empty subarray with sum equal to 0 
public class Test4 {

	public static void main(String[] args) {
//		int[] A = {1,2,3,4,5}; //o/p is zero
		
		int result = 0;
		int []A = {4,-1,1};//o/p is one
//		int[] A = {96, -71, 18, 66, -39, -32, -16, -83, -11, -92, 55, 66, 93, 5, 50, -45, 66, -28, 69, -4, -34, -87, -32, 7, -53, 33, -12, -94, -80, -71, 48, -93, 62};
//		for(int i=0;i<A.length;i++) {
//			for(int j= i+1;j<A.length;j++) {
//				if(A[i] + A[j] == 0) {
//					result = 1;
//					break;
//				}
//				
//			}
//		}
		
		
		System.out.println(hasZeroSumSubarray(A));
	}
	
	public static int hasZeroSumSubarray(int[] A) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : A) {
            sum += num;

            // If the current sum is zero or if we have seen the same sum before,
            // there exists a subarray with a sum of zero.
            if (sum == 0 || set.contains(sum)) {
                return 1;
            }

            set.add(sum);
        }

        return 0;
    }

}
