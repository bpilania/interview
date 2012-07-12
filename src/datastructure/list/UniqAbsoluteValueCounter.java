package datastructure.list;

import utils.ConsoleReader;

/**
 * Find the uniq amount of absolute values in a given sorted array
 * 
 * @author zouzhile
 *
 */
public class UniqAbsoluteValueCounter {

	public int countUniqAbsoluteValues(int [] array){
		int leftPos = 0;
		int rightPos = array.length - 1;
		int leftValue = Math.abs(array[leftPos]);
		int rightValue = Math.abs(array[rightPos]);
		int count = 0;
		if (array.length > 0){
			while (leftPos <= rightPos) {
				if(leftValue < rightValue){
					count ++;
					int countedRightValue = rightValue;
					do {
						rightPos -- ;
						rightValue = Math.abs(array[rightPos]);
					} while (countedRightValue == rightValue);
				} else if (leftValue > rightValue) {
					count ++;
					int countedLeftValue = leftValue;
					do {
						leftPos ++ ;
						leftValue = Math.abs(array[leftPos]);
					} while (leftValue == countedLeftValue);				
				} else if (leftValue == rightValue){
					count ++;
					// -4 -2 -1 0 1 1 2 3 5 5
					int currAbsValue = leftValue;
					while (leftValue == currAbsValue){
						leftPos ++;
						leftValue = Math.abs(array[leftPos]);
					}
					while (rightValue == currAbsValue){
						rightPos -- ;
						rightValue = Math.abs(array[rightPos]);
					}																									
				} 
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		ConsoleReader reader = new ConsoleReader();
		System.out.println("Count the amount of unique absolute values in the given int array");
		System.out.println("===============================================================================");
		int [] array = reader.readSortedIntItems();
		UniqAbsoluteValueCounter counter = new UniqAbsoluteValueCounter();
		int count = counter.countUniqAbsoluteValues(array);
		System.out.println("The amount of unique absolute value: " + count);
	}

}
