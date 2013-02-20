package com.interview.lectures.unionfind;

public interface IUnionFind {

	public void union(int a, int b);
	public boolean connected(int a, int b);
	public int find(int a);
	public String toString();
}
