package test.program.streams;

import java.util.stream.Stream;

public class StreamOfExample {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
		stream.forEach(p -> System.out.println(p));

		Stream<Integer> stream2 = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
		stream2.forEach(p -> System.out.println(p));
	}

}
