package net.azib.java.students.t050720.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * Test of the InputFactory class
 *
 * @author Marek
 */
public class InputFactoryTest {

	/**
	 * Get console input
	 * Test method for {@link net.azib.java.students.t050720.homework.InputFactory#getInputPlugin(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetConsoleInputPlugin() {
		InputFactory f=new InputFactory();
		Input i=null;
		try {
			i = f.getInputPlugin("-console", "");
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(i.getClass().getName(), (new ConsoleInput()).getClass().getName());
	}

	/**
	 * Get CSV input
	 * Test method for {@link net.azib.java.students.t050720.homework.InputFactory#getInputPlugin(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetCSVInputPlugin() {
		InputFactory f=new InputFactory();
		Input i=null;
		File tmpf=null;
		try {
			tmpf=File.createTempFile("iftest", "tmp");
		}
		catch (Exception e1) {
			e1.printStackTrace();
			fail("Couldn't create temporary file.");
		}
		tmpf.deleteOnExit();
		
		try {
			i = f.getInputPlugin("-csv", tmpf.getAbsolutePath());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		try {
			assertEquals(i.getClass().getName(), (new CSVInput(tmpf.getAbsolutePath())).getClass().getName());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
	}
	
	/**
	 * get database input
	 */
	@Test
	public void testGetDBInputPlugin()
	{
		InputFactory f=new InputFactory();
		Input i=null;
		try {
			i=f.getInputPlugin("-db", "2");
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		try {
			assertEquals(i.getClass().getName(), (new DatabaseInput("2")).getClass().getName());
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
	}
	
	/**
	 * get default input (should be console)
	 */
	@Test
	public void testGetDefaultInputPlugin()
	{
		InputFactory f=new InputFactory();
		Input i=null;
		try {
			i = f.getInputPlugin("", "");
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(i.getClass().getName(), (new ConsoleInput()).getClass().getName());	
	}
	
	/**
	 * get input plugin for invalid argument (should return console)
	 */
	@Test
	public void testGetNonExistentInputPlugin()
	{
		InputFactory f=new InputFactory();
		Input i=null;
		try {
			i = f.getInputPlugin("dsahfdsa", "asdhg");
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(i.getClass().getName(), (new ConsoleInput()).getClass().getName());	
	}
}
