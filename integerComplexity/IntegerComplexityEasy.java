/**
 * 
 */
package integerComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lukas Keul
 * 
 *         My solution for
 *         https://www.reddit.com/r/dailyprogrammer/comments/83uvey/20180312_challenge_354_easy_integer_complexity_1/
 *
 */
public class IntegerComplexityEasy {

	private static List<List<Long>> getFactorials(long givenNumber) {
		List<List<Long>> factorials = new ArrayList<List<Long>>();

		for (long i = 1; i < givenNumber / i; i++) {
			for (long j = givenNumber; j > i; j--) {
				if (i * j == givenNumber) {
					List<Long> innerList = new ArrayList<Long>();
					innerList.add(i);
					innerList.add(j);
					factorials.add(innerList);
					break;
				}
			}
		}
		return factorials;
	}

	private static long getSmallestSum(List<List<Long>> factorials, long givenNumber) {
		long smallestSum = givenNumber + 2;
		for (List<Long> list : factorials) {
			if (list.get(0) + list.get(1) < smallestSum) {
				smallestSum = list.get(0) + list.get(1);
			}
		}
		return smallestSum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long givenNumber;

		System.out.println("Number to factorize:");
		givenNumber = scanner.nextLong();

		// System.out.println(getFactorials(givenNumber));
		System.out.println(getSmallestSum(getFactorials(givenNumber), givenNumber));
	}
}
