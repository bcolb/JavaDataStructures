/** 
 * TestBinarySearchTree.java
 * Date: March 28th, 2015
 * @author Brice Colbert
 */

/**
 * A simple test class for my implementation of a basic Binary Search Tree.
 */
public class TestBinarySearchTree {

    public static void testOne() {
	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	bst.printInOrder();
	bst.insert(5);
	bst.printInOrder();
	bst.insert(3);
	bst.printInOrder();
	bst.insert(7);
	bst.printInOrder();
    }

    public static void main(String[] args) {
	System.out.println("***** Testing Binary Search Tree *****");
	testOne();
    }
    
}
