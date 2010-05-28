package net.azib.java.students.t100258.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 * OutHTML
 *
 * @author mihkel
 */
public class OutHTML implements OutputWith2Parameters {
	/**
	 * Outputs results to html file
	 *
	 * @param location location of output html file(filename and extension included)
	 * @param results Arraylist of Results
	 * @throws IOExeption
	 */
	public void outputResults(ArrayList<Object> results, String location) throws IOException {
		System.out.println("Output to html");
		File tempfile= java.io.File.createTempFile("temp", ".xml");
		tempfile.deleteOnExit();
		OutXML objectXML=new OutXML();
		objectXML.outputResults(results, tempfile.getAbsolutePath());
		
		  try {

		    TransformerFactory tFactory = TransformerFactory.newInstance();
		    URL xslLocation= this.getClass().getResource("transform.xsl");
		    Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(xslLocation.toString().substring(5)));
		    //Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("./src/net/azib/java/students/t100258/homework/transform.xsl"));
		    
		    transformer.transform
		      (new javax.xml.transform.stream.StreamSource
		            (tempfile.getAbsolutePath()),
		       new javax.xml.transform.stream.StreamResult
		            ( new FileOutputStream(location)));
		    }
		  catch (Exception e) {
		    e.printStackTrace( );
		    }
		  }

	}


