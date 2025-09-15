package test.program;

public class TestStrCamelCase {
	
	public static void main(String[] argv) {
		String val = "OPEN";
		
		String temp = val.toLowerCase();
		temp = temp.substring(0,1).toUpperCase() + temp.substring(1);;
		System.out.println(temp);
	}
}
