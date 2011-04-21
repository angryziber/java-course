package ee.ttu.decathlon.io;

import ee.ttu.decathlon.DecathlonException;
import org.apache.commons.io.IOUtils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class HtmlOutput extends XmlOutput {

    public HtmlOutput(File outputFile) {
        super(outputFile);
    }

    @Override
    void createOutput() {
        FileOutputStream out = null;
        try {
            Transformer t = TransformerFactory.newInstance()
                    .newTransformer(new StreamSource(new File("res" + File.separator + "decathlon.xsl")));
            out = new FileOutputStream(getOutputFile());
            t.transform(new DOMSource(getDocument()), new StreamResult(out));
        } catch (TransformerException e) {
            throw new DecathlonException("unable to transform xml document to html");
        } catch (FileNotFoundException e) {
            throw new DecathlonException("no such file: " + getOutputFile().getAbsolutePath());
        } finally {
            IOUtils.closeQuietly(out);
        }
    }
}
