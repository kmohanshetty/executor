package test.program.collections;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;


public class SortArrayListAscendingDescendingTest {
	
	@Test
	public void testSortAscDescOrder() throws Exception{
		ArrayList<String> countryList = new ArrayList<>();         
	    countryList.add("France");         
	    countryList.add("USA");         
	    countryList.add("India");         
	    countryList.add("Spain");         
	    countryList.add("England");
	    
	    SortArrayListAscendingDescending sortArrayList = new SortArrayListAscendingDescending(countryList);
	    ArrayList<String> unsortedArrayList = sortArrayList.getArrayList();
	    System.out.println("unsorted list:" + unsortedArrayList);
	    
	    ArrayList<String> sortedArrayListAscending = sortArrayList.sortAscending();         
	    System.out.println("Sorted ArrayList in Ascending Order : " + sortedArrayListAscending);         
	    ArrayList<String> sortedArrayListDescending = sortArrayList.sortDescending();         
	    System.out.println("Sorted ArrayList in Descending Order: " + sortedArrayListDescending);
	}
}



class SortArrayListAscendingDescending {
	private ArrayList<String> arrayList;

	public SortArrayListAscendingDescending(ArrayList<String> arrayList) {
		this.arrayList = arrayList;
	}

	public ArrayList<String> getArrayList(){
		return this.arrayList;
	}

	public ArrayList<String> sortAscending(){
		Collections.sort(this.arrayList);
		return this.arrayList;
	}

	public ArrayList<String> sortDescending(){
		Collections.sort(this.arrayList, Collections.reverseOrder());
		return this.arrayList;
	}

}
