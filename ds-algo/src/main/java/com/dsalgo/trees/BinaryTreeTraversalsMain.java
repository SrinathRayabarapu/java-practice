package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * On a given binary search tree(BST) -
  
   				40
   		20				60
   	10		30		50		70
   
 * 1. In Order traversal - left, root, right
	Traverse the left subtree in InOrder.
	Visit the node.
	Traverse the right subtree in InOrder.

	10 20 30 40 50 60 70


 * 2. Pre Order traversal - root, left, right
 	Visit the node.
	Traverse the left subtree in PreOrder.
	Traverse the right subtree in PreOrder.
	
	40 20 10 30 60 50 70 


 * 3. Post Order traversal - left, right, root
	Traverse the left subtree in PostOrder.
	Traverse the right subtree in PostOrder.
	Visit the node.
	
	10 30 20 50 70 60 40 
	
 *
	
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class BinaryTreeTraversalsMain {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(60, "sixty");
		root.leftChild = new TreeNode(30, "thirty");
		root.rightChild = new TreeNode(80, "eighty");
		root.leftChild.leftChild = new TreeNode(10, "ten");
		root.leftChild.rightChild = new TreeNode(50, "fifty");
		root.rightChild.leftChild = new TreeNode(70, "seventy");
		root.rightChild.rightChild = new TreeNode(90, "ninety");


		log.info("Original Tree: ");
		log.info("           60            ");
		log.info("     30            80    ");
		log.info("10      50     70        90");


		log.info("----- In Order -----");
		inOrderRecursive(root);

		log.info("----- Pre Order -----");
		preOrderRecursive(root);

		log.info("----- Post Order -----");
		postOrderRecursive(root);

	}

	/**
	 * printTree left child, node and right child
	 *
	 * @param node
	 */
	private static void inOrderRecursive(TreeNode node) {
		if(node != null){
			inOrderRecursive(node.leftChild);
			print(node);
			inOrderRecursive(node.rightChild);
		}
	}

	/**
	 * printTree node, left child and right child
	 *
	 * recursive is easy - uses implicit Stack
	 *
	 * @param node
	 */
	private static void preOrderRecursive(TreeNode node) {
		if(node != null){
			print(node);
			preOrderRecursive(node.leftChild);
			preOrderRecursive(node.rightChild);
		}
	}

	/**
	 * printTree left child, right child and node
	 *
	 * @param node
	 */
	private static void postOrderRecursive(TreeNode node){
		if(node != null){
			postOrderRecursive(node.leftChild);
			postOrderRecursive(node.rightChild);
			print(node);
		}
	}

	/**
	 * Need to do manual - uses external Stack
	 *
	 * Create empty stack and push root node to it.
	 * Do the following when stack is not empty
	 * Pop a node from stack and print it
	 * Push right child of popped node to stack
	 * Push left child of popped node to stack
	 *
	 * @param node
	 */
	private static void preOrderIterative(TreeNode node) {
		
		if(node == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		
		while(!stack.empty()){
			TreeNode pop = stack.pop();
			print(pop);
			
			//push right first so that while popping left comes early
			if(pop.rightChild != null)
				stack.push(pop.rightChild);

			if(pop.leftChild != null)
				stack.push(pop.leftChild);
		}
	}

	private static void print(TreeNode tNode) {
		log.info(tNode.data +" ");
	}
}