package com.rit.hw.assignment7A;
/**
 * Filename - Test.java
 *
 * Test program to test the SortedStorageSetWithNulls.java program.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Test {


	public static void testFishTree(){

		LivingThing lt1 = new LivingThing(5);
		Fish f1 = new Fish(5);
		Fish f2 = new Fish(6);
		Mouse m1 = new Mouse(8);
		Ant a1 = new Ant(4);
		Mouse m2 = new Mouse(6);
		Ant a2 = new Ant(3);

		SortedStorageSetWithNulls treeFish = new SortedStorageSetWithNulls();
		System.out.println("1. " + treeFish.add(f1));      // true
		System.out.println("2. " + treeFish.add(f2));      // true
		System.out.println("3. " + treeFish.add(f2));      // false
		System.out.println("4. " + treeFish.add(lt1));     // false
		System.out.println("5. " + treeFish.add(m1));     // false
		System.out.println("6. " + treeFish.add(a1));     // false
		System.out.println("7. " + treeFish.add(null));    // true
		System.out.println("8. " + treeFish.delete(null));    // true
		System.out.println("9. " + treeFish.delete(null));    // false
		System.out.println("10. " + treeFish.delete(f1));      // true
		System.out.println("11. " + treeFish.delete(f1));      // false
		System.out.println("12. " + treeFish.delete(f2));      // true
	}

	public static void testLivingThingTree(){

		LivingThing lt1 = new LivingThing(5);
		Fish f1 = new Fish(5);
		Mouse m1 = new Mouse(8);
		Ant a1 = new Ant(4);

		SortedStorageSetWithNulls treeLivingThing = new SortedStorageSetWithNulls();
		System.out.println("1. " + treeLivingThing.add(lt1));      // true
		System.out.println("2. " + treeLivingThing.add(f1));      // false
		System.out.println("3. " + treeLivingThing.add(lt1));     // false
		System.out.println("4. " + treeLivingThing.add(m1));     // false
		System.out.println("5. " + treeLivingThing.add(a1));     // false
		System.out.println("6. " + treeLivingThing.add(null));    // true
		System.out.println("7. " + treeLivingThing.delete(null));    // true
		System.out.println("8. " + treeLivingThing.delete(lt1));      // true
		System.out.println("9. " + treeLivingThing.delete(lt1));      // false
	}

	public static void testMouseTree(){

		LivingThing lt1 = new LivingThing(5);
		Fish f1 = new Fish(5);
		Mouse m1 = new Mouse(8);
		Ant a1 = new Ant(4);

		SortedStorageSetWithNulls treeMouse = new SortedStorageSetWithNulls();
		System.out.println("1. " + treeMouse.add(m1));      // true
		System.out.println("2. " + treeMouse.add(m1));      // false
		System.out.println("3. " + treeMouse.add(f1));      // false
		System.out.println("4. " + treeMouse.add(lt1));     // false
		System.out.println("5. " + treeMouse.add(a1));     // false
		System.out.println("6. " + treeMouse.add(null));    // true
		System.out.println("7. " + treeMouse.delete(null));    // true
		System.out.println("8. " + treeMouse.delete(m1));      // true
		System.out.println("9. " + treeMouse.delete(m1));      // false
	}

	public static void testAntTree(){

		LivingThing lt1 = new LivingThing(5);
		Fish f1 = new Fish(5);
		Mouse m1 = new Mouse(8);
		Ant a1 = new Ant(4);

		SortedStorageSetWithNulls treeMouse = new SortedStorageSetWithNulls();
		System.out.println("1. " + treeMouse.add(a1));      // true
		System.out.println("2. " + treeMouse.add(m1));      // false
		System.out.println("3. " + treeMouse.add(f1));      // false
		System.out.println("4. " + treeMouse.add(lt1));     // false
		System.out.println("5. " + treeMouse.add(a1));     // false
		System.out.println("6. " + treeMouse.add(null));    // true
		System.out.println("7. " + treeMouse.delete(null));    // true
		System.out.println("8. " + treeMouse.delete(a1));      // true
		System.out.println("9. " + treeMouse.delete(a1));      // false
	}


	public static void main(String[] args )	{

		testLivingThingTree();
//		testFishTree();
//		testMouseTree();
//		testAntTree();

	}
}
