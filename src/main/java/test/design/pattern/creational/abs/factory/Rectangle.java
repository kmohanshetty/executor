package test.design.pattern.creational.abs.factory;

public class Rectangle implements Shape{
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
