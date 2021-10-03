package com.practice.abhijeet;
/**
 * Filename - SortedStorageSetWithNulls.java
 * 
 * Problem Statement - Variation of BST from SortedStorage that behaves as a set and
 * 					   allows addition and deletion of null.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class SortedStorageSetWithNulls extends SortedStorageSet{

	static int nullCount = 0;

	/**
	 * @param root - Node element of BST
	 * @param val  - Value to find
	 * @return  true if found else false
	 * 
	 * This method find the value in the tree
	 */
	@Override
	public boolean findVal(Node root, String val) {
		if (val == null){
			return nullCount != 0;
		}
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
	@Override
	public boolean add(String val) {
		if (val == null) {
			nullCount += 1;
			return true;
			}
		tree = addVal(tree, val);
		return flag;
	}

	/**
	 * @param val  - Value to delete.
     * @return  true if found else false
     * 
     * This method deletes value from bst
	 */
	public boolean delete(String val) {
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
}