package net.azib.java.students.t100258.oldHomework;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
/**
 * class for HTML output
 *
 * @author mihkel
 */
public class OutHTML {
	

	/**
	 * outputs results to html file
	 *
	 * @param xml_path loxation of xml file
	 * @throws IOExeption
	 */
	public OutHTML(String xml_path) {
		System.out.println("Output to html");
	  try {

	    TransformerFactory tFactory = TransformerFactory.newInstance();
	    Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("./src/net/azib/java/students/t100258/Homework/transform.xsl"));
	    
	    transformer.transform
	      (new javax.xml.transform.stream.StreamSource
	            (xml_path),
	       new javax.xml.transform.stream.StreamResult
	            ( new FileOutputStream(Decathlon.out_arg)));
	    }
	  catch (Exception e) {
	    e.printStackTrace( );
	    }
	  }
	
}
