package test.design.pattern.creational.singleton;

public class OvercomingCloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton6 instance1 = Singleton6.getInstance();
		
		System.out.println("instance1:"+instance1.hashCode());
		Singleton6 instance2 = (Singleton6) instance1.clone();
		System.out.println("instance2:"+instance2.hashCode());
	}
}

class Singleton6 implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	private static Singleton6 instance = new Singleton6();
	
	private Singleton6() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton6 getInstance(){
		return instance;
	}
}

class SuperClass implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}