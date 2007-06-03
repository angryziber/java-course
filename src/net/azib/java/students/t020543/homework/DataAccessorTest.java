package decathlonTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import decathlon.Athlete;
import decathlon.Competition;
import decathlon.DataAccessor;
import decathlon.IDataAccessor;

/**
 * Test for {@link DataAccessor} class
 * @author t020543
 */
public class DataAccessorTest {

	private IDataAccessor dba;
	//link to the DB
	private String url = "jdbc:mysql://srv.azib.net:3306/decathlon?user=java&password=java";
	private List<Competition> list;
	private List<Athlete> athletes;
	//expected output
	private String expected = "(1) \"Training in Tallinn\" 2005-12-01 EE";
	private String exp = "2893,Siim Susi,1976-01-01,EE,14.15,3.98,10.0,1.45,70.12,18.65,29.15,2.15,32.67,466.6";
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp(){
		dba = new DataAccessor();
		list = new ArrayList<Competition>();
		athletes = new ArrayList<Athlete>();
	}
	
	/**
	 * Tests {@link DataAccessor} methods
	 */
	@Test
	public void testCompetition(){
		try{
			//open connection
			dba.initializeConnection(url);
			
			/*test for reading competition table*/
			list = dba.makeQueryForCompetition();
			assertNotNull(list);
			assertEquals(expected, list.get(0).asString());
			
			/*test for reading athletea and results tables*/
			athletes = dba.makeQueryForAthlete(1);
			assertNotNull(athletes);
			assertEquals(exp, athletes.get(0).asString());
		
			//close connection
			dba.releaseConnection();
			System.out.println("TEST: DataAccessor class => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! DataAccessor class test FAILED!");
		}
	}
}

