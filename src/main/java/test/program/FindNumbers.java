package test.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindNumbers {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher("number 13 nn 3");
		
		while(m.find()) {
			System.out.println(m.group());
		}
	}

}
