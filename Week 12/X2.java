package com.rit.assignment.C;

/**
 * Filename - X2.java
 * 
 * Problem Statement - Show different possible executions for below code.
 * 
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

public class X2 extends Thread    {
    static Object o = new Object();
    static int counter = 0;
    int id;
    public X2(int id)	{
        this.id = id;
        o       = new Object();
    }
    public void run () {
        if ( id == 0 )	{
            new X2(1).start();
            new X2(2).start();

            try {
                Thread.sleep(100);                  // thread 0 sleeps, either 1 or 2 goes in first
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
        new X2(0).start();
    }
}