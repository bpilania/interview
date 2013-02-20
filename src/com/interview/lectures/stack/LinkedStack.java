package com.interview.lectures.stack;

public class LinkedStack<T> implements Stack<T> {
	
	private Node head = null;
	private int size = 0;

	class Node{
		T node;
		Node next;
	}

	@Override
	public void push(T item) {
		Node node = this.head;
		head = new Node();
		head.node = item;
		head.next = node;
		this.size ++;
	}

	@Override
	public T pop() {
		if(this.head != null){
			T node = this.head.node;
			this.head = this.head.next;
			this.size --;
			return node;
		} else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.head != null;
	}

	@Override
	public int size() {
		return this.size;
	}

}
