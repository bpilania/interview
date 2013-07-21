package com.interview.algorithms.general;

import com.interview.utils.ConsoleReader;

/**
 * Created with IntelliJ IDEA.
 * User: zouzhile
 * Date: 7/21/13
 * Time: 12:54 PM
 * Write some code to find all permutations of the letters in a particular string.
 */
public class C1_7_GeneratePermutations {

    public  static void generatePermutations(String str) {
        generatePermutation("", str);
    }

    private static void generatePermutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                generatePermutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        System.out.print("Please input a string: ");
        String str = reader.readLine();
        generatePermutations(str);
    }
}
