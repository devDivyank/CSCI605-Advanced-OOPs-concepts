
/**
 * Filename - SortedStorage.java
 * 
 * Problem Statement - Implement a BST.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class SortedStorage {

	public static boolean flag = false;
	static Node tree = null;
	static int nullCount = 0;

	public static void main(String[] args) {

	}

	public static boolean find(String val) {
		return findVal(tree, val);
	}

	
	/**
	 * @param root - Node element of BST
	 * @param val  - Value to find.
	 * @return  true if found else false
	 * 
	 * This method find the value in the tree
	 */
	public static boolean findVal(Node root, String val) {
		if (root == null) {
			return false;
		}
		if (root.val == Integer.parseInt(val)) {
			return true;
		}
		if (root.val > Integer.parseInt(val)) {
			return findVal(root.left, val);
		} else {
			return findVal(root.right, val);
		}
	}

	/**
	 * @param val -value to add in BST
	 * @return true of added else false
	 * 
	 * This method will add value in bst
	 */
	public static boolean add(String val) {
		if (val == null) {
			if (nullCount == 0) {
				val = String.valueOf(Integer.MAX_VALUE);
				nullCount += 1;
			} else {
				nullCount += 1;
				return true;
			}
		}
		tree = addVal(tree, val);
		return flag;
	}

	/**
	 * @param root - Node element of BST
	 * @param val  - Value to find.
	 * @return root element
	 * 
	 * This method actual implementation for inserting in bst
	 */
	public static Node addVal(Node root, String val) {

		if (root == null) {
			root = new Node(val);
			flag = true;
			return root;
		} else if (root.val > Integer.parseInt(val)) {
			root.left = addVal(root.left, val);
		} else if (root.val < Integer.parseInt(val)) {
			root.right = addVal(root.right, val);
		} else {
			flag = false;
			return root;
		}
		return root;
	}

	/**
	 * @param root   - node of the bst
	 * @return       - updated root node with null element added
	 *
	 * This method adds a null value to the bst.
	 */
	public static Node addNull(Node root) {
		Node current = root;
		while (current.right != null) {
			current = current.right;
		}
		current.right = new Node(String.valueOf(Integer.MAX_VALUE));
		System.out.println("add(null) : " + true);
		return root;
	}

	/**
	 * @param root - Node element of BST
	 * @param val  - Value to delete.
     * @return  true if deleted null else false
     * 
     * This method deletes null from bst
	 */
	public static boolean deleteNull(Node root, String val) {
		if (val == null) {
			if (nullCount > 1) {
				nullCount -= 1;
			} else if (nullCount == 1) {
				root = deleteVal(root, String.valueOf(Integer.MAX_VALUE));
				nullCount -= 1;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param root - Node element of BST
	 * @param val  - Value to delete.
     * @return  true if found else false
     * 
     * This method deletes value from bst
	 */
	public static boolean delete(String val) {
		tree = deleteVal(tree, val);
		return flag;
	}

	/**
	 * @param root   - node of the bst
	 * @param val    - value to be deleted
	 * @return       - all characters that player has guessed correctly
	 *
	 * This method deletes a value from bst if present.
	 */
	public static Node deleteVal(Node root, String val) {
		if (val == null) {
			flag = deleteNull(root, val);
			return root;
		}
		if (root == null) {
			flag = false;
			return root;
		} else if (root.val == Integer.parseInt(val)) {
			Node current = root;
			if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			} else {
				current = root.right;
				while (current.left != null) {
					current = current.left;
				}
				root.val = current.val;
				if (current.left == null && current.right == null) {
					root.right = null;
				} else {
					current.val = current.right.val;
					current.right = null;
				}
			}
			flag = true;
		} else if (root.val > Integer.parseInt(val)) {
			root.left = deleteVal(root.left, val);
		} else if (root.val < Integer.parseInt(val)) {
			root.right = deleteVal(root.right, val);
		}
		return root;
	}
}