package datastructure.tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Timer;

/**
 * Problem Description: 
 * http://stackoverflow.com/questions/746082/how-to-find-list-of-possible-words-from-a-letter-matrix-boggle-solver
 * 
 * 
 * @author zouzhile
 *
 */

public class BoggleSolver {
	
	class State {
		
		public final int row, column; // row and column index
		public final String prefix; // the next prefix equals to (prefix + data[i][j])

		public State(int row, int column, String prefix){
			this.row = row; this.column = column; this.prefix = prefix;
		}
		
	}
	
	private Trie trie;
	
	
	public BoggleSolver(String dictionary) {
		this.trie = new Trie();
		this.buildTrie(dictionary);
	}

	public Set<String> findWords(char[][] data){
		Set<String> words = new HashSet<String>();
		
		for(int i = 0; i < data.length; i ++) 
			for(int j = 0; j < data[i].length; j ++) 
				words.addAll(this.findWords(data, i, j));  
				
		return words;
	}
	
	private Set<String> findWords(char[][] data, int i, int j){
		Set<String> words = new HashSet<String>();
			
		List<State> queue = new ArrayList<State>();
		if(this.isInsideBound(data, i, j))
			queue.add(new State(i, j, "")); 
		
		while(queue.size() > 0) {
			State state = queue.remove(0);
			String prefix = state.prefix + data[state.row][state.column];
			TrieNode matchNode = this.trie.match(prefix);
			if(matchNode != null) {
				List<State> states = this.getStatesByAdjacentChars(data, state.row, state.column, prefix);
				queue.addAll(states);
				if(matchNode.isWord() && prefix.length() >= 3) {
					words.add(prefix);
				}
			}
		}	
		return words;
	}
		
	private List<State> getStatesByAdjacentChars(char[][] data, int currentRow, int currentColumn, String prefix){
		List<State> states = new ArrayList<State>();
		for(int rowDelta = -1; rowDelta <= 1; rowDelta ++)
			for(int columnDelta = -1; columnDelta <= 1; columnDelta ++) {
				int newRow = currentRow + rowDelta;
				int newColumn = currentColumn + columnDelta;
				if(this.isInsideBound(data, newRow, newColumn))
					states.add(new State(newRow, newColumn, prefix));
			}
		return states;
	}
	
	private boolean isInsideBound(char[][] data, int i, int j){
		boolean inbound = (i >= 0 && i < data.length) && (j >= 0 && j < data[i].length);
		return inbound;
	}
	
	private void buildTrie(String dictionary){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(dictionary));
			String line = null;
			while( (line = reader.readLine()) != null) {
				String word = line.trim().toLowerCase();				
				this.trie.addWord(word);
			}
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) { 
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String array = "djhi,klps,yeut,eorn";
		String array = "fxie,amlo,ewbx,astu";
		String[] rows = array.split(",");
		
		int rowsCount = rows.length;
		int columnCount = rows[0].length();		
		char[][] data = new char[rowsCount][columnCount];
		
		for(int i = 0; i < rowsCount; i ++) 
			for(int j = 0; j < columnCount; j ++)
				data[i][j] = rows[i].charAt(j);
		
		Timer timer = new Timer();
		timer.start();
		BoggleSolver solver = new BoggleSolver("./documents/dictionary");
		timer.stop();
		System.out.println("Trie build took " + timer);
		
		timer.start();
		Set<String> words = solver.findWords(data);
		timer.stop();
		System.out.println("Word searching took " + timer);
		
		TreeSet<String> sortedWords = new TreeSet<String>();
		sortedWords.addAll(words);
		int count = 0;
		System.out.println();
		for(String word : sortedWords) {
			System.out.print(word + " "); 
			count ++;
			if(count % 10 == 0)
				System.out.println();
		}
	}

}
