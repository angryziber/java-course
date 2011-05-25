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
import java.util.ArrayList;

public class DataToHTMLWriter {
    public void writeDataToHTML(ArrayList<Athlete> athletes, String outputParam) {
        String path = new CoustomUtilities().getAbsolutePath(outputParam);

        DataToXMLWriter dtx = new DataToXMLWriter();
        dtx.writeDataToXml(athletes, "outputForHtml.xml");

        try {
            // OutputForHTML.xml should be outputed to .homework directory
            StreamSource source = new StreamSource(new CoustomUtilities().getAbsolutePath("OutputForHtml.xml"));
            StreamResult result = new StreamResult(new FileOutputStream(path));


            Transformer trans = TransformerFactory.newInstance().newTransformer(new StreamSource("OutputForHtml.xsl"));
            trans.transform(source, result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
