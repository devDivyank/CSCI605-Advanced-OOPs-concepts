/**
 * Filename - NearlyPerfectNumber.java
 * 
 * Problem Statement - To find nearly prime numbers from 2 -1000
 * 
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */

public class NearlyPerfectNumber {

	
	/**
	 * @param args - default main argument
	 * 
	 * The main method calls the subsequent methods for finding and displaying 
	 * nearly perfect numbers.
	 */
	public static void main(String args[]) {
		int totalSum = 0;
		String sumString = "";
		int limit = 1000;

		findNearlyPerfectNo(limit, totalSum, sumString);

	}

	/**
	 * @param limit     - upper limit for finding nearly perfect numbers
	 * @param sum       - addition of prime numbers i.e. nearly perfect number
	 * @param sumString - String of all the prime numbers that make up nearly
	 *                  perfect number.
	 * 
	 * This method finds nearly perfect numbers and add it to
	 *string for displaying
	 */
	public static void findNearlyPerfectNo(int limit, int sum, String sumString) 
	{
		for (int i = 2; i < limit; i++) {
			if (isPrime(i)) {
				// if prime, add it to the sum of primes
				sum = sum + i;
				if (sum < limit) {
					// if sum < 1000, print the sum
					sumString = concat(i, sumString);
					display(sum, sumString);
				} else {
					// if sum > 1000 we stop the function
					break;
				}
			}
		}
	}

	/**
	 * @param index - Number which is evaluated to be prime or not.
	 * @return      - true if index is prime else false
	 * 
	 * This method returns true if n is prime number
	 */
	public static boolean isPrime(int index) {
		for (int number = 2; number < index; number++) {
			if (index % number == 0)
				return false;
		}
		return true;
	}

	/**
	 * @param index - prime number between 2-1000
	 * @param str   - String of prime numbers that make up nearly perfect number
	 * @return      - String appended with index [prime number].
	 * 
	 * This method appends the prime numbers for displaying as output
	 */
	public static String concat(int index, String str) {
		return str.concat(String.valueOf(index) + " + ");
	}

	/**
	 * @param sum - addition of prime numbers i.e. nearly perfect number
	 * @param str - String of all the prime numbers that make up nearly perfect
	 *            number.
	 * 
	 * This method displays the output in expected format
	 */
	public static void display(int sum, String str) {
		int lastOccurance = str.lastIndexOf("+");
		str = str.substring(0, lastOccurance);
				System.out.println(sum + " is a nearly perfect number. " + 
		                           "[" + str + "]");

	}

}
