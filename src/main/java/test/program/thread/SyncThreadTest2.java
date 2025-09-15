package test.program.thread;

public class SyncThreadTest2 extends Thread{
	BB b = new BB();
	public static void main(String argv[]) throws Exception{
		SyncThreadTest2 t = new SyncThreadTest2();
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

class BB {
	public synchronized void printName(){
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
