package net.azib.java.students.t030657.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Karina
 * public class XmlWriter
 * The class is implementing writing of the .xml file according to the got data
 *
 */

public class XmlWriter implements Writer {
	
	File file;
	Document doc;
	Element root;
	
	public XmlWriter(File file) {
		this.file=file;
	}
	
	public void write(Results r) {
		try {
			if (doc==null) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				doc = builder.newDocument();
				root = doc.createElement("results");
				doc.appendChild(root);
			}

            Element result = doc.createElement("result");
            result.setAttribute("name", r.getAthlete().getName());
            result.setAttribute("dob", r.getAthlete().getDob());
            result.setAttribute("country_code", r.getAthlete().getCountryCode());
            result.setAttribute("position", r.getPosition());
            result.setAttribute("score", Integer.toString(r.getScore()));
            for (Event ev: Event.values())
            	result.setAttribute(ev.name(), Double.toString(r.getResult(ev)));
			root.appendChild(result);
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public void close() {
		BufferedWriter writer=null;
		try {
            OutputStream out = new FileOutputStream (file);
            OutputStreamWriter osWriter = new OutputStreamWriter (out, "UTF8");
            writer = new BufferedWriter (osWriter);
	        Transformer trans = getTransformer();
	        trans.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(doc);
			trans.transform(source,new StreamResult(writer));
		}
		catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		finally {
			if (writer!=null) {
				try { writer.close(); }
				catch (IOException ignore) {}
			}
		}
	}
	
	Transformer getTransformer() throws TransformerConfigurationException {
		return TransformerFactory.newInstance().newTransformer();
	}
}
