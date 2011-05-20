package net.azib.java.students.t092861.homework;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IOxmlTest {
	
	private File f;
	private String outFile = "outputTest.xml";
	private String[] lines = {
			//arranged in descending order
			"Jeremy Dunkleverylongname,21.05.1981,US,11.23,6.62,11.49,1.75,51.97,14.89,33.37,3.98,45.60,5:24.26",
			"Jürgen Schult,11.05.1960,DE,11.39,6.69,10.00,2.05,49.52,15.72,24.39,3.38,30.37,4:41.38",
			"Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72",
			"José Mañana Peréz,3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 ",
			};

	@Before
	public void createTestOutputData() {
    	
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		for (int i = 0; i < lines.length; i++) {
			ArrayList<String> inputData = new ArrayList<String>(Arrays.asList(lines[i].split(",")));
			athletes.add(new Controller().readData(inputData));
		}
        f = new IOxml(outFile, new Controller()).output(athletes);
    }

	@Test
	public void testXmlOutputFileExists() throws IOException {
		assertThat(f.exists(), is(true));
	}
	
	@Test
	public void testOutputResultsContainNames() throws IOException {
		for (int i = 0; i < lines.length; i++) {
			String[] array = lines[i].split(",");
			assertTrue(findNameinXML(f, array[0]));
		}
	}
	
	private boolean findNameinXML(File file, String name) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("athlete");

			for (int s = 0; s < nodeLst.getLength(); s++) {
				Node fstNode = nodeLst.item(s);

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element fstElmnt = (Element) fstNode;
					
					NodeList nameElmntLst = fstElmnt.getElementsByTagName("name");
					Element nameElmnt = (Element) nameElmntLst.item(0);
					NodeList nameNode = nameElmnt.getChildNodes();
					if(((Node) nameNode.item(0)).getNodeValue().toString().equals(name)){
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@After
	public void cleanUp() {
		if (f.exists()) {
			f.deleteOnExit();
		}
	}
}
