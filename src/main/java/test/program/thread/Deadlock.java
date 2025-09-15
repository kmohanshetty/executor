package test.program.thread;

public class Deadlock implements Runnable {
	  Aaa a = new Aaa();
	  Bbb b = new Bbb();
	  Thread t;

	  Deadlock() {
	    Thread.currentThread().setName("MainThread");
	    t = new Thread(this, "RacingThread");
	  }

	  void deadlockStart() {
	    t.start();
	    a.foo(b); // get lock on a in this thread.
	    System.out.println("Back in main thread");
	  }

	  public void run() {
	    b.bar(a); // get lock on b in other thread.
	    System.out.println("Back in other thread");
	  }

	  public static void main(String[] args) {
	    Deadlock dl = new Deadlock();
	    
	    dl.deadlockStart();
	  }
	}

class Aaa {
	  synchronized void foo(Bbb b) {
	    String name = Thread.currentThread().getName();

	    System.out.println(name + " entered A.foo");

	    try {
	      Thread.sleep(1000);
	    } catch(Exception e) {
	      System.out.println("A Interrupted");
	    }

	    System.out.println(name + " trying to call B.last()");
	    b.last();
	  }

	  synchronized void last() {
	    System.out.println("Inside A.last");
	  }
	}

	class Bbb {
	  synchronized void bar(Aaa a) {
	    String name = Thread.currentThread().getName();
	    System.out.println(name + " entered B.bar");

	    try {
	      Thread.sleep(1000);
	    } catch(Exception e) {
	      System.out.println("B Interrupted");
	    }

	    System.out.println(name + " trying to call A.last()");
	    a.last();
	  }

	  synchronized void last() {
	    System.out.println("Inside A.last");
	  }
	}