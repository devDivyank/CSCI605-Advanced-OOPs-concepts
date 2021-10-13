package com.rit.hw61.updated;
/**
 * Filename - BinarySearchTree.java
 *
 * BST interface which has been implemented in the SortedStorageSetWithNulls.java
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public interface BinarySearchTree {

    boolean find(Object val);

    boolean add(Object val);

    boolean delete(Object val);

    boolean includesNull();

}
