package net.azib.java.students.t072054.hometask1;

/**
 * CreatXMLFile
 *
 * @author r_vassiljev
 */
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
 
public class CreatXMLFile {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number to add elements in your XML file: ");
		String str = bf.readLine();
		int no = Integer.parseInt(str);
		System.out.print("Enter root: ");
		String root = bf.readLine();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
		Element rootElement = document.createElement(root);
        document.appendChild(rootElement);
		for (int i = 1; i <= no; i++){
			System.out.print("Enter the element: ");
			String element = bf.readLine();
			System.out.print("Enter the data: ");
			String data = bf.readLine();
			Element em = document.createElement(element);
			em.appendChild(document.createTextNode(data));
			rootElement.appendChild(em);
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result =  new StreamResult(System.out);
        transformer.transform(source, result);
	}
}
