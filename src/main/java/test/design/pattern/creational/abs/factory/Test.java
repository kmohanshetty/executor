package test.design.pattern.creational.abs.factory;

/**
 * 
Benefits:
Use of this pattern makes it possible to interchange the concrete classes without changing the client code even at runtime.

Drawback:
One of the main drawbacks is the extra complexity and writing the code during the initial stages.
 */
public class Test {

	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		
		Shape circle = shapeFactory.getShape("circle");
		circle.draw();
		Shape rectangle = shapeFactory.getShape("rectangle");
		rectangle.draw();
		Shape square = shapeFactory.getShape("square");
		square.draw();
		
		AbstractFactory printerFactory = FactoryProducer.getFactory("printer");
		
		Shape paper = printerFactory.getShape("paper");
		paper.draw();
		Shape web = printerFactory.getShape("web");
		web.draw();
		Shape screen = printerFactory.getShape("screen");
		screen.draw();
	}

}
