package com.interview.datastructures.tree;

public class TrieNode {
	
	private TrieNode[] children;
	private boolean isWord = false;
	
	public TrieNode() {
		this.children = new TrieNode[26];
	}

	public TrieNode addChild(char child) {
		if(child < 'a' || child > 'z')
			return null;
			
		int offset = child - 'a';
		if(this.children[offset] == null) {
			this.children[offset] = new TrieNode(); 
		}
		return this.children[offset];
	}
	
	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public TrieNode get(char c){
		int offset = c - 'a';
		return this.children[offset];
	}
	
}
