package net.azib.java.students.t107675.homework;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

/**
 * In this part, competitors are created from Array list of Athlete to be used in XML documentation.
 */
public class Athletes {

	public  ArrayList<Athlete> competitors;

	//@XmlElementWrapper(name="athlete")
	public ArrayList<Athlete> getAthletes() {
		return competitors;
	}

	public Athletes() {
		competitors = new ArrayList<Athlete>();
	}

	public void addAthlete(Athlete athlete){
		competitors.add(athlete);
	}


	/**
	 *  Athletes are being sorted here from the highest result to lowest result.
	 */

	public void sortAthletes() {
		Collections.sort(competitors, new Comparator<Athlete>() {
			public int compare(Athlete o1, Athlete o2) {
				Athlete p1 = (Athlete) o1;
				Athlete p2 = (Athlete) o2;
				return (p1.getTotalScore() < p2.getTotalScore() ? 1 : 0);
			}
		});
	}

}