package com.interview.datastructures.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Is a graph bipartite?
 * @author chenting
 *
 */
public class BiPartiteGraph {
	public static final Integer UNVISITED = 0;
	
	private Map<Integer, Integer> flag = new HashMap<Integer, Integer>();
	
	public boolean bipartite(Graph g){
		boolean isSuccess = true;
		for(Integer vertex : g.vertexs()){
			if(flag.get(vertex) == null){
				isSuccess = isSuccess && dfs(g, vertex, 1);
				if(!isSuccess) return isSuccess;
			}
		}
		return true;
	}
	
	public boolean dfs(Graph g, int v, int previousFlag){
		int currentFlag = 0;
		if(previousFlag == 1){
			currentFlag = 2;
		} else {
			currentFlag = 1;
		}
		flag.put(v, currentFlag);
		for(int w: g.adj(v)){
			if(flag.get(w) == null){
				dfs(g, w, currentFlag);
			} else if(flag.get(w) != previousFlag){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Graph g = new AdjListGraph();
		g.type = Graph.UNDIRECTED;
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(6, 4);
		g.addEdge(4, 5);
		g.addEdge(2, 4);
		g.addEdge(0, 2);
		g.addEdge(0, 6);
		
		
		BiPartiteGraph biGraph = new BiPartiteGraph();
		boolean isBiPartition = biGraph.bipartite(g);
		System.out.println("Is Bi-Partition?\t" + isBiPartition);
		
		
		for(Map.Entry<Integer, Integer> item : biGraph.flag.entrySet()){
			System.out.println(item.getKey() + "\t" + item.getValue());
		}
	}
}
