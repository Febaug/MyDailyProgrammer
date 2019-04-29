/**
 * 
 */
package perfectlybalanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lukas Keul
 * 
 *         My solution for
 *         https://old.reddit.com/r/dailyprogrammer/comments/afxxca/20190114_challenge_372_easy_perfectly_balanced/
 *
 */
public class PerfectlyBalanced {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;

		System.out.println("Enter your string: ");
		input = scanner.nextLine();

		isBalancedBonus(input);
	}

	/**
	 * 
	 * Checks if a string consisting of two different chars has the same amount
	 * of both chars.
	 * 
	 * @param input
	 * @author Lukas Keul
	 */
	private static void isBalanced(String input) {
		char firstChar = input.charAt(0);
		int count = 0;
		boolean balanced = true;

		for (char c : input.toCharArray()) {
			if (c != firstChar) {
				count--;
			}
			else {
				count++;
			}
		}

		if (count != 0) {
			balanced = false;
		}
		output(balanced);
	}

	/**
	 * Checks if a string consisting of n chars has the same amount of every
	 * char.
	 * 
	 * @param input
	 * @author Lukas Keul
	 */
	private static void isBalancedBonus(String input) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int amountOfElements, temp;
		boolean bool = true;

		for (Character c : input.toCharArray()) {
			if (map.containsKey(c)) {
				temp = (int) map.get(c);
				temp++;
				map.put(c, temp);
			}
			else {
				map.put(c, 1);
			}
		}
		amountOfElements = (int) map.get(input.charAt(0));

		for (Integer value : map.values()) {
			if (!value.equals(amountOfElements)) {
				bool = false;
				break;
			}
		}
		output(bool);
	}

	private static void output(boolean bool) {
		if (bool) {
			System.out.println("True. String is balanced");
		}
		else {
			System.out.println("False. String is not balanced");

		}
	}
}
