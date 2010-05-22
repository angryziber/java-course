package net.azib.java.students.t050720.homework;

import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * XMLOutput
 *
 * @author Marek
 */
public class XMLOutput implements Output {

	private File f;
	
	/**
	 * @param parameters
	 */
	public XMLOutput(String filename) {
		f=new File(filename);
	}

	@Override
	public void flush(ArrayList<Record> records) throws Exception {
		ListIterator<Record> iterator=records.listIterator();
		
		
		DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuildFactory.newDocumentBuilder();

		Document xml = docBuilder.newDocument();
		Element rootElement = xml.createElement("competition");
		xml.appendChild(rootElement);
		
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

			Element e_res = xml.createElement("result");

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

			Element e_pos = xml.createElement("pos");
			e_pos.appendChild(xml.createTextNode(displayedPosition));
			e_res.appendChild(e_pos);
			
			Element e_sc = xml.createElement("score");
			e_sc.appendChild(xml.createTextNode(String.valueOf(current.getScore())));
			e_res.appendChild(e_sc);
			
			Element e_ath = xml.createElement("athlete");
			e_ath.appendChild(xml.createTextNode(current.getAthlete()));
			e_res.appendChild(e_ath);
			
			Element e_dob = xml.createElement("dob");
			e_dob.appendChild(xml.createTextNode(current.getBirthDate()));
			e_res.appendChild(e_dob);
			
			Element e_c = xml.createElement("country");
			e_c.appendChild(xml.createTextNode(current.getCountry()));
			e_res.appendChild(e_c);
			
			Element e_evt_r100 = xml.createElement("event");
			Element e_evtn_r100 = xml.createElement("name");
			Element e_evtp_r100 = xml.createElement("performance");
			e_evtn_r100.appendChild(xml.createTextNode("100m race"));
			e_evtp_r100.appendChild(xml.createTextNode(String.valueOf(current.getRace_100m())));		
			e_evt_r100.appendChild(e_evtn_r100);
			e_evt_r100.appendChild(e_evtp_r100);
			e_res.appendChild(e_evt_r100);
			
			Element e_evt_lj = xml.createElement("event");
			Element e_evtn_lj = xml.createElement("name");
			Element e_evtp_lj = xml.createElement("performance");
			e_evtn_lj.appendChild(xml.createTextNode("Long jump"));
			e_evtp_lj.appendChild(xml.createTextNode(String.valueOf(current.getLong_jump())));		
			e_evt_lj.appendChild(e_evtn_lj);
			e_evt_lj.appendChild(e_evtp_lj);
			e_res.appendChild(e_evt_lj);
			
			Element e_evt_sp = xml.createElement("event");
			Element e_evtn_sp = xml.createElement("name");
			Element e_evtp_sp = xml.createElement("performance");
			e_evtn_sp.appendChild(xml.createTextNode("Shot put"));
			e_evtp_sp.appendChild(xml.createTextNode(String.valueOf(current.getShot_put())));		
			e_evt_sp.appendChild(e_evtn_sp);
			e_evt_sp.appendChild(e_evtp_sp);
			e_res.appendChild(e_evt_sp);
			
			Element e_evt_hj = xml.createElement("event");
			Element e_evtn_hj = xml.createElement("name");
			Element e_evtp_hj = xml.createElement("performance");
			e_evtn_hj.appendChild(xml.createTextNode("High jump"));
			e_evtp_hj.appendChild(xml.createTextNode(String.valueOf(current.getHigh_jump())));		
			e_evt_hj.appendChild(e_evtn_hj);
			e_evt_hj.appendChild(e_evtp_hj);
			e_res.appendChild(e_evt_hj);
			
			Element e_evt_r400 = xml.createElement("event");
			Element e_evtn_r400 = xml.createElement("name");
			Element e_evtp_r400 = xml.createElement("performance");
			e_evtn_r400.appendChild(xml.createTextNode("400m race"));
			e_evtp_r400.appendChild(xml.createTextNode(r400));		
			e_evt_r400.appendChild(e_evtn_r400);
			e_evt_r400.appendChild(e_evtp_r400);
			e_res.appendChild(e_evt_r400);
			
			Element e_evt_r110 = xml.createElement("event");
			Element e_evtn_r110 = xml.createElement("name");
			Element e_evtp_r110 = xml.createElement("performance");
			e_evtn_r110.appendChild(xml.createTextNode("110m hurdles race"));
			e_evtp_r110.appendChild(xml.createTextNode(String.valueOf(current.getHurdles_110m())));		
			e_evt_r110.appendChild(e_evtn_r110);
			e_evt_r110.appendChild(e_evtp_r110);
			e_res.appendChild(e_evt_r110);
			
			Element e_evt_dt = xml.createElement("event");
			Element e_evtn_dt = xml.createElement("name");
			Element e_evtp_dt = xml.createElement("performance");
			e_evtn_dt.appendChild(xml.createTextNode("Discus throw"));
			e_evtp_dt.appendChild(xml.createTextNode(String.valueOf(current.getDiscus_throw())));		
			e_evt_dt.appendChild(e_evtn_dt);
			e_evt_dt.appendChild(e_evtp_dt);
			e_res.appendChild(e_evt_dt);
			
			Element e_evt_pv = xml.createElement("event");
			Element e_evtn_pv = xml.createElement("name");
			Element e_evtp_pv = xml.createElement("performance");
			e_evtn_pv.appendChild(xml.createTextNode("Pole vault"));
			e_evtp_pv.appendChild(xml.createTextNode(String.valueOf(current.getPole_vault())));		
			e_evt_pv.appendChild(e_evtn_pv);
			e_evt_pv.appendChild(e_evtp_pv);
			e_res.appendChild(e_evt_pv);
			
			Element e_evt_jt = xml.createElement("event");
			Element e_evtn_jt = xml.createElement("name");
			Element e_evtp_jt = xml.createElement("performance");
			e_evtn_jt.appendChild(xml.createTextNode("Javelin throw"));
			e_evtp_jt.appendChild(xml.createTextNode(String.valueOf(current.getJavelin_throw())));		
			e_evt_jt.appendChild(e_evtn_jt);
			e_evt_jt.appendChild(e_evtp_jt);
			e_res.appendChild(e_evt_jt);
			
			Element e_evt_r1500 = xml.createElement("event");
			Element e_evtn_r1500 = xml.createElement("name");
			Element e_evtp_r1500 = xml.createElement("performance");
			e_evtn_r1500.appendChild(xml.createTextNode("1500m race"));
			e_evtp_r1500.appendChild(xml.createTextNode(r1500));		
			e_evt_r1500.appendChild(e_evtn_r1500);
			e_evt_r1500.appendChild(e_evtp_r1500);
			e_res.appendChild(e_evt_r1500);
			
			rootElement.appendChild(e_res);
			
			position++;
		}
		
		TransformerFactory tranFactory = TransformerFactory.newInstance();
		Transformer aTransformer = tranFactory.newTransformer();
		Source src = new DOMSource(xml);
		Result dest = new StreamResult(f);
		aTransformer.transform(src, dest);
	}

}
