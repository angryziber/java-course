package net.azib.java.students.t010687.homework;

import java.text.SimpleDateFormat;

/**
 * ResultsOfTheAthlet
 * @author Matu
 */
public class ResultsOfTheAthlet extends Athlet implements Comparable<ResultsOfTheAthlet>{
	private float sprint_100m;	//(sec)
	private float longJump;		//(m)
	private float shotPut;		//(m)
	private float highJump;		//(m)
	private float sprint_400m;	//(min:sec)
	private float hurdles_110m;	//(sec)
	private float discusThrow;	//(m)
	private float poleVault;	//(m)
	private float javelinThrow;	//(m)
	private float race_1500m;	//(min:sec)
	
	
	/*** @param specificAthlet*/
	public ResultsOfTheAthlet() {super();}
	/**
	 * @param specificAthlet
	 */
	public ResultsOfTheAthlet(String name, String dateOfBirth, String country) {
		super(name,dateOfBirth,country);
	}
	/**
	 * @return the sprint_100m
	 */	
	public float getSprint_100m() {
		return sprint_100m;
	}
	/**
	 * @param sprint_100m the  sprint_100m to set
	 */
	public void setSprint_100m(float sprint_100m) {
		this.sprint_100m = sprint_100m;
	}
	/**
	 * @param sprint_100m the  sprint_100m to set
	 */
	public void setSprint_100m(String sprint_100m) {
		try{
			this.sprint_100m = new Float(sprint_100m);
		}
		catch (NumberFormatException e){
			this.sprint_100m =0;
		}
	}
	/**
	 * @return the longJump
	 */
	public float getLongJump() {
		return longJump;
	}
	/**
	 * @param longJump the longJump to set
	 */
	public void setLongJump(float longJump) {
		this.longJump = longJump;
	}
	/**
	 * @param longJump the longJump to set
	 */
	public void setLongJump(String longJump) {
		try{
			this.longJump = new Float(longJump);
		}
		catch (NumberFormatException e){
			this.longJump = 0;
		}
	}
	/**
	 * @return the shotPut
	 */
	public float getShotPut() {
		return shotPut;
	}
	/**
	 * @param shotPut the shotPut to set
	 */
	public void setShotPut(float shotPut) {
		this.shotPut = shotPut;
	}
	/**
	 * @param shotPut the shotPut to set
	 */ 
	public void setShotPut(String shotPut) {
		try{
			this.shotPut = new Float(shotPut);
		}
		catch (NumberFormatException e){
			this.shotPut = 0;
		}
	}
	/**
	 * @return the highJump
	 */
	public float getHighJump() {
		return highJump;
	}
	/**
	 * @param highJump the highJump to set
	 */
	public void setHighJump(float highJump) {
		this.highJump = highJump;
	}
	/**
	 * @param highJump the highJump to set
	 */
	public void setHighJump(String highJump) {
		try{
			this.highJump = new Float(highJump);
		}
		catch (NumberFormatException e){
			this.highJump  = 0;
		}
	}
	/**
	 * @return the sprint_400m
	 */
	public String getSprint_400m() {
		return new SimpleDateFormat("mm:ss.SS").format(sprint_400m*1000).substring(0, 8);
	}
	/**
	 * @param sprint_400m the sprint_400m to set
	 */
	public void setSprint_400m(float sprint_400m) {
		this.sprint_400m = sprint_400m;
	}
	/**
	 * @param sprint_400m the sprint_400m to set
	 */
	public void setSprint_400m(String sprint_400m) {
		String RaceData[] = sprint_400m.split(":");		
		try{
			if (RaceData.length == 2){ 
				this.sprint_400m = new Integer(RaceData[0])*60 + new Float(RaceData[1]);
			}
			else if  (RaceData.length == 1){ 
				this.sprint_400m = new Float(RaceData[0]);
			}
		}
		catch (NumberFormatException e){
			this.sprint_400m  = 0;
		}
	}
	/**
	 * @return the hurdles_110m
	 */
	public float getHurdles_110m() {
		return hurdles_110m;
	}
	/**
	 * @param hurdles_110m the hurdles_110m to set
	 */
	public void setHurdles_110m(float hurdles_110m) {
		this.hurdles_110m = hurdles_110m;
	}
	/**
	 * @param hurdles_110m the hurdles_110m to set
	 */
	public void setHurdles_110m(String hurdles_110m) {
		try{
			this.hurdles_110m = new Float(hurdles_110m);
		}
		catch (NumberFormatException e){
			this.hurdles_110m = 0;
		}
	}
	/**
	 * @return the discusThrow
	 */
	public float getDiscusThrow() {
		return discusThrow;
	}
	/**
	 * @param discusThrow the discusThrow to set
	 */
	public void setDiscusThrow(float discusThrow) {
		this.discusThrow = discusThrow;
	}
	/**
	 * @param discusThrow the discusThrow to set
	 */
	public void setDiscusThrow(String discusThrow) {
		try{
			this.discusThrow = new Float(discusThrow);
		}
		catch (NumberFormatException e){
			this.discusThrow = 0;
		}
	}
	/**
	 * @return the poleVault
	 */
	public float getPoleVault() {
		return poleVault;
	}
	/**
	 * @param poleVault the poleVault to set
	 */
	public void setPoleVault(float poleVault) {
		this.poleVault = poleVault;
	}
	/**
	 * @param poleVault the poleVault to set
	 */
	public void setPoleVault(String poleVault) {
		try{
			this.poleVault = new Float(poleVault);
		}
		catch (NumberFormatException e){
			this.poleVault = 0;
		}
	}
	/**
	 * @return the javelinThrow
	 */
	public float getJavelinThrow() {
		return javelinThrow;
	}
	/**
	 * @param javelinThrow the javelinThrow to set
	 */
	public void setJavelinThrow(float javelinThrow) {
		this.javelinThrow = javelinThrow;
	}
	/**
	 * @param javelinThrow the javelinThrow to set
	 */
	public void setJavelinThrow(String javelinThrow) {
		try{
			this.javelinThrow = new Float(javelinThrow);
		}
		catch (NumberFormatException e){
			this.javelinThrow = 0;
		}
	}
	/**
	 * @return the race_1500m
	 */
	public String getRace_1500m() {
		return new SimpleDateFormat("mm:ss.SS").format(race_1500m*1000).substring(0, 8);
	}
	/**
	 * @param race_1500m the race_1500m to set
	 */
	public void setRace_1500m(float race_1500m) {
		this.race_1500m = race_1500m;
	}
	/**
	 * @param race_1500m the race_1500m to set
	 */
	public void setRace_1500m(String race_1500m) {
		String RaceData[] = race_1500m.split(":");
		try{
			if (RaceData.length == 2){ 
				this.race_1500m = new Integer(RaceData[0])*60 + new Float(RaceData[1]);
			}
			else if  (RaceData.length == 1){ 
				this.race_1500m = new Float(RaceData[0]);		
			}
		}
		catch (NumberFormatException e){
			this.race_1500m = 0;
		}
	}
	/**@return PointsCalc.SPRINT100.getPoints(sprint_100m);*/
	public long getSprint_100mPoints(){
		return PointsCalc.SPRINT100.getPoints(sprint_100m);
	}
	/**@return PointsCalc.LONGJUMP.getPoints(longJump)*/
	public long getLongJumpPoints() {
		return PointsCalc.LONGJUMP.getPoints(longJump);
	}
	/**@return PointsCalc.SHOTPUT.getPoints(shotPut)*/
	public long getShotPutPoints() {
		return PointsCalc.SHOTPUT.getPoints(shotPut);
	}
	/** @return PointsCalc.HIGHJUMP.getPoints(highJump)*/
	public long getHighJumpPoints() {
		return PointsCalc.HIGHJUMP.getPoints(highJump);
	}
	/** @return PointsCalc.SPRINT400.getPoints(sprint_400m)*/
	public long getSprint_400mPoints() {
		return PointsCalc.SPRINT400.getPoints(sprint_400m);
	}
	/**@return return PointsCalc.HURDLES110.getPoints(hurdles_110m)*/
	public long getHurdles_110mPoints() {
		return PointsCalc.HURDLES110.getPoints(hurdles_110m);
	}
	/**@return the discusThrow*/
	public long getDiscusThrowPoints() {
		return PointsCalc.DISCUSTHROW.getPoints(discusThrow);
	} 
	/**@return PointsCalc.POLEVAULT.getPoints(poleVault)*/
	public long getPoleVaultPoints() {
		return PointsCalc.POLEVAULT.getPoints(poleVault);
	}
	/**@return PointsCalc.JAVELINTHROW.getPoints(javelinThrow)*/
	public long getJavelinThrowPoints() {
		return PointsCalc.JAVELINTHROW.getPoints(javelinThrow);
	}
	/**@return PointsCalc.RACE1500.getPoints(race_1500m)*/
	public long getRace_1500mPoints() {
		return PointsCalc.RACE1500.getPoints(race_1500m);
	}
	/**@return PointsTogether*/
	public long getPoints() {
		return 	getSprint_100mPoints() + getLongJumpPoints() +
				getShotPutPoints() + getHighJumpPoints() +
				getSprint_400mPoints() + getHurdles_110mPoints() +
				getDiscusThrowPoints() + getPoleVaultPoints() +
				getJavelinThrowPoints() + getRace_1500mPoints();
	}
	
