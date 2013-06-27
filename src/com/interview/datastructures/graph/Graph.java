package com.interview.datastructures.graph;

public abstract class Graph {
	public static int UNDIRECTED = 1;
	public static int DIRECTED = 2;
	
	public int type;
	public int vertexNum;
	public int edgeNum;
	
	public int V(){
		return vertexNum;
	}
	public int E(){
		return edgeNum;
	}
	
	public abstract void addEdge(int v, int w);
	
	public abstract Iterable<Integer> adj(int v);
	
	public abstract Iterable<Integer> vertexs();
	
}
