package com.interview.lectures.unionfind;

public abstract class UnionFindBase implements IUnionFind{
	
	public final int N;
	public int[] index;
	
	public UnionFindBase(int N){
		this.N = N;
		this.index = new int[N];
		for(int i = 0; i < N; i ++){
			this.index[i] = i;
		}
	}
	
	public boolean checkIndex(int index){
		if(index >= 0 && index < N){
			return true;
		} else {
			return false;
		}
	}
	
	

	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < N; i ++){
			builder.append(this.index[i]);
			builder.append(", ");
		}
		return builder.toString();
	}
}
