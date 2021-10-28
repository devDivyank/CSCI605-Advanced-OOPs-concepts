/**
 * Filename - ListClass.java
 *
 * Problem Statement - Declare a ListClass which can store Line, Square, Cube, 3DCube
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

import java.util.ArrayList;

public class ListClass<T extends Line>{
	private int size;
	private T firstObj;
	ArrayList<T> list = new ArrayList<>();

	/**
	 * @param t  - object to add
	 * @return None
	 *
	 * This method adds objects of one type to a ClassList object.
	 */
	// store objects of only one kind of the above classes
	public void addSameType(T t) {
		if (this.size == 0) {
			this.firstObj = t;
			this.list.add(t);
			System.out.println(t.toString() + " added successfully!");
			this.size += 1;
		} else {
			if (t.getClass().getSimpleName().equals(this.firstObj.getClass().getSimpleName())){
				this.list.add(t);
				System.out.println(t.toString() + " added successfully!");
			} else {
				System.out.println(t.toString() + " can't be added to this list!");
			}
		}
	}

	/**
	 * @param t  - object to add
	 * @return None
	 *
	 * This method adds objects of all four types to a ClassList object.
	 */
	// Can store object of the following class: Line, Square, Cube, 3dCube
	public void addAnyType(T t) {
		this.list.add(t);
		System.out.println(t.toString() + " added successfully!");
	}

	/**
	 * @return None
	 *
	 * This method prints the elements of ClassList object.
	 */
	// method named print which prints the elements of the list
	public void print() {
		System.out.println("Printing the list...");
		for(T cb : this.list) {
			System.out.print(" " + cb.toString() + " ");
		}
		System.out.println();
	}

	/**
	 * @param t  - ListClass object
	 * @return None
	 *
	 * This method accepts ListClass of type Cube and DCube.
	 */
	// method named sum which accepts as argument a list of Cubes and 3dCubes
	public static void sum1(ListClass<? extends Cube> t) {
		System.out.println("In sum1 method now... List of Cube and 3DCube objects");
		t.print();
		System.out.println();
	}

	/**
	 * @param t  - ListClass object
	 * @return None
	 *
	 * This method accepts ListClass of type Square and Line.
	 */
	// method named sum which accepts as argument a list of Lines and Squares
	public static void sum2(ListClass<? super Square> t) {
		System.out.println("In sum2 method now... List of Line and Square objects");
		t.print();
		System.out.println();
	}

}
