package com.rit.assignment.C;

/**
 * Filename - X3.java
 * 
 * Problem Statement - Show different possible executions for below code.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

public class X3 extends Thread    {
    static Object o = new Object();
    static int counter = 0;
    int id;
    public X3(int id)	{
        this.id = id;
        o       = new Object();
    }
    public void run () {
        if ( id == 0 )	{
            new X3(1).start();

            try {
                Thread.sleep(100);                  // thread 0 sleeps and thread 1 goes in first
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new X3(2).start();

            try {
                Thread.sleep(100);                  // thread 0 sleeps again and thread 2 goes in after thread 1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized ( o ) {
            try {
                System.err.println(id + " --->");
                o.notifyAll();
                o.wait();
                o.notifyAll();
                System.err.println(id + " <---");
            }
            catch (  InterruptedException e ) {
            }
        }
    }
    public static void main (String args []) {
        new X3(0).start();
    }
}