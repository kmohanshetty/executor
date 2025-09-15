package test.design.pattern.creational.abs.factory;

abstract public class AbstractFactory {
	abstract Printer getPrinter(String type);
	abstract Shape getShape(String shape) ;
}
