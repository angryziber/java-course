package net.azib.java.students.t103640.homework;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CoustomUtilities {

    protected Date checkDate(String date) throws ParseException {

        SimpleDateFormat test = new SimpleDateFormat("dd.MM.yyyy");

        return test.parse(date);
    }

    protected Date parseDbDate(Date date) throws ParseException {

        String strungDate = date.toString();
        SimpleDateFormat test  = new SimpleDateFormat("yyyy-MM-dd");

       return test.parse(strungDate);
    }

    protected double setStringToDoubleInMinutes(String data) throws Exception {


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

    protected String getAbsolutePath(String path) {
        File file = new File(path);
        path = file.getAbsolutePath();
        return path;
    }

    protected String checkISOCountry(String test) throws Exception {
        for (String validCountry : Locale.getISOCountries()) {
            if(validCountry.equals(test))
                return test;
        }
        throw new Exception();
    }

    protected ArrayList<String> fromAthleticToStringConsoleFormat(ArrayList<Athlete> athletes) {
        ArrayList<String> convert = new ArrayList<String>();
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");

        for (Athlete athlete : athletes) {
         convert.add(athlete.getPlace() + "," +athlete.getScore() + ": "+ athlete.getName() + ", " + athlete.getCountry() + ", " + date.format(athlete.getBirthday())+", "
         + athlete.getDiscusThrow()+", "+ athlete.getFourHundredMSprint()+", "+ athlete.getHighJump()
         +", "+ athlete.getHundredAndTenHurdles()+ ", " + athlete.getHundredMSprint() + ", " + athlete.getJavelinThrow()
         + ", " + athlete.getKilometerAndHalfRace() + ", "+ athlete.getLongJump() + ", " + athlete.getPoleVault() + ", "
         + athlete.getShotPut()+"\n");
        }
        return convert;
    }
        protected ArrayList<String> fromAthleticToStringCSVFormat(ArrayList<Athlete> athletes) {
        ArrayList<String> convert = new ArrayList<String>();
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");

         for (Athlete athlete : athletes) {
         convert.add(athlete.getScore() + ": "+athlete.getName() + "," + athlete.getCountry() + "," + date.format(athlete.getBirthday())+","
         + athlete.getDiscusThrow()+","+ athlete.getFourHundredMSprint()+","+ athlete.getHighJump()
         +","+ athlete.getHundredAndTenHurdles()+ "," + athlete.getHundredMSprint() + "," + athlete.getJavelinThrow()
         + "," + athlete.getKilometerAndHalfRace() + ","+ athlete.getLongJump() + "," + athlete.getPoleVault() + ","
         + athlete.getShotPut());
        }
        return convert;
    }

}
