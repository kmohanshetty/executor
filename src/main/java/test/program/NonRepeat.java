package test.program;

import java.util.ArrayList;
import java.util.List;

//find non repeatable number
public class NonRepeat {

	public static void main(String[] args) {
		List<Integer> nonRepeat = new ArrayList<Integer>();
		int[] arr = new int[]{1, 2, 3, 2, 1, 3, 444} ;
		List<Integer> numbers = new ArrayList<Integer>();

		for(int i = 0;i<arr.length;i++) {
			if(!numbers.contains(arr[i])) {
				nonRepeat.add(arr[i]);
				numbers.add(arr[i]);
				//			}
			}else {
				nonRepeat.remove(nonRepeat.indexOf(arr[i]));
			}

		}

		System.out.println(nonRepeat);

	}

}
