package com.interview.algorithms.list.enhanced;


public class SortedListMergerTest {
	public static void main(String[] args) {
		System.out.println("Test case 1");
		int[] list1 = {10,11,12,13,14};
		int[] list2 = {1,2,3,4,5,6};
		Node nodeList1 = constractList(list1);
		Node nodeList2 = constractList(list2);
		Node finalHead = SortedListsMerger.merge(nodeList1, nodeList2);
		printList(finalHead);
		
		System.out.println("Test case 2");
		int[] list3 = {1,2,3,4,5,6};
		int[] list4 = {10,11,12,13,14};
		nodeList1 = constractList(list3);
		nodeList2 = constractList(list4);
		finalHead = SortedListsMerger.merge(nodeList1, nodeList2);
		printList(finalHead);
		
		
		System.out.println("Test case 3");
		int[] list5 = {1,3,7,9,11};
		int[] list6 = {2,4,6,8,10};
		nodeList1 = constractList(list5);
		nodeList2 = constractList(list6);
		finalHead = SortedListsMerger.merge(nodeList1, nodeList2);
		printList(finalHead);
		
		System.out.println("Test case 4");
		int[] list7 = {1,3,7,9,11};
		int[] list8 = {};
		nodeList1 = constractList(list7);
		nodeList2 = constractList(list8);
		finalHead = SortedListsMerger.merge(nodeList1, nodeList2);
		printList(finalHead);
		
		System.out.println("Test case 5");
		int[] list9 = {};
		int[] list10 = {1,3,7,9,11};
		nodeList1 = constractList(list9);
		nodeList2 = constractList(list10);
		finalHead = SortedListsMerger.merge(nodeList1, nodeList2);
		printList(finalHead);
		
		System.out.println("Test case 6");
		int[] list11 = {1,3,7,9,11,11,11,11,11,20};
		int[] list12 = {2,4,6,8,8,8,8,8,8,9,10,20,70};
		nodeList1 = constractList(list12);
		nodeList2 = constractList(list11);
		finalHead = SortedListsMerger.merge(nodeList1, nodeList2);
		printList(finalHead);
	}
	
	
	public static void printList(Node head){
		Node current = head;
		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static Node constractList(int[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}
		Node head = new Node();
		head.data = nums[0];
		Node current = head;
		for(int i = 1; i < nums.length; i++){
			Node next = new Node();
			next.data = nums[i];
			current.next = next;
			current = next;
		}
		return head;
	}
}
