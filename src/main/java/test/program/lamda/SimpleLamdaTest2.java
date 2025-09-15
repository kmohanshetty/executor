package test.program.lamda;

public class SimpleLamdaTest2 {

	public static void main(String[] args) {
		NumericTest isEven = null;
		
		isEven = (m) -> (m % 2) == 0;// here type is inferred as int
		if(isEven.test(10)){
			System.out.println("is even");
		}
		if(!isEven.test(9)){
			System.out.println("is odd");
		}
		
		NumericTest isNonNeg = (int param) -> param >= 0; //explicitly specify the type (int param)
		
		if(isNonNeg.test(-1)){
			System.out.println("is neg");
		}
		if(isNonNeg.test(1)){
			System.out.println("is non neg");
		}
		
	}

}


interface NumericTest{
	boolean test(int n);
}