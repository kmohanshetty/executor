package test.program.scalar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test5 {

	public static void main(String[] args) {
//		int [] A = {1,2,2,1};
//		int [] B = {2,3,1,2};
		
		int [] A = {17,12,5,3,14,};
		int [] B = {2,3,1,2};
		
//		int [] A = {2,1,4,10};
//		int [] B = {3,6,2,10,10};
		//find common elements in two array
		findCommonElements(A, B);
	}
	
	static int[] findCommonElements(int[] A, int[] B) {
		List<Integer> result = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>(); 
		for(int ele:B) {
			list.add(ele);
			map.put(ele, map.get(ele) == null ? 1 : map.get(ele) + 1);
		}
		int count = 0;
		for(int ele:A) {
			if(list.contains(ele) && count++ <= map.get(ele)) {
				result.add(ele);
			}
		}
		int[] res = new int[result.size()];
		int i = 0;
		for(int ele:result) {
			res[i++] = ele;
			System.out.println(res[i-1]);
		}
		
		
		return null;
	}

}
