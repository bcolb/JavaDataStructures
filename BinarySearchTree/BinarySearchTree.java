/**
 * BinarySearchTree.java
 * Date: March 27th, 2015
 * @author Brice Colbert
 */

/**
 * An implementation of a binary search tree.
 */
public class BinarySearchTree<SomeType extends Comparable<? super SomeType>> {

    /**
     * A nested node class for use in our Binary Search Tree.
     */
    private static class BinaryNode<SomeType> {
	// Fields
	SomeType element;
	BinaryNode<SomeType> left;
	BinaryNode<SomeType> right;
	
	/**
	 * A single parameter constructor that takes an element as the sole
	 * parameter.
	 * @param element
	 */
	BinaryNode(SomeType element) {
	    // Call to the three parameter constructor
	    this(element, null, null);
	}

	/**
	 * Constructor which accepts three parameters, an element, left sub-tree
	 * and right sub-tree
	 * @param element, left, right
	 */
	BinaryNode(SomeType element, BinaryNode<SomeType> left, BinaryNode<SomeType> right) {
	    this.element = element;
	    this.left = left;
	    this.right = right;
	}
    }

    // Fields for use in our Binary Search Tree
    private BinaryNode<SomeType> root;

    /**
     * A single parameter constructor for our Binary Search Tree.
     */
    public BinarySearchTree() {
	this.root = null;
    }

    /**
     * Makes the Tree empty.
     */ 
    public void makeEmpty() {
	this.root=null;
    }

    /**
     * Returns true if the root is null, false otherwise.
     */
    public boolean isEmpty() {
	return this.root==null;
    }

    /**
     * Finds an item in a subtree by calling a private method.
     */
    public boolean contains(SomeType value) {
	return contains(value, this.root);
    }

    /**
     * A private helper method for our public contains method.
     */
    public boolean contains(SomeType value, BinaryNode<SomeType> tree) {
	if(tree == null) return false;
	int result = value.compareTo(tree.element);
	if(result < 0) {
	    return contains(value, tree.left);
	} else if (result > 0) {
	    return contains(value, tree.right);
	} else {
	    return true;
	}
    }

}
