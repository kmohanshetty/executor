package test.program.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {

	public static void main(String[] args) {
		//write a program to find just odd numbers in the above array using streams
		Integer[] arr = {1,12, 11, 13, 8, -11, -12};
		List<Integer> list = Stream.of(arr).filter( n -> (n % 2) != 0).collect(Collectors.toList());
		System.out.println(list);

		List<Integer> minLst = Stream.of(arr).sorted().limit(2).collect(Collectors.toList());
		System.out.println(minLst);
		
		String name = "developer";
		Map<Character, Long> charList = name.chars().mapToObj(c ->(char) c).
				collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charList);
		
		Map<String, Long> repeatingStrings = Arrays.asList("AA", "BB", "AA", "CC")
		        .stream()
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		        .entrySet().stream()
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(repeatingStrings);
		
		Set<Entry<String, Long>> entrySet = Arrays.asList("AA", "BB", "AA", "CC")
        .stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet();
		
		System.out.println(entrySet);
	}

}
