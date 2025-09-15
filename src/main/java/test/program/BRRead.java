package test.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {
	public static void main(String args[]) throws IOException {
		char c;
		BufferedReader br = new
				BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter characters, 'q' to quit.");
			// read characters
			do {
				c = (char) br.read();
				System.out.println(c);
			} while(c != 'q');
		}finally{
			System.out.println("finally called");
			br.close();
		}
	}
}
