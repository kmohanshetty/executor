package test.program;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Siemens {

	/**
	 * write a program we can count 2 numbers combination which can have 10 as sum
	 * @param args
	 */
	public static void main(String[] args) {
//		withoutTimeComplexity();
		withTimeComplexity();
	}

	private static void withTimeComplexity() {
//		int arr[] = {2, 7, 3, 9, 2, 3, 1};
//		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Integer> numbers = Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5, 5);
		List<int[]> pairs = IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, numbers.size())
                        .filter(j -> numbers.get(i) + numbers.get(j) == 10)
                        .mapToObj(j -> new int[]{numbers.get(i), numbers.get(j)}))
                .collect(Collectors.toList());

        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
		
	}

	private static void withoutTimeComplexity() {
		int arr[] = {2, 7, 3, 9, 2, 3, 1};

		int sum = 10;

		for(int i = 0; i < arr.length;i++){
			for(int j = 0; j < arr.length;j++){
				if(arr[i] + arr[j] == sum){
					System.out.println(arr[i] + " "+ arr[j]);
				}
			}
		}
	}

}
