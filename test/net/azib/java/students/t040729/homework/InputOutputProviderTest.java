package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * InputOutputProviderTest
 * 
 * @author ValleTon
 */
public class InputOutputProviderTest {

	public String[] cmdLineArgs1 = {"-db","xx","-console"};
	public String[] cmdLineArgs2 = {"-console","-csv","yy"};
	public String[] cmdLineArgs3 = {"-csv","xx","-xml","yy"};
	
	/**
	 * Test method for {@link net.azib.java.students.t040729.homework.InputOutputProvider#getInput()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetInput() throws Exception {
		InputOutputProvider iop;
		
		iop = new InputOutputProvider(cmdLineArgs1);

		assertEquals("MySqlDataReader",iop.getInput().getClass().getSimpleName());
		iop = new InputOutputProvider(cmdLineArgs2);
		assertEquals("ConsoleDataReader",iop.getInput().getClass().getSimpleName());
		iop = new InputOutputProvider(cmdLineArgs3);
		assertEquals("CsvDataReader",iop.getInput().getClass().getSimpleName());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040729.homework.InputOutputProvider#getOutput()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetOutput() throws Exception {
		InputOutputProvider iop;
		
		iop = new InputOutputProvider(cmdLineArgs1);
		assertEquals("ConsoleDataWriter",iop.getOutput().getClass().getSimpleName());
		iop = new InputOutputProvider(cmdLineArgs2);
		assertEquals("CsvDataWriter",iop.getOutput().getClass().getSimpleName());
		iop = new InputOutputProvider(cmdLineArgs3);
		assertEquals("XmlDataWriter",iop.getOutput().getClass().getSimpleName());
	}

}
