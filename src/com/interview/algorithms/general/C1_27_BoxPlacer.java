package com.interview.algorithms.general;

/**
 * There are k exactly same boxes, and we have to put n exactly same items into them. 
 * Assume there is no limitation on box, and the only requirement is that each item should 
 * be put into one box. Please write out the code to print out all the possible possibilities, 
 * print error the input can not get any result. 
	Input:
		The number of items: n, and the number of boxes: k
	Output:
		All the possibilities of putting items into boxes, print error if the input is not correct.
	Sample Input
		5 2  (the first number for n, the second number for k)
	Sample Output
		0   5  (all 5 items are put into one box, and the left box is empty)	
		1   4  (one item is put into one box, and 4 items are put into another one)
		2   3  (two items are put into one box, and 3 items are put into another one)
 * @author stefanie
 *
 */
public class C1_27_BoxPlacer {

	public static void place(int[] boxes, int balls, int position) {
		if (balls <= 0) {
			for (; position < boxes.length; position++)
				boxes[position] = 0;
		}

		if (position >= boxes.length) {
			for (int box : boxes)
				System.out.print(box + "\t");
			System.out.println();
			return;
		}

		if (position == boxes.length - 1) {
			boxes[position] = balls;
			for (int box : boxes)
				System.out.print(box + "\t");
			System.out.println();
			return;
		}
		int amount = position == 0? 0:boxes[position-1];
		for (;amount <= Math.ceil(balls/2); amount++) {
			boxes[position] = amount;
			place(boxes, balls - amount, position + 1);
		}

	}

	public static void place(int k, int n) {
		int[] boxes = new int[k];
		for (int i = 0; i < boxes.length; i++)
			boxes[i] = 0;
		place(boxes, n, 0);
	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		place(3, 10);

	}

}