	public enum PointsCalc {//A  B	C
		SPRINT100	(25.4348,18.0, 1.81,-1),
	    LONGJUMP	(90.5674, 2.20, 1.40, 1), 
	    SHOTPUT   	(51.39, 1.5, 1.05, 1),
	    HIGHJUMP   	(585.65,0.75, 1.42, 1),
	    SPRINT400	(1.53775, 82, 1.81, -1),
	    HURDLES110	(5.74354,28.5, 1.92, -1),
	    DISCUSTHROW	(12.91, 4.0, 1.1, 1),
	    POLEVAULT	(140.182, 1.0, 1.35, 1),
	    JAVELINTHROW(10.14, 7.0, 1.08, 1),
	    RACE1500	(0.03768,480, 1.85,-1);
		//var C=new makearray(1.81,1.4,1.05,1.42,1.81,1.92,1.1,1.35,1.08,1.85);
		//var ala_tyyp=new makearray(-1,1,1,1,-1,-1,1,1,1,-1);
		
		double A; double B; double C; int Type;
	    
		PointsCalc (double A,double B,double C, int Type) {
			this.A = A; this.B = B; this.C = C; this.Type = Type;  
	    }
	    public long getPoints(float areaResult) {
	    	//Points = A*(B-P)C for Running Events
	    	return areaResult != 0 ? Math.round(A * Math.pow(Type*(areaResult - B),C) - 0.5):0;
	    }
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public final int compareTo(ResultsOfTheAthlet ComparedResultsOfTheAtlet) {
		ResultsOfTheAthlet rs = (ResultsOfTheAthlet)ComparedResultsOfTheAtlet; 
		return ((int)rs.getPoints() - (int)getPoints());
	}

}
