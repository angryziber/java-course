package net.azib.java.students.t030629.hometasks.ht3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DuplicateRemoverImplTest
 *
 * @author anton_chepurov
 */
public class DuplicateRemoverImplTest {
	
	@Test
	public void testRemoveDuplicateStrings(){
		
		String[][] multiArrayWithDuplicates = {
				{"abc", "more abc", "abc", "123", "11111", "qwer", "qwer", "321", "123"},
				{"AA", "AA", "AA", "AA"},
				{"op,", "op", "opp", "op"}
		};
		
		
		assertArrayEquals("", new String[]{"abc", "more abc", "123", "11111", "qwer", "321"},
				new DuplicateRemoverImpl().removeDuplicateStrings(multiArrayWithDuplicates[0]));
		assertArrayEquals("", new String[]{"AA"},
				new DuplicateRemoverImpl().removeDuplicateStrings(multiArrayWithDuplicates[1]));
		assertArrayEquals("", new String[]{"op,", "op", "opp"},
				new DuplicateRemoverImpl().removeDuplicateStrings(multiArrayWithDuplicates[2]));
				
		

	}

}
