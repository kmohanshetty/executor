package test.program.datastructure;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	public static void main(String[] args) {
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(100);
		iList.add(20);
		iList.add(19);
		iList.add(101);
		
		System.out.println(getSortedValues(iList));
	}
	
	public static List<Integer> getSortedValues(List<Integer> inputList){
		int temp = 0;
		int temp2 = 0;
		for(int i=0;i<inputList.size();i++){
			for(int j=0;j<inputList.size();j++){
				if(inputList.get(i) > inputList.get(j)){
					temp = inputList.get(i);
					temp2 = inputList.get(j);
					
					inputList.set(i,temp2);
					inputList.set(j,temp);
				}
			}
		}
		
		return inputList;
	}

}
