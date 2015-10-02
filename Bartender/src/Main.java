import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Name: 	Dan Gonzalez
 * Age: 	23
 * 
 * Program is a bartender program that can serve the user new drinks
 * Bartender starts off knowing how to make some drinks, but can learn to make new drinks
 * 
 * or something
 * 
 */

public class Main {

	//TODO: think of shitty way to check if drink is alcoholic, probably use hashmap instead of arraylist.
	//or be even worse and just add them sequentially
	public ArrayList<String> drinks = new ArrayList<>(Arrays.asList("AppleJuice", "Beer", "Whiskey"));
	
	//trying my best to put the whole program into one main method
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Bartendtron 2000, please select an option. Use \"list\" to display options");
		Scanner in = new Scanner(System.in);
		
		while (in.nextLine() != null){
			switch (in.nextLine()){
			case ("list"):
				System.out.println("Commands: \n\n order <String drink> <int age> \n\n teach <String drink> <bool isAlcoholic>");
				break;
			case ("teach"):
				//TODO
				break;
			case ("order"):
				//TODO
				break;
			default:
				System.out.println("Not a valid command. Type \"list\" to see valid commands.");
			
			}
		}
	}

}
