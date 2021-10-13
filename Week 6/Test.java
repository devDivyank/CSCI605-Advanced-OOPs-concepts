package com.rit.hw61.updated;

public class Test {

	public static void testIt(Comparable[] toInsert) {

		SortedStorageSetWithNulls aStorage = new SortedStorageSetWithNulls();

		if (!aStorage.add(toInsert[0])) {
			System.out.println(toInsert[0] + ":	add failed");
		}
		if (aStorage.add(toInsert[1])) {
			System.out.println(toInsert[1] + ":	add failed");
		}
		if (!aStorage.add(toInsert[2])) {
			System.out.println(toInsert[2] + ":	add failed");
		}
		if (!aStorage.find(toInsert[1])) {
			System.out.println(toInsert[1] + ":	not found");
		}
		if (!aStorage.add(toInsert[3])) {
			System.out.println(toInsert[3] + ":	add failed");
		}
		if (!aStorage.add(toInsert[4])) {
			System.out.println(toInsert[4] + ":	add failed");
		}
		if (!aStorage.delete(toInsert[3])) {
			System.out.println(toInsert[3] + ":	delete failed");
		}
		if (!aStorage.add(toInsert[5])) {
			System.out.println(toInsert[5] + ":	add failed **");
		}
	}

	public static void testItWithNulls() {

		SortedStorageSetWithNulls aStorage = new SortedStorageSetWithNulls();

		if (!aStorage.add(null)) {
			System.out.println("null:	add failed");
		}
		if (!aStorage.includesNull()) {
			System.out.println("false, does not includes Null");
		}
		if (!aStorage.add(null)) {
			System.out.println("null:	add failed");
		}
		if (!aStorage.delete(null)) {
			System.out.println("null :	delete failed");
		}
		if (!aStorage.delete(null)) {
			System.out.println("null :	delete failed");
		}
		if (aStorage.delete(null)) {
			System.out.println("null :	delete failed");
		}
		if (aStorage.includesNull()) {
			System.out.println("false, does not includes Null");
		}

	}

	public static void main(String args[]) {
		String strings[] = { "3", "3", "4", "8", "1", "8" };
		testIt(strings);
		Long longs[] = { Long.valueOf(3), Long.valueOf(3), Long.valueOf(4), Long.valueOf(8), Long.valueOf(1),
				Long.valueOf(8) };
		testIt(longs);
		Integer ints[] = { Integer.valueOf(3), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(8),
				Integer.valueOf(1), Integer.valueOf(8) };
		testIt(ints);
		testItWithNulls();
	}
}
