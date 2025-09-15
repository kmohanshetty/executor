package test.program.datastructure;

import java.util.Arrays;

public class QueueImpl {

	public static void main(String[] args) {
		Queue2 queue = new Queue2(10);
		
		for(int i=10;i<31;i++){
			queue.insert(i);
		}
		System.out.println("queue: "+queue);
		System.out.println("peek: "+queue.peek());
		System.out.println("Removing value.");
		for(int i=0;i<21;i++){
			System.out.println(queue.remove());
		}
		
		System.out.println("peek: "+queue.peek());
	}

}

class Queue2{
	private int[] queue;
	private int rearPtr;
	private int frontPtr;
	
	public Queue2(int size) {
		queue = new int[size];
		rearPtr = -1;
	}
	
	public void insert(int item){
		if(rearPtr == (queue.length - 1)){
			System.out.println("Queue2 is full");
			System.out.println("expanding buffer capacity");
			int[] newArr = new int[queue.length * 2];
			newArr = Arrays.copyOf(queue, newArr.length);
			queue = newArr;
			queue[++rearPtr] = item;
		}else{
			queue[++rearPtr] = item;
		}
	}
	
	public int remove(){
		if(rearPtr == frontPtr){
			System.out.println("Queue2 end reached.");
			return 0;
		}else{
			return queue[frontPtr++];
		}
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("No records in queue");
			return 0;
		}else{
			return (queue != null && rearPtr >0)?queue[rearPtr]:0;
		}
	}
	
	public boolean isEmpty(){
		return queue == null?true:false;
	}
}