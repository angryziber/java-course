package net.azib.java.students.t030633.homework.IO;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import org.junit.Test;

/**
 * ContractDecathlonInputTest
 *
 * @author t030633
 */
public class ContractDecathlonInputTest {

	private DecathlonInput input;
	
	ContractDecathlonInputTest(DecathlonInput input){
		this.input = input;
	}
	
	@Test
	public void inputIsList() throws IOException {
		assertTrue(input.read() instanceof List);
	}
	
}
