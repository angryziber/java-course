package net.azib.java.students.t020556.homework;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

/**
 * DecathlonResultXmlWriter
 *
 * @author Agu Aarna
 */
public class DecathlonResultXmlWriter implements IDecathlonResultWriter {

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	private String fName = "default.xml";
	private String rootName = "DecathlonResults";
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultWriter#writeResults(net.azib.java.students.t020556.homework.IDecathlonResultReader)
	 */
	public void writeResults(IDecathlonResultReader reader) {
		Document xmlDoc = new DocumentImpl();
		Element root = xmlDoc.createElement(rootName);
		
		PriorityQueue<Competitor> compQ = reader.readResults();
		if(compQ == null){
			LOG.severe("Unable to read results from the provided reader");
			return;
		}
		
		Competitor comp = null;
		int i = 1;
		while((comp = compQ.poll()) != null){
			Element xmlComp = xmlDoc.createElement("Competitor");
			
			//place
			Element node = xmlDoc.createElement("Place");
			node.appendChild(xmlDoc.createTextNode("" + (i++)));
			xmlComp.appendChild(node);
			
			//name
			node = xmlDoc.createElement("Name");
			node.appendChild(xmlDoc.createTextNode(comp.getName()));
			xmlComp.appendChild(node);

			//Date of birth
			node = xmlDoc.createElement("DateOfBirth");
			node.appendChild(xmlDoc.createTextNode(formatter.format(comp.getDateOfBirth())));
			xmlComp.appendChild(node);

			//Locale
			node = xmlDoc.createElement("Country");
			node.appendChild(xmlDoc.createTextNode(comp.getLocale().getCountry()));
			xmlComp.appendChild(node);
			
			//score
			node = xmlDoc.createElement("Score");
			node.appendChild(xmlDoc.createTextNode("" + Math.round(comp.getFinalResult())));
			xmlComp.appendChild(node);
			
			//results
			String[] results = comp.getResults();
			int j = 0;
			for(DecathlonEvent field : DecathlonEvent.values()){
				node = xmlDoc.createElement(field.name());
				node.appendChild(xmlDoc.createTextNode(results[j++]));
				xmlComp.appendChild(node);
			}
			root.appendChild(xmlComp);			
		}
		
		
	}
	
	/**
	 * setStream method obtains the stream but does not handle it's state in any way
	 * so the stream has to be closed by the caller
	 * 
	 * @author Agu Aarna
	 * 
	 * @param out - output stream
	 * 
	 * @version 1
	 */
	public void setFileName(String fName){
		this.fName = fName;
	}

}
