package com.interview.datastructures.string;

/**
 * Problems: 
 * 	Implement an algorithm to determine if a string has all 26 characters. 
 * 	What if you can not use additional data structures?
 * 
 * Solutions:
 *  1.Define a byte array of 26 characters, and scan the string and mark the flag to 1, 
 *  	check if all the byte is marked to 1.
 *  	time: O(N), space: O(26)
 *  
 * 
 * @author stefanie
 *
 */
public class C11_1_All26CharacterChecker {
	public boolean check_solution1(String str){
		int base = (int) 'A'; 
		boolean[] flag = new boolean[26];
		
		for(char character : str.toCharArray()){
			int index = -1;
			if(character >= 'A' && character <= 'Z'){ //if capital
				index = (int) character - base;
			} else if(character >= 'a' && character <= 'z') {
				index = (int) character - base - 32;
			} else { //if not character omit it
				continue;
			}
			flag[index] = true;
		}
	
		for(boolean each : flag){
			if(each == false){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		C11_1_All26CharacterChecker checker = new C11_1_All26CharacterChecker();
		String str1 = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(str1);
		System.out.println(checker.check_solution1(str1));
		String str2 = "AbcdefghijkLmnoPqrstuVwxyz";
		System.out.println(str2);
		System.out.println(checker.check_solution1(str2));
		String str3 = "QWERTYUIOPASDFGHJKLZXCVBNM";
		System.out.println(str3);
		System.out.println(checker.check_solution1(str3));
		String str4 = "sujpoubjwy72bbsj";
		System.out.println(str4);
		System.out.println(checker.check_solution1(str4));
		String str5 = "AbcdefghijkLmnoPqstuVwxyz";
		System.out.println(str5);
		System.out.println(checker.check_solution1(str5));
		String str6 = "Abcdefghijk67892LmnoPqrstuVwxyz12345";
		System.out.println(str6);
		System.out.println(checker.check_solution1(str6));
	}
}
