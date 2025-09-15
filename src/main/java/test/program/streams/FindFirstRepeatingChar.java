package test.program.streams;

import java.util.HashMap;
import java.util.LinkedHashSet;

//need to print first repeating character: eg: s is repeating here using streams
public class FindFirstRepeatingChar {

	public static <K> void main(String[] args) {
		String name = "bishan sammadar";
		HashMap<String, Integer> chars= new HashMap<>();
		
//		name.chars().forEach(p -> System.out.println(((char)p)));
		
		char firstRepeating = (char) name.chars().
				mapToObj(ch -> (char) ch).
				collect(LinkedHashSet::new, LinkedHashSet::add, (set1, set2) -> {}).
				stream().
				filter(ch -> name.indexOf((char) ch) != name.lastIndexOf((char) ch)).
				findFirst().
				orElse('\0');
		
		
		System.out.println(firstRepeating);
		

	}
}
