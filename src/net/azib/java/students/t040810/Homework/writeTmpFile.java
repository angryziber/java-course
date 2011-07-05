package net.azib.java.students.t040810.Homework;
	//Запись строки в файл
import java.io.*;
/**
 * Class: writeTmpFile
 * User: Vladimir Glushakov
 */
public class writeTmpFile {

public static String writeToFile(String filename, String strPage ){
    PrintWriter writer = null;
    try {
     writer = new PrintWriter(
             new OutputStreamWriter(
             new FileOutputStream(filename), "UTF-16"));
     writer.write(strPage);
     writer.close();
    } catch (Exception ex) {}
	return strPage;
	}
    public static void main(String[] args) throws IOException {
        String test="test";   //TODO: Add delimiter
        String filename="c:/JavaHomework";
        writeToFile(filename, test );
    }
}
