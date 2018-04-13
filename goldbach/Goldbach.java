package goldbach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Lukas Keul
 *
 *         My solution for
 *         https://www.reddit.com/r/dailyprogrammer/comments/8bh8dh/20180411_challenge_356_intermediate_goldbachs/
 *
 */
public class Goldbach {

	static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param number
	 *            the highest number that can be in the primelist
	 * @return a list of primes
	 * @author Lukas Keul
	 */
	static List<Integer> getPrimes(int number) {
		List<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		for (int i = 3; i < number; i++) {
			if (isPrime(i)) {
				primeList.add(i);
			}
		}
		return primeList;
	}

	static int[] goldbach(int givenNumber) {
		List<Integer> primeList = getPrimes(givenNumber - 4);
		Collections.sort(primeList);
		Collections.reverse(primeList);

		int[] sumOfPrimes = new int[3];
		int indexOfAdditionalPrime = 0;

		while (sumOfPrimes[2] == 0) {
			for (int prime : primeList) {
				for (int i = primeList.size() - 1; i > 0; i--) {
					if (primeList.get(i) + prime == givenNumber - primeList.get(indexOfAdditionalPrime)) {
						sumOfPrimes[0] = prime;
						sumOfPrimes[1] = primeList.get(i);
						sumOfPrimes[2] = primeList.get(indexOfAdditionalPrime);
					}
				}
			}
			indexOfAdditionalPrime++;
		}
		return sumOfPrimes;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input;

		System.out.println("Give number: ");
		input = scanner.nextInt();

		System.out.println(Arrays.toString(goldbach(input)));
	}
}
