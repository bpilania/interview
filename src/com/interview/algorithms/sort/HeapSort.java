package com.interview.algorithms.sort;

import com.interview.utils.ConsoleReader;

public class HeapSort<T extends Comparable<T>> {

	/**
	 * The heapify process makes sure the largest element is on the top of the subtree whose root node is 
	 * at the "index" position in the heap.
	 * If heapifyForSorting, the heapify's time complexity is O(logN); otherwise, the complexity is O(1)
	 * @param data
	 * @param index
	 * @param heapSize indicating the size of the heap on top of the data array.
	 * @return 
	 */
	public T[] heapify(T[] data, int index, int heapSize, boolean heapifyForSorting) {
		int lastIndex = heapSize - 1;

		int largest = index;
		int leftChildIndex = index == 0 ? 1 : 2 * index + 1;
		int rightChildIndex = index == 0 ? 2 : 2 * (index + 1);
		
		if(leftChildIndex <= lastIndex && data[leftChildIndex].compareTo(data[largest]) > 0)
			largest = leftChildIndex;
		if(rightChildIndex <= lastIndex && data[rightChildIndex].compareTo(data[largest]) > 0)
			largest = rightChildIndex;
		if(largest != index) {
			data = this.switchElements(data, index, largest);
			if(heapifyForSorting)
				data = this.heapify(data, largest, heapSize, heapifyForSorting);
		}
		return data;
	}
	
	/**
	 * The max heap building process is a bottom up heapify process starting from the last non-leaf node.
	 * @param data
	 */
	public void buildMaxHeap(T[] data){
		int lastNonLeafNodeIndex = (data.length - 1)/2; 
		for(int i = lastNonLeafNodeIndex; i >= 0; i --) 
			data = this.heapify(data, i, data.length, false);
	}
	
	/**
	 * The sort process first build a max heap with the given array. After this, it switches the largest element (at position 0)
	 * with the last element. Then the heap is "shrunk" to the rest length -1 elements excluding the last(largest) element. 
	 * The shrunk heap is then heapified. The previous procedure is repeated. Finally there array is sorted in ascending order. 
	 * @param data
	 * @return The sorted array
	 */
	public T[] sort(T[] data){
        this.buildMaxHeap(data);
        int count = 0;
        
        for(int i = data.length - 1; i >= 1; i --) {
        	this.switchElements(data, 0, data.length - 1 - count);
        	count ++;
        	data = this.heapify(data, 0, data.length - count, true);
        }
        return data;
	}

	private T[] switchElements(T[] data, int i, int j){
		T tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
		return data;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The Heap Sort Algorithm Implementation");
		System.out.println("===========================================================");
		
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the int array elements: ");
		int[] array = reader.readIntItems();
		Integer[] data = new Integer[array.length];
		for(int i = 0; i < array.length; i ++) 
			data[i] = array[i];
		
		HeapSort<Integer> sorter = new HeapSort<Integer>();
		System.out.print("The heap sort result is: ");
		for(Integer value : sorter.sort(data))
	        System.out.print(value + " ");
	}

}
