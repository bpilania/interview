package algorithms.sort;

import utils.ConsoleReader;

/**
 * The quick sort implementation
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class QuickSort {

	class State {
		public int[] array;
		public int pivot;
	}
	public int[] sort(int[] array, int begin, int end){
		if (begin <= end){
			State state = this.partition(array, begin, end);
			array = state.array;
			int pivot = state.pivot;
			array = this.sort(array, begin, pivot - 1);	
			array = this.sort(array, pivot + 1, end);
		}
		return array;
	}
	
	/**
	 * The partition is the "one time" quick sort. The result makes sure:
	 *   1) elements smaller than the pivot element are put on left side of pivot
	 *   2) elements bigger than the pivot element are put on the right side of pivot
	 * @param array The collection of elements under question
	 * @param begin the start offset
	 * @param end the end offset
	 * @return The state of the quick sort, including the current array and the current pivot
	 */
	private State partition(int[] array, int begin, int end){
        int i = begin - 1;
        int value = array[end];
        
        // At any given time, the for loop divides array[begin ... end] into 4 sections:
        //     1) array[begin .. i] the elements smaller or equal than array[end]
        //     2) array[i+1 .. j-1] the elements larger than array[end]
        //     3) array[j .. end-1] unrestricted elements
        //     4) array[end] the reference value
        for(int j = begin; j < end; j++){
        	if(array[j] <= value) { 
        		i++;
        		array = this.switchElements(array, i, j); 
        	}
        }
        
        State state = new State();
        state.array = this.switchElements(array, i + 1, end); // switch array[end] to section 1)
        state.pivot = i + 1;

		return state;
	}
	
	private int[] switchElements(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		return array;
	}
	
	public static void main(String[] args){
		System.out.println("The Quick Sort Algorithm Implementation");
		System.out.println("===========================================================");
		
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the int array elements: ");
		int[] array = reader.readIntItems();
		QuickSort sorter = new QuickSort();		
		System.out.print("The quick sort result is: ");
		for(int value : sorter.sort(array, 0, array.length - 1))
			System.out.print(value + " ");
	}
}
