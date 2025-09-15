package test.program;

import java.util.ArrayList;
import java.util.List;

public class CompareTwoLists {

	public static void main(String[] args) {
		List<String> mainList = new ArrayList<String>();
		mainList.add("Mohan");
		mainList.add("Vidya");
		
		List<String> anotherList = new ArrayList<String>();
		
		anotherList.add("Vidyaa");
		anotherList.add("Mohana");
		anotherList.add("Vidyaaa");
		anotherList.add("Mohan");
		boolean foundFlag = false;
		int count = 0;
		
		for(String name : mainList) {
			if(anotherList.contains(name)) {
				foundFlag = true;
				count++;
			}
		}
		
		if(count == mainList.size()) {
			System.out.print("found");
		} else {
			System.out.print("not found");
		}
	}

}
