package binarytreealgorithms;

/**
 * 
 * @author tvishwakarma
 * <p>
 * A Class which defines the Node structure
 * </p>
 *
 */
public class Node {
	
	private int data;
	private Node left;
	private Node right;
	
	/**
	 * 
	 * @param data Data to create a list with
	 * @param left Address of left node
	 * @param right Address of right node
	 */
	Node(int data,Node left,Node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * 
	 * @return Data
	 */
	public int getData() {
		return data;
	}

	/**
	 * 
	 * @param data set Data to Node
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * 
	 * @return leftious Node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * 
	 * @param left set the leftious to the current node
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * 
	 * @return right Node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * 
	 * @param right set right Node to current Node
	 */
	public void setRight(Node right) {
		this.right = right;
	}
}
	
