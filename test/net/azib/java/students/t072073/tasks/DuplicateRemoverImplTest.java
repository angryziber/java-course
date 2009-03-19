package net.azib.java.students.t072073.tasks;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DuplicateRemoverImpl
 *
 * @author janika
 */
public class DuplicateRemoverImplTest {
	@Test
	public void testShouldRemoveDuplicates() throws Exception {
		String [] arrayWithDuplicates = new String[]{
				   "Esimene",
				   "Teine",
				   "Kolmas",
				   "Esimene",
				   "Kolmas"
				};
		
		DuplicateRemoverImpl dupRemover = new DuplicateRemoverImpl();
		
		String [] resultArray = dupRemover.removeDuplicateStrings(arrayWithDuplicates);
		StringBuffer resultString = new StringBuffer();
	
		for(String s : resultArray) {
			resultString.append(s + " ");
			
		}
		assertEquals("Esimene Teine Kolmas ", resultString.toString());

	}
	
}
