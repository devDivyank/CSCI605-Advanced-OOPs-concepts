package com.rit.hw.assignment7A;

/**
 * Filename - SortedStorageSetWithNulls.java
 *
 * Problem Statement - Implement a binary search tree that does not allow duplicates
 * 					   and stores null.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class SortedStorageSetWithNulls implements BinarySearchTree {

	public boolean flag = false;
	Node tree = null;
	int nullCount = 0;

	SortedStorageSetWithNulls(){
	}

	SortedStorageSetWithNulls(Node root) {
		this.tree = root;
	}

	/**
	 * @param val  - Value to find.
	 * @return  true if found else false
	 *
	 * This method calls findVal find a value in the tree.
	 */
	public boolean find(Object val) {
		return findVal(tree, val);
	}

	/**
	 * @param root - Node element of BST
	 * @param val  - Value to find.
	 * @return  true if found else false
	 *
	 * This method will find the value in the tree.
	 */
	public boolean findVal(Node root, Object val) {
		if (val == null){
			return nullCount != 0;
		}
		if (root == null) {
			return false;
		}
		if (root.val.equals(val)) {
			return true;
		}
		if (root.compareTo(val) == 0) {
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
	public boolean add(Object val) {
		if (val == null) {
			nullCount += 1;
			return true;
		}
		tree = addVal(tree, val);
		return flag;
	}

	/**
	 * @param root - Node element of BST
	 * @param val  - Value to find.
	 * @return root element
	 *
	 * This method is actual implementation for inserting in bst
	 */
	public Node addVal(Node root, Object val) {
		if (root == null) {
			root = new Node(val);
			flag = true;
			return root;
		} else if (root.compareTo(val) == 0) {
			root.left = addVal(root.left, val);
		} else if (root.compareTo(val) == 1) {
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
	public boolean delete(Object val) {
		if (val == null) {
			if (nullCount != 0){
				nullCount -= 1;
				return true;
			} else {
				return false;
			}
		}
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
	public Node deleteVal(Node root, Object val) {
		if (root == null) {
			flag = false;
			return root;
		} else if (!root.val.getClass().getSimpleName()
				.equals(val.getClass().getSimpleName())) {
			flag = false;
			return root;
		} else if (root.val.equals(val)) {
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
		} else if (root.compareTo(val) == 0) {
			root.left = deleteVal(root.left, val);
		} else if (root.compareTo(val) == 1) {
			root.right = deleteVal(root.right, val);
		}
		return root;
	}

	/**
	 * @return  true if null exists else false
	 *
	 *  This method tells us if null exists in the tree
	 */
	public boolean includesNull(){
		return (this.nullCount != 0);
	}

	/**
	 * @param root   - node of the bst
	 *
	 * This method gives the inorder traversal of the BST
	 */
	private void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	@Override
	public String toString() {
		preOrder(tree);
		if (nullCount != 0) {
			for (int i = 0; i < nullCount; i++) {
			}
		}
		return "null";
	}
}
