package test.program.thread;

public class SyncTest2 {

	public static void main(String[] args) {
		Callme2 target = new Callme2();
		Caller2 obj1 = new Caller2(target, "Hello");
		Caller2 obj2 = new Caller2(target, "mohan");
		Caller2 obj3 = new Caller2(target, "dhriti");
		
		obj1.t.start();
		obj2.t.start();
		obj3.t.start();
		

		try {
			obj1.t.join();
			obj2.t.join();
			obj3.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

class Callme2 {
	void call(String msg) {
		System.out.print("["+msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}
}

class Caller2 implements Runnable{

	String msg;
	Callme2 target;
	Thread t;
	
	public Caller2(Callme2 targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
	}
	
	@Override
	public void run() {
		//use of synchronized block
		synchronized(target) {
			target.call(msg);
		}
	}
	
}