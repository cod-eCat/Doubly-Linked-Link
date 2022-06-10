package com.kiddy.dataStructure;

public class DoublyLinkedList<T> {

	public class Node{
		
		Node previous;
		Node next;
		T val;
		
		Node(T val){
			this.val = val;
		}
		
		
		Node next(){
			return next;
		}
		
		Node previous(){
			return previous;
		}
		
	}
	
	private Node head;
	private Node tail;
	
	private int size;
	
	public DoublyLinkedList(){
		// Constructor
		size = 0;
	}
	
	public T get(int index){
		
		if(size == 0){
			System.out.println("List is Empty");
			return null;
		}
		
		if(index == 0){
			return head.val;
		}
		if(index == (size - 1)){
			return tail.val;
		}
		
		Node currentNode = head;
		for (int i = 1; i <= index ; i++) {
			currentNode = currentNode.next;
		}
		
		return currentNode.val;
		
	}
	
	public void insertAtStart(T val){
		
		if(size == 0){
			add(val);
			return;
		}
		Node newNode = new Node(val);
		head.previous = newNode;
		newNode.next = head;
		head = newNode;
		size += 1;
		
	}
	
	public void insertAtEnd(T val){
		
		if(size == 0){
			add(val);
			return;
		}
		Node newNode = new Node(val);
		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode;
		size += 1;
		
	}
	
	public void add(T val){
		
		Node newNode = new Node(val);
		if(size == 0){
			// empty list
			
			head = newNode;
			tail = newNode;
			
		}else{
			
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
			
		}
		size += 1;
		
	}
	
	public void insert(int index,T val){
		
		if(index >= size){
			System.out.println("Index is Greater than List Size");
			return;
		}
		
		if(index == 0){
			insertAtStart(val);
			return;
		}
		
		if(index == (size - 1)){
			insertAtEnd(val);
			return;
		}
		
		Node newNode = new Node(val);
		Node currentNode = head;
		for(int i = 1; i <= index; i++){
			currentNode = currentNode.next;
		}
		
		Node preNode = currentNode.previous;
		preNode.next = newNode;
		currentNode.previous = newNode;
		newNode.previous = preNode;
		newNode.next = currentNode;
		size += 1;
		
	}
	
	public void remove(int index){
		
		if(index >= size){
			System.out.println("Index is greater than List Size");
			return;
		}
		
		if(index == 0){
			removeAtStart();
			return;
		}
		if(index == (size -1)){
			removeAtEnd(); 
			return;
		}
		
		int middle = (size + 1) / 2;
		Node currentNode = null;
		
		if(index <= middle){
			
			currentNode = head;
			for(int i = 1; i <= index; i++ ){
				
				currentNode = currentNode.next;
				
			}
			
		}else if(index >= middle){
			
			currentNode = tail;
			for (int i = (size-2); i >= index; i--){
				
				currentNode = tail.previous;
				
			}
			
		}
		
		currentNode.previous.next = currentNode.next;
		currentNode.next.previous = currentNode.previous;
		size -= 1;
		
	}
	
	public void removeAtStart(){
		
		if(size == 1){
			
			head = null;
			tail = null;
			size -= 1;
			return;
		}
		
		head = head.next;
		head.previous = null;
		size -= 1;
		
	}
	
	public void removeAtEnd(){
		
		if(size == 1){
			head = null;
			tail = null;
			size -= 1;
			return;
		}
		
		tail = tail.previous;
		tail.next = null;
		size -= 1;
		
	}
	
	public boolean search(T val){
		
		Node currentNode = head;
		while(currentNode!=null){
			if(val == currentNode.val){
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
		
	}
	
	public int size(){
		return size;
	}
	
	public void displayList(){
		
		Node currentNode = head;
		System.out.println();
		while(currentNode!=null){
			
			System.out.print(" " + currentNode.val + ", ");
			
			currentNode = currentNode.next;
			
		}
		System.out.println();
		
	}
	
	public void displayListReverse(){
		
		Node currentNode = tail;
		System.out.println();
		while(currentNode!=null){

			System.out.print(" " + currentNode.val + ", ");
			
			currentNode = currentNode.previous;
			
		}
		System.out.println();
		
	}
	
	@Override
	public String toString() {
		
		String result = "";
		
		Node currentNode = head;
		while(currentNode != null){
			result += " " + currentNode.val + ",";
			currentNode = currentNode.next;
		}
		
		return result;
		
	}
	
	
}
