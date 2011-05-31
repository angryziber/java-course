package net.azib.java.students.t092861.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Stanislav / 092861
 * 
 */
public class IOhtml extends AbstractIO {
	
	/**
	 * File name or the path to the file.
	 */
	public String param = "";

	/**
	 * Default constructor.
	 * 
	 * @param param
	 *            - parameters of the input/output
	 * @param ctrl
	 *            - controller
	 */
	public IOhtml(String param, Controller ctrl) {
		super(ctrl);
		this.param = param;
	}

	@Override
	ArrayList<Athlete> input() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	File output(ArrayList<Athlete> athletes) {
		File temp = null;
		try {

			// Create temp file.
			temp = File.createTempFile("temp", ".xml");
			out.println("Creating temp file " + temp.getPath());
			// Delete temp file when program exits.
			temp.deleteOnExit();

			//File file = processParameters();
			IOxml xml = new IOxml(temp, ctrl);
			xml.output(athletes);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(Const.USER_DIR + "/XSLTransform.xsl"));
			
			// Check if directory exist
			File file = getOutputFile(getParameters());
			transformer.transform(new StreamSource(temp), new StreamResult(new FileOutputStream(file)));
			
			out.println("Successful HTML output to " + "\""	+ getParameters() + "\"" + " file!");
			
		} catch (FileNotFoundException e) {
			out.println("\nError! Attempt to open the file denoted by a specified pathname has failed.");
			e.printStackTrace();
			
		} catch (TransformerException e) {
			out.println("\nError occured during the transformation process.");
			e.printStackTrace();
			
		} catch (IOException e) {
			out.println("\nError! I/O exception of some sort has occurred.");
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public String getParameters() {
		return param;
	}
}
