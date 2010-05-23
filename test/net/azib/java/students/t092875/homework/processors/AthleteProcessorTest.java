package net.azib.java.students.t092875.homework.processors;
import net.azib.java.students.t092875.homework.athletes.Athlete;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * AthleteProcessor
 *
 * @author Mihhail
 */
public class AthleteProcessorTest {
	@Test
	public void testGetSpecialPlace(){
		AthleteProcessor processor = new AthleteProcessor();
		assertEquals("3-4-5", processor.getSpecialPlace(3, 3));
		assertEquals("4-5", processor.getSpecialPlace(2, 4));
	}
	
	@Test
	public void testHowManyLikeMe(){
		AthleteProcessor processor = new AthleteProcessor();
		List<Athlete> athletes = new ArrayList<Athlete>();
		String[] result = new String[10];
		for(int i=0; i<10;i++){
			result[i] = "50.11";
		}
		Athlete a1 = new Athlete("Mihhail 1",new Date(),"EU",result); 
		Athlete a2 = new Athlete("Mihhail 2",new Date(),"RU",result); 
		a1.setResult(1000);
		a2.setResult(1000);
		athletes.add(a1);
		athletes.add(a2);
		
		assertEquals(2, processor.howManyLikeMe(athletes, 1000));
		
		a2.setResult(2000);
		
		assertEquals(1, processor.howManyLikeMe(athletes, 1000));
	}
	
	@Test
	public void testAssignPlaces(){
		AthleteProcessor processor = new AthleteProcessor();
		List<Athlete> athletes = new ArrayList<Athlete>();
		String[] result = new String[10];
		for(int i=0; i<10;i++){
			result[i] = "50.11";
		}
		Athlete a1 = new Athlete("Mihhail 1",new Date(),"EU",result); 
		Athlete a2 = new Athlete("Mihhail 2",new Date(),"RU",result); 
		Athlete a3 = new Athlete("Mihhail 3",new Date(),"ES",result); 
		a1.setResult(1000);
		a2.setResult(1000);
		a3.setResult(1500);
		athletes.add(a1);
		athletes.add(a2);
		athletes.add(a3);
		Collections.sort(athletes);
		processor.assignPlaces(athletes);

		assertEquals("1", a3.getPlace());
		assertEquals("2-3", a2.getPlace());
		assertEquals("2-3", a1.getPlace());
	}
	
	@Test
	public void testSetResult(){
		AthleteProcessor processor = new AthleteProcessor();
		String[] results = {"10.22","8.95","23.12","2.45","43.18","13.47","55.87","5.76","79.80","3:58.70"};
		Athlete a1 = new Athlete("Mihhail 1",new Date(),"EU",results); 
		int result = 1042+1312+1295+1244+1156+1044+993+1152+1040+963;
		processor.setResult(a1);
		assertEquals(result, a1.getResult());
	}
	
	@Test
	public void testSetAllResults(){
		AthleteProcessor processor = new AthleteProcessor();
		String[] results = {"10.22","8.95","23.12","2.45","43.18","13.47","55.87","5.76","79.80","3:58.70"};
		List<Athlete> athletes = new ArrayList<Athlete>();
		Athlete a1 = new Athlete("Mihhail 1",new Date(),"EU",results); 
		Athlete a2 = new Athlete("Mihhail 2",new Date(),"EU",results); 
		int result = 1042+1312+1295+1244+1156+1044+993+1152+1040+963;
		athletes.add(a1);
		athletes.add(a2);
		processor.setAllResults(athletes);
		assertEquals(result, a1.getResult());
		assertEquals(result, a2.getResult());
	}
	
	@Test
	public void testProcess(){
		AthleteProcessor processor = new AthleteProcessor();
		List<Athlete> athletes = new ArrayList<Athlete>();
		String[] result = new String[10];
		for(int i=0; i<10;i++){
			result[i] = "50.11";
		}
		String[] win_result = new String[10];
		for(int i=0; i<10;i++){
			win_result[i] = "51.11";
		}
		Athlete a1 = new Athlete("Mihhail 1",new Date(),"EU",result); 
		Athlete a2 = new Athlete("Mihhail 2",new Date(),"RU",result); 
		Athlete a3 = new Athlete("Mihhail 3",new Date(),"ES",win_result); 
		athletes.add(a1);
		athletes.add(a2);
		athletes.add(a3);
		processor.process(athletes);

		assertEquals("Mihhail 3", athletes.get(0).getName());
		assertEquals("Mihhail 1", athletes.get(1).getName());
		assertEquals("Mihhail 2", athletes.get(2).getName());
		
		assertEquals("1", athletes.get(0).getPlace());
		assertEquals("2-3", athletes.get(1).getPlace());
		assertEquals("2-3", athletes.get(2).getPlace());
	}
}
