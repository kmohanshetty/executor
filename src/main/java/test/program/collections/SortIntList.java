package test.program.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortIntList {

	public static void main(String[] args) {
		List<Double> testList=new ArrayList<>();

	    testList.add(0.5);
	    testList.add(0.2);
	    testList.add(0.9);
	    testList.add(0.1);
	    testList.add(0.1);
	    testList.add(0.1);
	    testList.add(0.54);
	    testList.add(0.71);
	    testList.add(0.71);
	    testList.add(0.71);
	    testList.add(0.92);
	    testList.add(0.12);
	    testList.add(0.65);
	    testList.add(0.34);
	    testList.add(0.62);
	    
	    Collections.sort(testList, new Comparator<Double>() {
			@Override
			public int compare(Double lhs, Double rhs) {
				return (lhs > rhs) ? -1 : (lhs < rhs) ? 1 : 0;
			}
		});
	    System.out.println("using Comparator: "+testList);
	    
	    Collections.sort(testList);
	    System.out.println("using Collections.sort: "+testList);
	    
	    Collections.sort(testList, Collections.reverseOrder());
	    System.out.println("reverse order sorting: "+testList);
	    
	    Comparator<Double> comp = (a,b) -> (a < b) ? -1 : (a > b) ? 1 : 0;
	    Collections.sort(testList, comp);
	    System.out.println("using Comparator lamda: "+testList);
	}

}
