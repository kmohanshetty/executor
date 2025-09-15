package test.program.lamda;

public class SimpleLamdaTest {

	public static void main(String[] args) {
		MyNumber myNumber = null;
		
		/*
		 * Here, the lambda expression is simply a constant expression.
		 * When it is assigned to myNumber, a class instance is
		 * constructed in which the lambda expression implements
		 * the getValue() method in MyNumber.
		 */
		myNumber = () -> 125.8; //() indicates no parameter is passed & getValue() will return this expression (125.8)
		
		System.out.println(myNumber.getValue());
		
		myNumber = () -> Math.random() * 100; //getValue() will return this expression (Math.random() * 100)
		System.out.println("1. "+myNumber.getValue());
		System.out.println("2. "+myNumber.getValue());
	}
}

/**
 * Is a functional interface because it contains only one abstract method per interface
 */
interface MyNumber{
	double getValue();
}