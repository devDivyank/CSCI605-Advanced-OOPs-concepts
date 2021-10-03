package com.practice.abhijeet;
/**
 * Filename - SortedStorageSet.java
 *
 * Problem Statement - Variation of BST from SortedStorage that behaves
 *                     as a set (no duplicates).
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */
public class SortedStorageSet extends SortedStorage{

    /**
     * @param root - Node element of BST
     * @param val  - Value to find.
     * @return root element
     *
     * This method actual implementation for inserting in bst
     */
    @Override
    public Node addVal(Node root, String val) {
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
     * @param val    - value to be deleted
     * @return       - all characters that player has guessed correctly
     *
     * This method deletes a value from bst if present.
     */
    @Override
    public Node deleteVal(Node root, String val) {
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
