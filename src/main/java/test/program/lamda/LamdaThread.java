package test.program.lamda;

public class LamdaThread {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("child thread: "+Thread.currentThread());
			for(int i =0;i<20;i++) {
				System.out.println("i:"+i);
			}
		},"mkthread1").start();

		
	}

}
