package com.interview.algorithms.tree;

import com.interview.datastructures.tree.BinarySearchTree;
import com.interview.datastructures.tree.BinaryTreeNode;

public class NextNodeByInOrderTraversal {

	public BinaryTreeNode findNextNode(BinaryTreeNode node){
		BinaryTreeNode result = null;
		
		if(node.getRightChild() != null) {
			result = node.getRightChild();
			while(result.getLeftChild() != null)
				result = result.getLeftChild();
		} else {
			BinaryTreeNode parent = node.getParent();
			while(parent != null){
				if(parent.getLeftChild() == node)
					return parent;
				node = parent;
				parent = node.getParent();
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The Tree Traverse Implementation");
		System.out.println("========================================================================");	
		
		System.out.println("Tree Structure : \n--------");
		System.out.println("              10 ");
		System.out.println("             / \\ ");
		System.out.println("            6  11");
		System.out.println("           / \\ ");
		System.out.println("          4   8");
		System.out.println("         / \\ / ");
		System.out.println("        3  5 7  ");

//		ConsoleReader reader = new ConsoleReader();
//		System.out.print("Please input a list of tree node values: ");
		int[] array = new int[]{10,6,11,4,8,3,5,7};
        BinarySearchTree tree = new BinarySearchTree(array);

        BinaryTreeNode root = tree.getRoot();
        BinaryTreeNode node4 = root.getLeftChild().getLeftChild();
        BinaryTreeNode node6 = root.getLeftChild();
        BinaryTreeNode node7 = root.getLeftChild().getRightChild().getLeftChild();
        BinaryTreeNode node8 = root.getLeftChild().getRightChild();
        
        NextNodeByInOrderTraversal finder= new NextNodeByInOrderTraversal();
        System.out.println("\nNext Nodes By InOrder : \n--------");
        System.out.println("The next node of node 4 : " + finder.findNextNode(node4).getValue());
        System.out.println("The next node of node 6 : " + finder.findNextNode(node6).getValue());
        System.out.println("The next node of node 7 : " + finder.findNextNode(node7).getValue());
        System.out.println("The next node of node 8 : " + finder.findNextNode(node8).getValue());
	}

}
