package com.rit.assignment11.C;

public class Marble {
	Boolean marble = false;

	public void generateMarble() {
		this.marble = true;
	}

	/**
	 * This function will remove the marble from the plate.
	 * 
	 * @return true/false 
	 */
	public synchronized Boolean grabMarble() {
		if (this.marble) {
			this.marble = false;
			return true;
		} else {
			return false;
		}
	}
}
