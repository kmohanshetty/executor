package test.program.collections;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) throws InterruptedException {
		Map<Order, Integer> orders = new WeakHashMap<Order, Integer>();
		orders.put(new Order(1,"adssfasd"), 100);//weak reference
		orders.put(new Order(2,"adssfasd"), 200);//weak reference
		Order order = new Order(3,"adssfasd");//strong reference
		orders.put(order, 300);
		
		System.out.println(orders.size());
//		Thread.sleep(10000);
		System.gc();
		System.out.println(orders.size());
	}
}

class Order{
	int orderId;
	String details;
	
	public Order(int orderId,String details) {
		this.orderId = orderId;
		this.details = details;
	}
}
