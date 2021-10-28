package com.rit.hw.assignment8B;

/**
 * Filename - BinarySearchTree.java
 *
 * BST interface which has been implemented in the SortedStorageSetWithNulls.java
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public interface BinarySearchTree<T> {

    boolean find(T val);

    boolean add(T val);

    boolean delete(T val);

    boolean includesNull();

}