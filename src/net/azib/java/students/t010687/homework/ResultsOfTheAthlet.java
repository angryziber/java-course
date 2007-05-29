package net.azib.java.students.t010687.homework;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.swing.JDialog;

/**
 * ResultsOfTheAthlet
 *
 * @author Matu
 */
public class ResultsOfTheAthlet extends Athlet{
	private float Sprint_100m; //(sec)
	private float LongJump;	//(m)
	private float ShotPut;		//(m)
	private float HighJump;	//(m)
	private float Sprint_400m;	//(min:sec)
	private float Hurdles_110m;//(sec)
	private float DiscusThrow;	//(m)
	private float PoleVault;	//(m)
	private float JavelinThrow;//(m)
	private float Race_1500m;	//(min:sec)
	
	
	/**
	 * @param specificAthlet
	 */
	public ResultsOfTheAthlet() {
		super();
	}
	/**
	 * @param specificAthlet
	 */
	public ResultsOfTheAthlet(String name, String dateOfBirth, String country) {
		super(name,dateOfBirth,country);
	}
	/**
	 * @return the sprint_100m
	 */	
	public String getSprint_100m() {
		return ((Float)Sprint_100m).toString();
	}
	/**
	 * @param sprint_100m the  sprint_100m to set
	 */
	public void setSprint_100m(String sprint_100m) {
		Sprint_100m = new Float(sprint_100m);
	}
	/**
	 * @return the longJump
	 */
	public String getLongJump() {
		return ((Float)LongJump).toString();
	}
	/**
	 * @param longJump the longJump to set
	 */
	public void setLongJump(String longJump) {
		LongJump = new Float(longJump);
	}
	/**
	 * @return the shotPut
	 */
	public String getShotPut() {
		return ((Float)ShotPut).toString();
	}
	/**
	 * @param shotPut the shotPut to set
	 */
	public void setShotPut(String shotPut) {
		ShotPut = new Float(shotPut);
	}
	/**
	 * @return the highJump
	 */
	public String getHighJump() {
		return ((Float)HighJump).toString();
	}
	/**
	 * @param highJump the highJump to set
	 */
	public void setHighJump(String highJump) {
		HighJump = new Float(highJump);
	}
	/**
	 * @return the sprint_400m
	 */
	public String getSprint_400m() {
		return new SimpleDateFormat("mm:ss.SS").format(Sprint_400m*1000).substring(0, 8);
	    //String s = formatter.format(date);
	}
	/**
	 * @param sprint_400m the sprint_400m to set
	 */
	public void setSprint_400m(String sprint_400m) {
		String RaceData[] = sprint_400m.split(":");
		if (RaceData.length == 2){ 
			Sprint_400m = new Integer(RaceData[0])*60 + new Float(RaceData[1]);
		}
		else if  (RaceData.length == 1){ 
			Sprint_400m = new Float(RaceData[0]);		
		}
	}
	/**
	 * @return the hurdles_110m
	 */
	public String getHurdles_110m() {
		return ((Float)Hurdles_110m).toString();
	}
	/**
	 * @param hurdles_110m the hurdles_110m to set
	 */
	public void setHurdles_110m(String hurdles_110m) {
		Hurdles_110m = new Float(hurdles_110m);
	}
	/**
	 * @return the discusThrow
	 */
	public String getDiscusThrow() {
		return ((Float)DiscusThrow).toString();
	}
	/**
	 * @param discusThrow the discusThrow to set
	 */
	public void setDiscusThrow(String discusThrow) {
		DiscusThrow = new Float(discusThrow);
	}
	/**
	 * @return the poleVault
	 */
	public String getPoleVault() {
		return ((Float)PoleVault).toString();
	}
	/**
	 * @param poleVault the poleVault to set
	 */
	public void setPoleVault(String poleVault) {
		PoleVault = new Float(poleVault);
	}
	/**
	 * @return the javelinThrow
	 */
	public String getJavelinThrow() {
		return ((Float)JavelinThrow).toString();
	}
	/**
	 * @param javelinThrow the javelinThrow to set
	 */
	public void setJavelinThrow(String javelinThrow) {
		JavelinThrow = new Float(javelinThrow);
	}
	/**
	 * @return the race_1500m
	 */
	public String getRace_1500m() {
		return ((Float)Race_1500m).toString();
	}
	/**
	 * @param race_1500m the race_1500m to set
	 */
	public void setRace_1500m(String race_1500m) {
		Race_1500m = new Float(race_1500m);
	}


}
