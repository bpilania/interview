package com.interview.lectures.unionfind;

public class TestUnionFind {
	public static final int QUICKFIND = 1;
	public static IUnionFind getUnionFind(int type, int N){
		switch(type){
		case QUICKFIND:
			return new QuickUnionFind(N);
		default:
			return null;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		IUnionFind finder = TestUnionFind.getUnionFind(QUICKFIND, N);
		finder.union(4, 3);
		finder.union(3, 8);
		finder.union(6, 5);
		finder.union(9, 4);
		finder.union(2, 1);
		System.out.println(finder.connected(0, 7));
		System.out.println(finder.connected(8, 9));
		finder.union(5, 0);
		finder.union(7, 2);
		finder.union(6, 1);
		System.out.println(finder.connected(0, 7));
	}

}
