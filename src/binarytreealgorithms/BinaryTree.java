package binarytreealgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	private Node start = null;
	private int size = 0;

	private Queue<Node> queue = new LinkedList<>();

	BinaryTree() {

	}
	
	public class Count
	{
		int nCount;
		Count()
		{
			nCount = 0;
		}
	}

	/**
	 * 
	 * @param data
	 */
	public void createRootNode(int data) {
		Node ptr;
		if (start == null) {
			ptr = new Node(data, null, null);
			start = ptr;
		}
	}

	/**
	 * 
	 * @param node
	 * @param data
	 */
	public Node insertBinarySearchTree(Node root, int data) {
		 Node ptr = root;

	        while(ptr.getPrev() != null || ptr.getNext() != null) {
	            if(data < ptr.data) {
	                if(ptr.getPrev() == null) {
	                    break;
	                }
	                ptr = ptr.getPrev();
	            }else {
	                if(ptr.getNext() == null) {
	                    break;
	                }
	                ptr = ptr.getNext();
	            }
	        }  
	        
	        if(data < ptr.data) {
	        	ptr.setPrev(new Node(data, null ,null));
	        }else {
	        	ptr.setNext(new Node(data, null, null));
	        }
	        return root;
	}

	/**
	 * 
	 * @param node
	 * @param data
	 */
	public void insertToTheLeftof(int node, int data) {
		Node advancedPtr;
		Queue<Node> queue = new LinkedList<Node>();
		size++;
		Node ptr = new Node(data, null, null);
		advancedPtr = start;
		queue.add(advancedPtr);
		while (!queue.isEmpty()) {
			Node topNode = queue.poll();

			if (topNode.getData() == node) {
				topNode.setPrev(ptr);
				queue.clear();
				break;
			} else {
				if (topNode.getPrev() != null) {
					queue.add(topNode.getPrev());
				}
				if (topNode.getNext() != null) {
					queue.add(topNode.getNext());
				}
			}
		}
	}

	/**
	 * 
	 * @param node
	 * @param data
	 */
	public void insertToTheRightOf(int node, int data) {
		Node advancedPtr;
		Queue<Node> queue = new LinkedList<Node>();
		size++;
		Node ptr = new Node(data, null, null);
		advancedPtr = start;
		queue.add(advancedPtr);
		while (!queue.isEmpty()) {
			Node topNode = queue.poll();
			if (topNode.getData() == node) {
				topNode.setNext(ptr);
				queue.clear();
				break;
			} else {
				if (topNode.getPrev() != null)
					queue.add(topNode.getPrev());
				if (topNode.getNext() != null)
					queue.add(topNode.getNext());
			}
		}
	}

	/**
	 * Level Order Traversal
	 */
	public void traverse() {
		Node ptr;
		if (start == null) {
			Utils.println("List is empty!!!!");
		} else {
			queue.add(start);
			while (queue.size() > 0) {
				ptr = queue.poll();
				Utils.println("" + ptr.getData());
				if (ptr.getPrev() != null) {
					queue.add(ptr.getPrev());
				}

				if (ptr.getNext() != null) {
					queue.add(ptr.getNext());
				}
			}
		}
	}

	/**
	 * 
	 * @return returns root node
	 */
	public Node getRootNode() {
		return start;
	}

	/**
	 * 
	 * @param node
	 *            ==> root Node
	 */
	public void inOrderTraversal(Node node) {
		if (node == null)
			return;

		inOrderTraversal(node.getPrev());
		Utils.println("" + node.getData());
		inOrderTraversal(node.getNext());
	}

	/**
	 * 
	 * @param node
	 *            ==> root Node
	 */
	public void preOrderTraversal(Node node) {

		if (node == null)
			return;

		Utils.println("" + node.getData());
		preOrderTraversal(node.getPrev());
		preOrderTraversal(node.getNext());

	}

	/**
	 * 
	 * @param node
	 *            ==> root Node
	 */
	public void postOrderTraversal(Node node) {
		if (node == null)
			return;

		postOrderTraversal(node.getPrev());
		postOrderTraversal(node.getNext());
		Utils.println("" + node.getData());
	}

	/**
	 * 
	 * @return size of binary Tree
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 */
	public int calculateHeight(Node node) {
		if (node == null)
			return -1;

		int leftHeight = calculateHeight(node.getPrev());
		int rightHeight = calculateHeight(node.getNext());
		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}
	
	public int findSecondLargestNumber(Node node) {
		Count count = new Count();
		return findSecondLargestNumber(node, count);
	}
	/**
	 * 
	 * @param node
	 * @return second largest number
	 */
	private int findSecondLargestNumber(Node node, Count count) {
		if (node == null || count.nCount >= 2) {
			return -2;
		}

		findSecondLargestNumber(node.getNext(), count);
		count.nCount++;
		if (count.nCount == 2) {
			return node.getData();
		}
		findSecondLargestNumber(node.getPrev(), count);

		return -1;
	}
	
	/**
	 * 
	 * @param array
	 * @return height of binary tree
	 */
	public int findHeightofBinarySearchTreeFromArray(int[] array)
	{
		/**
		 * create root node
		 */
		createRootNode(array[0]);

		/**
		 *  create a binary tree
		 */
		for (int i = 1; i < array.length; i++) {
			insertBinarySearchTree(getRootNode(), array[i]);
		}

		/**
		 *  find the height of binary search tree
		 */
		return calculateHeight(getRootNode());
	}
}
