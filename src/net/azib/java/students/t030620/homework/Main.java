package net.azib.java.students.t030620.homework;


import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.input.InputProvider;
import net.azib.java.students.t030620.homework.input.InputProviderFactory;
import net.azib.java.students.t030620.homework.output.OutputProvider;
import net.azib.java.students.t030620.homework.output.OutputProviderFactory;


import net.azib.java.students.t030620.homework.util.CompetitionUtil;
import net.azib.java.students.t030620.homework.util.IOParams;
import net.azib.java.students.t030620.homework.util.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;



/**
 * Main
 *
 * @author Maksim Konstantinov 030620
 */
public class Main {

	/**
	 * @param args the following input is expected -<input-method> [input-parameters] -<output-method> [output-parameters]
	 */
	public static void main(String[] args) throws Exception {
		
		try {
			
			Utils.prompt("Ork work\n");
			
			IOParams params = Utils.getIOParams(args);
			
			Properties props = Utils.getProperties("main.properties", Main.class);
			
			Properties inputProps = Utils.getProperties(props.getProperty("input-"+params.getInputType().name().toLowerCase()), Main.class);
			InputProvider input = InputProviderFactory.getInputProvider(params.getInputType(), inputProps);
			Collection<DecathleteScoreKeeper> scores = input.getInput(params.getInputParam());
			if(scores == null || scores.size() == 0) {
				throw new Exception("No data to process! See ya!");
			}
			
			scores = CompetitionUtil.setPlaces(new ArrayList<DecathleteScoreKeeper>(scores));
			
			Properties outputProps =  Utils.getProperties(props.getProperty("output-"+params.getOutputType().name().toLowerCase()), Main.class);
			OutputProvider output = OutputProviderFactory.getOutputProvider(params.getOutputType(), outputProps);
			output.output(scores, params.getOutputParam());
			
			Utils.prompt("Job's done");

		} catch (Exception e) {
			Utils.prompt(e.getMessage());
		}

	}

}
