package com.test.simple.two;

abstract class Operator{
	protected void turnOn();
	protected void turnOff();
}

class EngineOperator extends Operator {
	public final void turnOn() {System.out.println("ON");}
	public final void turnOff() {System.out.println("ON");}
}

class Engine {
	Operator op = new EngineOperator();
	
	void operate() {
		op.turnOn();
		op.turnOff();
	}
}

public class Test2 {

	public static void main(String[] args) {
		Engine engine = new Engine();
		engine.operate();
	}

}
