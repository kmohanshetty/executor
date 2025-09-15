package com.test.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorWithCallableClient {

	public static void main(String[] args) {
		ExecutorService _executor = Executors.newCachedThreadPool();
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		MyCallable myCallable[] = { new MyCallable("TaskOne", 2, 100), 
									new MyCallable("TaskTwo", 4, 100),
									new MyCallable("TaskThree", 5, 100) };
		
		for(int i=0;i<3;i++){
			Future<String> result = _executor.submit(myCallable[i]);
			list.add(result);
		}
		
		for(Future<String> ftr:list){
			try {
				System.out.println(new Date()+"::"+ftr.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//shut down the executor service now
        _executor.shutdown();
	}

}
