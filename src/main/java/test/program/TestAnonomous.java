package test.program;

public class TestAnonomous {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("test");
				
			}
		};
		Thread t = new Thread(runnable);
		t.start();
		System.out.println(runnable.hashCode());
	}

}
