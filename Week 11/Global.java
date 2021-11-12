package com.rit.assignment11B;

import java.util.ArrayList;
import java.util.List;

public class Global {
	public static void start(int threads, int lim) throws InterruptedException {
		try {

			int noOfThreads = threads;
			int limit = lim;

			List<PropertyCheckerGlobal> listofRunnables = new ArrayList<>();
			for (int i = 0; i < noOfThreads; i++) {
				int start = (limit / noOfThreads) * i;
				if (start == 0) {
					start += 1;
				}
				int end = (limit / noOfThreads) * (i + 1);
				if (i == noOfThreads - 1) {
					end = limit + 1;
				}
				PropertyCheckerGlobal obj = new PropertyCheckerGlobal(start, end);
				listofRunnables.add(i, obj);
			}
			List<Thread> listOfThreads = new ArrayList<>();
			for (PropertyCheckerGlobal obj : listofRunnables) {
				listOfThreads.add(new Thread(obj));
			}
			for (Thread thread : listOfThreads) {
				thread.start();
			}
			for (Thread thread : listOfThreads) {
				thread.join();
			}

			System.out.println(PropertyCheckerGlobal.numbers);

		} catch (InterruptedException e) {
			System.out.println("Exception occured " + e.getMessage());
		}
	}

}