package com.rit.hw.assignment7A;

/**
 * Filename - Node.java
 *
 * Node class used to create Node objects in a BST.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Node implements Comparable{

    Object val;
    Node left;
    Node right;

    public Node(Object val){
        this.val = val;
    }

    @Override
    public int compareTo(Object val) {
        if (val.getClass().getSimpleName().equals(this.val.getClass().getSimpleName())) {
            if (((LivingThing) val).age > ((LivingThing) this.val).age) {
                return 1;
            } else if (((LivingThing) val).age < ((LivingThing) this.val).age) {
                return 0;
            }
        }
        return -1;
    }
}
