package test.program.collections;

import java.util.Arrays;

public class CustomArrayListTest {

	public static void main(String[] args) {
		CustomArrayList<Integer> list = new CustomArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(10);
		list.add(30);
		list.add(500);
		list.add(100);
		list.add(101);
		
		for(int i=0;i<list.getSize();i++){
			System.out.println(list.get(i));
		}
	}

}

class CustomArrayList<E>{
	private int size = 0;
	private Object[] elements;
	private static int DEFAULT_SIZE = 10;
	
	public CustomArrayList() {
		elements = new Object[DEFAULT_SIZE];
	}
	
	public void add(E e){
		if(size == elements.length){
			ensureCapacity();
		}
		elements[size++] = e;
	}

	private void ensureCapacity() {
		int newLength = elements.length * 2;
		elements = Arrays.copyOf(elements, newLength);
	}
	
	@SuppressWarnings("unchecked")
	public E get(int i){
		if(i >= size && i < 0){
			throw new IndexOutOfBoundsException("Index: "+i+" caused this exception");
		}
		return ((E)elements[i]);
	}
	
	public int getSize(){
		return size;
	}
	
}