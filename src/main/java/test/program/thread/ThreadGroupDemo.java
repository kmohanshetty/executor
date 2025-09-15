package test.program.thread;

//Demonstrate thread groups.
class NewThread2 extends Thread {
	boolean suspendFlag;
	
	NewThread2(String threadname, ThreadGroup tgOb) {
		super(tgOb, threadname);
		System.out.println("New thread: " + this);
		suspendFlag = false;
		start(); // Start the thread
	}
	
	//This is the entry point for thread.
	public void run() {
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println(getName() + ": " + i);
				Thread.sleep(1000);
				synchronized(this) {
					while(suspendFlag) {
						wait();
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in " + getName());
		}
		System.out.println(getName() + " exiting.");
	}
	
	synchronized void mysuspend() {
		suspendFlag = true;
	}
	
	synchronized void myresume() {
		suspendFlag = false;
		notify();
	}
}

public class ThreadGroupDemo {

	public static void main(String[] args) {
		ThreadGroup groupA = new ThreadGroup("Group A");
		ThreadGroup groupB = new ThreadGroup("Group B");
		NewThread2 ob1 = new NewThread2("One", groupA);
		NewThread2 ob2 = new NewThread2("Two", groupA);
		NewThread2 ob3 = new NewThread2("Three", groupB);
		NewThread2 ob4 = new NewThread2("Four", groupB);

		System.out.println("\nHere is output from list():");
		groupA.list();
		groupB.list();
		System.out.println();

		System.out.println("Suspending Group A");
		Thread tga[] = new Thread[groupA.activeCount()];
		groupA.enumerate(tga); // get threads in group
		for(int i = 0; i < tga.length; i++) {
			((NewThread2)tga[i]).mysuspend(); // suspend each thread
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Resuming Group A");
		for(int i = 0; i < tga.length; i++) {
			((NewThread2)tga[i]).myresume(); // resume threads in group
		}
		// wait for threads to finish
		try {
			System.out.println("Waiting for threads to finish.");
			ob1.join();
			ob2.join();
			ob3.join();
			ob4.join();
		} catch (Exception e) {
			System.out.println("Exception in Main thread");
		}
		System.out.println("Main thread exiting.");
	}

}
