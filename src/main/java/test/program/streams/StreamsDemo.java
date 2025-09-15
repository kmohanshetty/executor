package test.program.streams;

//a simple program to demonstrate the use of stream in java
import java.util.*;
import java.util.stream.*;

public class StreamsDemo {
	public static void main(String args[]) {

		// create a list of integers
		List<Integer> number = Arrays.asList(2, 3, 4, 5);

		// demonstration of map method
		System.out.println("demonstration of map method squaring: ");
		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);
		System.out.println("-----------------------");
		// create a list of String
		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

		// demonstration of filter method
		System.out.println("demonstration of filter method: starts with S");
		List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println("result: "+result);
		System.out.println("-----------------------");
		
		// demonstration of sorted method
		List<String> show = names.stream().sorted().collect(Collectors.toList());
		System.out.println(show);

		// create a list of integers
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);

		// collect method returns a set
		Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println("squareSet: "+ squareSet);

		// demonstration of forEach method
		System.out.println("---demonstration of forEach method---");
		number.stream().map(x -> x * x).forEach(y -> System.out.println(y));
		System.out.println("------");
		// demonstration of reduce method
		int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);

		System.out.println(even);
		System.out.println("****demonstration of reduce method****");
		
		numbers.forEach(y -> System.out.println(y));
	}
}
