package test.design.pattern.creational.singleton;

public class SingletonWthClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Singleton5 instance1 = Singleton5.getInstance();
		
		System.out.println("instance1:"+instance1.hashCode());
		Singleton5 instance2 = (Singleton5) instance1.clone();
		System.out.println("instance2:"+instance2.hashCode());
	}

}

class Singleton5 implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	private static Singleton5 instance = new Singleton5();
	
	private Singleton5() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton5 getInstance(){
		return instance;
	}
}