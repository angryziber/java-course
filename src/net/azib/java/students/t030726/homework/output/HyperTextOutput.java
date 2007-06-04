package output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import decathlon.RatedDecathlonCompetition;

/**
 * Outputs HTML by merging XML+XSL. The XSL helper file is not generated on the fly, but is located in the output package/folder
 * @author Deniss Nikiforov
 *
 */
public class HyperTextOutput implements IOutput {
	private RatedDecathlonCompetition competition = null;
	private String outputFile = null;
	
	public HyperTextOutput(String filePath, RatedDecathlonCompetition competition) {
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
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("output/helper.xsl"), "UTF-8"));
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
	 */
	public void dump() {
		try {
			File xsl = this.generateXSLTFile();
			File xml = this.generateXMLFile(this.competition);
		    TransformerFactory tFactory = TransformerFactory.newInstance();

		    Transformer transformer = tFactory.newTransformer
		         (new javax.xml.transform.stream.StreamSource
		            (xsl.getPath()));

		    transformer.transform
		      (new javax.xml.transform.stream.StreamSource
		            (xml.getPath()),
		       new javax.xml.transform.stream.StreamResult
		            ( new FileOutputStream(this.outputFile)));
		    }
		  catch (Exception e) {
		    e.printStackTrace( );
		    }
		  }

		
	}
	
