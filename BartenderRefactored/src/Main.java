import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Name: 	Dan Gonzalez
 * UCID: 	10058656
 * 
 * Program is a bartender program that can serve the user drinks
 * Bartender starts off knowing how to make some drinks, but can learn to make new drinks. 
 * Checks for user's age when attempting to order alcoholic drinks
 * 
 */

public class Main 
{
	public static Map<String, Boolean> drinks = new HashMap<String, Boolean>();
	
	public static void main(String[] args) 
	{	
		//initializing bartender's drinks
		drinks.put("AppleJuice",false);
		drinks.put("Beer", true);
		drinks.put("Whiskey", true);
		
		Scanner in = new Scanner(System.in);
		
		int age = getUserAge(in);

		System.out.println("Welcome to Bartendtron 2000, please select an option. Use \"list\" to display options.");
		
		//declaring and instantiating our bartender object
		Bartender bt = new Bartender(in, age, drinks);
		bt.Run();
	}
	
	public static int getUserAge(Scanner in){
		
		//get user's age
		int age;
		while (true) {
			System.out.println("Please enter your age."); 	            
			String input = in.next();
	        try {
	        	age = Integer.parseInt(input);
	            break;
	        } 
	        catch (Exception e) {
	        	System.out.println("That's not a valid age, try again.");
	        }
		}
		return age;
	}

}
