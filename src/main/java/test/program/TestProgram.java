package test.program;

public class TestProgram {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.print(i+" ");
			if(i % 2 == 0) continue;
			System.out.println("");
		}
		
		char[] value = {'a','b','c','d','e'};
		System.out.println(value.toString());
	}

}
