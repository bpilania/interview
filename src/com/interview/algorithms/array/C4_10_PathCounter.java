package com.interview.algorithms.array;

import com.interview.utils.ConsoleReader;

/**
 * Given an m*n grid, how many paths are there from the left bottom corner to
 * the up right corner.
 * 
 * Here gives three solution: 
 *   1. inverseCalculatePath: inverse calculate the path using the following formula
 *   	 when m > 0 and n > 0: f(m, n) = f(m - 1, n) + f(m, n - 1) 
 *   	 when m = 0 and n > 0: f(m, n) = f(m, n - 1) 
 *   	 when m > 0 and n = 0: f(m, n) = f(m - 1, n) 
 *   	 when m = 0 and n = 0: f(m, n) = 1
 *      since we haven't store the path in the mid-step, it will calculate the same f(m,n) in different inverse process.
 *   2. inverseCalculatePathOptimized: use a long[][] to store the path num to prevent calculate them more then one time.
 *   	it will cost a long[m+1][n+1] array.
 *   	but it is much faster then the solution 1 when m and n are larger then 10. 
 *   3. loopCalculatePath: since we have already use a long[][] array to store the path num, we can use loop instead of inverse to save memory.
 *   		f(0, 0) = 1;
 * 			f(0, 0..n) = 1;
 * 			f(0..n, 0) = 1;
 * 			f(m, n) = f(m - 1, n) + f(m, n - 1)
 * 		return f(m, n)
 * 
 * @author zhaochenting (zhaochenting@gmail.com)
 * 
 */
public class C4_10_PathCounter {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The Path Counter Implementation");
		System.out.println("========================================================================");
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input two number as the size of the grid (MAX is 33*33): ");
		int[] array = null;
		try{
			array = reader.readIntItems();
		}catch (RuntimeException e){
			System.out.println("INPUT ERROR! Please input NUMBER for the size of the grid as M N");
			return;
		}
		if(array == null || array.length < 2){
			System.out.println("INPUT ERROR! Please input TWO number as the size of the grid as M N");
			return;
		}
		Integer m = array[0];
		Integer n = array[1];
		if(m > 33 || n > 33){
			System.out.println("INPUT ERROR! MAX Number of the size is 33 * 33");
			return;
		}
		C4_10_PathCounter counter = new C4_10_PathCounter();
		long path = counter.inverseCalculatePathOptimized(m, n);
		System.out.println("The path from the left bottom corner to the up right corner in a " + m + "*" + n + " grid is: " + path);
	}
	
	
	/**
	 * inverse calculate the path using the following formula
	 * 		when m > 0 and n > 0: f(m, n) = f(m - 1, n) + f(m, n - 1)
	 * 		when m = 0 and n > 0: f(m, n) = f(m, n - 1)
	 * 		when m > 0 and n = 0: f(m, n) = f(m - 1, n)		
	 *      when m = 0 and n = 0: f(m, n) = 1		
	 * @param m: the length of the grid
	 * @param n: the weight of the grid
	 * @return the path from the left bottom corner to the up right corner in grid m*n
	 */
	public long inverseCalculatePath(int m, int n) {
		if (m > 0 && n > 0) {
			return inverseCalculatePath(m - 1, n)
					+ inverseCalculatePath(m, n - 1);
		} else if (m == 0 & n > 0) {
			return inverseCalculatePath(m, n - 1);
		} else if (n == 0 & m > 0) {
			return inverseCalculatePath(m - 1, n);
		}
		return 1;
	}
	
	
	/**
	 * Optimize: store the calculate path into an array to prevent calculate the path has been calculated before	
	 * @param m: the length of the grid
	 * @param n: the weight of the grid
	 * @return the path from the left bottom corner to the up right corner in grid m*n
	 */
	public long inverseCalculatePathOptimized(int m, int n) {
		long pathArray[][] = new long[m + 1][n + 1];
		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				pathArray[i][j] = 0;
			}
		}
		return inverseCalculatePathOptimized(m, n, pathArray);
	}
	
	/**
	 * inverse calculate the path using the following formula
	 * 		when m > 0 and n > 0: f(m, n) = f(m - 1, n) + f(m, n - 1)
	 * 		when m = 0 and n > 0: f(m, n) = f(m, n - 1)
	 * 		when m > 0 and n = 0: f(m, n) = f(m - 1, n)		
	 *      when m = 0 and n = 0: f(m, n) = 1
	 * with a optimize: store the calculate path into an array to prevent calculate the path has been calculated before	
	 * @param m: the length of the grid
	 * @param n: the weight of the grid
	 * @param pathArray: the array to store the paths have been calculated
	 * @return the path from the left bottom corner to the up right corner in grid m*n
	 */
	public long inverseCalculatePathOptimized(int m, int n, long[][] pathArray) {
		//search in the path array firstly, in order to prevent calculate the path has been calculated before
		if(pathArray[m][n] != 0){
			return pathArray[m][n];
		}
		long path = 1;
		if (m > 0 && n > 0) {
			path = inverseCalculatePathOptimized(m - 1, n)
					+ inverseCalculatePathOptimized(m, n - 1);
		} else if (m == 0 & n > 0) {
			path = inverseCalculatePathOptimized(m, n - 1);
		} else if (n == 0 & m > 0) {
			path = inverseCalculatePathOptimized(m - 1, n);
		}
		pathArray[m][n] = path;
		return path;
	}
	
	/**
	 * with a optimize: store the calculate path into an array to prevent calculate the path has been calculated before	
	 * using loop instead of inverse to calculate the path
	 * 		f(0, 0) = 1;
	 * 		f(0, 0..n) = 1;
	 * 		f(0..n, 0) = 1;
	 * 		f(m, n) = f(m - 1, n) + f(m, n - 1)
	 * @param m: the length of the grid
	 * @param n: the weight of the grid
	 * @return the path from the left bottom corner to the up right corner in grid m*n
	 */
	public long loopCalculatePath(int m, int n) {
		//search in the path array firstly, in order to prevent calculate the path has been calculated before
		long pathArray[][] = new long[m + 1][n + 1];
		pathArray[0][0] = 1;
		for(int i = 1; i <= m; i ++){
			pathArray[i][0] = 1;
		}
		for(int j = 1; j <= n; j ++){
			pathArray[0][j] = 1;
		}
		for(int i = 1; i <= m; i ++){
			for(int j = 1; j <= n; j ++){
				pathArray[i][j] = pathArray[i - 1][j] + pathArray[i][j - 1];
				if(pathArray[i][j] < 0){
					System.out.println("m: " + i + " n: " + j + " path: " + pathArray[i][j]);
					return -1;
				}
			}
		}
		return pathArray[m][n];
	}
	
	
}
