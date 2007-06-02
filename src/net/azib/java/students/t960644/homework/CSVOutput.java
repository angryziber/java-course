package net.azib.java.students.t960644.homework;

import java.sql.Date;

/**
 * CSVOutput
 *
 * @author Lembit
 */
public class CSVOutput {
	
	public void writeData(Competition competition) {
		for (Result r:competition.getResults()){
			System.out.println(writeLine(r));
		}
	}
	
	protected StringBuffer writeLine(Result result) {
		return new StringBuffer(result.getPosition()).append(",").
		append(Integer.toString(result.calcResult())).append(",").
			append(quotation(result.getAthlete().getName())).append(",").
			append(result.getAthlete().getBorn().toString()).append(",").
			append(result.getAthlete().getCountryCode()).append(",").
			append(DecathlonEvent.RACE_100M.eventResultFormat(result.getRace100())).append(",").
			append(DecathlonEvent.LONG_JUMP.eventResultFormat(result.getLongJump())).append(",").
			append(DecathlonEvent.SHOT_PUT.eventResultFormat(result.getShotPut())).append(",").
			append(DecathlonEvent.HIGH_JUMP.eventResultFormat(result.getHighJump())).append(",").
			append(DecathlonEvent.RACE_400M.eventResultFormat(result.getRace400())).append(",").
			append(DecathlonEvent.HURDLES_110M.eventResultFormat(result.getHurdles110())).append(",").
			append(DecathlonEvent.DISCUS_THROW.eventResultFormat(result.getDiscusThrow())).append(",").
			append(DecathlonEvent.POLE_VAULT.eventResultFormat(result.getPoleVault())).append(",").
			append(DecathlonEvent.JAVELIN_THROW.eventResultFormat(result.getJavelinThrow())).append(",").
			append(DecathlonEvent.RACE_1500M.eventResultFormat(result.getRace1500()));
	}
	
	protected StringBuffer quotation(String src) {
		return new StringBuffer(src).insert(0,'"').append('"');
	}
	
	public static void main(String[] args) {
		CSVOutput co = new CSVOutput();
		Result res = new Result();
		Athlete a = new Athlete();
		a.setName("Peeter Pauksoo");
		a.setBorn(Date.valueOf("1950-05-01"));
		a.setCountryCode("EE");
		res.setAthlete(a);
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
		System.out.println(co.writeLine(res));
		
	}
}
