package com.interview.lectures.unionfind;

public class EnhencedQuickUnionPathCompression extends UnionFindBase {
	/**
	 * enhance quick union by doing path compression in order to reduce the time to find parent
	 * during get parent procedure, flat the tree by assign the node to its grandparent.
	 * quickunion:
	 * 	initialize: N
	 * 	union: N
	 * 	find: N
	 */
	
	
	public EnhencedQuickUnionPathCompression(int N){
		super(N);
	}

	@Override
	public void union(int a, int b) {
		int parent_a = this.getParent(a);
		int parent_b = this.getParent(b);
		this.index[parent_a] = parent_b;
	}

	@Override
	public boolean connected(int a, int b) {
		if(this.getParent(a) == this.getParent(b)){
			return true;
		} else {
			return false;
		}
	}
	
	public int getParent(int index){
		while(this.index[index] != index){
			this.index[index] = this.index[this.index[index]];
			index = this.index[index];
		}
		return index;
	}
}
