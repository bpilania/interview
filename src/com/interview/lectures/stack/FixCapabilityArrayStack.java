package com.interview.lectures.stack;

public class FixCapabilityArrayStack<T> implements Stack<T>{
	
	private T[] array;
	private int N;
	
	@SuppressWarnings("unchecked")
	public FixCapabilityArrayStack(int N){
		this.N = N;
		this.array = (T[]) new Object[N];
	}

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
