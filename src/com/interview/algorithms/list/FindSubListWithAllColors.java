package com.interview.algorithms.list;

import java.util.HashMap;

public class FindSubListWithAllColors {

	class SubList {
		Node start, end;
		int length;
		
		public SubList(Node start, Node end, int length){
			this.start = start;
			this.end = end;
			this.length = length;
		}
	}
	
	class State {
		int stepsFromHeadToEnd = 1, stepsFromHeadToStart = 0, maxSubListLength = Integer.MAX_VALUE;
		Node start, end, head;
		Node maxSubListStart, maxSubListEnd;
		HashMap<String, String> colors = new HashMap<String, String>();
		
		State(Node head){
			this.head = head;
			this.start = this.end = head;
			this.updateColorsForEndNode();
			this.end = this.start.next();
			this.updateColorsForEndNode();
			this.maxSubListStart = this.start;
			this.maxSubListEnd = this.end;
			this.maxSubListLength = this.getCurrentSubListLength();			
		}
		
		public boolean isCompleted(){
			boolean completed = (stepsFromHeadToStart == 0 && end.next() == head) ||
					            (stepsFromHeadToStart > 0 && start == head);
			return completed;
		}
		
		public int getCurrentSubListLength(){
			return this.stepsFromHeadToEnd - this.stepsFromHeadToStart;
		}
		
		public void updateColorsForEndNode(){
			String color = this.end.getValue();
			if(this.colors.get(color) == null)
				this.colors.put(color, "" + this.stepsFromHeadToEnd);
			else {
				String offsets = this.colors.get(color) + "," + this.stepsFromHeadToEnd;
				this.colors.put(color, offsets);
			}
		}
	}
	/**
	 * 
	 * @param head A cyclic list contains M nodes with N types of colors
	 * @param colorOffsets
	 * @return
	 */
	public State find(Node head, int colorCount) {
		State state = new State(head);
		
		while(! state.isCompleted()) {
			if(state.colors.size() == colorCount){
				int length = state.stepsFromHeadToEnd - state.stepsFromHeadToStart;
				if(length < state.maxSubListLength){
					state.maxSubListStart = state.start;
					state.maxSubListEnd = state.end;
					state.maxSubListLength = length;
				}
				
				state.colors.remove(state.start.getValue());
				state.start = state.start.next();
				state.stepsFromHeadToStart ++;
				this.compactSubList(state);
			} else if(state.start.getValue().equals(state.end.getValue())) // there is always 1 node with the color of start node in current sublist
				this.compactSubList(state);
			else {
				state.end = state.end.next();
				state.updateColorsForEndNode();
			}
		}
		return state;
	}
	
	/*
	 * Make the start->end sublist the smallest and contains all current colors.
	 * The algorithm is to move start node to the node with its color only appeared once and its 
	 *  stepsFromHeadToStart is the smallest
	 */
	private void compactSubList(State state){
		while(state.colors.get(state.start.getValue()).split(",").length > 1){
			String[] startNodeColors = state.colors.get(state.start.getValue()).split(","); 
			String colorsString = startNodeColors[1];
			for(int i = 2;  i < startNodeColors.length; i ++){
				colorsString += "," + startNodeColors[i];
			}
			state.colors.put(state.start.getValue(), colorsString);
			state.start = state.start.next();
			state.stepsFromHeadToStart ++ ;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("a".split(",").length);

	}

}
