package net.azib.java.students.t092860.homework;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * OutputToXML
 *
 * @author scythe
 */
class OutputToXML implements Output {

	private static Logger logger = Logger.getLogger("global");
	
	OutputToXML(){}
	
	OutputToXML(OutputStream out)
	{
		output = out;
	}
	
	public void set(List<Data> dataList) throws Exception
	{
	    XMLOutputter outputter = new XMLOutputter();
		outputter.output(generateXML(dataList), output);	
	}
	
	public String getXML(List<Data> dataList) throws Exception
	{
		XMLOutputter outputter = new XMLOutputter();
		return outputter.outputString(generateXML(dataList));
	}
	
	private Document generateXML(List<Data> dataList) throws Exception
	{
		logger.info("Generate XML");

    	Element competition = new Element("Competition");
    	Document doc = new Document(competition);
    	
    	Iterator<Data> it = dataList.iterator(); 
		while(it.hasNext()) 
		{
			Data data = it.next();
			
		    Element athlete = new Element("Athlete");
		    
		    Element pos = new Element("Position");
		    pos.addContent(data.getPosition());
		    athlete.addContent(pos);
		    
		    Element score = new Element("Score");
		    score.addContent(String.valueOf(data.getScore()));
		    athlete.addContent(score);
		    
		    Element name = new Element("Name");
		    name.addContent(data.getName());
		    athlete.addContent(name);
		    
		    Element birthdate = new Element("Birthdate");
		    try{
		    	birthdate.addContent(SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, Locale.getDefault()).format(data.getDate()));
		    }
		    catch(NullPointerException e){
		    	birthdate.addContent(String.valueOf(data.getDate()));
		    }
		    athlete.addContent(birthdate);

		    Element country = new Element("Country");
		    country.addContent(data.getCountry());
		    athlete.addContent(country);
		    
		    Element events = new Element("Events");
		    
		    Collection<Events> eventColl = data.getEvents();
		    for (Events e : eventColl) 
		    {
		        Element event = new Element(String.valueOf(e));
		        event.addContent(String.valueOf(data.getEventResult(e)));
		        events.addContent(event);
		    }
		    
		    athlete.addContent(events);
		    competition.addContent(athlete);		    
		}
		logger.info("XML created successfully");
		
		return doc;
	}
	
	private OutputStream output;
}
