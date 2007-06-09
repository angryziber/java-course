package net.azib.java.students.t030726.homework.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import net.azib.java.lessons.logging.JavaUtilLogging;
import net.azib.java.students.t030726.homework.decathlon.RatedDecathlonCompetition;
import net.azib.java.students.t030726.homework.output.MarkupLanguageOutput;
/**
 * Outputs HTML by merging XML+XSL. The XSL helper file is not generated on the fly, but is located in the output package/folder
 * @author Deniss Nikiforov
 *
 */
public class HyperTextOutput implements IOutput {
	private RatedDecathlonCompetition competition = null;
	private String outputFile = null;
	private Logger log;
	
	public HyperTextOutput(String filePath, RatedDecathlonCompetition competition) {
		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
		this.outputFile = filePath;
		this.competition = competition;
	}

	/**
	 * We create a temp file and dump contents from the helper there.
	 * @return
	 * @throws IOException
	 */
	private File generateXSLTFile() throws IOException {
		File f = File.createTempFile("xslt_helper", ".xsl");
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/net/azib/java/students/t030726/homework/output/helper.xsl"), "UTF-8"));
		String tempLine = null;
		do {
			tempLine = in.readLine();
			if(tempLine != null) {
				out.write(tempLine);
			}
			
		} while (tempLine != null);
		out.newLine();
		out.flush();
		out.close();
		in.close();
		return f;
	}
	
	/**
	 * We execute the XML generation sequence (XML is identical to the output to XML), so we can use it without modifications
	 * @param competition
	 * @return
	 * @throws Exception
	 */
	private File generateXMLFile(RatedDecathlonCompetition competition) throws Exception {
		IOutput outputControl = null;
		File f = File.createTempFile("xml_helper", ".xml");
		outputControl = new MarkupLanguageOutput(f.getPath(), competition);
		outputControl.dump();
		return f;
	}
	
	/**
	 * Transforming and saving to disk
	 * @throws Exception 
	 */
	public void dump() throws Exception {
		try {
			File xsl = this.generateXSLTFile();
			File xml = this.generateXMLFile(this.competition);
		    TransformerFactory tFactory = TransformerFactory.newInstance();

		    Transformer transformer = tFactory.newTransformer
		         (new javax.xml.transform.stream.StreamSource
		            (xsl.getPath()));
		    FileOutputStream fis = new FileOutputStream(this.outputFile);
            BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(fis, "UTF-16"));

		    transformer.transform
		      (new javax.xml.transform.stream.StreamSource
		            (xml.getPath()),
		       new javax.xml.transform.stream.StreamResult
		            ( buffWriter));
		    }
		  catch (Exception e) {
			  this.log.log(Level.SEVERE, "XML Parser Failed", e);
			  throw e;
		    }
		  }

		
	}
	
