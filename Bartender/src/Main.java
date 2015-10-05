import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Name: 	Dan Gonzalez
 * UCID: 	10058656
 * Age: 	23
 * 
 * Program is a bartender program that can serve the user new drinks
 * Bartender starts off knowing how to make some drinks, but can learn to make new drinks
 * 
 * or something
 * 
 */

public class Main 
{

	public static Map<String, Boolean> drinks = new HashMap<String, Boolean>();
	
	//trying my best to put the whole program into one main method
	public static void main(String[] args) 
	{
			//initializing bartender's drinks
		drinks.put("AppleJuice",false);
		drinks.put("Beer", true);
		drinks.put("Whiskey", true);
		
		int age = -1;
		
		Scanner in = new Scanner(System.in);
		
		while (in.nextLine() != "quit"){
			System.out.println("Please enter your age."); 
			age = in.nextInt();
			if (age != -1)
				break;
		}
		
		System.out.println("Welcome to Bartendtron 2000, please select an option. Use \"list\" to display options.");

		while (in.nextLine() != "quit"){
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
