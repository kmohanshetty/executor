package test.program.datastructure;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insertLast(10);
		linkedList.insertLast(11);
		linkedList.insertLast(9);
		linkedList.insertLast(8);
		linkedList.insertLast(12);
		linkedList.insertLast(0);
		
		linkedList.showReverse();
		linkedList.displayList();
		System.out.println("inserting a node at position 0");
		linkedList.insertAtPos(100, 0);
		linkedList.displayList();
	}

}

class SinglyLinkedList{
	private Node first;
	private int size;
	
	public SinglyLinkedList() {
		first = null;
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int data){
		Node node = new Node(data);
		if(this.isEmpty()){
			node.setLink(null);
			this.first = node;
			size++;
		}else if(this.first != null){
			node.setLink(this.first);
			this.first = node;
			size++;
		}
	}
	
	public void insertLast(int data){
		Node node = new Node(data);
		if(this.isEmpty()){
			node.setLink(null);
			this.first = node;
			size++;
		}else if(this.first != null){
			Node lastNode = getLastNode();
			lastNode.setLink(node);
			size++;
		}
	}
	
	public void insertAtPos(int data, int pos){
		Node node = new Node(data);
		Node prev = null;
		if(this.isEmpty()){
			node.setLink(null);
			this.first = node;
			size++;
		}else {
			int i = 0;
			Node cur = first;
			while(cur != null){
				if((pos == i) && (i == 0)){
					//need to insert at this position.
					insertFirst(data);
					size++;
				}else if(pos == i){
					if(prev != null){
						node.setLink(cur);
						prev.setLink(node);
						size++;
					}
				}
				prev = cur;
				cur = cur.getLink();
				i++;
			}
		}
	}
	
	private Node getLastNode(){
		Node cur = first;
		while(cur != null){
			if(cur.getLink() == null){
				return cur;
			}
			cur = cur.getLink();
		}
		return cur;
	}
	
	public void displayList(){
		System.out.println("Displaying list elements:");
		Node cur = first;
		while(cur != null){
			cur.displayNode();
			cur = cur.getLink();
		}
	}
	
	public void showReverse(){
		System.out.println("Displaying list elements in reverse order:");
		showReverse(first);
	}
	
	private void showReverse(Node cur){
		if(cur.getLink() == null){
			cur.displayNode();
			return;
		}else{
			showReverse(cur.getLink());
			cur.displayNode();
		}
	}
}


class Node{
	private int data;
	private Node link;
	
	public Node() {
		setLink(null);
		setData(0);
	}

	public Node(int data) {
		this.setData(data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
	
	public void displayNode(){
		System.out.println("{Data: " + data + "}");
	}
}