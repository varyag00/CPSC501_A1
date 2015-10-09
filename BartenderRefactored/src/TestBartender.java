import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBartender {

	private Scanner scanner;	
	private Map<String, Boolean> drinks;
	private Bartender bt;
	
	@Before
	public void setUp() throws Exception {
		
		//initializing bartender's drinks
		drinks = new HashMap<String, Boolean>();
		drinks.put("AppleJuice",false);
		drinks.put("Beer", true);
		drinks.put("Whiskey", true);
	}

	@After
	public void tearDown() throws Exception {
		drinks.clear();
		scanner = null;
		bt = null;
	}
	
	@Test
	public void TestTeach() {
		
		bt = new Bartender(scanner, 12, drinks);
	
		//tests teaching non-alcoholic drink
		String data = "Milk false";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("Milk learned!", bt.teach(scanner));
		
		//tests teaching alcoholic drink
		data = "RumAndCoke true";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("RumAndCoke learned!", bt.teach(scanner));
		
		//tests teaching gibberish/incorrect format (note that this demonstrates a bug present both in the refactored code and in the original code)
		data = "chocolate milk";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("chocolate learned!", bt.teach(scanner));
	}

	@Test
	public void TestOrder(){
		
		bt = new Bartender(scanner, 12, drinks);
		
		//tests a minor ordering a non-alcoholic drink
		String data = "AppleJuice";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("The bartender gives you a AppleJuice", bt.order(scanner));
		
		//tests a minor ordering alcoholic drink
		data = "Whiskey";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("You're not old enough to drink Whiskey", bt.order(scanner));
		
		bt = new Bartender(scanner, 23, drinks);
		
		//tests an adult ordering a non-alcoholic drink
		 data = "AppleJuice";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("The bartender gives you a AppleJuice", bt.order(scanner));
		
		//tests an adult ordering alcoholic drink
		data = "Whiskey";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("The bartender gives you a Whiskey", bt.order(scanner));
		
		//tests ordering an invalid drink
		data = "ChocolateMilk";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("The bartender doesn't know how to make ChocolateMilk", bt.order(scanner));
	}
	
	@Test
	public void TestMenu(){
		
		bt = new Bartender(scanner, 12, drinks);
		
		assertEquals("Whiskey, Alcoholic\nAppleJuice\nBeer, Alcoholic\n", bt.menu());
				
		//tests adding a drink to the menu
		String data = "ChocoMilk, false";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		bt.teach(scanner);
		
		assertEquals("ChocoMilk,\nWhiskey, Alcoholic\nAppleJuice\nBeer, Alcoholic\n", bt.menu());
	}
}
