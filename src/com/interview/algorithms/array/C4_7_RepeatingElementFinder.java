package com.interview.algorithms.array;

import com.interview.algorithms.sort.QuickSort;
import com.interview.utils.ConsoleReader;


/**
 * Given a sorted array, there is only one value K has multiple occurrence, find
 * the repeating element and its first occurrence. <br>
 * E.g. if the array is [1, 2, 3, 5, 5, 5, 9, 12], return 3. If there is no
 * repeating element, return -1.
 * 
 * @author zouzhile (zouzhile@gmail.com)
 * 
 */
public class C4_7_RepeatingElementFinder {

	/**
	 * 
	 * @param array
	 * @param begin
	 * @param end
	 * @return
	 */
	public int find(int[] array, int begin, int end) {
		int pivot = (begin + end) / 2;
		if(begin == end)
			return -1;
		if (array[pivot] == array[pivot + 1]) { // pivot is at beginning or middle of the repeating occurrence
			if (pivot == begin || array[pivot] != array[pivot - 1]) // find the first occurrence
				return pivot;
			else // pivot > begin && array[pivot] == array[pivot-1] -> in the middle of repeating occurrence
				return find(array, begin, pivot);
		} else { // pivot is not inside the repeating occurrences
			int offset = find(array, begin, pivot); // find left side
			if (offset >= 0)
				return offset;
			else
				return find(array, pivot + 1, end); // find right side
		}
	}

	public static void main(String[] args) {
		System.out.println("Find the first occurence of repeating element");
		System.out.println("========================================================================");

		// Prepare sorted input
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the int array elements: ");
		int[] array = reader.readIntItems();
		QuickSort sorter = new QuickSort();
		System.out.print("The sorted input is: ");
		sorter.sort(array, 0, array.length - 1);
		System.out.println();
		
		C4_7_RepeatingElementFinder finder = new C4_7_RepeatingElementFinder();
		int offset = finder.find(array, 0, array.length - 1);
		if (offset < 0)
			System.out.println("No Repeating Element Found!");
		else {
			System.out.println("The repeating element is: " + array[offset]); 
			System.out.println("The first occurrence's offset is: " + offset);
		}
	}

}
