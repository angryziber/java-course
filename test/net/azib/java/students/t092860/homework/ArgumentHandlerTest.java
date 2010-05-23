package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ArgumentHandlerTest
 *
 * @author scythe
 */
public class ArgumentHandlerTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.ArgumentHandler#ArgumentHandler(java.lang.String[])}.
	 * @throws Exception 
	 */
	@Test
	public void testArgumentHandler() throws Exception {
		{
			String[] args = {"-console","-console"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-console") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-console") == 0);
		}
		
		{
			String[] args = {"-console","-csv","file.txt"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-console") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-csv") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.txt") == 0);
		}
		
		{
			String[] args = {"-console","-xml","file.xml"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-console") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-xml") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.xml") == 0);
		}
		
		{
			String[] args = {"-console","-html","file.html"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-console") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-html") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.html") == 0);
		}
		
		{
			String[] args = {"-csv","file.txt","-console"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-csv") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("file.txt") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-console") == 0);
		}
		
		{
			String[] args = {"-db","2","-console"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-db") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("2") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-console") == 0);
		}
		
		{
			String[] args = {"-db","2","-csv","file.txt"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-db") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("2") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-csv") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.txt") == 0);
		}
		
		{
			String[] args = {"-csv","file.txt","-xml","file.xml"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-csv") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("file.txt") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-xml") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.xml") == 0);
		}
		
		{
			String[] args = {"-csv","file.txt","-html","file.html"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-csv") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("file.txt") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-html") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.html") == 0);
		}
		
		{
			String[] args = {"-db","2","-xml","file.xml"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-db") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("2") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-xml") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.xml") == 0);
		}
		
		{
			String[] args = {"-db","2","-html","file.html"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-db") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("2") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-html") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.html") == 0);
		}
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.ArgumentHandler#ArgumentHandler(java.lang.String[])}.
	 * @throws Exception 
	 */
	@Test (expected = Exception.class)
	public void testArgumentHandlerException() throws Exception {
		{
			String[] args = {"zzcz","2","xcv","file.html"};
			ArgumentHandler argHandler = new ArgumentHandler(args);
			assertNotNull(argHandler);
			assertTrue(argHandler.GetInputMethod().compareTo("-db") == 0);
			assertTrue(argHandler.GetInputParam().compareTo("2") == 0);
			assertTrue(argHandler.GetOutputMethod().compareTo("-html") == 0);
			assertTrue(argHandler.GetOutputParam().compareTo("file.html") == 0);
		}	
	}
}
