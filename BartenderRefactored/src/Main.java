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
		
		int age = getSomeInformationFromUser(in);

		System.out.println("Welcome to Bartendtron 2000, please select an option. Use \"list\" to display options.");

		Run(in, age, drinks);
	}
	
	public static int getSomeInformationFromUser(Scanner in){
		
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
	
	public static void Run(Scanner in, int age, Map<String, Boolean> drinks)
	{		
		String input;
		
		while (true) {
			input = in.next();
	        
			if (input.contains("list")){
				System.out.println("Commands: \n\n order <String drink> \n\n teach <String drink> <bool isAlcoholic> \n\n menu");
			}
			
			else if (input.contains("teach")){
				
					//parsing string
				String drinkName = in.next();
				try {
					drinks.put(drinkName,Boolean.parseBoolean(in.next()));  
						
					System.out.println(drinkName + " learned!");
				}
				catch (Exception e){
					System.out.println("Invalid teaching format.");
				}
			}
			
			else if (input.contains("order")){
				
				//check if drink exists
				String drink = in.next();
				boolean drinkSeen = false;
				
				for (Map.Entry<String, Boolean> entry : drinks.entrySet()) 
				{ 
					//if the bartender knows he drink
					if (drink.equals(entry.getKey())){
						drinkSeen = true;
						
						//if the drink is alcoholic, check age
						if (Boolean.parseBoolean(entry.getValue().toString()) == true){			    		
							if (age >= 18){
								System.out.println("The bartender gives you a " + drink);
							}
							System.out.println("You're not old enough to drink " + drink);
					    }
						else{
							System.out.println("The bartender gives you a " + drink);
						}
					} 
					if (drinkSeen)
						break;
				}
				
				if (!drinkSeen)
					System.out.println("The bartender doesn't know how to make " + drink);
			}
			
			else if (input.contains("menu")){
			    
			    for (Map.Entry<String, Boolean> entry : drinks.entrySet()) 
			    { 
			    	System.out.print(entry.getKey());
			        if (Boolean.parseBoolean(entry.getValue().toString()) == true){
				        System.out.print(", Alcoholic");
			        }
			        System.out.println("");
			    }
			    
			}
			
			else if (input.equals("quit")){
				System.out.println("Bye");
				break;
			}
			
			else{
				System.out.println("Invalid command, type \"list\" to see valid commands");
				input = in.nextLine();
			}
		}	
	}
}
