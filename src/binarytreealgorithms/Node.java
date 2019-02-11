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
	
	int data;
	Node prev;
	Node next;
	
	/**
	 * 
	 * @param data Data to create a list with
	 * @param prev Address of previous node
	 * @param next Address of next node
	 */
	Node(int data,Node prev,Node next){
		this.data = data;
		this.prev = prev;
		this.next = next;
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
	 * @return previous Node
	 */
	public Node getPrev() {
		return prev;
	}

	/**
	 * 
	 * @param prev set the previous to the current node
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}

	/**
	 * 
	 * @return next Node
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * 
	 * @param next set next Node to current Node
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}
	
