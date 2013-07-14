package com.interview.algorithms.array;

import com.interview.utils.ConsoleWriter;

/**
 * Problem:
 * 	Write code to reverse a array. 
 * 	
 * Solution
 * @author stefanie
 *
 */
public class C4_16_ArrayReverser {
	public void reverse(int[] array){
		int start = 0;
		int end = array.length - 1;
		while(start < end){
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start ++;
			end --;
		}
	}
	
	public static void main(String[] args){
		C4_16_ArrayReverser reverser = new C4_16_ArrayReverser();
		int[] arr1 = {1,2,3,4,5,6};
		ConsoleWriter.printIntArray(arr1);
		reverser.reverse(arr1);
		ConsoleWriter.printIntArray(arr1);
		
		int[] arr2 = {};
		ConsoleWriter.printIntArray(arr2);
		reverser.reverse(arr2);
		ConsoleWriter.printIntArray(arr2);
		
		int[] arr3 = {1,2,3,4,5,6,7};
		ConsoleWriter.printIntArray(arr3);
		reverser.reverse(arr3);
		ConsoleWriter.printIntArray(arr3);
	}
}
