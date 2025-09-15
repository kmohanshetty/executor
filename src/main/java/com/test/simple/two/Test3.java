package com.test.simple.two;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test3 {

	public static void main(String[] args) {
//		Stream<List<String>> iStr= Stream.of (
//				Arrays.asList ("1", "John"),
//				Arrays.asList ("2", null), 0);
//				Stream<<String> nInSt = iStr.flatMapToInt ((x) -> x.stream ());
//				nInSt.forEach (System.out :: print);
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
		stream.forEach(p -> System.out.println(p));

	}

}
