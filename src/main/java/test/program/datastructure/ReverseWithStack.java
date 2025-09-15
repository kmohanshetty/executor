package test.program.datastructure;

class MyStack {
	private int top = 0;
	int [] stk = null;
	
	public MyStack(int size) {
		stk = new int[size];
		top = -1;
	}
	
	void push(int ele) {
		++top;
		if(top >= stk.length) {
			System.out.println("stack overflow");
			return;
		}
		stk[top] = ele;
	}
	
	int pop() {
		top--;
		if(top < 0) {
			System.out.println("stack underflow");
			return 0;
		}
		return stk[top];
	}
}

public class ReverseWithStack {

	public static void main(String[] args) {
		MyStack stack = new MyStack(10);
		
		for(int i = 0;i<11 ;i++) {
			stack.push(i);
		}
		for(int i = 0;i<11 ;i++) {
			System.out.println(stack.pop());
		}

	}

}
