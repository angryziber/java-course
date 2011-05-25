package net.azib.java.students.t103640.homework;

import java.io.*;
import java.util.ArrayList;

public class CSVReader{

	/**
	 * This method takes in given path or name of the csv file as a parameter, converts it to path and try-s to read in
	 * all data given in that specific cvs file. This method uses other methods to validate the data that has been read
	 * in.
	 * @param path (file name or file path)
	 * @return  athletes (array list of athletes, that has been read in from csv file)
	 */

    public ArrayList<Athlete> getCSVData(String path) {
        CustomUtilities validator = new CustomUtilities();

        ArrayList<Athlete> athletes = new ArrayList<Athlete>();
        String absPath;
        absPath = validator.getAbsolutePath(path);
        ArrayList<String> data = new ArrayList<String>(readInData(absPath));
        String[] splittedData;
        boolean allDataCopyed;

        for (String line : data) {
               Athlete athlete = new Athlete();
                splittedData = line.split(",");
                allDataCopyed = false;
                try{
                    athlete.setName(splittedData[0]);

                    athlete.setBirthday(validator.checkDate(splittedData[1]));

                    athlete.setCountry(validator.checkISOCountry(splittedData[2]));

                    athlete.setHundredMSprint(setStringToDouble(splittedData[3]));

                    athlete.setLongJump(setStringToDouble(splittedData[4]));

                    athlete.setShotPut(setStringToDouble(splittedData[5]));

                    athlete.setHighJump(setStringToDouble(splittedData[6]));

                    athlete.setFourHundredMSprint(setStringToSec(splittedData[7]));

                    athlete.setHundredAndTenHurdles(setStringToDouble(splittedData[8]));

                    athlete.setDiscusThrow(setStringToDouble(splittedData[9]));

                    athlete.setPoleVault(setStringToDouble(splittedData[10]));

                    athlete.setJavelinThrow(setStringToDouble(splittedData[11]));

                    athlete.setKilometerAndHalfRace(setStringToSec(splittedData[12]));



                    allDataCopyed = true;
                }catch (Exception e){
                    System.out.println(splittedData[0]+"´s had some bad data, skipping..");
                }
              if(allDataCopyed)
                  athletes.add(athlete);
        }
        return athletes;
    }

    private double setStringToSec(String s) throws Exception {
        CustomUtilities valid = new CustomUtilities();
        return valid.setStringToDoubleInSeconds(s);

    }

    private double setStringToDouble(String s) {
                return Double.parseDouble(s);

    }

    protected ArrayList<String> readInData(String path) {
         ArrayList<String> dataFromFile = new ArrayList<String>();
        String lineOfData;
        BufferedReader buffReader = null;

        try{
            File inputFile = new File(path);
            if(inputFile.exists()){
            buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            }
            else
            buffReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("CSVSample.csv")));

            while((lineOfData = buffReader.readLine()) != null){
                dataFromFile.add(lineOfData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if (buffReader != null) {
                    buffReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataFromFile;
    }


}
