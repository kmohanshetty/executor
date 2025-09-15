package test.program.generics;

public class Gen1Demo {

	public static void main(String[] args) {
		Gen1<Integer> iOb = new Gen1<Integer>(100);
		iOb.showType();
		iOb.printOb();
		
		Gen1<String> sOb = new Gen1<String>("birla soft");
		sOb.showType();
		sOb.printOb();
	}
}

class Gen1<T> {
	T ob;
	
	public Gen1(T o) {
		this.ob = o;
	}
	
	public T getOb() {
		return this.ob;
	}
	
	public void showType() {
		System.out.println("Type of T is "+ob.getClass().getName());
	}
	
	public void printOb() {
		T ob2 = getOb();
		System.out.println("-------------------------");
		System.out.println(ob2);
		System.out.println(ob2.getClass());
		System.out.println("-------------------------");
	}
}