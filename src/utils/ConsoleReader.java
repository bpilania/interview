package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	public String readLine(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {			
			input = reader.readLine().trim();
		} catch (IOException e) {			
			e.printStackTrace();
			System.exit(1);
		}
		return input;
	}
	
	/**
	 * Input elements are separated by white space
	 * @return The string array as parsed from console input
	 */
	public String[] readStringItems(){
		String input = readLine();
		String[] values = input.split("\\s+");
		return values;
	}
	
	/**
	 * Input elements are separated by white space
	 * @return The integer array as parsed from console input
	 */
	public int[] readIntItems(){
		String[] values = readStringItems();
		int[] array = new int[values.length];
		for(int i = 0; i < values.length; i++){
			array[i] = Integer.parseInt(values[i]); 
		}
		return array;
	}
	
	public int readInt(){
		String value = this.readLine();
		return Integer.parseInt(value);
	}
	
}
