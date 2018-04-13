/**
 * 
 */
package pancakeProblem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lukas Keul
 *
 */
public class PancakeProblem {

	static boolean isSorted(int[] pancakes) {
		for (int i = 1; i < pancakes.length; i++) {
			if (pancakes[i] < pancakes[i - 1]) {
				return false;
			}
		}
		return true;
	}

	static int[] flipPancakes(int indexOfPancake, int sizeSorted, int[] pancakes) {
		int swapIndex = indexOfPancake;
		if (indexOfPancake == 0) {
			swapIndex = sizeSorted - 1;
		}
		int temp;
		for (int i = 0; i <= indexOfPancake; i++) {
			if (i == swapIndex) {
				break;
			}
			temp = pancakes[i];
			pancakes[i] = pancakes[swapIndex];
			pancakes[swapIndex] = temp;
			swapIndex--;
		}
		return pancakes;
	}

	static int[] sortPancakes(int[] pancakes) {
		int sizeSorted = pancakes.length;
		while (!isSorted(pancakes)) {
			int biggestPancake = 0;
			int pancakeIndex = 0;

			for (int i = 0; i < sizeSorted; i++) {
				if (pancakes[i] > biggestPancake) {
					biggestPancake = pancakes[i];
					pancakeIndex = i;
				}
			}
			pancakes = flipPancakes(pancakeIndex, sizeSorted, pancakes);

			// sizeSorted--;
		}

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
			// System.out.println(listOfStrings[i] + " bla");
		}

		System.out.println(Arrays.toString(sortPancakes(pancakes)));
	}
}
