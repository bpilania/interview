package com.interview.algorithms.array;

/**
 * Problem:
 * 		1. define a operator "swap", which delete one element in an array and put the element at
 * the end of the array.
 * 		2. how to use this "swap" to sort an array, with min operator.
 * 
 * Solution
 * 		1. for min "swap" operation, loop the array every time select the min value and swap
 * it to the end of the array.
 * 		algorithm: O(N^2), swap(N)
 * 		2. to optimize, swap all the inverse number from min to max
 * 		find all min and check if inverse O(N^2), swap(N)
 * @author stefaniezhao
 *
 */

public class SortBySwap {
	public static void swap(int[] array, int index){
		int node = array[index];
		for(int i = index; i < array.length - 1; i++){
			array[i] = array[i + 1];
		}
		array[array.length - 1] = node;
	}
	
	public static int sortBySelect(int[] array){
		int num = 0;
		for(int i = 0; i < array.length; i++){
			int min = 0;
			for(int j = 0; j < array.length - i; j ++){
				if(array[j] < array[min]){
					min = j;
				}
			}
			swap(array, min);
			num ++;
		}
		return num;
	}
	
	public static int findMinInverseNumber(int[] array){
		int min = Integer.MAX_VALUE;
		int minInverseNumber = Integer.MAX_VALUE;
		for(int i = array.length - 1; i >= 0; i--){
			if(array[i] > min){
				//is a inverse number;
				if(array[i] < minInverseNumber){
					//update the min inverse number
					minInverseNumber = array[i];
				}
			} else {
				min = array[i];
			}
		}
		return minInverseNumber;
	}
	
	public static int sortBySelectInverseNumber(int[] array){
		int num = 0;
		int lastMin = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++){
			int min = 0;
			for(int j = 1; j < array.length; j ++){
				if(array[j] < array[min] && (array[j] > lastMin)){
					min = j;
				}
			}
			lastMin = array[min];
			//check if min is an inverse number
			if(isInverseNumber(array, min)){
				swap(array, min);
				num ++;
			}
			
		}
		return num;
	}
	
	public static boolean isInverseNumber(int[] array, int index){
		for(int j = index + 1; j < array.length; j ++){
			if(array[j] < array[index]){
				return true;
			}
		}
		return false;
	}
	
	public static void print(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args){
		int[] testArray = {5,3,1,2,4};
		print(testArray);
		
//		int num = sortBySelectInverseNumber(testArray);
//		print(testArray);
//		System.out.println("swap num : " + num);
		
		int minInverseNumber = findMinInverseNumber(testArray);
		System.out.println("minInverseNumber : " + minInverseNumber);
		
		System.out.println();
		testArray = new int[]{5,4,3,2,1};
		print(testArray);	
		minInverseNumber = findMinInverseNumber(testArray);
		System.out.println("minInverseNumber : " + minInverseNumber);
		
		System.out.println();
		testArray = new int[]{1,2,3,4,5};
		print(testArray);	
		minInverseNumber = findMinInverseNumber(testArray);
		System.out.println("minInverseNumber : " + minInverseNumber);
		
		System.out.println();
		testArray = new int[]{1,6,2,4,-1,1,3};
		print(testArray);	
		minInverseNumber = findMinInverseNumber(testArray);
		System.out.println("minInverseNumber : " + minInverseNumber);
		
		System.out.println();
		testArray = new int[]{5,3,1,2, 2,4};
		print(testArray);	
		minInverseNumber = findMinInverseNumber(testArray);
		System.out.println("minInverseNumber : " + minInverseNumber);
	}
}
