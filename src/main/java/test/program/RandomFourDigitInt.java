package test.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomFourDigitInt {

	public static void main(String[] args) {
		Random rand = new Random();
		List<String> randValues= new ArrayList<String>(); 
		
		for(int i =0;i<10;i++) {
			int temp = (int)(rand.nextDouble() * 10000);
			String stemp = temp + "";
			if(stemp.length() < 4) {
				randValues.add(prefixZeros(stemp));
			} else {
				randValues.add(String.valueOf(temp));
			}
		}
		System.out.println(randValues);
	}

	private static String prefixZeros(String stemp) {
		String st = "";
		if(stemp.length() < 4) {
			for(int i = stemp.length(); i < 4; i++) {
				stemp = "0" + stemp;
				st = stemp;
			}
		}
		return st;
	}

}
