package com.practice.abhijeet;
/**
 * Filename - SortedStorage.java
 * 
 * Problem Statement - Implement a Binary Search Tree that allows duplicates.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class SortedStorage {

	public static boolean flag = false;
	static Node tree = null;

	public boolean find(String val) {
		return findVal(tree, val);
	}
	/**
	 * @param root - Node element of BST
	 * @param val  - Value to find.
	 * @return  true if found else false
	 *
	 * This method find the value in the tree
	 */
	public boolean findVal(Node root, String val) {
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
	public boolean add(String val) {
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
	public Node addVal(Node root, String val) {
		if (root == null) {
			root = new Node(val);
			root.count += 1;
			flag = true;
			return root;
		} else if (root.val == Integer.parseInt(val)) {
			root.count += 1;
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
	 * @param val  - Value to delete.
     * @return  true if found else false
     *
     * This method deletes value from bst
	 */
	public boolean delete(String val) {
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
	public Node deleteVal(Node root, String val) {
		if (root == null) {
			flag = false;
			return root;
		} else if (root.val == Integer.parseInt(val)) {
			if (root.count > 1){
				root.count -= 1;
				flag = true;
				return root;
			}
			Node current = root;
			if (root.left == null && root.right != null) {
				root = root.right;
			} else if (root.right == null && root.left != null) {
				root = root.left;
			} else if (root.left == null && root.right == null) {
				root = null;
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

	/**
	 * @param root   - node of the bst
	 *
	 * This method gives the inorder traversal of the BST
	 */
	private void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.val + " ");
		inOrderTraversal(root.right);
	}

	public String toString() {
		inOrderTraversal(tree);
		return "--End of tree--";
	}
}