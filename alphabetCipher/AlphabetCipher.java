/**
 * 
 */
package alphabetCipher;

import java.util.Scanner;

/**
 * @author Lukas Keul
 * 
 *         My solution for
 *         https://www.reddit.com/r/dailyprogrammer/comments/879u8b/20180326_challenge_355_easy_alphabet_cipher/
 *
 */
public class AlphabetCipher {

	static String alphabet = "abcdefghijklmnopqrstuvwxyz";

	/**
	 * 
	 * @param keyword
	 * @param message
	 * @return Encrypts the given message with the given keyword by using the
	 *         alphabet cipher
	 * @author Lukas Keul
	 */
	private static char[] encrypt(String keyword, String message) {
		char[] encryptedMessage = new char[message.length()];
		int newLetter;

		for (int i = 0; i < message.length(); i++) {
			newLetter = alphabet.indexOf(message.charAt(i)) + alphabet.indexOf(keyword.charAt(i % keyword.length()));
			encryptedMessage[i] = alphabet.charAt(newLetter % alphabet.length());
		}

		return encryptedMessage;
	}

	/**
	 * 
	 * @param keyword
	 * @param message
	 * @return Decrypts the given message with the given keyword by using the
	 *         alphabet cipher
	 * @author Lukas Keul
	 */
	private static char[] decrypt(String keyword, String message) {
		char[] decryptedMessage = new char[message.length()];
		int newLetter;

		for (int i = 0; i < message.length(); i++) {
			newLetter = alphabet.indexOf(message.charAt(i)) - alphabet.indexOf(keyword.charAt(i % keyword.length()));
			if (newLetter < 0) {
				newLetter += alphabet.length();
			}

			decryptedMessage[i] = alphabet.charAt(newLetter % alphabet.length());
		}
		return decryptedMessage;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String keyword, message, mode;

		System.out.println("Keyword:");
		keyword = scanner.nextLine();

		System.out.println("Message:");
		message = scanner.nextLine();

		System.out.println("Decrypt or encrypt?");
		mode = scanner.nextLine();

		if (mode.equals("decrypt")) {
			System.out.println(decrypt(keyword, message));
		}
		else if (mode.equals("encrypt")) {
			System.out.println(encrypt(keyword, message));
		}
		else {
			System.out.println("Wrong input!");
		}

	}
}
