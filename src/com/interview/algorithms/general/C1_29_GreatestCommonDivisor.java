package com.interview.algorithms.general;

import com.interview.utils.ConsoleReader;

public class C1_29_GreatestCommonDivisor {

	public int gcd(int x, int y){
		if (x < y) {
			return gcd(y, x);
		}
		if(y == 0)
			return x;
		else
			return gcd(x - y, y);
	}
	
	public static void main(String[] args) {
		System.out.println("Greatest Common Divisor");
		System.out.println("========================================================================");
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Plz input two integers : ");
		int[] inputs = reader.readIntItems();
		C1_29_GreatestCommonDivisor gcd = new C1_29_GreatestCommonDivisor();
		System.out.println("The greatest common divisor is: " + gcd.gcd(inputs[0], inputs[1]));
	}

}
