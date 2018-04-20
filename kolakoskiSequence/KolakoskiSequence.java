package kolakoskiSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KolakoskiSequence {

	/**
	 * 
	 * @param sequence
	 *            A list of 1s and 2s.
	 * @param length
	 *            The maximal length the list is being looked at.
	 * @return Returns a String "amount of 1s : amount of 2s"
	 * 
	 */
	private static String getAmountOfNumbers(List<Integer> sequence, int length) {
		int one = 0, two = 0;
		for (int i = 0; i < length; i++) {
			if (sequence.get(i) == 1) {
				one++;
			}
			else {
				two++;
			}
		}
		return new String(one + " : " + two);
	}

	/**
	 * 
	 * @param length
	 *            The wanted length of the sequence
	 * @return Returns a list of the Kolakoski-sequence with a length of
	 *         'length'.
	 * 
	 */
	private static List<Integer> createSequence(int length) {
		List<Integer> sequence = new ArrayList<Integer>();
		sequence.add(1);
		sequence.add(2);
		sequence.add(2);

		for (int i = 1; i < length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < sequence.get(i - 1); j++) {
					sequence.add(2);
				}
			}
			else {
				for (int j = 0; j < sequence.get(i - 1); j++) {
					sequence.add(1);
				}
			}
		}
		return sequence;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length;

		System.out.println("Length of String: ");
		length = scanner.nextInt();

		System.out.println(getAmountOfNumbers(createSequence(length), length));
	}
}
