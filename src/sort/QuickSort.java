package sort;

import utils.ConsoleReader;

/**
 * The quick sort implementation
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class QuickSort {

	public void sort(int[] array, int begin, int end){
		if (begin <= end){
			int pivot = this.partition(array, begin, end);			
			this.sort(array, begin, pivot - 1);	
			System.out.print(array[pivot] + " ");
			this.sort(array, pivot + 1, end);
		}
		
	}
	
	/**
	 * The partition is the "one time" quick sort. The result makes sure:
	 *   1) elements smaller than the pivot element are put on left side of pivot
	 *   2) elements bigger than the pivot element are put on the right side of pivot
	 * @param array The collection of elements under question
	 * @param begin the start offset
	 * @param end the end offset
	 * @return the pivot
	 */
	private int partition(int[] array, int begin, int end){
		int pivot = begin;
		int i = begin, j = end;
		while(i < j){
			if (array[j] < array[i]){
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
				i ++;
				pivot = j;
			} else if (array[j] >= array[i]){
				j --;
			}
		}

/* Please uncomment to see the quick sort process
		System.out.print("Pivot: " + array[pivot] + ", Sequence: "); 
		for (int k = 0; k< array.length; k ++){
			System.out.print(array[k] + " ");
		}
		System.out.println();
*/
		return pivot;
	}
	
	public static void main(String[] args){
		System.out.println("The Quick Sort Algorithm Implementation");
		System.out.println("===========================================================");
		ConsoleReader reader = new ConsoleReader();
		String[] values = reader.readItems();
		int[] array = new int[values.length];
		for(int i = 0; i < values.length; i++){
			array[i] = Integer.parseInt(values[i]); 
		}
		QuickSort sorter = new QuickSort();
		//int[] array = new int[]{1, 9, 2, 3, 7, 4, 35, 22};
		System.out.print("The quick sort result is: ");
		sorter.sort(array, 0, array.length - 1);
	}
}
