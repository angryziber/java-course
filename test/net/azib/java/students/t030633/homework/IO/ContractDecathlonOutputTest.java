package net.azib.java.students.t030633.homework.IO;

import static org.junit.Assert.assertTrue;

import net.azib.java.students.t030633.homework.Athlete;

import java.io.IOException;
import java.util.LinkedList;
import org.junit.Test;

/**
 * ContractDecathlonInputTest
 *
 * @author t030633
 */
public class ContractDecathlonOutputTest {

	private DecathlonOutput output;
	
	ContractDecathlonOutputTest(DecathlonOutput output){
		this.output = output;
	}
	
	@Test 
	public void outputAcceptsList() throws IOException {
		assertTrue(output.write(new LinkedList<Athlete>()));
	}
	
}
