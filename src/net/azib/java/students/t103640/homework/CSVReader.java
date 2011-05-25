package net.azib.java.students.t103640.homework;

import java.io.*;
import java.util.ArrayList;

public class CSVReader{



    public ArrayList<Athlete> getCSVData(String path) {
        CoustomUtilities validator = new CoustomUtilities();

        ArrayList<Athlete> athletes = new ArrayList<Athlete>();
        String absPath;
        absPath = validator.getAbsolutePath(path);
        ArrayList<String> data = new ArrayList<String>(readInData(absPath));
        String[] splittedData;
        boolean allDataCopyed = false;
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

                    athlete.setFourHundredMSprint(setStringToMins(splittedData[7]));

                    athlete.setHundredAndTenHurdles(setStringToDouble(splittedData[8]));

                    athlete.setDiscusThrow(setStringToDouble(splittedData[9]));

                    athlete.setPoleVault(setStringToDouble(splittedData[10]));

                    athlete.setJavelinThrow(setStringToDouble(splittedData[11]));

                    athlete.setKilometerAndHalfRace(setStringToMins(splittedData[12]));



                    allDataCopyed = true;
                }catch (Exception e){
                    System.out.println(splittedData[0]+"´s had some bad data, skipping..");
                }
              if(allDataCopyed)
                  athletes.add(athlete);
        }
        return athletes;
    }

    private double setStringToMins(String s) throws Exception {
        CoustomUtilities valid = new CoustomUtilities();
        return valid.setStringToDoubleInMinutes(s);

    }

    private double setStringToDouble(String s) {

                return Double.parseDouble(s);

    }

    private ArrayList<String> readInData(String path) {
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
