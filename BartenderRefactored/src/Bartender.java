import java.util.Map;
import java.util.Scanner;

public class Bartender {
	
	private Scanner in;
	private int age;
	private Map<String, Boolean> drinks;
	
	public Bartender(Scanner in, int age, Map<String, Boolean> drinks){
		
		this.in = in;
		this.age = age;
		this.drinks = drinks;
	}
	
	public String teach(Scanner in){
			//parsing string
		String drinkName = in.next();
		try {
			drinks.put(drinkName,Boolean.parseBoolean(in.next()));  
										
			return (drinkName + " learned!");
		}
		catch (Exception e){
			return "Invalid teaching format.";
		}
	}
	
	public void Run()
	{				
		String input;
		
		while (true) {
			input = in.next();
	        
			if (input.contains("list")){
				System.out.println("Commands: \n\n order <String drink> \n\n teach <String drink> <bool isAlcoholic> \n\n menu");
			}
			
			else if (input.contains("teach")){
					
				String output = teach(in);
				System.out.println(output);
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
