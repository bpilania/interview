package com.interview.datastructures.stack;

/**
 * Design a stack. We want to push, pop, and also, retrieve the minimum element in constant time.
 * @author zouzhile
 *
 */
public class SimpleStack {
	
	private Node head;
	private Node minHead;
	
	class Node {
		int value;
		Node next, previous;
		
		protected Node clone() { 
			Node clone = new Node();
			clone.value = this.value;
			clone.next = this.next;
			clone.previous = this.previous;
			return clone;
		}
	}
	
	public SimpleStack(){
		
	}
	
	public void push(int value){
		Node node = new Node();
		node.value = value;
		
		if(head == null) {
			head = node;
			Node clone = node.clone();
			minHead = clone;			
		} else {
			Node clone = null;
			if(node.value < minHead.value)  
				clone = node.clone();
			else
				clone = minHead.clone();
			// data stack
			node.next = head;
			head = node;
			// min stack
			clone.next = minHead;
			minHead = clone;
		}
	}
	
	public int pop(){
		int result = Integer.MIN_VALUE;
		
		if(head != null) {
			// min stack
			Node temp = minHead;
			minHead = minHead.next;
			temp.next = null;
			
			// data stack
			temp = head;
			result = head.value;
			head = head.next;
			temp.next = null;		
		}
		
		return result;
	}
	
	public int getMinValue(){
		int min = Integer.MIN_VALUE;
		if(minHead != null)
			min = minHead.value;
		return min;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
