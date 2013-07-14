package com.interview.datastructures.string;

/**
 * Problem:
 * 	Implement an algorithm to determine if a string has all unique characters. 
 * 	What if you can not use additional data structures?
 * 
 * Solutions:
 *  1. assume char set is ASCII, use a 256 char array as a flag to check if there is duplicate characters
 *  	time: O(N), space: O(256)
 *  2. if not allow to use extra space, could check every character in the string if there is duplicate char.
 *  	time: O(N^2), space: 1
 *     if could destroy the string, could sort then check if have duplicate char
 *     	time: O(NlogN), space: 1
 * @author stefanie
 *
 */
public class C11_2_UniqueCharacterChecker {
	
	public boolean check_solution1(String str){
		boolean[] flag = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int ch = str.charAt(i);
			if(flag[ch]) 
				return false;
			else 
				flag[ch] = true;
		}
		return true;
	}
	
	public static void main(String[] args){
		C11_2_UniqueCharacterChecker checker = new C11_2_UniqueCharacterChecker();
		String str1 = "stefaniezhao";
		System.out.println(str1);
		System.out.println(checker.check_solution1(str1));
		String str2 = "STEFANIezhao";
		System.out.println(str2);
		System.out.println(checker.check_solution1(str2));
		String str3 = "1234567890STEFANIezhao";
		System.out.println(str3);
		System.out.println(checker.check_solution1(str3));
	}
}
