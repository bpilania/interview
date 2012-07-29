package com.interview.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

import com.interview.datastructures.tree.BinarySearchTree;
import com.interview.datastructures.tree.BinaryTreeNode;

public class TreeTraverse {

	public void traversInDepthFirstOrder(BinaryTreeNode tree){
		if(tree == null)
			return;
		
		System.out.print(tree.getValue() + " ");
		traversInDepthFirstOrder(tree.getLeftChild());
		traversInDepthFirstOrder(tree.getRightChild());
	}
	
	public void traverseInBreadthFirstOrder(BinaryTreeNode tree) {
		if(tree == null)
			return;
		
		List<BinaryTreeNode> pendings = new ArrayList<BinaryTreeNode>();
		pendings.add(tree);
		
		while(pendings.size() > 0) {
			BinaryTreeNode node = pendings.remove(0);
			System.out.print(node.getValue() + " ");
			// add children to pendings
			if(node.getLeftChild() != null)
				pendings.add(node.getLeftChild());
			if(node.getRightChild() != null)
				pendings.add(node.getRightChild());
		}		
		
	}
	
	public void traverseByPreOrder(BinaryTreeNode tree) {
		if(tree == null)
			return;
		
		System.out.print(tree.getValue() + " ");
		traverseByPreOrder(tree.getLeftChild());
		traverseByPreOrder(tree.getRightChild());
	}
	
	public void traverseByInOrder(BinaryTreeNode tree){
		if(tree == null)
			return;
		
		traverseByInOrder(tree.getLeftChild());
		System.out.print(tree.getValue() + " ");
		traverseByInOrder(tree.getRightChild());
	}
	
	public void traverseByPostOrder(BinaryTreeNode tree) {
		if(tree == null)
			return;
		traverseByPostOrder(tree.getLeftChild());
		traverseByPostOrder(tree.getRightChild());
		System.out.print(tree.getValue() + " ");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("The Tree Traverse Implementation");
		System.out.println("========================================================================");	
		
		System.out.println("Tree Structure : \n--------");
		System.out.println("            6");
		System.out.println("           / \\ ");
		System.out.println("          4   8");
		System.out.println("         / \\ / \\ ");
		System.out.println("        3  5 7  9");

//		ConsoleReader reader = new ConsoleReader();
//		System.out.print("Please input a list of tree node values: ");
		int[] array = new int[]{6,4,8,3,5,7,9};
        BinarySearchTree tree = new BinarySearchTree(array);

        TreeTraverse runner = new TreeTraverse();
        
        System.out.println("\nTree Traversal Results : \n--------");
        System.out.print("\tPreOrderTraversal: ");
        runner.traverseByPreOrder(tree.getRoot());
        
        System.out.print("\n\tInOrderTraversal: ");
        runner.traverseByInOrder(tree.getRoot());
        
        System.out.print("\n\tPostOrderTraversal: ");
        runner.traverseByPostOrder(tree.getRoot());
        
        System.out.print("\n\tBreadth First Traversal: ");
        runner.traverseInBreadthFirstOrder(tree.getRoot());
        
        System.out.print("\n\tDepth First Traversal: ");
        runner.traversInDepthFirstOrder(tree.getRoot());
        
	}

}
