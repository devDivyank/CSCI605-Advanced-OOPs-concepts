package com.rit.hw61.updated;
/**
 * Filename - Node.java
 *
 * Node class used to create Node objects in a BST.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Node implements Comparable<Object>{

    Object val;
    Node left;
    Node right;

    public Node(Object val){
        this.val = val;
    }

    @Override
    public int compareTo(Object val) {
        if (val instanceof Long && this.val instanceof Long){
            if (Long.parseLong(String.valueOf(val)) > Long.parseLong(String.valueOf(this.val))){
                return 1;
            } else if (Long.parseLong(String.valueOf(val)) < Long.parseLong(String.valueOf(this.val))){
                return 0;
            }
        } else if (val instanceof Integer && this.val instanceof Integer){
            if (Integer.parseInt(String.valueOf(val)) > Integer.parseInt(String.valueOf(this.val))){
                return 1;
            } else if (Integer.parseInt(String.valueOf(val)) < Integer.parseInt(String.valueOf(this.val))){
                return 0;
            }
        } else if (val instanceof String && this.val instanceof String){
            if (Long.parseLong(String.valueOf(val)) > Long.parseLong(String.valueOf(this.val))){
                return 1;
            } else if (Long.parseLong(String.valueOf(val)) < Long.parseLong(String.valueOf(this.val))){
                return 0;
            }
        }
        return -1;
    }

}
