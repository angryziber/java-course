package net.azib.java.students.t050545.homework.utils;

import net.azib.java.students.t050545.homework.loaders.CSVloadTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.File;

/*
 * PluginLoaderTest
 *
 * @author libricon
 */
public class PluginLoaderTest {

	@Test
	public void testGetLoaders1() throws LoadException {
		String[] args = { "-csv", CSVloadTest.class.getResource("sport_utf8.txt").getFile().replace('/', File.separatorChar).substring(1), "-csv", "sport_out.txt" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("CSVLoader", plug.getLoader().getClass().getSimpleName());
		
	}

	@Test
	public void testGetLoaders2() throws LoadException {
		String[] args = { "-console", "-console" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("ConsoleLoader", plug.getLoader().getClass().getSimpleName());
		plug.getLoader().close();
		plug.getWriter().close();
	}

	@Test
	public void testGetWriter1() throws LoadException {
		String[] args = { "-csv", CSVloadTest.class.getResource("sport_utf8.txt").getFile().replace('/', File.separatorChar).substring(1), "-csv", "sport_out.txt" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("CSVWriter", plug.getWriter().getClass().getSimpleName());
		plug.getLoader().close();
		plug.getWriter().close();
	}

	@Test
	public void testGetWriter2() throws LoadException {
		String[] args = { "-console", "-console" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("ConsoleWriter", plug.getWriter().getClass().getSimpleName());
		plug.getLoader().close();
		plug.getWriter().close();
	
	}

}
