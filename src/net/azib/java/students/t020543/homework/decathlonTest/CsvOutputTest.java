package decathlonTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * Test for {@link CsvOutput} class
 * @author t020543
 */
public class CsvOutputTest {

	private IOutput out;
	private String destination = "csvOutTest.txt"; //test file declaration
	private Set<Competitor> set;
	private IAthlete man;
	/*expected output*/
	private String expected = "0,4000,test,null,null,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0";
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp(){
		out = new CsvOutput();
		set = new TreeSet<Competitor>();
		man = new Athlete();
		man.setScore(4000);		
		man.setName("test");
		set.add(new Competitor(man));
	}
	
	/**
	 * Test  {@link CsvOutput} methods with a particular input
	 * @author t020543
	 */
	@Test
	public void testFile(){
		
		out.saveFile(set, destination); 	//creates test file
		Scanner scanner = null;
		try{	
			scanner = new Scanner(new BufferedInputStream(new FileInputStream(destination)), "UTF-8");
			
			//comparing expected and received strings
			assertEquals(scanner.nextLine(), expected);
			System.out.println("TEST: CsvOutput class => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! CsvOutput class test FAILED! Unexpected output!");
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR! CsvOutput class test FAILED! File Not Found!");
		}
		finally {   
 				scanner.close();
		}
 			
	}
}
