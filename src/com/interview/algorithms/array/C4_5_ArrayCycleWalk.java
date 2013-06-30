package com.interview.algorithms.array;

import java.util.ArrayList;
import java.util.List;

import com.interview.utils.ConsoleReader;


/**
 * This is to walk an array in a cycle manner <br>
 * E.g. Given the following array, "a" should be printed<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a<br>
 * E.g. Given the following array, "a b d c" should be printed<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a&nbsp;&nbsp; b<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c&nbsp;&nbsp; d<br>
 * E.g. Given the following array, "a b c f i h g d e" should be printed<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a&nbsp;&nbsp; b&nbsp;&nbsp; c <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d&nbsp;&nbsp; e&nbsp;&nbsp; f <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;g&nbsp;&nbsp; h&nbsp;&nbsp; i <br>
 * E.g. Given the following array, "a b c d h l k j i e f g" should be printed
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a&nbsp;&nbsp; b&nbsp;&nbsp; c&nbsp;&nbsp;
 * d<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e&nbsp;&nbsp; f&nbsp;&nbsp; g&nbsp;&nbsp;
 * h<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i&nbsp;&nbsp; j&nbsp;&nbsp; k&nbsp;&nbsp;
 * l<br>
 * E.g. Given the following array, "a b c d h l p o n m i e f g k j" should be
 * printed<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a&nbsp;&nbsp; b&nbsp;&nbsp; c&nbsp;&nbsp;
 * d <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e&nbsp;&nbsp; f&nbsp;&nbsp; g&nbsp;&nbsp;
 * h <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;i&nbsp;&nbsp; j&nbsp;&nbsp; k&nbsp;&nbsp;
 * l <br>
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;m&nbsp;&nbsp; n&nbsp;&nbsp; o&nbsp;&nbsp;
 * p <br>
 * 
 * @author zouzhile
 * 
 */
public class C4_5_ArrayCycleWalk {

	public void walk(String[][] array) {
		boolean stop = false;
		int cycleCount = 0;
		int rowCount = array.length;
		int columnCount = array[0].length;
		System.out.println("The cycle walk of the array is below");
		System.out.println("-----------------------------------------------");
		while (!stop) {
			int columnFrom = cycleCount;
			int columnStop = columnCount - cycleCount;
			int rowFrom = cycleCount;
			int rowStop = rowCount - cycleCount;
			if (rowCount <=2  || columnCount <= 2 || columnFrom == columnCount / 2 || rowFrom == rowCount / 2) {
				// rowCount <=2  || columnCount <= 2 condition means only one cycle is enough for the given array
				// columnFrom == columnCount / 2 || rowFrom == rowCount / 2 condition means the last cycle 
				// for the given multi-cycle array 
				stop = true;
			}
			for (int i = columnFrom; i < columnStop; i++)
				System.out.print(array[rowFrom][i] + " ");
			for (int i = rowFrom + 1; i < rowStop; i++)
				System.out.print(array[i][columnStop - 1] + " ");
			for (int i = columnStop - 2; i >= columnFrom && rowCount != 1; i--) // no back printing for single line array
				System.out.print(array[rowStop - 1][i] + " ");
			for (int i = rowStop - 2; i > rowFrom && columnCount != 1; i--) // no back printing for single column array
				System.out.print(array[i][columnFrom] + " ");
			cycleCount++;
		}
	}

	public static void main(String[] args) {
		System.out.println("Array Cycle Walk");
		System.out
				.println("========================================================================");
		System.out
				.println("Please input the array line by line below, row element seperated by a white space, finish by typing 'end'");
		ConsoleReader reader = new ConsoleReader();
		String[] row = null;
		List<String[]> rows = new ArrayList<String[]>();
		do {
			row = reader.readStringItems();
			if (row[0].equals("end")) {
				break;
			}
			rows.add(row);
		} while (!row[0].equals("end"));
		int rowsCount = rows.size();
		int columnCount = rows.get(0).length;
		String[][] array = new String[rowsCount][columnCount];
		for (int i = 0; i < rowsCount; i++) {// set the given row's data
			row = rows.get(i);
			for (int j = 0; j < columnCount; j++) {
				array[i][j] = row[j];
			}
		}
		C4_5_ArrayCycleWalk walker = new C4_5_ArrayCycleWalk();
		walker.walk(array);
	}

}
