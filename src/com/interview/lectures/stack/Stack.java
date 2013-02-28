package com.interview.lectures.stack;

public interface Stack<T> {

	public void push(T item);
	
	public T pop();
	
	public T peek();
	
	public boolean isEmpty();
	
	public int size();

}
