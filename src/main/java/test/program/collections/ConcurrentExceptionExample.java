package test.program.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConcurrentExceptionExample {

	public static void main(String[] args) {
		Map<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("user1", 10);
		scores.put("user2", 10);
		scores.put("user3", 10);
		scores.put("user4", 10);
		scores.put("user5", 10);
		scores.put("user6", 10);
		scores.put("user7", 10);
		scores.put("user8", 10);
		
		Iterator<String> userItr = scores.keySet().iterator();
		while(userItr.hasNext()){
			System.out.println(scores.get(userItr.next()));
			scores.put("user9", 10);
		}
		
	}

}
