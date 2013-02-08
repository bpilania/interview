package com.interview.lectures.unionfind;

public class TestUnionFind {
	public static final int QUICKFIND = 1;
	public static final int QUICKUNION = 2;
	public static final int ENHENCEDQUICKUNIONWEIGHT = 3;
	public static final int ENHENCEDQUICKUNIONPATH = 4;
	public static final int ENHENCEDQUICKUNIONWEIGHTANDPATH = 5;
	
	public static IUnionFind getUnionFind(int type, int N){
		switch(type){
		case QUICKFIND:
			return new QuickFind(N);
		case QUICKUNION:
			return new QuickUnion(N);
		case ENHENCEDQUICKUNIONWEIGHT:
			return new EnhancedQuickUnionWeightTree(N);
		case ENHENCEDQUICKUNIONPATH:
			return new EnhencedQuickUnionPathCompression(N);
		case ENHENCEDQUICKUNIONWEIGHTANDPATH:
			return new EnhancedQuickUnionWeightTreeWithPathCompression(N);
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
		System.out.println("Test Quick Find");
		IUnionFind finder = TestUnionFind.getUnionFind(QUICKFIND, N);
		testCase(finder);
		
		System.out.println("Test Quick Union");
		finder = TestUnionFind.getUnionFind(QUICKUNION, N);
		testCase(finder);
		
		System.out.println("Test Enhanced Quick Union");
		finder = TestUnionFind.getUnionFind(ENHENCEDQUICKUNIONWEIGHT, N);
		testCase(finder);
		
		System.out.println("Test Enhanced Quick Union");
		finder = TestUnionFind.getUnionFind(ENHENCEDQUICKUNIONPATH, N);
		testCase(finder);
		
		System.out.println("Test Enhanced Quick Union");
		finder = TestUnionFind.getUnionFind(ENHENCEDQUICKUNIONWEIGHTANDPATH, N);
		testCase(finder);
		
	}
	
	public static void testCase(IUnionFind finder){
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
		System.out.println(finder.toString());
		System.out.println(finder.connected(0, 7));
	}

}
