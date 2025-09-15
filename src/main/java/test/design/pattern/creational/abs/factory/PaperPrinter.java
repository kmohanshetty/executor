package test.design.pattern.creational.abs.factory;

public class PaperPrinter implements Printer{

	@Override
	public void print() {
		System.out.println("paper");
	}

}
