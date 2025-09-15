package test.program.streams;

// Java program for list convert in map
// with the help of Collectors.toMap() method

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// create a list
class Students {

	// id will act as Key
	private Integer id;

	// name will act as value
	private String name;

	// create constructor for reference
	public Students(Integer id, String name) {

		// assign the value of id and name
		this.id = id;
		this.name = name;
	}

	// return private variable id
	public Integer getId() {
		return id;
	}

	// return private variable name
	public String getName() {
		return name;
	}
}

// main class and method
public class CollectorsMap {

	// main Driver
	public static void main(String[] args) {

		// create a list
		List<Students> lt = new ArrayList<>();

		// add the member of list
		lt.add(new Students(1, "Geeks"));
		lt.add(new Students(2, "For"));
		lt.add(new Students(3, "Geeks"));
		lt.add(new Students(4, "Peeks"));
		lt.add(new Students(5, "Peeky"));
		lt.add(new Students(6, "Blinders"));
		lt.add(new Students(7, "Vikings"));

		// create map with the help of
		// Collectors.toMap() method
		LinkedHashMap<Integer, String>
		lhmap = lt.stream()
		.collect(
				Collectors.toMap(
						Students::getId,
						Students::getName,
						(x, y) -> x + ", " + y,
						LinkedHashMap::new));

		System.out.println(lhmap.getClass());
		// print map
		lhmap.forEach(
				(x, y) -> System.out.println(x + "=" + y));
		System.out.println("-----------------------------------------");
		
		Map<Integer, String> normMap = lt.stream().collect(Collectors.toMap(Students::getId,
						Students::getName));
		normMap.forEach((x, y) -> System.out.println(x + "=" + y));
		System.out.println("-----------------------------------------");
		
		Map<Integer, String> normMap2 = lt.stream().collect(
				Collectors.toMap(Students::getId,
								 Students::getName,
								 (s, a) -> s + ", " + a));
		normMap2.forEach((x, y) -> System.out.println(x + "=" + y));
	}
}
