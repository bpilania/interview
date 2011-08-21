package algorithms.bczm.chapter2;

import utils.ConsoleReader;

/**
 * Chapter 2.1 Count the amout of '1's in an integer's binary form
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class BinaryOneCounter {

	public int count(int value){
		int amount = 0;
		while (value != 0){
			amount += value & 1;
			value >>>= 1;
		}
		return amount;
	}
	
	public static void main(String[] args) {
		System.out.println("Binary One Counter");
		System.out.println("========================================================================");
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Plz input an integer : ");
        int value = reader.readInt();
        System.out.println("The binary form of the input integer: " + Integer.toBinaryString(value));
        
        BinaryOneCounter counter = new BinaryOneCounter();
        int amount = counter.count(value);
        System.out.println("The amount of '1' is : " + amount);
	}

}
