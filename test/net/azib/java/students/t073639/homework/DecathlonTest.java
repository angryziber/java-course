package net.azib.java.students.t073639.homework;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * <p>JUnit testing class.
 * <br>Testing classes, which are used in DecathlonCalculator.
 * <br>All List's use toString() method for comparison, because it is overridden and generic types are different(Athlete vs String).
 * <br> File compare using {@link FileReader}, files are equal if sum of read character are equal.  
 * @author t073639
 */
public class DecathlonTest {
	String s1 = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";
	String s2 = "\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76";
	String s3 = "\"José Mañana Perez\",3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75";
	String s4 = "\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01";

	Athlete athlete = new Athlete(s4);
	Console console;
	CSVControl csv;
	List<String> singleAthlete = createAthleteUsingStringConverter();
	List<String> listOfAthletes;

	/**
	 * <p>Comparison of manually created athlete and created using {@link StringConverter}
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void singleAthlete() throws Exception {
		List<String> athleteList = new ArrayList<String>();
		athleteList.add(athlete.getName());
		athleteList.add(athlete.getBirthdate());
		athleteList.add(athlete.getCountry());
		athleteList.add(athlete.getM100Result());
		athleteList.add(athlete.getLongJumpResult());
		athleteList.add(athlete.getShotPutResult());
		athleteList.add(athlete.getHighJumpResult());
		athleteList.add(athlete.getM400Result());
		athleteList.add(athlete.getM110HurdlesResult());
		athleteList.add(athlete.getDiscusThrowResult());
		athleteList.add(athlete.getPoleVaultResult());
		athleteList.add(athlete.getJavelinThrowResult());
		athleteList.add(athlete.getM1500Result());
		assertEquals(singleAthlete, athleteList);
	}

	private List<String> createAthleteUsingStringConverter() {
		StringConverter sc = new StringConverter(s4);
		return sc.getList();
	}

	/**
	 * <p>Check if points for one event same as we expected.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void singleRecordPointsCalculation() throws Exception {
		Event e = Event.M100;
		double p = 12.61;
		assertEquals(25.4347 * Math.pow(18 - p, 1.81), e.getPoints(new BigDecimal(p)).doubleValue(), 0.001);
	}

	/**
	 * <p>Comparison of athlete's results lists.
	 * <br>Some of results is needed to be in centimetres, or in second, here we check it.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void compareListAddedByHandAndFormatedListFromString() throws Exception {
		List<String> actual = new ArrayList<String>();
		actual.add("13.43");
		actual.add("435");
		actual.add("8.64");
		actual.add("150");
		actual.add("66.06");
		actual.add("19.05");
		actual.add("24.89");
		actual.add("220");
		actual.add("33.48");
		actual.add("411.01");
		assertEquals(singleAthlete.subList(3, singleAthlete.size()), actual);
	}

	/**
	 * <p>Comparison total points created using {@link DecathlonCalculator} and manually calculated. 
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void totalPointsOfOnePerformance() throws Exception {
		assertEquals((long) DecathlonCalculator.getTotalPoints(singleAthlete.subList(3, singleAthlete.size())), 3099l);
	}

	/**
	 * Check if {@link StringConverter} method works same as we expect.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void minutesToSecondsStringConversion() throws Exception {
		assertEquals(Double.parseDouble("66.06"), Double.parseDouble(StringConverter.formatTimeMinToSec("1:06.06")), 0.001);
		assertEquals(Double.parseDouble("411.01"), Double.parseDouble(StringConverter.formatTimeMinToSec("6:51.01")), 0.001);
	}

	/**
	 * <p>Comparison of lists created from console input using {@link Console} and compares with manually created one.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void compareFromConsoleInputtedAthleteListAndManualInputtedAthleteList() throws Exception {
		console = new Console();
		console.addNewAthlete(new Scanner(s1 + "\n").nextLine());
		console.addNewAthlete(new Scanner(s2 + "\n").nextLine());
		console.addNewAthlete(new Scanner(s3 + "\n").nextLine());
		console.addNewAthlete(new Scanner(s4 + "\n").nextLine());
		assertEquals(getAthletesList().toString(), console.getInputAthleteList().toString());
	}

	private List<String> getAthletesList() {
		listOfAthletes = new ArrayList<String>();
		listOfAthletes.add(new StringConverter(s1).toString());
		listOfAthletes.add(new StringConverter(s3).toString());
		listOfAthletes.add(new StringConverter(s2).toString());
		listOfAthletes.add(new StringConverter(s4).toString());
		return listOfAthletes;
	}
	

	/**
	 * <p>Comparison of manually created list with created from csv file using {@link CSVControl}.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void compareCsvControlInputtedAthleteListWithManualAthleteList() throws Exception {
		String str = DecathlonTest.class.getResource("input.csv").getFile();
		assertEquals(getAthletesList().toString(), new CSVControl(str).getInputAthleteList().toString());
	}

	/**
	 * <p>Comparison of csv output file using {@link CSVControl} with manually created.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void compareCSVControlOutputtedFileWithManuallyCreated() throws Exception {
		csv = new CSVControl();
		csv.addNewAthlete(s1);
		csv.addNewAthlete(s2);
		csv.addNewAthlete(s3);
		csv.addNewAthlete(s4);
		String str = DecathlonTest.class.getResource("results.csv").getFile();
		csv.printResultsToFile(str);
		long dataExp = getSumDataInLongFromFIle(DecathlonTest.class.getResource("results.csv").getFile());
		long dataAct = getSumDataInLongFromFIle(DecathlonTest.class.getResource("results.expected.csv").getFile());
		assertEquals(dataAct, dataExp);
	}

	private long getSumDataInLongFromFIle(String sFile) throws FileNotFoundException, IOException {
		FileReader reader = new FileReader(sFile);
		int read = reader.read();
		long dataSum = read;
		while (read != -1) {
			read = reader.read();
			dataSum = dataSum + read;
		}
		reader.close();
		return dataSum;
	}

	/**
	 * <p>Comparison of list manually gotten from database and gotten using {@link DBControl}.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void dbConnectionAndGetListOfAthletes() throws Exception {
		String idOrName = "1";
		DBControl db = new DBControl(idOrName);
		assertEquals(getAthleteListFromDatabase(idOrName).toString(), db.getInputAthleteList().toString());
		idOrName = "2";
		db = new DBControl(idOrName);
		assertEquals(getAthleteListFromDatabase(idOrName).toString(), db.getInputAthleteList().toString());
		idOrName = "3";
		db = new DBControl(idOrName);
		assertEquals(getAthleteListFromDatabase(idOrName).toString(), db.getInputAthleteList().toString());
		idOrName = "Training";
		db = new DBControl(idOrName);
		assertEquals(getAthleteListFromDatabase(idOrName).toString(), db.getInputAthleteList().toString());
		idOrName = "DECATHLON4BEER";
		db = new DBControl(idOrName);
		assertEquals(getAthleteListFromDatabase(idOrName).toString(), db.getInputAthleteList().toString());
		idOrName = "Training2";
		db = new DBControl(idOrName);
		assertEquals(getAthleteListFromDatabase(idOrName).toString(), db.getInputAthleteList().toString());
	}

	private List<Athlete> getAthleteListFromDatabase(String idOrName) throws SQLException {
		AthleteList list = new AthleteList();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(DBControl.class.getResource("db.properties").getFile())).useDelimiter("\\,");
		}
		catch (FileNotFoundException e) {
			System.out.println("Problems with opening \"db.properties\"");
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(scanner.next().replaceAll(" ", ""), scanner.next().replaceAll(" ", ""),
				scanner.next().replaceAll(" ", ""));
		Scanner stringScanner = new Scanner(idOrName);
		PreparedStatement statement = null;
		if (stringScanner.hasNext("\\d")) {
			statement = conn.prepareStatement("SELECT `athletes`.`name` , `athletes`.`dob` , `athletes`.`country_code` ,"
					+ "`results`.`race_100m` , `results`.`long_jump` , `results`.`shot_put` , "
					+ "`results`.`high_jump` , `results`.`race_400m` , `results`.`hurdles_110m` , "
					+ "`results`.`discus_throw` , `results`.`pole_vault` , `results`.`javelin_throw` ,"
					+ "`results`.`race_1500m` FROM athletes, results, competitions WHERE `competitions`.`id`=?"
					+ "AND `results`.`athlete_id` = `athletes`.`id`" + "AND `results`.`competition_id` = `competitions`.`id`");
			statement.setString(1, idOrName);
		}
		else {
			statement = conn.prepareStatement("SELECT `athletes`.`name` , `athletes`.`dob` , `athletes`.`country_code` ,+"
					+ "`results`.`race_100m` , `results`.`long_jump` , `results`.`shot_put` , "
					+ "`results`.`high_jump` , `results`.`race_400m` , `results`.`hurdles_110m` , "
					+ "`results`.`discus_throw` , `results`.`pole_vault` , `results`.`javelin_throw` ,"
					+ "`results`.`race_1500m` FROM athletes, results, competitions WHERE `competitions`.`name`=?"
					+ "AND `results`.`athlete_id` = `athletes`.`id`" + "AND `results`.`competition_id` = `competitions`.`id`");
			statement.setString(1, idOrName);
		}
		ResultSet rs = statement.executeQuery();
		int maxColumnIndex = statement.getMetaData().getColumnCount();
		while (rs.next()) {
			int columnIndex = 1;
			String s = "";
			while (columnIndex <= maxColumnIndex) {
				try {
					if (columnIndex == 1) {
						s = s + "\"" + rs.getString(columnIndex) + "\"";
					}
					else if (columnIndex == 2) {
						SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM,
								new Locale("ru"));
						Calendar c = Calendar.getInstance(new Locale("ru"));
						c.setTime(rs.getDate(columnIndex));
						s = s + "," + dateFormat.format(c.getTime());
					}
					else {
						s = s + "," + rs.getString(columnIndex);
					}
				}
				catch (SQLException e) {
					System.out.println("\t*" + s + "\tERROR in database-check value:\n" + "\t*" + e.toString());
					s = s + ",00.00.0000";
				}
				columnIndex++;
			}
			Pattern p = Pattern.compile("\"[\\D\\ ]+\"," + "[0-9]{1,2}\\.[0-9]{2}\\.[0-9]{4},[A-Z]{2}"
					+ "(,[0-9]{1,3}(\\.[0-9]{1,2})*){10}[\\s]*");
			Matcher m = p.matcher(s);
			if (m.find()) {
				list.addNewAthlete(s);
			}
		}
		list.sortAndSetPlaces();
		conn.close();
		return list.getInputAthleteList();
	}

	/**
	 * Checks two sorted lists.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void sortManuallyCreatedAndCreatedUsingCSVControl() throws Exception {
		AthleteList listAct = new AthleteList(new CSVControl(DecathlonTest.class.getResource("input.csv").getFile())
				.getInputAthleteList());
		AthleteList listExp = new AthleteList();
		listExp.addNewAthlete(s1);
		listExp.addNewAthlete(s2);
		listExp.addNewAthlete(s3);
		listExp.addNewAthlete(s4);
		assertEquals(listExp.getInputAthleteList().toString(), listAct.getInputAthleteList().toString());
	}

	/**
	 * Comparison of xml file created using {@link XMLControl} and manually created one.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void compareTwoXMLFilesManuallyCreatedAndGenerated() throws Exception {
		AthleteList list = new AthleteList(new CSVControl(DecathlonTest.class.getResource("input.csv").getFile())
				.getInputAthleteList());
		String file = DecathlonTest.class.getResource("actual.xml").getFile();
		XMLControl xml = new XMLControl(list.getInputAthleteList());
		xml.formatFile(file);
		long actual = getSumDataInLongFromFIle(file);
		long expected = getSumDataInLongFromFIle(DecathlonTest.class.getResource("expected.xml").getFile());
		assertEquals(expected, actual);
	}

	/**
	 * Comparison of html file created using {@link XMLControl} and manually created one.
	 * @throws Exception If not equal or error occurs.
	 */
	@Test
	public void compareTwoHTMLFilesManuallyCreatedAndGenerated() throws Exception {
		String file = DecathlonTest.class.getResource("actual.html").getFile();
		AthleteList list = new AthleteList(new CSVControl(DecathlonTest.class.getResource("input.csv").getFile())
				.getInputAthleteList());
		XMLControl xml = new XMLControl(list.getInputAthleteList());
		xml.transform2html(file);
		long actual = getSumDataInLongFromFIle(file);
		long expected = getSumDataInLongFromFIle(DecathlonTest.class.getResource("expected.html").getFile());
		assertEquals(expected, actual);
	}

}
