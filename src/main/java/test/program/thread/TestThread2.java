package test.program.thread;

class A extends Thread {
	int count = 0;

	public void run() {
		System.out.println("run");
		synchronized (this) {
			for (int i = 0; i < 50; i++) {
				count = count + i;
			}
			notify();
		}
	}
}

public class TestThread2 {
	public static void main(String argv[]) {
		A a = new A();
		a.start();
		System.out.println("waiting");
		try {
			a.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a.count);
	}
}
