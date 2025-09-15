package test.program;

import java.util.List;

public class TestForeach {
	public static void main(String[] args) {
		List<String> list = List.of("apple", "banana", "mango", "cherry");

		list.forEach(fruit -> {
		    if (fruit.equals("banana")) {
		        return; // Skips the rest of the code for "banana"
		    }
		    System.out.println(fruit);
		});
	}

}

