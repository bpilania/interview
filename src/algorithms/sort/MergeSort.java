package algorithms.sort;

import java.util.Arrays;

import utils.ConsoleReader;

public class MergeSort {

	public int[] sort(int[] array, int begin, int end){
		
		if (begin < end){ // there are at least 2 elements from begin to end
			int index = (begin + end)/2;
			array = this.sort(array, begin, index);
			array = this.sort(array, index + 1, end);
			array = this.merge(array, begin, index, end);
		} 
				
		return array;
	}
	
	/**
	 * Apply merge for two sub arrays bounded by begin, middle and end
	 * @param array
	 * @param begin
	 * @param middle
	 * @param end
	 * @return the array after this merge
	 */
	public int[] merge(int[] array, int begin, int middle, int end) {
		int[] result = Arrays.copyOf(array, array.length);
		// The initial value of i and j must make sure the max differences of 
		// the 2 sub arrays' sizes must be at most 1
		int i = begin, j = middle + 1;  
		int offset = 0;
		while(i <= middle && j <= end) {
			if(array[i] <= array[j]) {
				result[begin + offset] = array[i];
				i++; 
			} else {
				result[begin + offset] = array[j];
				j++;
			}
			offset ++;
		} 
		while(i <= middle) {
			result[begin + offset] = array[i];
			i ++;
			offset ++;
		}
		
		while(j <= end) {
			result[begin + offset] = array[j];
			j ++;
			offset ++;
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The Merge Sort Algorithm Implementation");
		System.out.println("===========================================================");
		
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the int array elements: ");
		int[] array = reader.readIntItems();

		MergeSort sorter = new MergeSort();
		array = sorter.sort(array, 0, array.length - 1);
		//array = sorter.merge(array, 0, 2, 5);
		System.out.print("The merge sort result is: ");
		for(int value : array)
			System.out.print(value + " ");
	}

}
