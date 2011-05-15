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
	void output(ArrayList<Athlete> athletes) {
		try {

			// Create temp file.
			File temp = File.createTempFile("temp", ".xml");
			out.println("Creating temp file " + temp.getPath());
			// Delete temp file when program exits.
			temp.deleteOnExit();

			//File file = processParameters();
			IOxml xml = new IOxml(temp, ctrl);
			xml.output(athletes);
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(Const.PACKAGE + "/XSLTransform.xsl"));
			
			// Check if directory exist
			File file = getOutputFile(getParameters());
			transformer.transform(new StreamSource(temp), new StreamResult(new FileOutputStream(file)));

			out.println("Successful HTML output to " + "\""	+ getParameters() + "\"" + " file!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		} catch (TransformerException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}

	@Override
	public String getParameters() {
		return param;
	}
}
