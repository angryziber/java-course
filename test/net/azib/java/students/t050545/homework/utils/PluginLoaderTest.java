package net.azib.java.students.t050545.homework.utils;

import net.azib.java.students.t050545.homework.loaders.CSVLoaderTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
 * PluginLoaderTest
 *
 * @author libricon
 */
public class PluginLoaderTest {

	@Test
	public void testGetLoaders1() throws LoadException {
		String[] args = { "-csv", CSVLoaderTest.class.getResource("sport_in.txt").getPath().toString(), "-csv", "sport_out.txt" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("CSVLoader", plug.getLoader().getClass().getSimpleName());
	}

	@Test
	public void testGetLoaders2() throws LoadException {
		String[] args = { "-console", "-console" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("ConsoleLoader", plug.getLoader().getClass().getSimpleName());
	}

	@Test
	public void testGetWriter1() throws LoadException {
		String[] args = { "-csv", CSVLoaderTest.class.getResource("sport_in.txt").getPath().toString(), "-csv", "sport_out.txt" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("CSVWriter", plug.getWriter().getClass().getSimpleName());
	}

	@Test
	public void testGetWriter2() throws LoadException {
		String[] args = { "-console", "-console" };
		PluginLoader plug = new PluginLoader(args);
		assertEquals("ConsoleWriter", plug.getWriter().getClass().getSimpleName());
	}

}
