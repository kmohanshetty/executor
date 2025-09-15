package test.program.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppendAA {

	public static void main(String[] args) {
		//input
		List<String> list = new ArrayList<>();
		list.add(null);
		list.add("Australia");
		list.add("India");
		list.add("Africa");
		list.add("Indonesia");
		list.add("Malaysia");
		
		//output = {"AustraliaAA","AfricaAA"}
		
		List<String> list2 = list.stream().
				filter((name) -> name != null && name.startsWith("I")).
				map((name) -> name + "AA").
				collect(Collectors.toList());
		
		System.out.println(list2);
		

	}

}
