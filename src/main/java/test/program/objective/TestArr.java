package test.program.objective;

public class TestArr {

	public static void main(String[] args) {
		int[] arr = new int[] { 2013, 2014, 2015, 2016, 2015 };
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 2015)
				continue;
			count++;
		}
		System.out.println(count + " found!");

	}

}
