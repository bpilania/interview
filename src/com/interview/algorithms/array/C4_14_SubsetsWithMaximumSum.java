package com.interview.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/forum/view/company-interview?company=146
 * Given a set S, find all the maximal subsets whose sum <= k. For example, if S = {1, 2, 3, 4, 5} and k = 7
 * Output is: {1, 2, 3} {1, 2, 4} {1, 5} {2, 5} {3, 4}
 * 
 * @author zouzhile
 *
 */
public class C4_14_SubsetsWithMaximumSum {

	/**
	 * 
	 * @param sortedSet an array containing the unique and sorted elements in a set
	 * @param k the max sum of the subset' elements
	 */
	public List<List<Integer>> findSubsets(int[] sortedSet, int k) {
		List<List<Integer>> maxSubsets = new ArrayList<List<Integer>>();
		
		for(int i = 0; i< sortedSet.length; i ++) {
			if (sortedSet[i] < k) {
				int smallest= sortedSet[i];
				// finding all subsets starting with sortedSet[i] with sum smaller than k
				// using lexicographical order
				for(int j = i + 1; j < sortedSet.length; j ++ ) {	
					int sum = smallest;
					List<Integer> maxSubset = new ArrayList<Integer> ();
					maxSubset.add(smallest);
				    for(int h = j; h < sortedSet.length; h ++) {				    							
				    	int next = sortedSet[h];
				    	if(sum + next <= k) {		
				    		maxSubset.add(next);
				    		sum += next;
				    		if (sum == k) {
				    			j = h + 1;
				    			maxSubsets.add(maxSubset);
				    			break;
				    		}
				    	} else {
				    		sum -= sortedSet[h --];
				    		maxSubset.remove(maxSubset.size() - 1);
				    	}				    	
				    }
				 
				}
			}
			else if (sortedSet[i] == k) {
			    List<Integer> maxSubset = new ArrayList<Integer> ();
			    maxSubset.add(k);
			    maxSubsets.add(maxSubset);
			} else { // sortedSet[i] is the smallest element
				break; // smallest element is larger than k, break. 
			}					
		}

		return maxSubsets;
		
	}
	
	
	public static void main(String[] args) {
		int[] set = {1, 2, 3, 4, 5};
		int k = 7;
		List<List<Integer>> maxSubsets = new C4_14_SubsetsWithMaximumSum().findSubsets(set, k);
		for(List<Integer> subset : maxSubsets) {
			for(Integer v : subset) 
				System.out.print(v + "\t"); 
			System.out.println();
		}
	}
}
