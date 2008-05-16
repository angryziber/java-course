package net.azib.java.students.t011861.homework;

import java.io.File;
import java.util.List;

import org.dom4j.Document;

/**
 * OutDataToXml
 *
 * @author 011861
 * @param Input parameters are output filename and data from ProcessedData module!
 * @return Result is generated XML file in projects root directory
 */
public class OutDataToXml {
	public void showInXmlFile(File output, List<String[]> completeData) {
		//Create XML document tree
		CreateDocument newDoc = new CreateDocument();
		Document doc = newDoc.createDocument(completeData);
		//Write XML tree into a file
		WriteIntoFile writeFile = new WriteIntoFile();
		writeFile.writeIntoFile(output, doc);	
	}
}
