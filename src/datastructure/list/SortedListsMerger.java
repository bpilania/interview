package datastructure.list;

import utils.ConsoleReader;

public class SortedListsMerger {

	public Node mergeLists(Node node1, Node node2) {
		Node head = null;
		Node node1Pre = null;
		//insert the nodes of second list into the first list
		while (node2 != null) {
			//search the node in list 1 which is greater or equal than current node2
			while (node1 != null && node1.compareTo(node2) < 0) { 
				if(head == null)
					head = node1;
				node1Pre = node1;
				node1 = node1.next();
			}
			
			if(node1 == null)
				break;
			//insert node2 before node1
			if(head == null)
				head = node2;
			if(node1Pre == null) {
				node1Pre = node2;
				node2 = node2.next();
				node1Pre.setNextNode(node1);
			} else {
				//update node1Pre
				node1Pre.setNextNode(node2);
				node1Pre = node2;
				//insert node2 before node1
				Node nextNode2 = node2.next();
				node2.setNextNode(node1);
				//update node2
				node2 = nextNode2;
			}
			
		}
		if(node1 == null)
			node1Pre.setNextNode(node2);
		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConsoleReader reader = new ConsoleReader();
		System.out.println("Merge two sorted list");
		System.out.println("===============================================================================");
		System.out.print("Please input the first int array: ");
		int[] array1 = reader.readSortedIntItems();
		Node list1 = Node.createList(array1);
		System.out.print("Please input the second int array: ");
		int[] array2 = reader.readSortedIntItems();
		Node list2 = Node.createList(array2);

		SortedListsMerger merger = new SortedListsMerger();
		Node node = merger.mergeLists(list1, list2);
		System.out.print("The merged list is : ");
		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.next();
		}
	}

}
