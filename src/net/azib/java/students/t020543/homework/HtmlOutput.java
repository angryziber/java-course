package net.azib.java.students.t020543.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * A class, which outputs data to the HTML file, using XSL transformation of XML
 * @author Collega
 */
public class HtmlOutput implements IOutput{

	/**
	 * Creates temporary XML file, needed as a source stream for the transformation<br>
	 * Calls the {@link IOutput} interface.
	 * @param output - IOutput interface
	 * @param set - data to be written
	 * @param destination - file name or path
	 * @throws IOException
	 */
	private static void createSource(IOutput output, Set<Competitor> set, String destination ) throws IOException{
		output.saveFile(set, destination);
	}

	@Override
	public void saveFile( Set<Competitor> set, String destination){
		
	try {
		//output stream creating
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(destination), "UTF-8"); 
		
		try{	
			//Temporary file declaration an creating
			String source = "xml.tmp";
			createSource(new XmlOutput(), set, source);
			
			//Reading the XML source
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xml = db.parse(new FileInputStream(source), "UTF-8");
			
			//Transformer instantiation with decathlon.xsl file
			Transformer t = TransformerFactory.newInstance().newTransformer(new StreamSource(HtmlOutput.class.getResourceAsStream("decathlon.xsl"), "UTF-8"));
				
			//Writing result of transformation to the file
			t.transform(new DOMSource(xml), new StreamResult(out));
			
			}
			// Exception handling
			catch (SAXException e){
				System.out.println("Error while reading XML source!");
			}
			catch (IOException e){
				System.out.println("Output error while writing!");
			}
			catch (ParserConfigurationException e){
				System.out.println("Error while reading XML source! Parser configuration error!");
			}
			catch (TransformerFactoryConfigurationError e){
				System.out.println("Transformer configuration error!");
			}
			catch (TransformerException e){
				System.out.println("Error while transforming XML!");
			}
			finally {
				try {
					out.close();	//stream closing
					}
				catch (IOException e) {
					System.out.println("Output error while closing!");
					}
			}
		}
		// Exception handling
		catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported Encoding! (UTF-8 Needed!)");
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}	
		
	}
}
