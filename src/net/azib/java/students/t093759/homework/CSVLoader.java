package net.azib.java.students.t093759.homework;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dionis
 *         5/30/113:57 AM
 */
public class CSVLoader implements AthletesLoader {
	private static final AthleteDataLoaderHelper ATHLETE_DATA_LOADER_HELPER_INSTANCE = AthleteDataLoaderHelper.getInstance();

	/**
	 * @param additionalParams Filename with results in .csv.
	 * @return List of loaded athletes or empty list.
	 */
	@Override
	public List<Athlete> load(Object... additionalParams) {
		if (additionalParams.length < 1) throw new IllegalArgumentException("One parameter needed.");
		if (!(additionalParams[0] instanceof String))
			throw new IllegalArgumentException("Parameter should be a string.");
		List<Athlete> athletes = new ArrayList<Athlete>(100);
		try {
			List<String> lines = FileUtils.readLines(new File((String) additionalParams[0]), "UTF-8");
			for (String line : lines) {
				if (line.trim().isEmpty()) continue;
				try {
					athletes.add(loadOneAthlete(line));
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return athletes;
	}

	private Athlete loadOneAthlete(String lineWithAthleteData) throws Exception {
		Athlete.Builder builder = new Athlete.Builder();
		loadAllAthleteFieldsUsing(builder, lineWithAthleteData);
		return builder.build();
	}

	private void loadAllAthleteFieldsUsing(Athlete.Builder builder, String lineWithAthleteData) throws Exception {
		String[] str = lineWithAthleteData.split(",");
		int i = 0;
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadNameUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadDateOfBirthUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadCountryISO2LetterCodeUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadOneHundredMeterSprintTimeUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadLongJumpLengthUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadShotPutLengthUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadHighJumpHeightUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadFourHundredMeterSprintTimeUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadOneHundredTenMeterHurdlesTimeUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadDiscusThrowLengthUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadPoleVaultHeightUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadJavelinThrowLengthUsing(builder, str[i++]);
		ATHLETE_DATA_LOADER_HELPER_INSTANCE.loadThousandFiveHundredMeterRaceTimeUsing(builder, str[i]);
	}
}