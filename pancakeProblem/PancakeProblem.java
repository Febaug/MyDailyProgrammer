/**
 * 
 */
package pancakeProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lukas Keul
 * 
 *         My solution for
 *         https://www.reddit.com/r/dailyprogrammer/comments/82pt3h/20180307_challenge_353_intermediate/
 *
 */
public class PancakeProblem {

	/**
	 * Checks from bottom to top if the given array is sorted.
	 * 
	 * @param pancakes
	 * @return True, if the whole array is sorted. False, if at least one
	 *         element in the array is not sorted
	 * @author Lukas Keul
	 */
	private static boolean isSorted(int[] pancakes) {
		for (int i = pancakes.length - 1; i > -1; i--) {
			if (pancakes[i - 1] > pancakes[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param indexOfBiggestPancake
	 * @param pancakes
	 *            The (unsorted) array of the given pancakes(ints)
	 * @return The array with the reversed order till the indexOfBiggestPancakes
	 * @author Lukas Keul
	 */
	private static int[] flipPancakes(int indexOfBiggestPancake, int[] pancakes) {
		int j = indexOfBiggestPancake, temp = 0;

		for (int i = 0; i < j; i++) {
			temp = pancakes[i];
			pancakes[i] = pancakes[j];
			pancakes[j] = temp;
			j--;
		}
		return pancakes;
	}

	/**
	 * 
	 * @param highestIndex
	 *            The index of the last sorted element
	 * @param pancakes
	 *            The (unsorted) array of the given pancakes(ints)
	 * @return Returns the index of the biggest element till highestIndex
	 * @author Lukas Keul
	 */
	private static int getIndexOfBiggest(int highestIndex, int[] pancakes) {
		int highestNumber = 0, index = 0;

		for (int i = 0; i <= highestIndex; i++) {
			if (pancakes[i] > highestNumber) {
				highestNumber = pancakes[i];
				index = i;
			}
		}
		return index;
	}

	/**
	 * 
	 * @param pancakes
	 * @return Returns the sorted array
	 * @author Lukas Keul
	 */
	private static int[] sortPancakes(int[] pancakes) {
		int indexOfBiggestPancake, flips = 0;

		for (int onPlace = pancakes.length - 1; onPlace > 0; onPlace--) {
			indexOfBiggestPancake = getIndexOfBiggest(onPlace, pancakes);
			pancakes = flipPancakes(indexOfBiggestPancake, pancakes);
			pancakes = flipPancakes(onPlace, pancakes);
			flips += 2;
		}
		System.out.println("Flips: " + flips);
		return pancakes;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] pancakes;

		System.out.println("Amount of Pancakes: ");
		pancakes = new int[scanner.nextInt()];

		System.out.println("Pancakes:");
		for (int i = 0; i < pancakes.length; i++) {
			pancakes[i] = scanner.nextInt();
		}

		System.out.println(Arrays.toString(sortPancakes(pancakes)));
	}
}
