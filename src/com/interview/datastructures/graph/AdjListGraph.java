package com.interview.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdjListGraph extends Graph {

	private Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();
	
	@Override
	public void addEdge(int v, int w) {
		this._addEage(v, w);
		if(this.type == UNDIRECTED){
			this._addEage(w, v);
		}
		this.edgeNum++;
	}
	
	private void _addEage(int v, int w){
		Set<Integer> bag = adj.get(v);
		if(bag == null){
			bag = new HashSet<Integer>();
			adj.put(v, bag);
			this.vertexNum++;
		}
		bag.add(w);
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj.get(v);
	}

	@Override
	public Iterable<Integer> vertexs() {
		return adj.keySet();
	}

}
