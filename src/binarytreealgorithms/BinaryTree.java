package binarytreealgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private Node start = null;
    private int size = 0;

    private Queue<Node> queue = new LinkedList<>();

    BinaryTree() {

    }

    public class Count {
        int nCount;

        Count() {
            nCount = 0;
        }
    }

    /**
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
     * @param root
     * @param data
     */
    public Node insertBinarySearchTree(Node root, int data) {
        Node ptr = root;

        if (root == null) {
            root = new Node(data, null, null);
            return root;
        }

        while (ptr.getLeft() != null || ptr.getRight() != null) {
            if (data < ptr.getData()) {
                if (ptr.getLeft() == null) {
                    break;
                }
                ptr = ptr.getLeft();
            } else {
                if (ptr.getRight() == null) {
                    break;
                }
                ptr = ptr.getRight();
            }
        }

        if (data < ptr.getData()) {
            ptr.setLeft(new Node(data, null, null));
        } else {
            ptr.setRight(new Node(data, null, null));
        }
        return ptr;
    }

    /**
     * @param node
     * @param data
     */
    public void insertToTheLeftof(int node, int data) {
        Node advancedPtr;
        Queue<Node> queue = new LinkedList<>();
        size++;
        Node ptr = new Node(data, null, null);
        advancedPtr = start;
        queue.add(advancedPtr);
        while (!queue.isEmpty()) {
            Node topNode = queue.poll();

            if (topNode.getData() == node) {
                topNode.setLeft(ptr);
                queue.clear();
                break;
            } else {
                if (topNode.getLeft() != null) {
                    queue.add(topNode.getLeft());
                }
                if (topNode.getRight() != null) {
                    queue.add(topNode.getRight());
                }
            }
        }
    }

    /**
     * @param node
     * @param data
     */
    public void insertToTheRightOf(int node, int data) {
        Node advancedPtr;
        Queue<Node> queue = new LinkedList<>();
        size++;
        Node ptr = new Node(data, null, null);
        advancedPtr = start;
        queue.add(advancedPtr);
        while (!queue.isEmpty()) {
            Node topNode = queue.poll();
            if (topNode.getData() == node) {
                topNode.setRight(ptr);
                queue.clear();
                break;
            } else {
                if (topNode.getLeft() != null)
                    queue.add(topNode.getLeft());
                if (topNode.getRight() != null)
                    queue.add(topNode.getRight());
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
                if (ptr.getLeft() != null) {
                    queue.add(ptr.getLeft());
                }

                if (ptr.getRight() != null) {
                    queue.add(ptr.getRight());
                }
            }
        }
    }

    /**
     * @return returns root node
     */
    public Node getRootNode() {
        return start;
    }

    /**
     * @param node ==> root Node
     */
    public void inOrderTraversal(Node node) {
        if (node == null)
            return;

        inOrderTraversal(node.getLeft());
        Utils.println("" + node.getData());
        inOrderTraversal(node.getRight());
    }

    /**
     * @param node ==> root Node
     */
    public void preOrderTraversal(Node node) {

        if (node == null)
            return;

        Utils.println("" + node.getData());
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());

    }

    /**
     * @param node ==> root Node
     */
    public void postOrderTraversal(Node node) {
        if (node == null)
            return;

        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        Utils.println("" + node.getData());
    }

    /**
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

        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
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
     * @param node
     * @return second largest number
     */
    private int findSecondLargestNumber(Node node, Count count) {
        if (node == null || count.nCount >= 2) {
            return -2;
        }

        findSecondLargestNumber(node.getRight(), count);
        count.nCount++;
        if (count.nCount == 2) {
            return node.getData();
        }
        findSecondLargestNumber(node.getLeft(), count);

        return -1;
    }

    /**
     * @param array
     * @return height of binary tree
     */
    public int findHeightofBinarySearchTreeFromArray(int[] array) {
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

    /**
     * a function to print zig zag binary tree
     */
    public void printZigZag(Node rootNode) {

        if (rootNode == null)
            return;
        boolean rightToLeft = true;

        Stack<Node> nodeStack = new Stack<>();
        Stack<Node> nextNodeStack = new Stack<>();
        nodeStack.add(rootNode);

        while (!nodeStack.isEmpty()) {

            Node node = nodeStack.pop();
            System.out.println(node.getData());

            if (rightToLeft) {
                if (node.getLeft() != null) {
                    nextNodeStack.add(node.getLeft());
                }

                if (node.getRight() != null) {
                    nextNodeStack.add(node.getRight());
                }
            } else {
                if (node.getRight() != null) {
                    nextNodeStack.add(node.getRight());
                }

                if (node.getLeft() != null) {
                    nextNodeStack.add(node.getLeft());
                }
            }

            if (nodeStack.isEmpty()) {
                Stack<Node> temp;
                temp = nodeStack;
                nodeStack = nextNodeStack;
                nextNodeStack = temp;

                if (rightToLeft) {
                    rightToLeft = false;
                } else {
                    rightToLeft = true;
                }
            }
        }
    }
}
