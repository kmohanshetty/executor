package test.program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueElement {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("ABC");
		list.add("ABC");
		list.add("XYZ");
		
		Set<String> set = new HashSet<String>(list);
		
		System.out.println("list: "+list);
		System.out.println("set: "+set);
	}

}
