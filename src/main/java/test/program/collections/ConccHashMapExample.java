package test.program.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ConccHashMapExample {
	static Map<String,AtomicLong> orders = new ConcurrentHashMap<String, AtomicLong>();
	
	static void processOrders(){
		for(String city:orders.keySet()){
//			synchronized (orders) {
				for(int i = 0;i<50;i++){
					orders.get(city).getAndIncrement();
				}
//			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		orders.put("Bombay", new AtomicLong());
		orders.put("London", new AtomicLong());
		orders.put("Beijing", new AtomicLong(0));
		orders.put("New york", new AtomicLong(0));
		List<Integer> l = new ArrayList<Integer>();
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(ConccHashMapExample::processOrders);
		service.submit(ConccHashMapExample::processOrders);
		
		service.awaitTermination(1, TimeUnit.SECONDS);
		service.shutdown();
		
		System.out.println(orders);
	}

}
