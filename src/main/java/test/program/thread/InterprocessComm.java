package test.program.thread;

//An incorrect implementation of a producer and consumer.
class QQ {
	int n;
	synchronized int get() {
		System.out.println("Got: " + n);
		return n;
	}
	synchronized void put(int n) {
		this.n = n;
		System.out.println("Put: " + n);
	}
}

class Producer2 implements Runnable {
	QQ q;
	Producer2(QQ q) {
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

class Consumer2 implements Runnable {
	QQ q;
	Consumer2(QQ q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}
	public void run() {
		while(true) {
			q.get();
		}
	}
}

public class InterprocessComm {

	public static void main(String[] args) {
		QQ q = new QQ();
		new Producer2(q);
		new Consumer2(q);
		System.out.println("Press Control-C to stop.");

	}

}
