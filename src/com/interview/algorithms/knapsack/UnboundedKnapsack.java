package com.interview.algorithms.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * http://en.wikipedia.org/wiki/Knapsack_problem
 * http://zh.wikipedia.org/wiki/%E8%83%8C%E5%8C%85%E9%97%AE%E9%A2%98
 * @author zouzhile
 *
 */
public class UnboundedKnapsack {

	class Bag {
		List<Item> itemsInBag = new ArrayList<Item>();
		int totalValue = 0;
		int weightLimit = 0;
		
		void addItem(Item item){
			this.itemsInBag.add(item);
			this.weightLimit -= item.weight;
			this.totalValue += item.value;
		}
		
		void removeItem(Item item){
			this.itemsInBag.remove(item);
			this.weightLimit += item.weight;
			this.totalValue -= item.value;
		}
		

	}
	
	public int getMaxValue(List<Item> items, Bag bag){
		int maxValue = 0;
		for(Item item : items){
			if(item.weight <= bag.weightLimit){
				// suppose the bag can't be filled full with current item
				
				// calculate the max value if we put the current item in bag	
				bag.addItem(item);	
				int maxValueWithItemInBag = this.getMaxValue(items, bag);
				if(maxValueWithItemInBag <= maxValue)
					bag.removeItem(item);
				else {
					maxValue = maxValueWithItemInBag;
				}
			}
		}
		// assume weight limit can't be reached with the given items
		maxValue = getMaxValue(items, bag);
		
		return maxValue;
	}
}
