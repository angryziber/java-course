package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.SQLException;

/**
 * LoadNewResultsTest
 * 
 * @author r_vassiljev
 */
public class LoadNewResultsTest {

	/**
	 * Test method for ???
	 */
	@Test
	public void testLoadResults() {
		
		// TODO what exactly is tested here?

		LoadNewResults lnr = new LoadNewResults();

//		lnr.loadResults(); doesn't compile
		
		int i = 1; //counter
		try{
			do
			{
				System.out.println(lnr.rs1.getString(1));
				assertTrue(lnr.rs1.getInt(1) == i);
				i++;
			}
			while(lnr.rs1.next());
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		lnr.connClose();
	}
}
