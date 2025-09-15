package test.program.streams;

import java.util.Random;
import java.util.stream.Stream;

public class StreamGenerateIterateEg {

	public static void main(String[] args) {
		Stream<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(100));

		randomNumbers.limit(20).forEach(System.out::println);

	}

}
