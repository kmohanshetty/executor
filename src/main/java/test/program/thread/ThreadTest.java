package test.program.thread;

public class ThreadTest {
	Thread tObj = null;
	
	public ThreadTest(Test t) {
		System.out.println("child");
		tObj = new Thread(t);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		ThreadTest childThread = new ThreadTest(t);
		
		childThread.start();
		
		for(int i=0;i<2;i++) {
			System.out.println("main: "+i);
		}
	}
	
	void start() {
		tObj.start();
//		try {
//			tObj.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}

class Test implements Runnable {
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("child: "+i);
		}
		
	}
	
}