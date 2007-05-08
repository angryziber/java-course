package net.azib.java.students.t020556.homework;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Competitor class resembles dechatlon competitors
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public class Competitor {
	//data members
	private Map<DecathlonEvent.Running, Double> runningEvents = 
		new EnumMap<DecathlonEvent.Running, Double>(DecathlonEvent.Running.class);
	private Map<DecathlonEvent.Field, Double> fieldEvents = 
		new EnumMap<DecathlonEvent.Field, Double>(DecathlonEvent.Field.class);
	
	private String name = null;
	private Calendar dateOfBirth = null;
	private Locale locale = null;

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * setEventResult method sets the competitor event result
	 * 
	 * @author Agu Aarna
	 * 
	 * @param fieldEvent - specifies an event
	 * @param result - specifies the event's result of the competitor
	 * 
	 * @version 1
	 */
	public void setEventResult(DecathlonEvent.Running event, double result){
		runningEvents.put(event, result);
	}
	
	/**
	 * setEventResult method sets the competitor event result
	 * 
	 * @author Agu Aarna
	 * 
	 * @param fieldEvent - specifies an event
	 * @param result - specifies the event's result of the competitor
	 * 
	 * @version 1
	 */
	public void setEventResult(DecathlonEvent.Field event, double result){
		fieldEvents.put(event, result);
	}
	
	/**
	 * getRunningEventMap method returns the results of runnning events as a Map
	 * 
	 * @author Agu Aarna
	 * 
	 * @param fieldEvent - specifies an event
	 * @param result - specifies the event's result of the competitor
	 */
	public Map<DecathlonEvent.Running, Double> getRunningEventMap(){
		return runningEvents;
	}
	
	/**
	 * getFieldEventMap method returns the results of field events as a Map
	 * 
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public Map<DecathlonEvent.Field, Double> getFieldEventMap(){
		return fieldEvents;
	}

	/**
	 * createDateOfBirth creates the birth date (from scratch if needed).
	 * 
	 * @author Agu Aarna
	 * 
	 * @param dateOfBirht the dateOfBirth
	 * 
	 * @version 1
	 */
	private void createDateOfBirth(Date dateOfBirth) {
		if(this.dateOfBirth == null)
			this.dateOfBirth = new GregorianCalendar(new Locale("et"));
		this.dateOfBirth.setTime(dateOfBirth);
	}

	/**
	 * @author Agu Aarna
	 * 
	 * @return the dateOfBirth
	 * 
	 * @version 1
	 */
	public Date getDateOfBirth() {
		if(dateOfBirth == null)
			return null;
		return dateOfBirth.getTime();
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 *
	 * @version 1
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		createDateOfBirth(dateOfBirth);
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 *
	 * @version 1
	 */
	public void setDateOfBirth(String dateOfBirth) {
		try {
			Date date = (new SimpleDateFormat("dd.mm.yyyy")).parse(dateOfBirth);
			createDateOfBirth(date);
		}
		catch (ParseException e) {
			LOG.log(
				Level.SEVERE, 
				"Unable to parse given date of birth: \"" + dateOfBirth + "\"!" + 
				"The date has to be in a format \"dd.mm.yyyy\"",
				e);
		}
	}

	/**
	 * @author Agu Aarna
	 * 
	 * @return the locale
	 * 
	 * @version 1
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @author Agu Aarna
	 * 
	 * @param locale - the locale to set
	 * 
	 * @version 1
	 */
	public void setLocale(String locale) {
		if(locale.matches("[A-Z]{2}"))
			this.locale = new Locale(locale.toLowerCase());
		else
			LOG.warning("Unable to set string \"" + locale + "\" as locale!");
	}

	/**
	 * @author Agu Aarna
	 * 
	 * @param locale - the locale to set
	 * 
	 * @version 1
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * @author Agu Aarna
	 * 
	 * @return the name
	 * 
	 * @version 1
	 */
	public String getName() {
		return name;
	}

	/**
	 * @author Agu Aarna
	 * 
	 * @param name the name to set
	 * 
	 * @version 1
	 */
	public void setName(String name) {
		if(name == null){
			LOG.warning("Unable to set a given name: " + name);
			return;
		}
		try {
			this.name = new String(name.getBytes("UTF-16"), "UTF-16");
		}
		catch (UnsupportedEncodingException e) {
			LOG.log(Level.SEVERE, "Unable to decode string \"" + name + "\" to UTF-8.", e);
		}
	}
	
	
}
