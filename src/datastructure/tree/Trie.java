package datastructure.tree;

class TrieNode {
	
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

public class Trie {

	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	public void addWord(String word) {
		TrieNode node = this.root;
		for(char c : word.toCharArray()){
			node = node.addChild(c);
			if (node == null) 
				return;
		}
		node.setWord(true);
	}
	
	public boolean isWord(String s) {
		TrieNode node = this.root;
		for(char c : s.toCharArray()){
			node = node.get(c);
			if(node == null)
				return false;
		}
		return node.isWord();
	}
	
	public TrieNode match(String s) {
		TrieNode node = this.root;
		for(char c : s.toCharArray()){
			node = node.get(c);
			if(node == null)
				return null;
		}
		
		return node;
	}

}
