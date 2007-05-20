package net.azib.java.students.t030632.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * FileWriter
 *
 * @author Toni
 */
public class outFileWriter {
	
	public outFileWriter(File fileName, List <Competitor> listofCompetitorstoWrite){
		List places = new PlaceCalculator(listofCompetitorstoWrite).getPlaces();
		FileOutputStream outStream;
		OutputStreamWriter outStreamWriter;
		BufferedWriter outBufWriter;
		try {
			outStream = new FileOutputStream(fileName);
			outStreamWriter = new OutputStreamWriter(outStream,"UTF8");
			outBufWriter = new BufferedWriter(outStreamWriter);
			/*PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName),""));*/
			for(Competitor champ : listofCompetitorstoWrite){
				outBufWriter.write(places.size() - places.indexOf(champ.getPoints())+") ");
				outBufWriter.write(champ+"\n");
			}
			outBufWriter.close();
		}
		catch (IOException e) {
			System.out.println("Unable to write data to: "+ fileName.getAbsolutePath()+" file");
			e.printStackTrace();
		}
	
	}
}
