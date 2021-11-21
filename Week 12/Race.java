package com.rit.assignment.C;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race implements Runnable {
	ArrayList<Runner> runners = new ArrayList<>();
	final int noOfRaces;

	public Race(int noOfRaces) {
		this.noOfRaces = noOfRaces;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.noOfRaces; i++) {
			ExecutorService runnersStart = Executors.
					newFixedThreadPool(runners.size());
			System.out.println("New Race (race# = " + (i + 1) + ")"); 
			for (Runner runner : this.runners) {
				runnersStart.execute(runner);
			}
			runnersStart.shutdown();
			try {
				Thread.sleep(100 * runners.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
