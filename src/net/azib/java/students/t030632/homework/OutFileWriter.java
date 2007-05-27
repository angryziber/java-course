package net.azib.java.students.t030632.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * FileWriter writes sorted competitors list with results to the file.
 *
 * @author Toni
 */
public class OutFileWriter {
	
	public OutFileWriter(File fileName, List <Competitor> listofCompetitorstoWrite){
		Map<Integer, String> places = new PlaceCalculator(listofCompetitorstoWrite).getPlaces();
//		List places = new PlaceCalculator(listofCompetitorstoWrite).getPlaces();
		FileOutputStream outStream;
		OutputStreamWriter outStreamWriter;
		BufferedWriter outBufWriter;
		Set <String> compsDataToWrite = new TreeSet<String>();
		for(Competitor champ : listofCompetitorstoWrite){
			compsDataToWrite.add(String.valueOf("("+places.get(champ.getPoints())+"), "+champ));
		}
		try {
			outStream = new FileOutputStream(fileName);
			outStreamWriter = new OutputStreamWriter(outStream,"UTF8");
			outBufWriter = new BufferedWriter(outStreamWriter);
			/*PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName),""));*/
			for(String data:compsDataToWrite){
				outBufWriter.write(data+ System.getProperty("line.separator"));
				
			}
			outBufWriter.close();
		}
		catch (IOException e) {
			System.out.println("Unable to write data to: "+ fileName.getAbsolutePath()+" file");
			e.printStackTrace();
		}
	
	}
}
