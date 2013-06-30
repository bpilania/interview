package com.interview.algorithms.general;

public class C1_31_Random7 {

	/**
	 * random function returns random number [1,5]
	 * @return
	 */
	public int rand5(){
		return (int) ((5 * Math.random()) % 4  + 1);
	}
	
	public int rand7(){
		int i;
		do
		{
		  i = 5 * (rand5() - 1) + rand5();  // i is now uniformly random between 1 and 25
		} while(i > 21);
		// i is now uniformly random between 1 and 21
		return i % 7 + 1;  // result is now uniformly random between 1 and 7
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new C1_31_Random7().rand7());
	}

}
