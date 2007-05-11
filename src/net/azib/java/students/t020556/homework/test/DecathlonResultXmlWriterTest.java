package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import net.azib.java.students.t020556.homework.DecathlonResultStreamReader;
import net.azib.java.students.t020556.homework.DecathlonResultXmlWriter;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DecathlonResultXmlWriterTest
 *
 * @author agu
 */
public class DecathlonResultXmlWriterTest {
	
	private static DecathlonResultXmlWriter dxw = new DecathlonResultXmlWriter();
	private static DecathlonResultStreamReader dsr = new DecathlonResultStreamReader();
	private static FileOutputStream fos = null;
	private static FileInputStream fis = null;
	private static File testDir = null;
	private static File tstXml;
	private static File tstHtml;

	/**
	 * Test method for {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultXmlWriter#writeResults(net.azib.java.students.t020556.homework.IDecathlonResultReader)}.
	 */
	@Test
	public void testWriteResults() {
		dxw.writeResults(dsr);
		assertTrue(tstXml.exists());
		assertTrue(tstXml.isFile());
	}

	/**
	 * Test method for {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultXmlWriter#setFile(java.net.URL)}.
	 */
	@BeforeClass
	public static void setUp() {
		URL url = DecathlonResultXmlWriterTest.class.getResource("src.txt");
		
		try {
			File f = new File(url.toURI());
			fis = new FileInputStream(f.getAbsolutePath());
			dsr.setStream(fis);
			
			testDir = new File(f.getParent());
			tstXml = new File(testDir.getAbsolutePath() + File.separator + "tst.xml");
			tstHtml = new File(testDir.getAbsolutePath() + File.separator + "tst.Html");
			dxw.setFile(tstXml.toURI().toURL());			
			fos = new FileOutputStream(tstHtml);
		}
		catch (FileNotFoundException e) {
			fail("File " + url + " not found!");
		}
		catch (URISyntaxException e) {
			fail("URI syntax failure: " + url);
		}
		catch (MalformedURLException e) {
			fail("URL malformed " + testDir);
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultXmlWriter#transform(java.io.OutputStream)}.
	 */
	@Test
	public void testTransform() {
		dxw.transform(fos);
		assertTrue(tstHtml.exists());
		assertTrue(tstHtml.isFile());
	}

	/**
	 * Method tears down all initialized stuff
	 */
	@AfterClass
	public static void kill() {
		try {
			fos.close();
			fis.close();
			
			tstXml.delete();
			tstHtml.delete();
		}
		catch (IOException e) {
			fail("Stram closure failed");
		}
		
	}

}
