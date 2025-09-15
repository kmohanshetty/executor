package test.program.thread;

public class StopAThread {
	public static void main(String [] args){
		Thread t = new Thread(new IndexProcessor());
		t.start();
		
		System.out.println("Miaw before interrupt");
		t.interrupt();
//		t.stop();
		System.out.println("Miaw after interrupt");
	}
}

class IndexProcessor implements Runnable {

    @Override
    public void run() {
        boolean run = true;
        while (run) {
            try {
                System.out.println("Sleeping...");
                Thread.sleep((long) 15000);

                System.out.println("Processing");
            } catch (InterruptedException e) {
            	System.err.printf("Exception", e);
                run = false;
            }
        }

    }
}