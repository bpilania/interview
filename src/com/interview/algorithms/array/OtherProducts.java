package com.interview.algorithms.array;

import com.interview.utils.ConsoleReader;

/**
 * Define a function that takes an array of integer numbers and returns an array
 * of numbers of the same length. Each element of the output array out[i] should
 * be equal to the product of all of the elements of the input array except for
 * in[i]. Example: input {1,2,3,4} output {24,12,8,6}
 * 
 * @author stefanie
 * 
 */
public class OtherProducts {
	public static void main(String args[]) throws Exception {
		System.out.println("The Binary Search Implementation");
		System.out
				.println("========================================================================");

		// Prepare sorted input
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the int array elements: ");
		int[] array = reader.readIntItems();
		OtherProducts.calculateProducts(array);
	}

	public static void calculateProducts(int[] numbers) {

		int zeroCount = 0;
		int total = 1;
		for (Integer num : numbers) {
			if (num != 0) {
				total = total * num;
			} else {
				zeroCount++;
			}
		}
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		boolean notFirst = false;
		if (zeroCount > 1) {
			for (int i = 0; i < numbers.length; i++) {
				if (notFirst) {
					builder.append(",");
				} else {
					notFirst = true;
				}
				builder.append("0");
			}
		} else if (zeroCount == 1) {
			for (int number : numbers) {
				int product = 0;
				if (number == 0) {
					product = total;
				}
				if (notFirst) {
					builder.append(",");
				} else {
					notFirst = true;
				}
				builder.append(product);
			}
		} else {
			for (int num : numbers) {
				int product = total / num;
				if (notFirst) {
					builder.append(",");
				} else {
					notFirst = true;
				}
				builder.append(product);
			}
		}
		builder.append("}");
		System.out.println(builder.toString());
	}
}
