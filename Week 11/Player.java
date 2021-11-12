package com.rit.assignment11.C;

public class Player implements Runnable {
	private int noOfMarbles;
	static Marble marbleObj = new Marble();

	public int getMarbleCount() {
		return this.noOfMarbles;
	}

	/** This method simulates a player grabbing an marble and increments 
	 *  the marble count of the player.
	 *    
	 * @throws InterruptedException
	 */
	public void grabMarble() throws InterruptedException {
		try {
			
			Thread.sleep((int) (10 * Math.random()));
			this.noOfMarbles += (marbleObj.grabMarble() ? 1 : 0);
			
		} catch (InterruptedException e) {
			System.out.println("Exception occured " + e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			grabMarble();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
