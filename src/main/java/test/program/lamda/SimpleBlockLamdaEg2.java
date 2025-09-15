package test.program.lamda;

public class SimpleBlockLamdaEg2 {

	public static void main(String[] args) {
		StringFunc reverse = (str) -> {
			String result = "";
			int i = 0;
			for(i = str.length() - 1; i >= 0; i--){
				result += str.charAt(i);
			}
			
			return result;
		};
		System.out.println("mohan: "+reverse.func("mohan"));
	}
}

interface StringFunc{
	String func(String n);
}