package net.azib.java.students.t050720.homework;

import java.io.*;
import java.util.ArrayList;

import javax.xml.transform.*;

/**
 * HTMLOutput
 *
 * @author Marek
 */
public class HTMLOutput implements Output {

	private File f;
	
	/**
	 * @param parameters
	 * @throws Exception 
	 */
	public HTMLOutput(String filename) {
		f=new File(filename);
	}

	@Override
	public void flush(ArrayList<Record> records) throws Exception {
		File xmlF = File.createTempFile("decathlon", ".tmp");
		xmlF.deleteOnExit();
		
		XMLOutput xmlO=new XMLOutput(xmlF.getAbsolutePath());
		xmlO.flush(records);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer (new javax.xml.transform.stream.StreamSource("decathlon.xsl"));
		transformer.transform(new javax.xml.transform.stream.StreamSource(xmlF.getAbsolutePath()), new javax.xml.transform.stream.StreamResult(new FileOutputStream(f)));
	}

}
