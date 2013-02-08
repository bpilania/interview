package com.interview.lectures.unionfind;

public interface IUnionFind {

	public void union(int a, int b);
	public boolean connected(int a, int b);
	public String toString();
}
