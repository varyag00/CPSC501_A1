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
		
		drinks = new HashMap<String, Boolean>();
		
		//initializing bartender's drinks
		drinks.put("AppleJuice",false);
		drinks.put("Beer", true);
		drinks.put("Whiskey", true);
		
	}

	@After
	public void tearDown() throws Exception {
		scanner = null;
		drinks = null;
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
		data = "ChocoMilk true";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		
		assertEquals("ChocoMilk learned!", bt.teach(scanner));
	}

	public void TestOrder(){
		
	}
	
	public void TestMenu(){
		
	}
}
