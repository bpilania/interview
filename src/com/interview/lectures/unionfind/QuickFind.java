package com.interview.lectures.unionfind;

public class QuickFind extends UnionFindBase{
	
	/**
	 * User a integer array to store the flag of each node, the node with same flag in one connectivity.
	 * quickfind:
	 * 	initialize: N
	 * 	union: N
	 * 	find: 1
	 */
	
	public QuickFind(int N) {
		super(N);
	}

	
	@Override
	public void union(int a, int b) {
		if(!this.checkIndex(a) || !this.checkIndex(b)){
			System.err.println("input index out of bound");
			return;
		}
		int flag_a = this.index[a];
		int flag_b = this.index[b];
		if(flag_a == flag_b){
			return;
		} else {
			for(int i = 0; i < N; i ++){
				if(this.index[i] == flag_a){
					this.index[i] = flag_b;
				}
			}
		}
	}

	@Override
	public boolean connected(int a, int b) {
		if(!this.checkIndex(a) || !this.checkIndex(b)){
			System.err.println("input index out of bound");
			return false;
		}
		if(this.index[a] == this.index[b]){
			return true;
		} else {
			return false;
		}
	}
	
	
}
