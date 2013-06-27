package com.interview.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/***
 * Problem: Find a (general) cycle that uses every edge exactly once.
 * @author chenting
 *
 */
public class EulerianTour {
	
	private List<Integer> visited = new ArrayList<Integer>();
	
	public boolean eulerianCheck(Graph g, Integer start){
		return true;
	}
	
	
	
	public static void main(String[] args){
		Graph g = new AdjListGraph();
		g.type = Graph.UNDIRECTED;
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 5);
		g.addEdge(0, 6);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
	}
}
