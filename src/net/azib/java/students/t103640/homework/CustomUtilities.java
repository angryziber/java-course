package net.azib.java.students.t103640.homework;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CustomUtilities {
	/**
	 *  This method converts all given dates in format dd.MM.YYYY to computer-understandable dates. This gives the
	 *  advantage of doing further formating and conversions later, if all dates are the same type. Also it is used to
	 *  validate dates from console-input.
	 * @param date from input
	 * @return formated date
	 * @throws ParseException - throws that if parsing fails
	 */
    protected Date checkDate(String date) throws ParseException {

        SimpleDateFormat test = new SimpleDateFormat("dd.MM.yyyy");

        return test.parse(date);
    }

	/**
	 * This method parses dates from database to same format that they would be if they had been entered from console.
	 * @param date from input
	 * @return date
	 * @throws ParseException - throws that if parsing fails
	 */

    protected Date parseDbDate(Date date) throws ParseException {

        String strungDate = date.toString();
        SimpleDateFormat test  = new SimpleDateFormat("yyyy-MM-dd");

       return test.parse(strungDate);
    }

	/**
	 * This is a method for converting all given time from minutes to seconds,
	 * as it is necessary for later calculations.
	 * @param data (minutes as a string)
	 * @return seconds
	 * @throws Exception    if fails
	 */
    protected double setStringToDoubleInSeconds(String data) throws Exception {


		if (data.matches("[0-9]+:[0-9]+\\.?[0-9]*")) {
			String[] tempData = data.split(":");
			return (Double.parseDouble(tempData[0]) * 60) + Double.parseDouble(tempData[1]);
		}
		else if (data.matches("[0-9]+\\.?[0-9]*")) {

			return Double.parseDouble(data);
		}
		else {
			throw new Exception();
		}
	}

	/**
	 * This method takes in file name or path and outputs it into path.
	 * @param path of given file
	 * @return  absolute path of file
	 */
    protected String getAbsolutePath(String path) {
        File file = new File(path);
        path = file.getAbsolutePath();
        return path;
    }

	/**
	 * This method is for validating country, to see if it´s and iso - standard acronym.
	 * @param test (country to check)
	 * @return     (country if true, otherwise throws exception and crashes the program)
	 * @throws Exception    - throws exception if country not in the ISO list
	 */
    protected String checkISOCountry(String test) throws Exception {
        for (String validCountry : Locale.getISOCountries()) {
            if(validCountry.equals(test))
                return test;
        }
        throw new Exception();
    }

	/**
	 * This method is for formatting output data to be a little more human friendly to read from console
	 * @param athletes   as ArrayList of athletes
	 * @return converted athletes as String
	 */
    protected ArrayList<String> fromAthleticToStringConsoleFormat(ArrayList<Athlete> athletes) {
        ArrayList<String> convert = new ArrayList<String>();
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
	        convert.add("Place\tScore");
        for (Athlete athlete : athletes) {
         convert.add(athlete.getPlace() + "\t\t" +athlete.getScore() + ": "+ athlete.getName() + ", "
		         + athlete.getCountry() + ", " + date.format(athlete.getBirthday())+". Day 1: ["+
		         athlete.getHundredMSprint() + ", " +athlete.getLongJump() +", " + athlete.getShotPut()+ ", " +
		         athlete.getHighJump()+ ", " + athlete.getFourHundredMSprint()+ "]. Day 2: [" + athlete.getHundredAndTenHurdles()
		         + ", "+  athlete.getDiscusThrow() + ", " + athlete.getPoleVault() + ", " + athlete.getJavelinThrow() +
		         ", " + athlete.getKilometerAndHalfRace()+"]");
        }
        return convert;
    }

	/**
	 * This method is for converting data to CSV  aka. coma separated values format.
	 * @param athletes  as ArrayList of athletes
	 * @return converted athletes
	 */
        protected ArrayList<String> fromAthleticToStringCSVFormat(ArrayList<Athlete> athletes) {
        ArrayList<String> convert = new ArrayList<String>();
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");

         for (Athlete athlete : athletes) {
         convert.add(athlete.getPlace()+ ","+athlete.getScore() + ",\""+athlete.getName() + "\"," + athlete.getCountry() + "," + date.format(athlete.getBirthday())+","
         + athlete.getDiscusThrow()+","+ athlete.getFourHundredMSprint()+","+ athlete.getHighJump()
         +","+ athlete.getHundredAndTenHurdles()+ "," + athlete.getHundredMSprint() + "," + athlete.getJavelinThrow()
         + "," + athlete.getKilometerAndHalfRace() + ","+ athlete.getLongJump() + "," + athlete.getPoleVault() + ","
         + athlete.getShotPut());
        }
        return convert;
    }

}
