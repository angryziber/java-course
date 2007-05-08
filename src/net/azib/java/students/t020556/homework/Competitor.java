package net.azib.java.students.t020556.homework;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Competitor class resembles dechatlon competitors
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public class Competitor 
	extends EnumMap<DecathlonEvent, Double>
	implements Comparable{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 3512693074923315896L;

	private String name = null;
	private Calendar dateOfBirth = null;
	private Locale locale = null;

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	/**
	 * the constructor
	 * 
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public Competitor() {
		super(DecathlonEvent.class);
	}

	/**
	 * the constructor
	 * 
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public Competitor(EnumMap<DecathlonEvent, Double> map) {
		super(map);
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
	
	/**
	 * getFinalResult method returns the the final result of the copetitor. If for some reason
	 * a particular event result is missing, the method terminates returning 0
	 * 
	 * @author Agu Aarna
	 * 
	 * @param competitor to compare to
	 * 
	 * @version 1
	 */
	public double getFinalResult() {
		double result = 0;
		
		//first handle running
		for(DecathlonEvent event : DecathlonEvent.values()){
			Double d = this.get(event);
			if(d == null){
				LOG.warning(
					"Missing " + this.name + "'s event points for event " + event.getName() + "!");
				return 0;
			}
			
			result += d;
		}
		return result;
	}
	
	/**
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * @author Agu Aarna
	 * 
	 * @param competitor to compare to
	 * 
	 * @version 1
	 */
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Competitor))
			return -1;
		
		double d = this.getFinalResult() - ((Competitor)o).getFinalResult();
		
		if (d < 0)
			return -1;
		else if (d > 0)
			return 1;
		return 0;
	}
}
