package test.program.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoListCommonElements {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(1, 2, 4, 5);
		
		List<Integer> diff = list2.stream().
								filter(item -> !list1.contains(item)).
								collect(Collectors.toList());
		
		List<Integer> diff2 = list1.stream()
				  .filter(item -> !list2.contains(item))
				  .collect(Collectors.toList());
		
		
		System.out.println(diff);
		System.out.println(diff2);

		List<String> slist1 = Arrays.asList("one", "two", "three");
		List<String> slist2 = Arrays.asList("one", "two", "four", "five");
		
		
		List<String> sdiff = slist2.stream().
				filter(item -> !slist1.contains(item)).
				collect(Collectors.toList());
		
		System.out.println(sdiff);
	}

}
