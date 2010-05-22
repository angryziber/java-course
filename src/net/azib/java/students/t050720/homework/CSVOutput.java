package net.azib.java.students.t050720.homework;

import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * CSVOutput
 *
 * @author Marek
 */
public class CSVOutput implements Output {

	private File f;
	/**
	 * @param parameters
	 */
	public CSVOutput(String filename) {
		f = new File(filename);
	}

	@Override
	public void flush(ArrayList<Record> records) throws Exception {
		
		PrintWriter writer=new PrintWriter(f);
		
		Iterator<Record> iterator=records.iterator();
		
		int position=1;
		int lastPos=1;
		int lastScore=0;
		while (iterator.hasNext())
		{
			DecimalFormat df= new DecimalFormat("0.00");
			DecimalFormatSymbols s=df.getDecimalFormatSymbols();
			s.setDecimalSeparator('.');
			df.setDecimalFormatSymbols(s);
			DecimalFormat raceF=new DecimalFormat("00.00");
			DecimalFormatSymbols raceS=raceF.getDecimalFormatSymbols();
			raceS.setDecimalSeparator('.');
			raceF.setDecimalFormatSymbols(raceS);
			Record current = iterator.next();
			String r400, r1500;
			if(current.getRace_400m()>59.99)
			{
				Integer minutes=(int) (current.getRace_400m() / 60.0);
				Float seconds= (float) (current.getRace_400m()-((float) minutes*60.0));
				r400=new String(minutes.toString()+":"+raceF.format(seconds));
			}
			else r400=df.format(new Float(current.getRace_400m()));
			Integer r1500min=(int) (current.getRace_1500m() / 60.0);
			Float r1500s=(float) (current.getRace_1500m() - ((float) r1500min *60.0));
			r1500=new String(r1500min.toString()+":"+raceF.format(r1500s));
			if(lastScore!=current.getScore()) 
			{
				lastPos=position;
				lastScore=current.getScore();
			}
			writer.println(lastPos + "," 
					+ current.getScore() + ",\"" 
					+ current.getAthlete() + "\"," 
					+ current.getBirthDate() + ","
					+ current.getCountry() + ","
					+ df.format(current.getRace_100m()) + ","
					+ df.format(current.getLong_jump()) + ","
					+ df.format(current.getShot_put()) + ","
					+ df.format(current.getHigh_jump()) + ","
					+ r400 + ","
					+ df.format(current.getHurdles_110m()) + ","
					+ df.format(current.getDiscus_throw()) + ","
					+ df.format(current.getPole_vault()) + ","
					+ df.format(current.getJavelin_throw()) + ","
					+ r1500);
			position++;
		}
		writer.close();
	}

}
