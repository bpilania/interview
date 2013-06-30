package com.interview.algorithms.array;

import java.util.Hashtable;

/**
 * Suppose you have an NxM matrix of positive and negative integers. 
 * Write some code that finds the sub-matrix with the maximum sum of its elements.
 */
public class C4_13_SubMatrixWithMaximumSum {

	private int maxSum = Integer.MIN_VALUE;
	private int maxSumLeftUpperPointRow = 0;
	private int maxSumLeftUpperPointColumn = 0;
	private int maxSumRows, maxSumColumns = 0;
	
	private Hashtable<String, Integer> sums = new Hashtable<String, Integer>();
	
	/**
	 * find the max sub matrix of the given array
	 * @param array
	 */
	public void findMatrixWithMaxSum(int[][] array) {
		int rows = array.length;
		int columns = array[0].length;
		this.initMatrixSums(array);
		
		// Time Complexity O(N^2 * M^2)
		for(int subMatrixRows = rows; subMatrixRows >= 1; subMatrixRows --)
			for(int subMatrixColumns = columns; subMatrixColumns >= 1; subMatrixColumns --) 
				this.findMatrixWithMaxSum(array, subMatrixRows, subMatrixColumns);//O(N*M)
		
	}
	
	/**
	 * calculate the sums of all matrix with the left uppper point be (0,0)
	 * @param array
	 */
	private void initMatrixSums(int[][] array){
		int rows = array.length;
		int columns = array[0].length;
		
		// Time complexity: O(N^2 * M^2)
		for(int rightBottomRow = 0; rightBottomRow < rows; rightBottomRow++)
			for(int rightBottomColumn = 0; rightBottomColumn< columns; rightBottomColumn++) {
				int matrixSum = 0;
				for(int i = 0; i <= rightBottomRow; i ++)
					for(int j = 0; j<= rightBottomColumn; j++)
						matrixSum += array[i][j];
				String key = rightBottomRow + "," + rightBottomColumn;
				this.sums.put(key, matrixSum);
		    }
	}
	
	/**
	 * find the max sub matrix of size (rows, columns)
	 * @param array
	 * @param rows
	 * @param columns
	 */
	private void findMatrixWithMaxSum(int[][] array, int rows, int columns) {
		int arrayRows = array.length;
		int arrayColumns = array[0].length;
		
		for(int rowLeftUpper = 0; rowLeftUpper < arrayRows; rowLeftUpper++) {
			int rowRightBottom = rowLeftUpper + rows - 1;
			if(rowRightBottom >= arrayRows)
				break;
			for(int columnLeftUpper = 0; columnLeftUpper< arrayColumns; columnLeftUpper++) {				
				int columnRightBottom = columnLeftUpper + columns - 1;
				if (columnRightBottom >= arrayColumns)
					break;
				int matrixSum = calculateMatrixSum(rowLeftUpper, columnLeftUpper,
	                                               rowRightBottom, columnRightBottom);
				System.out.println(String.format("Left Upper Point = (%s, %s), Right Bottom Point = (%s, %s), Sum = %s", rowLeftUpper, columnLeftUpper,
                        rowRightBottom, columnRightBottom, matrixSum));
				if(matrixSum > this.maxSum){
					this.maxSum = matrixSum;
					this.maxSumLeftUpperPointColumn = columnLeftUpper;
					this.maxSumLeftUpperPointRow = rowLeftUpper;
					this.maxSumRows = rows;
					this.maxSumColumns = columns;
				}
			}
		}
	}

	private int calculateMatrixSum(int rowLeftUpper, int columnLeftUpper,
			                       int rowRightBottom, int columnRightBottom){
		
		int sum = this.sums.get(rowRightBottom + "," + columnRightBottom).intValue();
		if(rowLeftUpper == 0 && columnLeftUpper == 0 && rowRightBottom >= 0 && columnRightBottom >= 0) {
		   /* Any sub matrix whose left upper point is (0,0)
		    * 1 2 % %
		    * 3 4 % %
		    * % % % %
		    * % % % %
		    */
		   return sum;
		} else if(rowLeftUpper > 0 && columnLeftUpper == 0) {
			/* Any sub matrix whose left upper point's column is 0
			 * % % % %
			 * 1 2 % %
			 * 3 4 % %
			 * % % % %
			 */
			sum -= this.sums.get((rowLeftUpper - 1) + "," + columnRightBottom).intValue();
		} else if (columnLeftUpper > 0 && rowLeftUpper == 0) {
			/* Any sub matrix whose left upper point's row is 0
			 * % 1 3 %
			 * % 2 4 %
			 * % % % %
			 * % % % %
			 */
			sum -= this.sums.get(rowRightBottom + "," + (columnLeftUpper - 1));
		} else {
			/* Any sub matrix whose left upper point is Not on the left or upper edge of the matrix
			 * % % % %
			 * % 1 2 %
			 * % 3 4 %
			 * % 5 6 %
			 */
		    sum = this.sums.get(rowRightBottom + "," + columnRightBottom).intValue() -
				  this.sums.get((rowLeftUpper - 1) + "," + columnRightBottom).intValue() - 
				  this.sums.get(rowRightBottom + "," + (columnLeftUpper - 1)).intValue() +
				  this.sums.get((rowLeftUpper - 1) + "," + (columnLeftUpper - 1)).intValue();
		}
		return sum;
	}
	
	
	public int getMaxSum() {
		return maxSum;
	}

	public int getMaxSumLeftUpperPointRow() {
		return maxSumLeftUpperPointRow;
	}

	public int getMaxSumLeftUpperPointColumn() {
		return maxSumLeftUpperPointColumn;
	}

	public int getMaxSumRows() {
		return maxSumRows;
	}

	public int getMaxSumColumns() {
		return maxSumColumns;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = {{1, 22, 3, 9}, {7, -20, 33, 17}, {95, 102, -84, 10}}; 
		
		System.out.println("The Given Matrix is Below: ");
		System.out.println("-----------------------------------");
		for(int[] row: array) {
			System.out.println("\t");
			for(int column: row)
				System.out.print(String.format("%5d", column));			
		}
		
		System.out.println("\n");
		C4_13_SubMatrixWithMaximumSum finder = new C4_13_SubMatrixWithMaximumSum();
		finder.findMatrixWithMaxSum(array);

		System.out.println();
		System.out.println("Max Sub Matrix Information");
		System.out.println("-----------------------------------");
		System.out.println(String.format("Left Upper Point = (%s, %s), Bottom Right Point = (%s, %s), Sum = %s", 
				finder.getMaxSumLeftUpperPointRow(), finder.getMaxSumLeftUpperPointColumn(),
				finder.getMaxSumLeftUpperPointRow() + finder.getMaxSumRows() - 1, 
				finder.getMaxSumLeftUpperPointColumn() + finder.getMaxSumColumns() - 1, finder.getMaxSum()));
	}

}
