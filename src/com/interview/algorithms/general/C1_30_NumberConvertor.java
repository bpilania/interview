package com.interview.algorithms.general;
/**
 * Problem: Remove all the number contains 7 from the integer, and define a method to return 
 * corresponding number when giving a regular number
 * Key Idea: 
 * 	  1. When we need remove a particular number from a integer series, it could be consider
 * 		 to format the integer to base-N system. 
 * 	  2. During the format, replace particular number to allowed number by mapping.
 * @author stefaniezhao
 *
 */
public class C1_30_NumberConvertor {
	
	public static int convert(int i, int n, int k){
		int result = 0;
		int index = 1;
		while(i/n != 0 || i % n != 0){
			int j = i % n;
			if(j >= k){
				j ++;
			}
			result += j * index; 
			i = i / n;
			index = index * 10;
		}
		return result;
	}
	
	public static void main(String[] args){
		for (int i = 0; i < 100; i++){
			System.out.print(i  + " ");
		}
		System.out.println();
		for (int i = 0; i < 100; i++){
			System.out.print(convert(i, 9, 7)  + " ");
		}
		System.out.println();
		for (int i = 0; i < 100; i++){
			System.out.print(convert(i, 9, 4)  + " ");
		}
	}
}
