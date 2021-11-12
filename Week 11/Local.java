package com.rit.assignment11B;

import java.util.ArrayList;
import java.util.List;

public class Local {
	public static void start(int threads, int lim) throws InterruptedException {
		try {

			int noOfThreads = threads;
			int limit = lim;
			List<String> strs = new ArrayList<>();

			List<PropertyCheckerLocal> listofRunnables = new ArrayList<>();
			for (int i = 0; i < noOfThreads; i++) {
				int start = (limit / noOfThreads) * i;
				if (start == 0) {
					start += 1;
				}
				int end = (limit / noOfThreads) * (i + 1);
				if (i == noOfThreads - 1) {
					end = limit + 1;
				}
				PropertyCheckerLocal obj = new PropertyCheckerLocal(start, end);
				listofRunnables.add(i, obj);
			}
			List<Thread> listOfThreads = new ArrayList<>();
			for (PropertyCheckerLocal obj : listofRunnables) {
				listOfThreads.add(new Thread(obj));
			}
			for (Thread thread : listOfThreads) {
				thread.start();
			}
			for (Thread thread : listOfThreads) {
				thread.join();
			}

			for (PropertyCheckerLocal ele : listofRunnables) {
				strs.addAll(ele.stringRep);
			}
			for (String str : strs) {
				System.out.println(str);
			}

			for (PropertyCheckerLocal ele : listofRunnables) {
				System.out.println("Thread: " + ele.numbers);
			}

		} catch (InterruptedException e) {
			System.out.println("Exception occured " + e.getMessage());
		}
	}
}
