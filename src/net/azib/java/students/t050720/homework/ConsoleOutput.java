package net.azib.java.students.t050720.homework;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * <b>ConsoleOutput</b>
 * <br />
 * Displays data to the console. Implements Output interface.
 * Data displayed is basically in the same format that gets output to .csv files,
 * apart from the column header.
 *
 * @see net.azib.java.students.t050720.homework.Output
 * @author Marek
 */
public class ConsoleOutput implements Output {

	/**
	 * Displays the data from the passed ArrayList<Record>, preceded by a header.
	 * Position is calculated here on the fly: If the previous or next records have the same score,
	 * then the ArrayList is searched forwards and backwards starting from the current position,
	 * to find out the start and end of the "tie" and then display that region. This is done for
	 * every item that partakes in a tie, so for a competition with many or large ties it can get slow-ish.
	 * Although the format of decathlon implies that there aren't very many ties.
	 */
	@Override
	public void flush(ArrayList<Record> records) {
		
		PrintWriter writer=new PrintWriter(System.out, true);
		
		writer.println("Position, Score, Athlete, Birthdate, Country, 100 m, Long Jump, Shot Put, High Jump, 400m, 110m Hurdles, Discus, Pole Vault, Javelin, 1500m");
		
		ListIterator<Record> iterator=records.listIterator();
		int position=1;
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
			
			String displayedPosition;
			displayedPosition=String.valueOf(position);
			boolean hN=iterator.hasNext();
			iterator.previous();
			boolean hP=iterator.hasPrevious();
			iterator.next();
			if(!hN & !hP)
			{
				displayedPosition=String.valueOf(position);
			}
			else
			{
				Record peekF=iterator.hasNext() ? iterator.next() : null;
				if(peekF!=null) 
				{
					iterator.previous();
				}
				iterator.previous();
				Record peekB=iterator.hasPrevious() ? iterator.previous() : null;
				if(peekB!=null) 
				{
					iterator.next();
				}
				iterator.next();
				
				int scoreF= peekF==null ? -1 : peekF.getScore();
				int scoreB= peekB==null ? -1 : peekB.getScore() ;
				if(current.getScore() != scoreF && current.getScore() != scoreB) 
				{
					displayedPosition=String.valueOf(position);
				}
				else
				{
					int stepsBack=1;
					int stepsForward=0;
					int startOfTie=-1;
					int endOfTie=-1;

					if(peekB==null)
					{
						startOfTie=position;
						stepsBack=0;
					}
					else 
					{
						iterator.previous();
					}

					while (startOfTie==-1)
					{
						if(!iterator.hasPrevious())
						{
							startOfTie=position-stepsBack+1;
							break;
						}
						else {
							Record prevEl=iterator.previous();
							stepsBack++;
							if(prevEl.getScore()!=current.getScore())
							{
								startOfTie=position-stepsBack+2;
								break;
							}
						}
					}

					while(stepsBack-- > 0) iterator.next(); //rewind iterator

					if(peekF==null)
					{
						endOfTie=position;
					}
					
					while(endOfTie==-1)
					{
						if(!iterator.hasNext())
						{
							endOfTie=position+stepsForward;
							break;
						}
						else 
						{
							Record nextEl=iterator.next();

							stepsForward++;
							if(nextEl.getScore()!=current.getScore())
							{
								endOfTie=position+stepsForward-1;
								break;
							}
						}
					}

					while(stepsForward-- >0) iterator.previous(); //rewind iterator
					displayedPosition=String.valueOf(startOfTie)+"-"+String.valueOf(endOfTie);
				}
			}
			
			writer.println(displayedPosition + "," 
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
