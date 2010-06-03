package net.azib.java.students.t073639.homework;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * <p>
 * XmlControl class extends AthleteList.
 * <br>Instance of XmlControl class has methods to write athletes to XML or HTML files.
 * <br>All errors or correct result are displayed to User with console messages.
 * @author t073639
 * @see AthleteList
 */
public class XMLControl extends AthleteList {
	Document dom;

	/**
	 * <p>
	 * Create a new list of athletes, which is copy of parameter and DOM Document.
	 * @param lis
	 *            - List of athletes
	 */
	public XMLControl(List<Athlete> lis) {
		super(lis);
		this.sortAndSetPlaces();
		this.createDocument();
	}

	private void printToFile(String f) {
		File file=new File(f);
		OutputFormat format = new OutputFormat(dom);
		format.setIndenting(true);
		try {
			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(file), format);
			serializer.serialize(dom);
			System.out.println("Results are written in "+file.toURI()+"");
		}
		catch (IOException e) {
			System.out.println("\tXMLControl ERROR: "+e.toString());
		}

	}

	private void createDOMTree() {
		Element root = dom.createElement("Athletes");
		dom.appendChild(root);
		Iterator<Athlete> it = this.getInputAthleteList().iterator();
		while (it.hasNext()) {
			Athlete a = it.next();
			Element athleteEl = createAthleteElement(a);
			root.appendChild(athleteEl);
		}
	}

	private Element createAthleteElement(Athlete a) {
		Element athleteEl = dom.createElement("Athlete");
		
		Element placeEl = dom.createElement("Place");
		Text placeText = dom.createTextNode(a.getPlace());
		placeEl.appendChild(placeText);
		athleteEl.appendChild(placeEl);
		
		Element totalPointsEl = dom.createElement("TotalPoints");
		Text totalPointsText = dom.createTextNode(String.valueOf(a.getTotalPoints()));
		totalPointsEl.appendChild(totalPointsText);
		athleteEl.appendChild(totalPointsEl);
		
		Element nameEl = dom.createElement("Name");
		Text nameText = dom.createTextNode(a.getName());
		nameEl.appendChild(nameText);
		athleteEl.appendChild(nameEl);

		Element birthdateEl = dom.createElement("Birthdate");
		Text birthdateText = dom.createTextNode(a.getBirthdate());
		birthdateEl.appendChild(birthdateText);
		athleteEl.appendChild(birthdateEl);

		Element countryEl = dom.createElement("Country");
		Text countryText = dom.createTextNode(a.getCountry());
		countryEl.appendChild(countryText);
		athleteEl.appendChild(countryEl);

		Element m100ResultEl = dom.createElement("M100Result");
		Text m100ResultText = dom.createTextNode(a.getM100Result());
		m100ResultEl.appendChild(m100ResultText);
		athleteEl.appendChild(m100ResultEl);

		Element longJumpResultEl = dom.createElement("LongJumpResult");
		Text longJumpResultText = dom.createTextNode(a.getLongJumpResult());
		longJumpResultEl.appendChild(longJumpResultText);
		athleteEl.appendChild(longJumpResultEl);

		Element shotPutResultEl = dom.createElement("ShotPutResult");
		Text shotPutResultText = dom.createTextNode(a.getShotPutResult());
		shotPutResultEl.appendChild(shotPutResultText);
		athleteEl.appendChild(shotPutResultEl);

		Element highJumpResultEl = dom.createElement("HighJumpResult");
		Text highJumpResultText = dom.createTextNode(a.getHighJumpResult());
		highJumpResultEl.appendChild(highJumpResultText);
		athleteEl.appendChild(highJumpResultEl);

		Element m400ResultEl = dom.createElement("M400Result");
		Text m400ResultText = dom.createTextNode(a.getM400Result());
		m400ResultEl.appendChild(m400ResultText);
		athleteEl.appendChild(m400ResultEl);

		Element m110HurdlesResultEl = dom.createElement("M110HurdlesResult");
		Text m110HurdlesResultText = dom.createTextNode(a.getM110HurdlesResult());
		m110HurdlesResultEl.appendChild(m110HurdlesResultText);
		athleteEl.appendChild(m110HurdlesResultEl);

		Element discusThrowResultEl = dom.createElement("DiscusThrowResult");
		Text discusThrowResultText = dom.createTextNode(a.getDiscusThrowResult());
		discusThrowResultEl.appendChild(discusThrowResultText);
		athleteEl.appendChild(discusThrowResultEl);

		Element poleVaultResultEl = dom.createElement("PoleVaultResult");
		Text poleVaultResultText = dom.createTextNode(a.getPoleVaultResult());
		poleVaultResultEl.appendChild(poleVaultResultText);
		athleteEl.appendChild(poleVaultResultEl);

		Element javelinThrowResultEl = dom.createElement("JavelinThrowResult");
		Text javelinThrowResultText = dom.createTextNode(a.getJavelinThrowResult());
		javelinThrowResultEl.appendChild(javelinThrowResultText);
		athleteEl.appendChild(javelinThrowResultEl);

		Element m1500ResultEl = dom.createElement("M1500Result");
		Text m1500ResultText = dom.createTextNode(a.getM1500Result());
		m1500ResultEl.appendChild(m1500ResultText);
		athleteEl.appendChild(m1500ResultEl);

		return athleteEl;
	}
	
	private void createDocument() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			dom = db.newDocument();
		}
		catch (ParserConfigurationException e) {
			System.out.println("\tXMLControl ERROR: "+e.toString());
		}
	}

	/**
	 * <p>Create XML file and fill with athletes.
	 * @param file - File path or file name.
	 */
	public void formatFile(String file) {
		this.createDOMTree();
		this.printToFile(file);
	}

	/**
	 * <p>Create HTML file and fill with athletes.
	 * <br> XML DOM is used.
	 * @param f - File path or file name.
	 */
	public void transform2html(String f) {
		this.createDOMTree();
		File file=new File(f);
		OutputFormat format = new OutputFormat(dom);
		format.setIndenting(true);
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		try {
			XMLSerializer serializer = new XMLSerializer(os, format);
			serializer.serialize(dom);
			os.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		ByteArrayInputStream in=new ByteArrayInputStream(os.toByteArray());

		TransformerFactory tFactory = TransformerFactory.newInstance();
	    Transformer transformer;
		try {
			transformer = tFactory.newTransformer(new StreamSource(XMLControl.class.getResourceAsStream("transform.xsl")));
			transformer.transform(new StreamSource(in),new StreamResult(new FileOutputStream(f)));
			System.out.println("Results are written in "+file.toURI()+"");
		}
		catch (TransformerConfigurationException e) {
			System.out.println("\tXMLControl ERROR: "+e.toString());
		}
		catch (FileNotFoundException e) {
			System.out.println("\tXMLControl ERROR: "+e.toString());
		}
		catch (TransformerException e) {
			System.out.println("\tXMLControl ERROR: "+e.toString());
		}
		finally{
			try {
	        	os.close();
				in.close();
			}
			catch (IOException e) {
				System.out.println("\tXMLControl ERROR: "+e.toString());
			}
		}
	}

}
