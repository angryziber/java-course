package net.azib.java.students.t103640.homework;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataToHTMLWriter {
    public void writeDataToHTML(ArrayList<Athlete> athletes, String outputParam) {
        String path = new CustomUtilities().getAbsolutePath(outputParam);

        DataToXMLWriter dtx = new DataToXMLWriter();
        dtx.writeDataToXml(athletes, "outputForHtml.xml");

        try {

            StreamSource source = new StreamSource(new CustomUtilities().getAbsolutePath("OutputForHtml.xml"));
            StreamResult result = new StreamResult(new FileOutputStream(path));

	        InputStream xsl = getClass().getResourceAsStream("OutputFormatForHtml.xsl");
            Transformer trans = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl));
            trans.transform(source, result);

        } catch (FileNotFoundException e) {
	        System.out.println("Could not open the file");
        } catch (TransformerConfigurationException e) {
	        System.out.println("Something with xsl failed");
        } catch (TransformerException e) {
	        System.out.println("Could not transform to HTML");
        } catch (IOException e) {
	        System.out.println("InputOutput Exception" + e.getMessage());
        }
    }


}
