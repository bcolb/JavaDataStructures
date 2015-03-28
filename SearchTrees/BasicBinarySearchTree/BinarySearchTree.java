/**
 * BinarySearchTree.java
 * Date: March 27th, 2015
 * @author Brice Colbert
 */

/**
 * This is an implementation of a basic, unbalanced, binary search tree.
 * I'm writing it solely for practice and don't intend on using this in 
 * any production code.
 *
 * While the average time-complexity for most operations will remain at O(logN)
 * for this implementation, worst case will be O(N).
 */
public class BinarySearchTree<SomeType extends Comparable<? super SomeType>> {

    /**
     * This nested class is used to represent the nodes and links between
     * nodes in the binary search tree.
     */
    private static class BinaryNode<SomeType> {
	// Fields for the nested BinaryNode class
	SomeType element;
	BinaryNode<SomeType> left;
	BinaryNode<SomeType> right;
	
	/**
	 * A single parameter constructor that takes an element as the sole
	 * parameter.
	 * @param element the element for the new node
	 */
	BinaryNode(SomeType element) {
	    // Call to the three parameter constructor
	    this(element, null, null);
	}

	/**
	 * Constructor which accepts three parameters, an element, left sub-tree
	 * and right sub-tree
	 * @param element, left, right the node's value and subtrees
	 */
	BinaryNode(SomeType element, BinaryNode<SomeType> left, BinaryNode<SomeType> right) {
	    this.element = element;
	    this.left = left;
	    this.right = right;
	}
    }

    // Fields for use in the BinarySearchTree
    private BinaryNode<SomeType> root;

    /**
     * A parameterless constructor for the Binary Search Tree.
     */
    public BinarySearchTree() {
	this.root = null;
    }

    /**
     * Makes the Tree empty by setting the root node to null.
     */ 
    public void makeEmpty() {
	this.root=null;
    }

    /**
     * Returns true if the root is null, false otherwise.
     * @return boolean value indicating if the tree is empty.
     */
    public boolean isEmpty() {
	return this.root==null;
    }

    /**
     * Finds an item in a subtree by calling a recursive helper method.
     * @param value the value of the item being searched for
     * @return whether or not the value is contained in the tree
     */
    public boolean contains(SomeType value) {
	return contains(value, this.root);
    }

    /**
     * A private helper method for our public contains method.
     * @param value the value being searched for
     * @param tree - the tree to search in
     * @return whether or not the tree contains said value
     */
    private boolean contains(SomeType value, BinaryNode<SomeType> tree) {
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

    /**
     * Returns the minimum value in the search tree.
     * @preturn the minimum item in the tree.
     */
    public SomeType findMin() {
	return findMin(root).element;
    }

    /**
     * Recursively finds the minimum item in the tree by traversing 
     * left subtrees.
     * @param tree - the tree to search in.
     * @return The minimum value in the tree (null if empty)
     */ 
    private BinaryNode<SomeType> findMin(BinaryNode<SomeType> tree) {
	if(tree == null) return null;
	if(tree.left == null) return tree;
	return findMin(tree.left);
    }

    /**
     * Finds the maximum item in the tree.
     * @return the maximum item.
     */
    public SomeType findMax() {
	return findMax(root).element;
    }
    
    /**
     * Recursively finds the maximum value in the tree.
     * @param tree the tree to search.
     * @return the maximum item in that subtree.
     */
    private BinaryNode<SomeType> findMax(BinaryNode<SomeType> tree) {
	if(tree == null) return null;
	if(tree.right == null) return tree;
	return findMax(tree.right);
    }

    /** 
     * Inserts an element into the tree.
     * @param element the value to be inserted
     */
    public void insert(SomeType element) {
	root = insert(element, root);
    }

    private BinaryNode<SomeType> insert(SomeType element, BinaryNode<SomeType> tree) {
	if(tree == null) {
	    return new BinaryNode<SomeType>(element, null, null);
	}
	int result = element.compareTo(tree.element);
	if(result < 0) {
	    tree = insert(element, tree.left);
	} else if(result > 0){
	    tree = insert(element, tree.right);
	}
	return tree;
    }
    

}