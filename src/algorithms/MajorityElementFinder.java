package algorithms;

import java.util.ArrayList;
import java.util.List;

import utils.ConsoleReader;

/**
 * Given a list, there is one element whose amount is greater or equal to the half length of the list, 
 * find this element without applying additional storage space.
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class MajorityElementFinder {

	public Integer find(List<Integer> array){
		int index = 0;
		while (index < array.size() - 1){
			if(array.get(index) != array.get(index + 1)){
				array.remove(index);
				array.remove(index);
				if(index > 0){
					index --;
				}
			} else{
				index ++;
			}
		}
		return array.get(0);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The Majority Element Finder");
		System.out.println("========================================================================");
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the array elements: ");
		int[] inputs = reader.readIntItems();
		List<Integer> array = new ArrayList<Integer>();;
		for(int input:inputs){
			array.add(Integer.valueOf(input));
		}
		MajorityElementFinder finder = new MajorityElementFinder();
		Integer result = finder.find(array);
		System.out.println("The majority element is " + result);
	}

}
