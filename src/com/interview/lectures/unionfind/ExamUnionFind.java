package com.interview.lectures.unionfind;

public class ExamUnionFind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String command = "9-1 8-3 7-6 9-6 8-9 0-9";
		String command = "8-6 1-9 7-3 1-0 9-5 6-3 1-4 0-7 4-2";
		String[] operations = command.split(" ");
		IUnionFind finder = new EnhancedQuickUnionWeightTree(10);
		for(int i = 0; i < operations.length; i++){
			String operation = operations[i];
			char[] chars = operation.toCharArray();
			int a = Integer.parseInt(""+chars[0]);
			int b = Integer.parseInt(""+chars[2]);
			finder.union(a, b);
		}
		System.out.println(finder.toString());
	}

}
