package net.azib.java.students.t104607.homework;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 104607 IASM
 */
public class Athlete implements Comparable<Athlete>{
	private String name;
	private Date birthday;
	private String country;
	private double sprint100m;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double sprint400m;
	private double hurdles110m;
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double race1500m;

	private String position;
	private DecimalFormat df = new DecimalFormat("#.##");
	private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	private double min2sec(String min) {
		if (min.contains(":")) {
			String[] split = min.split(":");
			return new Double(split[0]) * 60 + new Double(split[1]);
		} else {
			return new Double(min);
		}
	}

	private String sec2min(double sec) {
		if (sec < 60) {
			return df.format(sec);
		} else {
			Integer minutes = (int) sec / 60;
			DecimalFormat df = new DecimalFormat("00.##");  // we need extra 0 here
			return minutes.toString() + ":" + df.format(sec - (60*minutes));
		}
	}

	Athlete(String name, Date birthday, String country, double sprint100m, double longJump, double shotPut,
	     double highJump, double sprint400m, double hurdles110m, double discusThrow, double poleVault,
	     double javelinThrow, double race1500m) {
		this.name = name;
		this.birthday = birthday;
		this.country = country;
		this.sprint100m = sprint100m;
		this.longJump = longJump;
		this.shotPut = shotPut;
		this.highJump = highJump;
		this.sprint400m = sprint400m;
		this.hurdles110m = hurdles110m;
		this.discusThrow = discusThrow;
		this.poleVault = poleVault;
		this.javelinThrow = javelinThrow;
		this.race1500m = race1500m;
	}

	Athlete(String name, String birthday, String country, String sprint100m, String longJump, String shotPut,
	     String highJump, String sprint400m, String hurdles110m, String discusThrow, String poleVault,
	     String javelinThrow, String race1500m) throws ParseException {
		this.name = name;
		this.birthday = dateFormat.parse(birthday);
		this.country = country;
		this.sprint100m = min2sec(sprint100m);
		this.longJump = new Double(longJump);
		this.shotPut = new Double(shotPut);
		this.highJump = new Double(highJump);
		this.sprint400m = min2sec(sprint400m);
		this.hurdles110m = min2sec(hurdles110m);
		this.discusThrow = new Double(discusThrow);
		this.poleVault = new Double(poleVault);
		this.javelinThrow = new Double(javelinThrow);
		this.race1500m = min2sec(race1500m);
	}

	public String getName() {
		return name;
	}

	public String getBirthday() {
		return dateFormat.format(birthday);
	}

	public String getCountry() {
		return country;
	}

	public String getSprint100m() {
		return sec2min(sprint100m);
	}

	public String getLongJump() {
		return df.format(longJump);
	}

	public String getShotPut() {
		return df.format(shotPut);
	}

	public String getHighJump() {
		return df.format(highJump);
	}

	public String getSprint400m() {
		return sec2min(sprint400m);
	}

	public String getHurdles110m() {
		return sec2min(hurdles110m);
	}

	public String getDiscusThrow() {
		return df.format(discusThrow);
	}

	public String getPoleVault() {
		return df.format(poleVault);
	}

	public String getJavelinThrow() {
		return df.format(javelinThrow);
	}

	public String getRace1500m() {
		return sec2min(race1500m);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getScore() {
		return Points.SPRINT100M.getPoints(sprint100m) +
				Points.LONGJUMP.getPoints(longJump) +
				Points.SHOTPUT.getPoints(shotPut) +
				Points.HIGHJUMP.getPoints(highJump) +
				Points.SPRINT400M.getPoints(sprint400m) +
				Points.HURDLES110M.getPoints(hurdles110m) +
				Points.DISCUSTHROW.getPoints(discusThrow) +
				Points.POLEVAULT.getPoints(poleVault) +
				Points.JAVELINTHROW.getPoints(javelinThrow) +
				Points.RACE1500M.getPoints(race1500m);

	}

	@Override
	public int compareTo(Athlete athlete) {
		return this.getScore() - athlete.getScore();
	}
}
