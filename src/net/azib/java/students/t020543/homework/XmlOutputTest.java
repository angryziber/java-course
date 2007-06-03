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
/*
import decathlon.Athlete;
import decathlon.Competitor;
import decathlon.IAthlete;
import decathlon.IOutput;
import decathlon.XmlOutput;
*/
/**
 * Test for {@link XmlOutput} class
 * @author t020543
 */
public class XmlOutputTest {

	private IOutput out;
	private String destination = "xmlOutTest.txt";//test file declaration
	private Set<Competitor> set;
	private IAthlete man;
	/*expected output*/
	private String expected = "test<?xmlversion=\"1.0\"?><Decathlon><Athlete><place>0</place><score>4000</score><name>test</name><birthday>null</birthday><country>null</country><sprint100>0.0</sprint100><longJump>0.0</longJump><shotPut>0.0</shotPut><highJump>0.0</highJump><sprint400>0.0</sprint400><hurdles110>0.0</hurdles110><discusThrow>0.0</discusThrow><poleVault>0.0</poleVault><javelinThrow>0.0</javelinThrow><race1500>0.0</race1500></Athlete></Decathlon>";
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp(){
		out = new XmlOutput();
		set = new TreeSet<Competitor>();
		man = new Athlete();
		man.setScore(4000);		
		man.setName("test");
		set.add(new Competitor(man));
	}
	
	/**
	 * Test  {@link XmlOutput} methods with a particular input
	 * @author t020543
	 */
	@Test
	public void testFile(){
		
		out.saveFile(set, destination);	//creates test file
		Scanner scanner = null;
		try{	
			scanner = new Scanner(new BufferedInputStream(new FileInputStream(destination)), "UTF-8");
			String buf = "test";
			
			//reading file into string 
			while (scanner.hasNext()){
				buf = buf + scanner.next();
			}
			//comparing expected and received strings
			assertEquals(expected, buf);
			System.out.println("TEST: XmlOutput class => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! XmlOutput class test FAILED! Unexpected output!");
		}
		catch (FileNotFoundException e) {
			System.out.println("ERROR! XmlOutput class test FAILED! File Not Found!");
		}
		finally {   
 				scanner.close();
		}
	}

}