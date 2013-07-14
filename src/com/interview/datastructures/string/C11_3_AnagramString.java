package com.interview.datastructures.string;

/**
 * Problem:
 * 	Write a method to decide if two strings are anagrams or not.
 * 
 * Solution:
 * 	1. sort the two strings, and check if equal
 * 		time: O(NlogN), space: O(1)
 *  2. check contained character is same or not
 *  	time: O(N^2), space: O(1)
 * @author stefanie
 *
 */
public class C11_3_AnagramString {
	public boolean check_solution1(String str1, String str2){
		str1 = sortStr(str1);
		str2 = sortStr(str2);
		return str1.equals(str2);
	}
	
	public boolean check_solution2(String str1, String str2){
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		for(char ch : arr1){
			int num1 = 0;
			for(char ch1 : arr1){
				if(ch1 == ch) num1++;
			}
			int num2 = 0;
			for(char ch2 : arr2){
				if(ch2 == ch) num2++;
			}
			if(num1 != num2) return false;
		}
		return true;
	}
	
	public String sortStr(String str){
		char[] array = str.toCharArray();
		//quick sort
		quicksort(array, 0, array.length-1);
		return String.valueOf(array);
	}
	
	public void quicksort(char[] array, int start, int end){
		if(end <= start) return;
		int key = partition(array, start, end);
		quicksort(array, start, key - 1);
		quicksort(array, key + 1, end);
	}
	
	public int partition(char[] array, int start, int end){
		char key = array[start];
		int i = start + 1;
		int j = end;
		while(true){
			while(array[i] <= key && i < end) i++;
			while(array[j] > key && j > start) j--;
			if(i >= j) break;
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		array[start] = array[j];
		array[j] = key;
		return j;
	}
	
	public static void main(String[] args){
		C11_3_AnagramString checker = new C11_3_AnagramString();
		String str1 = "abcde";
		String str2 = "cdbae";
		System.out.println(checker.check_solution1(str1, str2));
		System.out.println(checker.check_solution2(str1, str2));
		
		String str3 = "abcdeabsyy";
		String str4 = "bcydybaeas";
		System.out.println(checker.check_solution1(str3, str4));
		System.out.println(checker.check_solution2(str3, str4));
		
		String str5 = "abcdeabsey";
		String str6 = "bcydybaeas";
		System.out.println(checker.check_solution1(str5, str6));
		System.out.println(checker.check_solution2(str5, str6));
	}
}
