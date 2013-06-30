package com.interview.algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given an int array, find the sub arrays whose sum is closest to a given K
 * @author stefanie
 *
 */
public class C4_12_SubArraysWithSumClosestToK {

	private static HashMap<Integer, List<Integer>> subarrays = new HashMap<Integer, List<Integer>>(); 	
	
	public static void split(int[] array, int K) {
		int closestSum = Integer.MAX_VALUE; 
		
		for(int i = 0; i< array.length; i ++) {
			int current = array[i];
			Set<Entry<Integer, List<Integer>>> entries = subarrays.entrySet();
			int size = entries.size();
			Entry<Integer, List<Integer>>[] entriesArray = new Entry[size];
			entriesArray = entries.toArray(entriesArray);
			for(int j = 0 ; j < size; j ++) {
				Entry<Integer, List<Integer>> entry = entriesArray[j];
				int sum = entry.getKey();
				if(! subarrays.containsKey(sum + current)) {
					List<Integer> members = entry.getValue();
					List<Integer> newMembers = new ArrayList<Integer>();
					newMembers.addAll(members);
					newMembers.add(current);
					subarrays.put(sum + current, newMembers);
				}
				if(Math.abs(K - (sum+current)) < Math.abs(K - closestSum)) 
					closestSum = sum+current;
			}
			if(! subarrays.containsKey(current)) {
				List<Integer> members = new ArrayList<Integer>();
				members.add(current);
				subarrays.put(current, members);
				if(Math.abs(K - current) < Math.abs(K - closestSum))
					closestSum = current;
				
			}
		}
		System.out.println("Closed Sum: " + closestSum);
		
		for(Entry<Integer, List<Integer>> entry : subarrays.entrySet()) {
			System.out.print(entry.getKey() + " ----> ");
			for(int value : entry.getValue())
				System.out.print(value +"\t");
			System.out.println();			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4};
		int sum = 0;
		for(int item : array){
			sum += item;
		}
		split(array, sum/2);

	}

}
