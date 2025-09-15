package test.program;

public interface Inter {
	public static void main(String[] args) {
		System.out.println("main");
		another();
		
	}
	
	public static void another() {
		System.out.println("another");
	}
	
	public default void mydefault() {
		System.out.println("mydefault");
	}
	
	public default void mydefault2() {
		System.out.println("mydefault2");
	}
}