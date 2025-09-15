package test.program;

import java.util.Arrays;

public class SecondHighest {

	public static void main(String[] args) {
		int[] arr = {123, 10, -3 , 10, 200, 300, 400};
		int max = Integer.MIN_VALUE;
		
		for(int val:arr) {
			if(val > max)
				max = val;
		}
		
//		System.out.println(max);

		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j < arr.length;j++) {
				
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j]= temp;
				}
			}
		}
		
//		for(int i:arr) {
//			System.out.println(i);
//		}
		
		if(arr != null && arr.length > 1) {
			System.out.println(arr[arr.length - 2]);
		}
	}

}
