package com.jdk18.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestJ8 {
	public static void main(String[] args) {
		List<String> listVal = Arrays.asList("Joe", "Paul", "Alice", "Tom");

		System.out.println(listVal.stream().filter(x -> x.length()>3).count());
		System.out.println(listVal.stream().map(x -> x.length()>3).count());
		//		System.out.println(listVal.stream().peek(x -> x.length()>3).count().get());
		//		System.out.println(listVal.stream().filter(x -> x.length()>3).mapToInt(x -> x).count());

		List<String> colors = Arrays.asList("red", "green", "yellow");
		Predicate<String> test = (n) -> {
			System.out.println("Searching…");
			return n.contains("red");
		};

		colors.stream()
		.filter(c -> c.length() > 3)
		.allMatch(test);
		
		List<String> nums = Arrays.asList("EE", "SE");
		String ans = nums
				.parallelStream()
				.reduce("Java ", (a, b) -> a.concat(b));
		System.out.println(ans);
		
		
		System.out.println("------------------");
		Supplier<Double> randomSupplier = () -> Math.random();

		// Get a value
		System.out.println("random1:"+randomSupplier.get());

		// Using with Streams
		Stream.generate(randomSupplier)
		      .limit(5)
		      .forEach(System.out::println);

	}
}
