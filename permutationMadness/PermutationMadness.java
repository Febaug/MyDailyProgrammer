package permutationMadness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lukas Keul
 * 
 *         My solution for
 *         https://www.reddit.com/r/dailyprogrammer/comments/7xkhar/20180214_challenge_351_intermediate_permutation/
 *
 */
public class PermutationMadness {
	
	/**
	 * 
	 * @param toSpin
	 *            The string in which elements should be spinned
	 * @param amount
	 *            The amount of elements that should be spinned
	 * @return Returns a modified version of 'toSpin' in which the last 'amount'
	 *         elements are set to the front of the string.
	 * @author Lukas Keul
	 */
	private static String spin(String toSpin, int position){
		String string, string2;
		string2 = toSpin.substring(toSpin.length() - position);
		string = toSpin.substring(0, toSpin.length() - position);
		return string2 + string;
	}
	
	/**
	 * 
	 * @param toExchange
	 *            The String in which elements should be exchanged
	 * @param firstElement
	 *            The index of the first element to exchange
	 * @param secondElement
	 *            The index of the second element to exchange
	 * @return Returns a modified version of toExchange in which two elements
	 *         are exchanged
	 * @author Lukas Keul
	 */
	private static String exchange(String toExchange, int firstElement, int secondElement){
		char temp;
		char[] string = toExchange.toCharArray();
		temp = string[firstElement];
		string[firstElement] = string[secondElement];
		string[secondElement] = temp;
		return new String(string);
	}
	
	/**
	 * 
	 * @param original
	 *            An original copy of 'toPartner'.
	 * @param toPartner
	 *            The String in which elements should be partnered.
	 * @param origIndexOne
	 *            The index of an element in 'original'
	 * @param origIndexTwo
	 *            The index of an element in 'original'
	 * @return Returns a modified version of 'toPartner' in which two elements
	 *         chosen from the original String are exchanged.
	 * @author Lukas Keul
	 */
	private static String partner(String original, String toPartner, int origIndexOne, int origIndexTwo){
		char firstPartner, secondPartner;
		firstPartner = original.charAt(origIndexOne);
		secondPartner = original.charAt(origIndexTwo);
		return exchange(toPartner, toPartner.indexOf(firstPartner), toPartner.indexOf(secondPartner));
	}
	
	/**
	 * 
	 * @param toPermutate
	 *            The String which should be modified.
	 * @param actionsToPerform
	 *            An array of actions to perform.
	 * @return Returns the modified version of 'toPermutate' which went through
	 *         all changes from 'actionsToPerform'
	 * @author Lukas Keul
	 */
	private static String permutate(String toPermutate, String[] actionsToPerform){
		String original = toPermutate;
		String[] newSplit = new String[2];
		
		for(String s : actionsToPerform){

			if(s.charAt(0) == 's'){
				toPermutate = spin(toPermutate, Integer.parseInt(s.substring(1)));
			}
			else if(s.charAt(0) == 'x'){
				newSplit = s.substring(1).split("/");
				toPermutate = exchange(toPermutate, Integer.parseInt(newSplit[0]), Integer.parseInt(newSplit[1]));
			}
			else if(s.charAt(0) == 'p'){
				newSplit = s.substring(1).split("/");
				toPermutate = partner(original, toPermutate,Integer.parseInt(newSplit[0]), Integer.parseInt(newSplit[1]));
			}
		}
		
		return toPermutate;
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		List<String> actionsToPerform = new ArrayList<String>();
		String givenString, givenActions;
		
		System.out.println("String: ");
		givenString = scanner.nextLine();
		
		System.out.println("Actions to perform on the String: ");
		givenActions = scanner.nextLine();
		
		actionsToPerform = Arrays.asList(givenActions.split(",[ ]*"));
		System.out.println(actionsToPerform);
		
		String[] actionsArray = new String[actionsToPerform.size()];
		for(int i = 0; i < actionsArray.length; i++){
			actionsArray[i] = actionsToPerform.get(i);
		}
		System.out.println(permutate(givenString, actionsArray));
		
	}

}
