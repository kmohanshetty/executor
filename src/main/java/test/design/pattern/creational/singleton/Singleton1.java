package test.design.pattern.creational.singleton;

public class Singleton1 {
	private static Singleton1 instance = new Singleton1();
	private Singleton1(){}
	
	public static Singleton1 getInstance(){
		return instance;
	}
	
	public void showMessage(){
		System.out.println("message from singleton1");
	}
	
	public static void main(String[] args) {
		Singleton1 singleton1 = Singleton1.getInstance();
		singleton1.showMessage();
	}

}
