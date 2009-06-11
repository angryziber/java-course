package net.azib.java.students.t072073.homework;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.jdom.Attribute;
import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * Decathlon
 *
 * @author janika
 * @description set of athletes, who compete in the same decathlon
 */
public class Decathlon {
	  private Set <Athlete> athletes = new TreeSet<Athlete>();
	  
	  /**
	   * 
	   * @param athlete who will be added to the competition. 
	   * Updates athletes places.
	   */
	  public void add(Athlete athlete){
		  athletes.add(athlete);
		  setPlaces();
	  } 
	  
	  /**
	   * 
	   * @return set of athletes in the competition
	   */
	  public Set <Athlete> getAthletes(){
		  return athletes;
	  }
	  
	  private void setPlaces(){
		  Iterator <Athlete> athletesIterator = athletes.iterator();
		  int index = 1;
		  while(athletesIterator.hasNext()){
			  Athlete athlete = athletesIterator.next();	  
			  athlete.setPlace(Integer.toString(index));
			  index++;
		  }
	  }
	  
	  /**
	   * @description - prints all the athletes to the console
	   */
	  public void printToConsole(){
		for(Athlete ath : athletes){
			System.out.println(ath.toString());
		}
	  }
	  
	  /**
	   * 
	   * @return xml document of this competition
	   */
	  public Document toXml(){
			Element decathlonElement = new Element("decathlon");
			DocType documentType = new DocType("decathlon","decathlon.dtd");
			Document decathlonDocument = new Document(decathlonElement, documentType);
			for(Athlete ath : athletes){
				
				decathlonElement.addContent(ath.toXml());
			}
			return decathlonDocument;
	  }
}
