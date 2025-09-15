package test.program.thread;

class MyRunnable implements Runnable {

	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 100;
		};
		
		@Override
		public Integer get() {
			return super.get();
		};
	};
	private int i = 0;
	
	@Override
	public void run() {
		i = (int) (Math.random() * 100D);
//		threadLocal.set( i );

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}

		System.out.println("threadlocal: "+threadLocal.get());
		System.out.println("i: "+i);
	}
}

public class ThreadLocalExample {
	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); //wait for thread 1 to terminate
		thread2.join(); //wait for thread 2 to terminate
	}
}
