package test.program;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestIterator {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("mango", "apple", "orange", "cheeku", "papaya");
		
		Iterator<String> iterator = names.iterator();
		
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}

	}

}
