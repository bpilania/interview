package com.interview.algorithms.list;

import com.interview.utils.ConsoleReader;

/**
 * Find the -M element in a node list
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class LastMElementFinder {

	public Node findElement(Node list, int m){
		Node result = null, pointer = list;
		int length = 0;
		while(pointer != null){
			length ++;
			pointer = pointer.next();
		}
		int steps = length - m;
		for(int i = 0; i < steps; i++){
			if(result == null){
				result = list;
			}
			result = result.next();
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Search the Node at the '-M' position in the list");
		System.out.println("===============================================================================");
		ConsoleReader reader = new ConsoleReader();
		System.out.print("Please input the node values: ");
		String[] elements = reader.readStringItems();
		System.out.print("Please input the value of M: ");
		int m = reader.readInt();
		//build the node list
		Node head = null, current = null;
		for(int i = 0; i < elements.length; i++){
			Node node = new Node(elements[i], null);
			if(i == 0){
				head = node;
				current = node;
			} else {
				current.setNextNode(node);
				current = node;
			}
		}
		LastMElementFinder finder = new LastMElementFinder();
		Node result = finder.findElement(head, m);
		if (result == null){
			System.out.println("List is empty or its length is smaller than " + m);
		} else {
			System.out.println("The '-M' element is: " + result.getValue());
		}	    
	}

}
