/**
 * 
 */
package integerComplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lukas Keul
 *
 */
public class IntegerComplexityMedium {
	private static List<List<Integer>> getFactorials(int givenNumber, List<Integer> primeList) {
		List<List<Integer>> factorials = new ArrayList<List<Integer>>();

		for (int i = 1; i < Math.sqrt(givenNumber); i++) {
			for (int j = givenNumber; j > i; j--) {
				if (primeList.contains(j)) {
					List<Integer> innerList = new ArrayList<Integer>();
					innerList.add(i);
					innerList.add(j);
					factorials.add(innerList);
					break;
				}
			}
		}
		return factorials;
	}

	private static List<Integer> getSmallestSum(List<List<Integer>> factorials, int givenNumber) {
		List<Integer> smallestFactors = new ArrayList<Integer>();
		long smallestSum = givenNumber + 2;
		for (List<Integer> list : factorials) {
			if (list.get(0) + list.get(1) < smallestSum) {
				smallestSum = list.get(0) + list.get(1);
				smallestFactors = list;

			}
		}
		return smallestFactors;
	}

	private static List<Integer> getPrimeList() {
		List<Integer> primeList = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[1000];

		Arrays.fill(isPrime, true);
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primeList.add(i);
			}
		}

		return primeList;
	}

	private static List<Integer> getSmallestFactorials(int givenNumber) {
		List<Integer> factorials = new ArrayList<Integer>();

		if (givenNumber == 1) {
			factorials.add(givenNumber);
		}
		while (givenNumber != 1) {
			if (givenNumber % 3 == 0) {
				factorials.add(3);
				givenNumber /= 3;
			}
			else if (givenNumber % 4 == 0) {
				factorials.add(4);
				givenNumber /= 4;
			}
			else if (givenNumber % 2 == 0) {
				factorials.add(2);
				givenNumber /= 2;
			}
			else {
				factorials.add(1);
				givenNumber -= 1;
			}
		}

		return factorials;
	}

	private static int getSum(List<Integer> factorials, int givenNumber) {
		int smallestSum = 0;
		for (int n : factorials) {
			smallestSum += n;
		}
		return smallestSum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sumOfAll = 0;

		// System.out.println("Number to factorize:");
		// givenNumber = scanner.nextInt();

		// System.out.println(getFactorials(givenNumber));
		for (int i = 1; i < 1001; i++) {
			System.out.print("Für " + i + ": ");
			System.out.println(getSum(getFactorials(i), i));
			sumOfAll += getSum(getFactorials(i), i);
		}
		System.out.println(sumOfAll);
	}
}
