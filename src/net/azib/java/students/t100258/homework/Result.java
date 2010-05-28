package net.azib.java.students.t100258.homework;



/**
 * Result
 *
 * @author mihkel
 * 
 */
public class Result {
	public String name;
    public String country;
    public String date;
    public float sprint_100;
    public float long_jump;
    public float short_put;
    public float hurdles;
    public float discus_throw;
    public float pole_vault;
    public float jevelin_throw;
    public float high_jump;
    public String sprint_400;
    public String race;
    public int sum;
    public int place;

    
    /**
    * @param name Name of athlete
    * @param date Date of birth of athlete
    * @param country Two letter country code of athlete
    * @param name Name of athlete
    * @param sprint_100 result of 100m sprint
    * @param long_jump result of long jump
    * @param short_put result of short put
    * @param hurdles result of 110m hurdles
    * @param discus_throw result of discus throw
    * @param pole_vault result of pole vault
    * @param jevelin_throw result of jevelin throw
    * @param high_jump result of high jump
    * @param sprint_400 result of 400m sprint
    * @param race result of 1500m race
    * @param sum total sum of points
    * 
    */
public Result(String name, String date, String country, float sprint_100, float long_jump, float short_put, float high_jump, String sprint_400, float hurdles, float discus_throw, float pole_vault, float jevelin_throw,  String race, int sum, int place) {
	this.name=name;
	this.country=country;
	this.date=date;
	this.sprint_100=sprint_100;
	this.long_jump=long_jump;
	this.short_put=short_put;
	this.hurdles=hurdles;
	this.discus_throw=discus_throw;
	this.pole_vault=pole_vault;
	this.jevelin_throw=jevelin_throw;
	this.high_jump=high_jump;
	this.sprint_400=sprint_400;
	this.race=race;
	this.sum=sum;
	this.place=place;

}
}
