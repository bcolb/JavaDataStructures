/** 
 * TestBinarySearchTree.java
 * Date: March 28th, 2015
 * @author Brice Colbert
 */
import java.util.Scanner;
/**
 * A simple test class for my implementation of a basic Binary Search Tree.
 */
public class TestBinarySearchTree {

    /**
     * A helper method that creates a BST from a String.
     */
    public static BinarySearchTree<Integer> createTree(String str) {
	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
	String[] elements = str.split(" ");
	for(int i = 0; i < elements.length; i++) {
	    bst.insert(Integer.parseInt(elements[i]));
	}
	return bst;
    }

    /**
     * Test method that checks to the output of the BST toStringInOrder against
     * the test String.
     */
    public static boolean testInOrder(BinarySearchTree<Integer> bst, String str) {
	String result = bst.toStringInOrder().trim();
	return result.equals(str);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
	int testCases = Integer.parseInt(scan.nextLine());
	int passed = 0;
	int totalTests = 0;
	System.out.println("***** Testing Binary Search Tree *****");
	for(int i = 0; i < testCases; i++) {
	    System.out.println(" - Test Case " + i);
	    String insertStr = scan.nextLine();
	    BinarySearchTree<Integer> bst = createTree(insertStr);
	    String testStr = scan.nextLine();
	    totalTests++;
	    if(testInOrder(bst, testStr)) {
		System.out.println("    PASSED insertion test");
		passed++;
	    } else {
		System.out.println("    FAILED insertion test");
	    }
	    int deletionTests = Integer.parseInt(scan.nextLine());
	    for(int j = 0; j < deletionTests; j++) {
		int toremove = Integer.parseInt(scan.nextLine());
		bst.remove(toremove);
		String tester = scan.nextLine();
		totalTests++;
		if(testInOrder(bst, tester)) {
		    System.out.println("    PASSED deletion test " + j);
		    passed++;
		} else {
		    System.out.println("    FAILED deletion test " + j);
		}
	    }
	}
	System.out.println("*****Results*****");
	System.out.println("Passed " + passed + " of " + totalTests + " tests");
    }
    
}
