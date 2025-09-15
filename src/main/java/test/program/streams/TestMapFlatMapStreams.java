package test.program.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMapFlatMapStreams {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		List<Integer> nameLengths = names.stream()
		    .map(String::length)
		    .collect(Collectors.toList());
		System.out.println(nameLengths);
		
		
		List<List<String>> namesList = Arrays.asList(
			    Arrays.asList("Alice", "Bob"),
			    Arrays.asList("Charlie", "David")
			);

			List<String> allNames = namesList.stream()
			    .flatMap(List::stream)
			    .collect(Collectors.toList());
		System.out.println(allNames);

	}

}
