package decathlonTest;

import static org.junit.Assert.assertEquals;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import decathlon.Athlete;
import decathlon.Competitor;
import decathlon.HtmlOutput;
import decathlon.IAthlete;
import decathlon.IOutput;

/**
 * Test for {@link HtmlOutput} class
 * @author t020543
 */
public class HtmlOutputTest {
	private IOutput out;
	private String destination = "htmlOutTest.txt"; //test file declaration
	private Set<Competitor> set;
	private IAthlete man;
	/*expected output*/
	private String expected = "test<html><body><br>Place:0<br>Score:4000<br>Name:test<br>Birthday:null<br>Country:null<br>Sprint100m:0.0<br>LongJump:0.0<br>Shotput:0.0<br>HighJump:0.0<br>Sprint400m:0.0<br>Hurdles110m:0.0<br>DiscusThrow:0.0<br>PoleVault:0.0<br>JavelinThrow:0.0<br>Race1500m:0.0<br><br></body></html>";
	
	@Before
	public void setUp(){
		out = new HtmlOutput();
		set = new TreeSet<Competitor>();
		man = new Athlete();
		man.setScore(4000);		
		man.setName("test");
		set.add(new Competitor(man));
	}
	/**
	 * Test  {@link HtmlOutput} methods with a particular input
	 * @author t020543
	 */
	@Test
	public void testFile(){
		
		out.saveFile(set, destination);	//creates test file
		Scanner scanner = null;
		try{	
			scanner = new Scanner(new BufferedInputStream(new FileInputStream(destination)), "UTF-8");
			String buf = "test"; 
			
			//reading file into test string 
			while (scanner.hasNext()){
				buf = buf + scanner.next();
			}
			//comparing expected and received strings
			assertEquals(expected, buf);
			System.out.println("TEST: HtmlOutput class => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! HtmlOutput class test FAILED! Unexpected output!");
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR! HtmlOutput class test FAILED! File Not Found!");
		}
		finally {   
 				scanner.close();
		}
	}
}
