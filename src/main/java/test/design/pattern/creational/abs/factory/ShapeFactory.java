package test.design.pattern.creational.abs.factory;

public class ShapeFactory extends AbstractFactory {

	@Override
	Shape getShape(String shape) {
		if(shape == null){
			return null;
		}
		if(shape.equalsIgnoreCase("circle")){
			return new Circle();
		}else if(shape.equalsIgnoreCase("square")){
			return new Square();
		}else if(shape.equalsIgnoreCase("rectangle")){
			return new Rectangle();
		}
		
		return null;
	}
	
	@Override
	Printer getPrinter(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
