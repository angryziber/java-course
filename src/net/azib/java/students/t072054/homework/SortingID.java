package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

/**
 * SortingID
 * 
 * @author r_vassiljev
 */
public class SortingID {
	
	public static void SortByID(){
		LoadNewResults lnr = new LoadNewResults();

		lnr.LoadResults();
		
		int i = 1; // counter
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
		
		lnr.ConnClose();
	}
}
