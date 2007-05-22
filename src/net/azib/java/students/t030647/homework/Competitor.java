package net.azib.java.students.t030647.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Competitor
 * Information about participant
 * @author Igor
 */
public class Competitor {
	
	private String name;
	private Date birthday;
	private String country;
	private Second running100m;
	private Second running400m;
	private Second running1500m;
	private Second running110m;
	private Meter longJump;
	private Meter shotPut;
	private Meter highJump;
	private Meter discusThrow;
	private Meter poleVault;
	private Meter javelinThrow;
	private DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
	
	public Competitor(String inputData) throws ParseException {
		String[] inp = inputData.split(",");
		if (inp.length != 13) {
			
		}
		else {
			try {
				for (int i=0; i<13; i++) {
					name = inp[0];
					birthday = df.parse(inp[1]);
					country = inp[2];
					running100m = new Second(inp[3]);
					longJump = new Meter(inp[4]);
					shotPut = new Meter(inp[5]);
					highJump = new Meter(inp[6]);
					running400m = new Second(inp[7]);
					running110m = new Second(inp[8]);
					discusThrow = new Meter(inp[9]);
					poleVault = new Meter(inp[10]);
					javelinThrow = new Meter(inp[11]);
					running1500m = new Second(inp[12]);
				}
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Returns information about participant
	 */
	public String toString() {
		
		String data = name + "," + df.format(birthday) + "," + country + "," + running100m.toString() + "," 
		+ longJump.toString() + "," +  shotPut.toString() + "," + highJump.toString() + "," + running400m.toString() 
		+ "," + running110m.toString() + "," + discusThrow.toString() + "," + poleVault.toString()
		 + "," + javelinThrow.toString() + "," + running1500m.toString();
		
		return data;
	}
	
	/**
	 * 
	 * @return participant's result in points
	 */
	public int getResult() {
		
		double result = 0;
		
		result += (25.437*Math.pow(18.0-(running100m.getMinutes()*60+running100m.getSeconds()+running100m.getMilliseconds()/100), 1.81));
		result += (0.14354*Math.pow((longJump.getMeters()*100+longJump.getCentimeters())-220, 1.40));
		result += (51.39*Math.pow((shotPut.getMeters()+shotPut.getCentimeters()/100)-1.5, 1.05));
		result += (0.8465*Math.pow((highJump.getMeters()*100+highJump.getCentimeters())-75, 1.42));
		result += (1.53775*Math.pow(82-(running400m.getMinutes()*60+running400m.getSeconds()+running100m.getMilliseconds()/100), 1.81));
		result += (5.74352*Math.pow(28.5-(running110m.getMinutes()*60+running110m.getSeconds()+running110m.getMilliseconds()/100), 1.92));
		result += (12.91*Math.pow((discusThrow.getMeters()+discusThrow.getCentimeters()/100)-4, 1.1));
		result += (0.2797*Math.pow((poleVault.getMeters()*100+poleVault.getCentimeters())-100, 1.35));
		result += (10.14*Math.pow((javelinThrow.getMeters()+javelinThrow.getCentimeters()/100)-7, 1.08));
		result += (0.03768*Math.pow(480-(running1500m.getMinutes()*60+running1500m.getSeconds()+running1500m.getMilliseconds()/100), 1.85));
		
		
		return (int)result;
	}
	
}
