package binarytreealgorithms;

import java.util.Scanner;

import binarytreealgorithms.BinaryTree.Count;

public class BinaryTreeAlgorithms {

	public static void main(String[] args) {
		int choice;
		Scanner scanner = new Scanner(System.in);
		BinaryTree binaryTree = new BinaryTree();
		while (true) {
			Utils.println(" Enter 0 for creating root node");
			Utils.println(" Enter 1 for insert");
			Utils.println(" Enter 2 for insert to left Of");
			Utils.println(" Enter 3 for insert to right of");
			Utils.println(" Enter 4 for level Order traversal/BFS");
			Utils.println(" Enter 5 for in Order Traversal/DFS");
			Utils.println(" Enter 6 for pre Order Traversal/DFS");
			Utils.println(" Enter 7 for post Order Traversal/DFS");
			Utils.println(" Enter 8 for Height of Binary Tree");
			Utils.println(" Enter 9 for Finding the second largest number");
			Utils.println("_______Enter your choice______");
			choice = scanner.nextInt();
			switch (choice) {
			case 0:
				Utils.println(" Enter the value of which you want to create a root node");
				int valueForRootNode = scanner.nextInt();
				binaryTree.createRootNode(valueForRootNode);
				break;
			case 1:
				Utils.println("____ Enter the value which you want to insert");
				int valueToInsert = scanner.nextInt();
				binaryTree.insertBinarySearchTree(binaryTree.getRootNode(), valueToInsert);
				break;
			case 2:
				Utils.println("____ Enter the value which you want to insert___");
				int leftAlignmentValue = scanner.nextInt();
				Utils.println("____ Enter the value of which left you want to insert");
				int leftOptions = scanner.nextInt();
				binaryTree.insertToTheLeftof(leftOptions, leftAlignmentValue);
				break;
			case 3:
				Utils.println("____ Enter the value which you want to insert");
				int rightAligmwentValue = scanner.nextInt();
				Utils.println("___ Enter the value of which right you want to insert");
				int rightOptions = scanner.nextInt();
				binaryTree.insertToTheRightOf(rightOptions, rightAligmwentValue);
				break;
			case 4:
				Utils.println("___ Level Order Traversal");
				binaryTree.traverse();
				break;
			case 5:
				Utils.println("___ Inorder Traversal");
				binaryTree.inOrderTraversal(binaryTree.getRootNode());
				break;
			case 6:
				Utils.println("___ Preorder Traversal");
				binaryTree.preOrderTraversal(binaryTree.getRootNode());
				break;
			case 7:
				Utils.println("___ Postorder Traversal");
				binaryTree.postOrderTraversal(binaryTree.getRootNode());
				break;
			case 8:
				int height = binaryTree.calculateHeight(binaryTree.getRootNode());
				Utils.println("Height of binary tree " + height);
				break;
			case 9:
				int secondLargestNumber = binaryTree.findSecondLargestNumber(binaryTree.getRootNode());
				Utils.println(" Second largest number in tree " + secondLargestNumber);
				break;
			}
		}
	}
}
