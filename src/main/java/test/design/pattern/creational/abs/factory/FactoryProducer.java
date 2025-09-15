package test.design.pattern.creational.abs.factory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("shape")){
	         return new ShapeFactory();
	      } else if(choice.equalsIgnoreCase("printer")){
	         return new PrinterFactory();
	      }
		
		return null;
	}
}
