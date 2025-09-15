package test.program.collections;

import java.util.EnumMap;
import java.util.Iterator;

public class EnumMapExample {
	
	public enum STATE{
        NEW, RUNNING, WAITING, FINISHED;
    }


	public static void main(String[] args) {
		EnumMap<STATE, Integer> scores = new EnumMap<STATE, Integer>(STATE.class);
		scores.put(STATE.NEW, 10);
		scores.put(STATE.FINISHED, 10);
		scores.put(STATE.RUNNING, 10);
		scores.put(STATE.WAITING, 10);
		scores.put(STATE.FINISHED, 20);
		
		Iterator<STATE> iterator = scores.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(scores.get(iterator.next()));
			scores.put(STATE.WAITING, 20);
		}
	}

}
