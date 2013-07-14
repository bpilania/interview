package com.interview.utils;

public class ConsoleWriter {
	public static void printIntArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
