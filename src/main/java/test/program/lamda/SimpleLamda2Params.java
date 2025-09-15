package test.program.lamda;

public class SimpleLamda2Params {

	public static void main(String[] args) {
		NumericTest2 numericTest2 = (int a,int b) -> ((a%b) == 0); // can specify without type: (a,b) ->, you can't do this: (int a,b) ->
		if(numericTest2.test(10, 2)){
			System.out.println("Both numerics are factors of each other");
		}
		if(!numericTest2.test(10, 3)){
			System.out.println("Both numerics are not factors of each other");
		}
	}
}

interface NumericTest2{
	boolean test(int a,int b);
}