package com.interview.algorithms.general;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zouzhile
 * Date: 7/4/13
 * Time: 9:23 PM
 *  Write a function f(a, b) which takes two character string arguments and
 *  returns a string containing only the characters found in both strings in the order of a.
 *  Write a version which is order N-squared and one which is order N.
 */
public class C1_3_CharFinder {

    public static String f_N2(String a, String b){
        String result = "";
        for(int i = 0; i < a.length(); i++) {
            char ac = a.charAt(i);
            for(int j = 0; j < b.length(); j++) {
                char bc = b.charAt(j);
                if(ac == bc)
                    result += ac;
            }
        }
        return result;
    }

    public static String f_N(String a, String b) {
        HashMap<String, Boolean> b_map = new HashMap<String, Boolean>();
        for(int i = 0; i < b.length(); i ++) {
             b_map.put("" + b.charAt(i), true);
        }

        String result = "";
        for(int i = 0; i< a.length(); i ++) {
            if(b_map.get("" + a.charAt(i)))
                result += a.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(f_N2("abfgde", "edgfba"));
        System.out.println(f_N("abfgde", "edgfba"));
    }
}
