package test.program;

//Java program to check if a given credit 
//card is valid or not. 
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

/*
 * 
► It must start with a 4,5 or 6.
► It must contain exactly 16 digits.
► It must only consist of digits (0-9).
► It may have digits in groups of 4, separated by one hyphen "-".
► It must NOT use any other separator like ' ' , '_', etc.
► It must NOT have 4 or more consecutive repeated digits. 
 */

public class CreditCard {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) 
	{ 
//		long number = 5196081888500645L; 
		long number = 123;//4123456789123456L;
		
		Long lNum = Long.valueOf(number);
//		String svalue = "5122-2368-7954-32144";//"4123456789123456";//lNum.toString();
		String svalue = scanner.next();
//		System.out.println(svalue);
		Pattern pattern = Pattern.compile(".*[^0-9].*");
		Matcher m = pattern.matcher(svalue);
		
		//if only number
		if(svalue != null && (svalue.startsWith("4") || svalue.startsWith("5") || svalue.startsWith("6"))) {
			if(!m.matches() && svalue.length() == 16) {
				System.out.println("valid");
			} else {
				String temp = "";
				String[] split = svalue.split("-");
				for(String s:split) {
					temp = temp + s;
				}
//				System.out.println(temp.length());
				m = pattern.matcher(temp);
				if(!m.matches() && temp.length() == 16) {
					System.out.println("valid");
				} else {
					System.out.println("invalid");
				}
			}
		}else {
			System.out.println("invalid");
		}
		
		/*
		// Regular expression in Java to check if String is number or not
        Pattern patternn = Pattern.compile(".*[^0-9].*");
       //Pattern pattern = Pattern.compile(".*\\D.*");
       String [] inputs = {"123","4123456789123456", "-123" , "123.12", "abcd123"};
     
       for(String input: inputs){
           System.out.println( "does " + input + " is number : "
                                + !patternn.matcher(input).matches());
       }*/


	}
	
	
/*	// Main Method 
	public static void main(String[] args) 
	{ 
//		long number = 5196081888500645L; 
		long number = 4123456789123456L;

		System.out.println(number + " is " + 
				(isValid(number) ? "valid" : "invalid")); 
	} 

	public static boolean isValid(long number) { 
		return (getSize(number) >= 13 && 
				getSize(number) <= 16) && 
				(prefixMatched(number, 4) || 
						prefixMatched(number, 5) || 
						prefixMatched(number, 37) || 
						prefixMatched(number, 6)) && 
				((sumOfDoubleEvenPlace(number) + 
						sumOfOddPlace(number)) % 10 == 0); 
	} 

	public static int sumOfDoubleEvenPlace(long number) { 
		int sum = 0; 
		String num = number + ""; 
		for (int i = getSize(number) - 2; i >= 0; i -= 2) 
			sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2); 

		return sum; 
	} 

	public static int getDigit(int number) { 
		if (number < 9) 
			return number; 
		return number / 10 + number % 10; 
	} 

	public static int sumOfOddPlace(long number) { 
		int sum = 0; 
		String num = number + ""; 
		for (int i = getSize(number) - 1; i >= 0; i -= 2) 
			sum += Integer.parseInt(num.charAt(i) + "");		 
		return sum; 
	} 

	public static boolean prefixMatched(long number, int d) { 
		return getPrefix(number, getSize(d)) == d; 
	} 

	public static int getSize(long d) { 
		String num = d + ""; 
		return num.length(); 
	} 

	public static long getPrefix(long number, int k) { 
		if (getSize(number) > k) { 
			String num = number + ""; 
			return Long.parseLong(num.substring(0, k)); 
		} 
		return number; 
	}*/ 
} 
