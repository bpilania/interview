package com.interview.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	public String readLine(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {			
			input = reader.readLine().trim();
		} catch (IOException e) {			
			e.printStackTrace();
			System.exit(1);
		}
		return input;
	}
	
	/**
	 * Input elements are separated by white space
	 * @return The string array as parsed from console input
	 */
	public String[] readStringItems(){
		String input = readLine();
		String[] values = input.split("\\s+");
		return values;
	}
	
	public int[] readSortedIntItems(){
		int[] array = this.readIntItems();
		for(int i = 0; i < array.length -1; i ++)
			for(int j = i + 1; j < array.length; j ++){
				if(array[i] > array[j]){
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		System.out.print("The sorted input array is : ");
		for(int a : array){
			System.out.print(a + " ");
		}
		System.out.println();
		return array;
	}
	/**
	 * Input elements are separated by white space
	 * @return The integer array as parsed from console input
	 */
	public int[] readIntItems(){
		String[] values = readStringItems();
		int[] array = new int[values.length];
		for(int i = 0; i < values.length; i++){
			array[i] = Integer.parseInt(values[i]); 
		}
		return array;
	}
	
	public int readInt(){
		String value = this.readLine();
		return Integer.parseInt(value);
	}
	
}
