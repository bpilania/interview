package com.interview.java.basics;

public class InstanceInitializer {

	private int a = 10; // instance variable initializer
	//private int b = c;  <- This causes compiling error
	private int b = initB(); // b is set to 0, since c is not initialized yet.
	private int c;
	
	{
		c = 20; // this code block is called instance initializer
	}
	
	private int initB(){
		return 100 * c;
	}
	
	public int getA() {
		return a;
	}

	public int getB(){
		return this.b;
	}
	
	public int getC(){
		return this.c;
	}
	
	public static void main(String[] args) {
		InstanceInitializer init = new InstanceInitializer();
		System.out.println("B is initialized as: " + init.getB());
		System.out.println("C is initialized as: " + init.getC());
	}

}
