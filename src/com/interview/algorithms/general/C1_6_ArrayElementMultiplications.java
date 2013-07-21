package com.interview.algorithms.general;

import com.interview.utils.ConsoleReader;

/**
 * Created_By: zouzhile
 * Date: 7/21/13
 * Time: 2:36 PM
 *
 * There is an array A of N numbers. You have to compose an array Output[N] such that Output[i] will be equal to
 * multiplication of all the elements of A[N] except A[i]. For example Output[0] will be multiplication of A[1] to
 * A[N-1] and Output[1] will be multiplication of A[0] and from A[2] to A[N-1]. Solve it without division operator
 * and in O(n).
 */
public class C1_6_ArrayElementMultiplications {

    /*
      For any A[i], Output[i] equals (the multiplications of elements before A[i]) * (the multiplications of the
      elements after A[i]). So we create two arrays:
           - leftMultiplications[i] represents A[0]*A[1]*...*A[i]
           - rightMultiplications[i] represents A[N-1]*A[N-2]*...*A[i]
      So we have Output[i] =  leftMultiplications[i - 1] * rightMultiplications[i+1]
      Special cases are Output[0] and Output[N-1]
      Totally there are 3N operations, which gives O(N).
     */
    public static int[] transform(int[] elements) {
        int[] result = new int[elements.length];
        int[] leftMultiplications = new int[elements.length];
        int[] rightMultiplications = new int[elements.length];
        // initialize left multiplications
        for(int i = 0; i < elements.length; i ++) {
            if(i == 0)
                leftMultiplications[i] = elements[i];
            else
                leftMultiplications[i] = leftMultiplications[i-1] * elements[i];
        }
        // initialize right multiplications
        for(int i = elements.length - 1; i >= 0; i --) {
            if(i == elements.length - 1)
                rightMultiplications[i] = elements[i];
            else
                rightMultiplications[i] = rightMultiplications[i + 1] * elements[i];
        }
        for(int i = 0; i < elements.length; i ++) {
            if(i == 0)
                result[i] = rightMultiplications[1];
            else if (i == elements.length - 1)
                result[i] = leftMultiplications[elements.length - 2];
            else
                result[i] = leftMultiplications[i - 1] * rightMultiplications[i + 1];
        }

        return result;
    }

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        int[] values = reader.readIntItems();
        int[] transformedValues = transform(values);
        for(int value: transformedValues)
            System.out.print(value + " ");
    }
}
