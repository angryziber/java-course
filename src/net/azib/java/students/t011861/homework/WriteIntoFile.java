package net.azib.java.students.t011861.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.XMLWriter;

/**
 * WriteIntoFile
 *
 * @author 011861
 * @param Input parameters are output filename and data document!
 * @return Result is generated file file! This class is used by OutDataToHtml and OutDataToXml modules!
 */
public class WriteIntoFile {
	public void writeIntoFile(File output, Document document) {
        XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
			writer.write(document);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding" + e);
		} catch (FileNotFoundException e) {
			System.out.println(output + " file not found!");
		} catch (IOException e) {
			System.out.println("Writing into " + output + " file failed!");
		} finally {
			try {
				writer.close();
			} catch (IOException e1) {
				System.out.println("Problem with closing " + output + " file");
			}
		}
	}
}
