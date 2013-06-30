package com.interview.algorithms.general;

import java.math.BigInteger;

import com.interview.utils.ConsoleReader;


/**
 * Get the amout of ending zeros of N! without calculating N!.
 * 
 * @author stefanie
 *
 */
public class C1_28_NFactorialEndingZeros {

	/**
	 * N! = K * (10)^m = K * 2^m * 5^m
	 * The amount of ending zeros = the amount of 5.
	 * @param n
	 * @return
	 */
	public int count1(int n){
		int amount = 0;
		for(int i = 1; i <= n; i++){
			int j = i;
			while ( j % 5 == 0){
				amount ++;
				j /= 5;
			}
		}
		return amount;
	}
	
	/**
	 * the amount of ending zero = N/5 + N/(5)^2 + N/(5)^3 + ..... + N/(5)^k, where (5)^k > N
	 * 
	 * @param n
	 * @return
	 */
	public int count2(int n){
		int amount = 0;
		while (n > 0){
			amount += n/5;
			n /= 5;
		}
		return amount;
	}
	
	public static void main(String[] args) {
		System.out.println("Count ending zero of n's C1_28_NFactorialEndingZeros");
		System.out.println("========================================================================");
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Plz input an integer : ");
        int value = reader.readInt();
        BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= value; i++){
        	factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println("The factorial of " + value + " is : " + factorial);
        C1_28_NFactorialEndingZeros fac = new C1_28_NFactorialEndingZeros();
        int amount = fac.count1(value);
        System.out.println("The amount of ending zero by count1 is : " + amount);
        amount = fac.count2(value);
        System.out.println("The amount of ending zero by count2 is : " + amount);
	}

}
