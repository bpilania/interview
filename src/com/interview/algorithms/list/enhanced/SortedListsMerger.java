package com.interview.algorithms.list.enhanced;

class Node{
	public int data;
	public Node next;
}
public class SortedListsMerger {
	public static Node merge(Node head1, Node head2){
		//handle the special case if list1 or list2 or both is/are empty
		if(head1 == null || head2 == null)
			return head1 == null ? head2 : head1;
		
		Node head = null, current = null;
		while(true){ //it will terminate when any list is empty
			while(head1 != null && head1.data <= head2.data){
				if(head == null) 
					head = head1;
				current = head1;
				if(head1.data == head2.data) 
					head2 = head2.next;
				head1 = head1.next;
				while(head1 != null && head1.data == current.data){
					head1 = head1.next;
				}
				current.next = head1;
			}
			if(current != null) {
				current.next = head2;
				current = current.next;
			}
			//optimize: if no more element in list1, finish the scan
			if(head1 == null) 
				break;
			//swap head1 and head2, to avoid duplicate code
			Node temp = head1; 
			head1 = head2; 
			head2 = temp;
		}
		return head;
	}
}