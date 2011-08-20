package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	public String readline(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		try {
			System.out.print("Please type the input (items separated by whitespace): ");
			input = reader.readLine().trim();
		} catch (IOException e) {			
			e.printStackTrace();
			System.exit(1);
		}
		return input;
	}
	
	public String[] readItems(){
		String input = readline();
		String[] values = input.split("\\s+");
		return values;
	}
	
}
