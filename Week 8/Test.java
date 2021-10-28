package com.rit.hw.assignment8B;

import java.util.Date;

public class Test {
	public static void testHumanTree(){
		Human divyank = new Human(new Date(), "Divyank", "Kulshresth");
		Human abhijeet = new Human(new Date(), "Abhijeet", "Mulik");
		MusicLP music1 = new MusicLP(1997, "Divyank", "HousePartyProtocol", 6.4f, 8);
		Address address1 = new Address(16, "River Meadow", "Rochester",
				"New York", 14623);

		SortedStorageSetWithNulls<Human> humanTree = new SortedStorageSetWithNulls<>();
		System.out.println("1. " + humanTree.add(divyank));      // true
		System.out.println("2. " + humanTree.add(abhijeet));      // true
		System.out.println("3. " + humanTree.add(abhijeet));      // false
		//System.out.println(humanTree.add(music1));     // compilation error
		//System.out.println(humanTree.add(address1));     // compilation error
		System.out.println("4. " + humanTree.add(null));    // true
		System.out.println("5. " + humanTree.delete(null));    // true
		System.out.println("6. " + humanTree.delete(null));    // false
		System.out.println("7. " + humanTree.delete(divyank));      // true
		System.out.println("8. " + humanTree.delete(divyank));      // false
		System.out.println("9. " + humanTree.delete(abhijeet));      // true
	}

	public static void testMusicTree(){
		MusicLP music1 = new MusicLP(1997, "Divyank", "HousePartyProtocol", 6.4f, 8);
		MusicLP music2 = new MusicLP(1998, "Nimisha", "The Neighbourhood", 16.28f, 7);
		Address address1 = new Address(16, "River Meadow", "Rochester",
												"New York", 14623);
		Human abhijeet = new Human(new Date(), "Abhijeet", "Mulik");

		SortedStorageSetWithNulls<MusicLP> musicTree = new SortedStorageSetWithNulls<>();
		System.out.println("1. " + musicTree.add(music1));      // true
		System.out.println("2. " + musicTree.add(music2));      // true
		System.out.println("3. " + musicTree.add(music1));      // false
		//System.out.println(humanTree.add(address1));     // compilation error
		//System.out.println(humanTree.add(abhijeet));     // compilation error
		System.out.println("4. " + musicTree.add(null));    // true
		System.out.println("5. " + musicTree.delete(null));    // true
		System.out.println("6. " + musicTree.delete(null));    // false
		System.out.println("7. " + musicTree.delete(music1));      // true
		System.out.println("8. " + musicTree.delete(music1));      // false
		System.out.println("9. " + musicTree.delete(music2));      // true
	}

	public static void testAddressTree(){
		Address address1 = new Address(16, "River Meadow", "Rochester",
				"New York", 14623);
		Address address2 = new Address(16, "River Meadow", "Rochester",
				"Minnesota", 55901);
		Human divyank = new Human(new Date(), "Divyank", "Kulshresth");
		MusicLP music2 = new MusicLP(1998, "Nimisha", "The Neighbourhood", 16.28f, 7);

		SortedStorageSetWithNulls<Address> musicTree = new SortedStorageSetWithNulls<>();
		System.out.println("1. " + musicTree.add(address1));      // true
		System.out.println("2. " + musicTree.add(address2));      // true
		System.out.println("3. " + musicTree.add(address1));      // false
		//System.out.println(humanTree.add(divyank));     			// compilation error
		//System.out.println(humanTree.add(music2));     			// compilation error
		System.out.println("4. " + musicTree.add(null));    	// true
		System.out.println("5. " + musicTree.delete(null));    // true
		System.out.println("6. " + musicTree.delete(null));    // false
		System.out.println("7. " + musicTree.delete(address1));      // true
		System.out.println("8. " + musicTree.delete(address1));      // false
		System.out.println("9. " + musicTree.delete(address2));      // true
	}

	public static void main(String args[] )	{
		testHumanTree();
//		testMusicTree();
//		testAddressTree();
	}
}
