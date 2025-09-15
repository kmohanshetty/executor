package test.program.datastructure;

import java.util.Arrays;

public class StackDynamic {

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		
		for(int i=10;i<31;i++){
			stack.push(i);
		}
		System.out.println("popping value.");
		for(int i=0;i<11;i++){
			System.out.println(stack.pop());
		}
	}

}

class Stack{
	private int[] stck;
	private int tos;
	
	public Stack(int size) {
		stck = new int[size];
		tos = -1;
	}
	
	public void push(int item){
		if(tos == (stck.length - 1)){
			System.out.println("Stack is full");
			System.out.println("expanding buffer capacity");
			int[] newArr = new int[stck.length * 2];
			newArr = Arrays.copyOf(stck, newArr.length);
			stck = newArr;
			stck[++tos] = item;
		}else{
			stck[++tos] = item;
		}
	}
	
	public int pop(){
		if(tos < 0){
			System.out.println("Stack underflow");
			return 0;
		}else{
			return stck[tos--];
		}
	}
}