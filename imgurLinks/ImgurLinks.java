/**
 * 
 */
package imgurLinks;

import java.util.Scanner;

/**
 * @author Lukas Keul
 * 
 *         My solution for
 *         https://www.reddit.com/r/dailyprogrammer/comments/7yyt8e/20180220_challenge_352_easy_making_imgurstyle/
 *
 */
public class ImgurLinks {

	/**
	 * Reverses the given array by exchanging the first and the last element and
	 * then increases(first element) and decreases(last element) the used index
	 * by one till both are the same.
	 * 
	 * @param array
	 * @return Returns the reversed array
	 * @author Lukas Keul
	 */
	static char[] reverseArray(char[] array) {
		char temp;
		int index = array.length - 1;
		for (int i = 0; i < array.length / 2; i++) {
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
			index--;
		}

		return array;
	}

	/**
	 * 
	 * @param input
	 *            The ID that should be converted to make it shorter
	 * @return Returns the ID in Base62
	 * @author Lukas Keul
	 */
	static String createID(long input) {
		String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] output;
		int power, n = 0;

		while (Math.pow(alphabet.length(), n) < input) {
			n++;
		}
		output = new char[n];
		power = n - 1;

		for (int i = 0; i < output.length; i++) {
			output[i] = alphabet.charAt((int) Math.floorDiv(input, (long) Math.pow(alphabet.length(), power)));
			input = input % (long) Math.pow(alphabet.length(), power);
			power--;

		}

		return String.valueOf(reverseArray(output));
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		long input = 0;

		System.out.println("Input:");
		input = scanner.nextLong();

		System.out.println(createID(input));
	}
}
