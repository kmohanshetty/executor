package test.program.thread;

//An correct implementation of a producer and consumer.
class QQQ {
	int n;
	boolean valueSet = false;
	synchronized int get() {
		while(!valueSet)
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		while(valueSet)
			try {
				wait();
			} catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}

class Producer3 implements Runnable {
	QQQ q;
	Producer3(QQQ q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}
	public void run() {
		int i = 0;
		while(true) {
			q.put(i++);
		}
	}
}

class Consumer3 implements Runnable {
	QQQ q;
	Consumer3(QQQ q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	public void run() {
		while(true) {
			q.get();
		}
	}
}

public class InterprocessComm2 {

	public static void main(String[] args) {
		QQQ q = new QQQ();
		new Producer3(q);
		new Consumer3(q);
		System.out.println("Press Control-C to stop.");

	}

}
