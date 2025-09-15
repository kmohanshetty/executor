package test.program.thread;

public class TestRun {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("starting a thread"+Thread.currentThread());
			}},"mkthread");
		t.start();
		System.out.println("control back to "+Thread.currentThread());
	}

}
