package permutationMadness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermutationMadness {
	
	private static String spin(String toSpin, int position){
		String string, string2;
		string2 = toSpin.substring(toSpin.length() - position);
		string = toSpin.substring(0, toSpin.length() - position);
		return string2 + string;
	}
	
	private static String exchange(String toExchange, int firstElement, int secondElement){
		char temp;
		char[] string = toExchange.toCharArray();
		temp = string[firstElement];
		string[firstElement] = string[secondElement];
		string[secondElement] = temp;
		return new String(string);
	}
	
	private static String partner(String original, String toPartner, int origIndexOne, int origIndexTwo){
		char firstPartner, secondPartner;
		firstPartner = original.charAt(origIndexOne);
		secondPartner = original.charAt(origIndexTwo);
		return exchange(toPartner, toPartner.indexOf(firstPartner), toPartner.indexOf(secondPartner));
	}
	
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
