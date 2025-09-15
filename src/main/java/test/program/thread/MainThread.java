package test.program.thread;

public class MainThread {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();

		System.out.println(thread);
		thread.setName("Mohan thread");
		System.out.println(thread);
		System.out.println(thread.getName());

		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000, 1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
