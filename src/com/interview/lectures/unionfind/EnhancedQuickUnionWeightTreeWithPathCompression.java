package com.interview.lectures.unionfind;

public class EnhancedQuickUnionWeightTreeWithPathCompression extends UnionFindBase {
	
	public int[] treesize;
	
	public EnhancedQuickUnionWeightTreeWithPathCompression(int N){
		super(N);
		this.treesize = new int[N];
		for(int i = 0; i < N; i ++){
			this.treesize[i] = 1;
		}
	}

	@Override
	public void union(int a, int b) {
		int parent_a = this.getParent(a);
		int parent_b = this.getParent(b);
		if(this.treesize[parent_a] > this.treesize[parent_b]){
			this.index[parent_b] = parent_a;
			this.treesize[parent_a] += this.treesize[parent_b];
		} else {
			this.index[parent_a] = parent_b;
			this.treesize[parent_b] += this.treesize[parent_a];
		}
		
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

	public boolean checkIndex(int index){
		if(index >= 0 && index < N){
			return true;
		} else {
			return false;
		}
	}
	

}
