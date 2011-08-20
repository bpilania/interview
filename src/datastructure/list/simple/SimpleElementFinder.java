package datastructure.list.simple;

import utils.ConsoleReader;

/**
 * Find the -3 element in a node list
 * 
 * @author zouzhile (zouzhile@gmail.com)
 *
 */
public class SimpleElementFinder {

	public Node findElement(Node nav){
		while(true){
			if(nav.next().next().next() == null)
				return nav;
			else
				nav = nav.next();	
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Search the -3 Node");
		System.out.println("===============================================================================");
		ConsoleReader reader = new ConsoleReader();
		String[] elements = reader.readItems();
		if (elements.length < 3) {
			System.err.println("There must be more than 3 element!");
			System.exit(1);
		}
		//build the node list
		Node node = new Node(elements[0], null);
		Node head = node;
		for(int i = 1; i < elements.length; i++){
			Node current = new Node(elements[i], null);
			node.setNextNode(current);
			node = current;
		}
		SimpleElementFinder finder = new SimpleElementFinder();
		Node result = finder.findElement(head);
	    System.out.println("The -3 element is: " + result.getValue());
	}

}
