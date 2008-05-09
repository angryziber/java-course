package net.azib.java.students.t011861.homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * UNUSED
 *
 * @author 011861
 */
public class UNUSED {
		private static final String[] sports = { "name", "date_of_birth",
			"country", "Results:","100 m", "long jump", "shot put", "high jump", "400 m",
			"110 m hurdles", "discus throw", "pole vault", "javelin throw",
			"1500 m", "score", "place" };
		public void generateWithSAX(String filename, List<String[]> finalData)
		  {
		    try
		    {
		      FileOutputStream fos = new FileOutputStream(filename);
		      OutputFormat of = new OutputFormat("XML","UTF-8",true);
		      of.setIndent(1);
		      of.setIndenting(true);
		      of.setDoctype(null,"athletes.dtd");
		      XMLSerializer serializer = new XMLSerializer(fos,of);
		      // SAX2.0 ContentHandler.
		      ContentHandler hd = serializer.asContentHandler();
		      hd.startDocument();
		      // Processing instruction sample.
		      //hd.processingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"athletes.xsl\"");
		      // ATHLETE attributes.
		      AttributesImpl atts = new AttributesImpl();
		      // ATHLETES tag.
		      hd.startElement("","","ATHLETES",atts);
		      // ATHLETE tags.
		    	  for (String[] athleteData : finalData)
		    	  {
		    		  	atts.clear();
		        		atts.addAttribute("","",sports[0],"CDATA",athleteData[0]);
		        		atts.addAttribute("","",sports[1],"CDATA",athleteData[1]);
		        		atts.addAttribute("","",sports[2],"CDATA",athleteData[2]);
		        		atts.addAttribute("","",sports[14],"CDATA",athleteData[13]);
		        		atts.addAttribute("","",sports[15],"CDATA",athleteData[14]);
		        		hd.startElement("","","ATHLETE",atts);
		        			hd.characters(sports[3].toCharArray(),0,sports[3].length());
		        			hd.characters(" ".toCharArray(),0,1);
		        			int k = 3;
		        			while (k<13)
		        			{
		        				hd.characters(athleteData[k].toCharArray(),0,athleteData[k].length());
		        					if (k != 12)
		        						{
		        							hd.characters(",".toCharArray(),0,1);
		        						}
		        				k++;
		    	        
		  	    	  		}
		        			hd.endElement("","","ATHLETE");
		        	}
		      hd.endElement("","","ATHLETES");
		      hd.endDocument();
		      fos.close();
		      
		    } catch (SAXException se)
		      {
		        se.printStackTrace();
		      }
		      catch (IOException ioe)
		      {
		        ioe.printStackTrace();
		      }
		  }
}
