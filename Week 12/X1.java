package com.rit.assignment.C;

/**
 * Filename - X1.java
 * 
 * Problem Statement - Show different possible executions for below code.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

public class X1 extends Thread    {
    static Object o = new Object();
    static int counter = 0;
    int id;
    public X1(int id)	{
        this.id = id;
        o       = new Object();
    }
    public void run () {
        if ( id == 0 )	{
            new X1(1).start();

            try {
                Thread.sleep(1);                  // thread 0 sleeps and thread 1 goes in first
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new X1(2).start();                       // either thread 0 or 2 can go in after thread 1
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
        new X1(0).start();
    }
}