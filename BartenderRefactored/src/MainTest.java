import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

	private Scanner scanner;	

	@Test
	public void TestGetUserAge(){
		String data = "12";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		assertEquals(12 , Main.getUserAge(scanner));
		
		data = "-1";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		scanner = new Scanner(System.in);
		assertEquals(-1, Main.getUserAge(scanner));
	}

	
//	@Test
//	public void TestBartenderRun(){
//	
//		int age = 12;
//		
//		String data = "order Whiskey";
//		System.setIn(new ByteArrayInputStream(data.getBytes()));
//		scanner = new Scanner(System.in);
//		
//		Map<String, Boolean> drinks = new HashMap<String, Boolean>();
//		drinks.put("AppleJuice",false);
//		drinks.put("Beer", true);
//		drinks.put("Whiskey", true);
//
//		Bartender bt = new Bartender(scanner, age, drinks);
//		
//		bt.Run();
//	}
}

