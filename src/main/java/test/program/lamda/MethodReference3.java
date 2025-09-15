package test.program.lamda;

import java.util.function.BiFunction;

class Arithmetic {
	public static float add(int a, float b) {
		return a + b;
	}
}

public class MethodReference3 {
	public static void main(String[] args) {
		BiFunction<Integer, Float, Float> adder = Arithmetic::add;
		float result = adder.apply(10, 20.04f);
		System.out.println(result);
	}
}