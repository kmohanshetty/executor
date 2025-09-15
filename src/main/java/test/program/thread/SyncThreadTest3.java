package test.program.thread;

public class SyncThreadTest3 extends Thread{
	BBB b = new BBB();
	public static void main(String argv[]) throws Exception{
		SyncThreadTest3 t = new SyncThreadTest3();
		Thread t1 = new Thread(t,"t1");
		Thread t2 = new Thread(t,"t2");
		t1.start();
		t2.start();
	}
	public void run(){
		if(Thread.currentThread().getName().equals("t1")){
			b.printName();
		}else{
			b.printValue();
		}
	}
}

class BBB {
	public static synchronized void printName(){
		try{
			System.out.println("printName");
			Thread.sleep(5*1000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	public void printValue(){
		System.out.println("printValue");
	}
}
