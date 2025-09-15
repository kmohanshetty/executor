package test.program;

import java.util.HashMap;
import java.util.Map;

public class VowelTest {

	public static void main(String[] args) {
		Map<Character, Integer> vowelCount = new HashMap<Character, Integer>();
		
		String inputText = "test the vowels in this text";
		char[] charArray = inputText.toCharArray();
		for(char c: charArray) {
			if(isVowel(c)) {
				if(vowelCount.get(c) == null) {
					vowelCount.put(c, 1);
				}else {
					vowelCount.put(c, vowelCount.get(c)+1);
				}
			}
		}
		System.out.println("vowel count: "+vowelCount);

	}
	
	static boolean isVowel(char c) {
		char [] vowels = new char[] {'a','e','i','o','u','A','E','I','O','U'};
		for(char ch:vowels) {
			if(ch == c) {
				return true;
			}
		}
		return false;
	}
}
