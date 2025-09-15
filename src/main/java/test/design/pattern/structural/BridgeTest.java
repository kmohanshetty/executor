package test.design.pattern.structural;
/*
 * Bridge pattern decouples an definition from its implementation
 * that lets you split a large class or a set of closely related classes into two separate 
 * hierarchies—abstraction and implementation—which can be developed independently of each other.
 * 
 * example of tv vs remote bridge
 */

interface Printer2 {
	public void print(int radius, int x, int y);
}
class ColorPrinter2 implements Printer2 {
	@Override
	public void print(int radius, int x, int y) {
		System.out.println("Color: " + radius +", x: " +x+", "+ y +"]");
	}
}
class BlackPrinter2 implements Printer2 {
	@Override
	public void print(int radius, int x, int y) {
		System.out.println("Black: " + radius +", x: " +x+", "+ y +"]");
	}
}
abstract class Shape {
	protected Printer2 printer;
	protected Shape(Printer2 p){
		this.printer = p;
	}
	public abstract void draw();  
}
class Circle extends Shape {
	private int x, y, radius;

	public Circle(int x, int y, int radius, Printer2 printer) {
		super(printer);
		this.x = x;  
		this.y = y;  
		this.radius = radius;
	}

	public void draw() {
		printer.print(radius,x,y);
	}
}
public class BridgeTest {
	public static void main(String[] args) {
		Shape redCircle = new Circle(100,100, 10, new ColorPrinter2());
		Shape blackCircle = new Circle(100,100, 10, new BlackPrinter2());

		redCircle.draw();
		blackCircle.draw();
	}
}
