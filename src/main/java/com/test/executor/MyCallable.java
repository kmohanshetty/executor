/**
 * 
 */
package com.test.executor;

import java.util.concurrent.Callable;

/**
 * @author u6023985
 *
 */
public class MyCallable implements Callable<String> {
	private String myName;
	private int count;
	private final long timeSleep;
	
	public MyCallable(String name, int newcount, long newtimeSleep) {
		this.myName = name;
	    this.count = newcount;
	    this.timeSleep = newtimeSleep;
	}

	@Override
	public String call() throws Exception {
		System.out.print("count: "+count+" ");
		int sum = 0;
	    for (int i = 1; i <= this.count; i++) {
	    	sum = sum + i;
	    }
	    System.out.println(myName + " thread has sum = " + sum + 
	    		" and is going to sleep for " + timeSleep);
	    try {
			Thread.sleep(this.timeSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum+"";
	}

}
