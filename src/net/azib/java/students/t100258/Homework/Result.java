package net.azib.java.students.t100258.Homework;



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
    public Float sprint_100;
    public Float long_jump;
    public Float short_put;
    public Float hurdles;
    public Float discus_throw;
    public Float pole_vault;
    public Float jevelin_throw;
    public Float high_jump;
    public String sprint_400;
    public String race;
    public Integer sum;
    public Integer place;

    
    /**
    * @param namea Name of athlete
    * @param datea Date of birth of athlete
    * @param countrya Two letter country code of athlete
    * @param namea Name of athlete
    * @param sprint_100a result of 100m sprint
    * @param long_jumpa result of long jump
    * @param short_puta result of short put
    * @param hurdlesa result of 110m hurdles
    * @param discus_throwa result of discus throw
    * @param pole_vaulta result of pole vault
    * @param jevelin_throwa result of jevelin throw
    * @param high_jumpa result of high jump
    * @param sprint_400a result of 400m sprint
    * @param racea result of 1500m race
    * @param suma total sum of points
    * 
    */
public Result(String namea, String datea, String countrya, Float sprint_100a, Float long_jumpa, Float short_puta, Float high_jumpa, String sprint_400a, Float hurdlesa, Float discus_throwa, Float pole_vaulta, Float jevelin_throwa,  String racea, int suma, int placea) {
	name=namea;
    country=countrya;
    date=datea;
    sprint_100=sprint_100a;
    long_jump=long_jumpa;
    short_put=short_puta;
    hurdles=hurdlesa;
    discus_throw=discus_throwa;
    pole_vault=pole_vaulta;
    jevelin_throw=jevelin_throwa;
    high_jump=high_jumpa;
    sprint_400=sprint_400a;
    race=racea;
    sum=suma;
    place=placea;

}
}
