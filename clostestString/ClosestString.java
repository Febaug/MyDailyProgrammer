/**
 * 
 */
package clostestString;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lukas Keul
 * 
 *         My solution for
 *         https://www.reddit.com/r/dailyprogrammer/comments/826coe/20180305_challenge_353_easy_closest_string/
 *
 */
public class ClosestString {

	/**
	 * 
	 * @param stringOne
	 * @param stringTwo
	 * @return returns the Hamming distance between the two given Strings
	 * @author Lukas Keul
	 */
	private static int getHammingDistance(String stringOne, String stringTwo) {
		int hammingDistance = 0;
		for (int i = 0; i < stringOne.length(); i++) {
			if (stringOne.charAt(i) != stringTwo.charAt(i)) {
				hammingDistance++;
			}
		}
		return hammingDistance;
	}

	/**
	 * 
	 * @param arrayOfStrings
	 *            An array of different Strings
	 * @return Returns a list in which the Hamming distance between every given
	 *         two Strings has been calculated
	 * @author Lukas Keul
	 */
	private static Map<String, Integer> createListOfDistances(String[] arrayOfStrings) {
		int distance;

		Map<String, Integer> listOfDistances = new HashMap<String, Integer>();
		for (String string : arrayOfStrings) {
			distance = 0;
			for (String otherStrings : arrayOfStrings) {
				if (string.equals(otherStrings)) {
					continue;
				}
				distance += getHammingDistance(string, otherStrings);
			}
			listOfDistances.put(string, distance);
		}
		return listOfDistances;
	}

	/**
	 * 
	 * @param arrayOfStrings
	 *            An array of different Strings
	 * @return Returns the String with the smallest Hamming distance to every
	 *         other String
	 * @author Lukas Keul
	 */
	private static String getClosestString(String[] arrayOfStrings) {
		int minDistance = Integer.MAX_VALUE;
		String closestString = null;
		Map<String, Integer> listOfDistances = new HashMap<String, Integer>();

		listOfDistances = createListOfDistances(arrayOfStrings);

		for (String string : arrayOfStrings) {
			if (listOfDistances.get(string) < minDistance) {
				minDistance = listOfDistances.get(string);
				closestString = string;
			}
		}
		return closestString;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] listOfStrings;

		System.out.println("Amount of Strings: ");
		listOfStrings = new String[scanner.nextInt()];

		System.out.println("Strings:");
		for (int i = 0; i < listOfStrings.length; i++) {
			listOfStrings[i] = scanner.next();
		}

		System.out.println("Closest String: " + getClosestString(listOfStrings));
	}
}
