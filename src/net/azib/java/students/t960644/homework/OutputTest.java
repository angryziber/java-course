package net.azib.java.students.t960644.homework;

import java.text.ParseException;


/**
 * OutputTest
 *
 * @author Lembit
 */
public class OutputTest {
	/**
	 * A handy Athlete for testing output methods.
	 * @return
	 */
	public static Athlete singleAthlete() {
		Athlete a = new Athlete();
		a.setName("Peeter Hülss");
		try {
			a.setBirthDate("01.05.1986");
		}
		catch (ParseException e) {
			// do nothing
		}
		a.setCountryCode("EE");		
		return a;
	}
	/**
	 * A handy Result for testing output methods.
	 * @return
	 */
	public static Result singleResult() {
		Result res = new Result();
		res.setAthlete(singleAthlete());
		res.setPosition("1");
		res.setRace100(10.60);
		res.setLongJump(7.63);
		res.setShotPut(14.90);
		res.setHighJump(2.03);
		res.setRace400(46.23);
		res.setHurdles110(14.40);
		res.setDiscusThrow(43.40);
		res.setPoleVault(5.40);
		res.setJavelinThrow(67.01);
		res.setRace1500(269.58);
		return res;
	}
	
	public static Competition singleCompetition() {
		Competition comp = new Competition();
		Result res = singleResult();
		comp.addResult(res);
		comp.addAthlete(res.getAthlete());
		try {
			comp.setDate("01.06.2007");
		}
		catch (ParseException e) {
			// do nothing 
			// e.printStackTrace();
		}
		comp.setCountryCode("EE");
		comp.setDescription("Kükametsa");
		
		return comp;
	}
	

}
