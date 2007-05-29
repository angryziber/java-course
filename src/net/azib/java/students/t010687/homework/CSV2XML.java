package net.azib.java.students.t010687.homework;
/**
 * DOM Example: Creating XML document by converting CSV file to XML
 * First line in CSV file is field/column names - 
 * which is also used as element names while creating XML document
 */
import java.io.*;
import java.util.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult; 
/**
 * CSV2XML
 * http://www.javareference.com/jrexamples/printexample.jsp?id=63
 * @author Matu
 */
public class CSV2XML {
	// Protected Properties
	protected DocumentBuilderFactory domFactory = null;
	protected DocumentBuilder domBuilder = null;

	// CTOR
	public CSV2XML(){
		try{
			domFactory = DocumentBuilderFactory.newInstance();
			domBuilder = domFactory.newDocumentBuilder();
		}
		catch(FactoryConfigurationError exp){
			System.err.println(exp.toString());
		}
		catch(ParserConfigurationException exp){
			System.err.println(exp.toString());
		}
		catch(Exception exp){
			System.err.println(exp.toString());
		}
	}

	public int convertFile(String csvFileName, String xmlFileName){
		int rowsCount = -1;
		try{
			Document newDoc = domBuilder.newDocument();

			// Root element
			Element rootElement = newDoc.createElement("CSV2XML");
			newDoc.appendChild(rootElement);

			// Read comma seperated file
			BufferedReader csvReader;
			csvReader = new BufferedReader(new FileReader(csvFileName));
			int fieldCount = 0;
			String[] csvFields = null;
			StringTokenizer stringTokenizer = null;

			// Assumption: first line in CSV file is column/field names
			// As the column names are used to name the elements in the XML file,
			// avoid using spaces/any other characters not suitable for XML element naming
			String curLine = csvReader.readLine();
			if(curLine != null){
				stringTokenizer = new StringTokenizer(curLine, ",");
				fieldCount = stringTokenizer.countTokens();
				if(fieldCount > 0){
					csvFields = new String[fieldCount];
					int i=0;
					while(stringTokenizer.hasMoreElements())
						csvFields[i++] = String.valueOf(stringTokenizer.nextElement());
				}
			}

			// Now we know the columns, now read data row lines
			while((curLine = csvReader.readLine()) != null){
				stringTokenizer = new StringTokenizer(curLine, ",");
				fieldCount = stringTokenizer.countTokens();

				if(fieldCount > 0){
					Element rowElement = newDoc.createElement("row");

					int i=0;
					while(stringTokenizer.hasMoreElements()){
						try{
							String curValue = String.valueOf(stringTokenizer.nextElement());
							Element curElement = newDoc.createElement(csvFields[i++]);
							curElement.appendChild(newDoc.createTextNode(curValue));
							rowElement.appendChild(curElement);
						}
						catch(Exception exp){
						}
					}

					rootElement.appendChild(rowElement);
					rowsCount++;
				}
			}

			csvReader.close();

			// Save the document to the disk file
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();

			Source src = new DOMSource(newDoc);
			Result dest = new StreamResult(new File(xmlFileName));
			aTransformer.transform(src, dest);

			rowsCount++;
		}
		catch(IOException exp){
			System.err.println(exp.toString());
		}
		catch(Exception exp){
			System.err.println(exp.toString());
		}

		return rowsCount;
	}

	public static void main(String[] args){
		try{
			if(args.length != 2){
				System.out.println("Usage: java CSV2XML <inputCSVFile> <outputXMLFile>");
				return;
			}
		}
		catch(Exception exp){
			System.err.println(exp.toString());
		}

		try{
			CSV2XML csvConverter = new CSV2XML();
			int rowsCount = csvConverter.convertFile(args[0], args[1]);

			if(rowsCount >= 0){
				System.out.println("CSV File " + args[0] +
						"' successfully converted to XML File "+ args[1] + "\n" +
						"(" + String.valueOf(rowsCount) + " rows)");
			}
			else{
				System.out.println("Error while converting input CSV File " + args[0] +
						" to output XML File "+ args[1] + " ");
			}
		}
		catch(Exception exp){
			System.err.println(exp.toString());
		}
	} 
}