package test.program;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyJunitTestCase {

	@Test
	public void test() {
		//fail("Not yet implemented");
		TestThread thread = new TestThread();
		Thread t = new Thread(thread);
		t.start();
		
		assertTrue(1 == 1);
	}

}
class TestThread implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("i:"+i);
		}
		
	}
	
}