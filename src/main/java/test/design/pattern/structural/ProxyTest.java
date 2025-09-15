package test.design.pattern.structural;
/*
 * Proxy means 'in place of', representing' or 'in place of' or 'on behalf of'
 * are literal meanings of proxy and that directly explains Proxy Design Pattern
 *
 * A real world example can be a cheque or credit card is a proxy for what is in our bank account.
 * It can be used in place of cash, and provides a means of accessing that cash when required
 */
interface Printer3 {
	void print();
}

class ConsolePrinter3 implements Printer3 {
	private String fileName;

	public ConsolePrinter3(String fileName){
		this.fileName = fileName;
	}
	@Override
	public void print() {
		System.out.println("Displaying " + fileName);
	}
}
class ProxyPrinter3 implements Printer3 {
	private ConsolePrinter3 consolePrinter3;
	private String fileName;

	public ProxyPrinter3(String fileName){
		this.fileName = fileName;
	}

	@Override
	public void print() {
		if(consolePrinter3 == null){
			consolePrinter3 = new ConsolePrinter3(fileName);
		}
		System.out.println("do specific proxy activity before invoking actual method");
		consolePrinter3.print();
	}
}


public class ProxyTest {
	public static void main(String[] args) {
		Printer3 image = new ProxyPrinter3("test");
		image.print();
	}
}
