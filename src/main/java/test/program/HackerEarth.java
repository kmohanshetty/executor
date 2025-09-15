package test.program;

import java.util.Arrays;
import java.util.Comparator;

public class HackerEarth {

	int val = 10;
	public static void main(String[] args) {
		HackerEarth e = new HackerEarth();
		System.out.println(e.val);
		
		
//		var xyFile:File = File.createTempFile();
		String [] testStrings = {"ZZZ", "DDD", "AAA", "EEE" };
		

		Arrays.sort(testStrings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (int) o2.compareTo(o1);
			}
			
		});
		for(String s : testStrings)
		System.out.println(s);
		System.out.println("-----------------------------------");
		Arrays.sort(testStrings, (s1, s2) -> s1.compareTo(s2));
		for(String s : testStrings)
		System.out.println(s);
		System.out.println("-----------------------------------");
		float f = 3.996f;
		System.out.println(f);
		
	}

}
