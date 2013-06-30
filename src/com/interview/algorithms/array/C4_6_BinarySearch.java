package com.interview.algorithms.array;

import com.interview.algorithms.sort.QuickSort;
import com.interview.utils.ConsoleReader;


/**
 * Binary search implementation. The binary search works on an sorted input.
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class C4_6_BinarySearch {
	
	/**
	 * Recursive implementation
	 * @param elements the input that is a sorted integer array
	 * @param begin the 'from' boundary
	 * @param end the 'to' boundary
	 * @param target the value to search
	 * @return the offset of the target value in the input array. Return -1 if not found.
	 */
	public int searchRecursively(int[] elements, int begin, int end, int target){
		if(begin < 0 || begin > end){
			return -1;
		} else {
			int offset = (begin + end)/2;
			if (target < elements[offset]){
				return searchRecursively(elements, begin, offset - 1, target);
			} else if (target > elements[offset]){
				return searchRecursively(elements, offset + 1, end, target);
			}
			return offset;
		}
	}
	
	/**
	 * 
	 * @param elements the input that is a sorted integer array
	 * @param target the value to search
	 * @return
	 */
	public int searchByLoop(int[] elements, int target){
		int begin = 0;
		int end = elements.length - 1;
		while (begin <= end){
			int offset = (begin + end)/2;
			if(target == elements[offset]){
				return offset;
			} else if (target < elements[offset]){
				end = offset - 1;
			} else {
				begin = offset + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		System.out.println("The Binary Search Implementation");
		System.out.println("========================================================================");
		
		//Prepare sorted input
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the int array elements: ");
		int[] array = reader.readIntItems();
		QuickSort sorter = new QuickSort();
		System.out.print("The sorted input is: ");
		sorter.sort(array, 0, array.length - 1);
		System.out.println();
		
		System.out.print("Please input the target element to search: ");
		int target = reader.readInt();		
		System.out.println();
		
		C4_6_BinarySearch searcher = new C4_6_BinarySearch();
		// Recursive Search
		int offset = searcher.searchRecursively(array, 0, array.length - 1, target);
		if(offset >= 0){
			System.out.println("By recursive search, the target's offset on the sorted input is : " + offset);
		} else {
			System.out.println("By recursive search, The target doesn't exist in the input int array!");
		}
		// Search By Loop
		offset = searcher.searchByLoop(array, target);
		if(offset >= 0){
			System.out.println("By Loop search, the target's offset on the sorted input is : " + offset);
		} else {
			System.out.println("By Loop search, The target doesn't exist in the input int array!");
		}
	}
}
