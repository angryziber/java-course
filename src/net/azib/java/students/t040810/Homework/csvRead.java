package net.azib.java.students.t040810.Homework;

/**
 * Class: csvRead
 * User: Vladimir Glushakov
 */

import java.io.*;


class FileRead {
    public static void main(String args[]) throws IOException
    {
    try{
     // Open the file that is the first
     // command line parameter
     FileInputStream fileInputStream = new FileInputStream("test.csv");
     // Get the object of DataInputStream
     DataInputStream in = new DataInputStream(fileInputStream);

     BufferedReader br = new BufferedReader(new InputStreamReader(in));//novyj BufferedReader s parametrom
     String strLine;
     //Read File Line By Line
     while ((strLine = br.readLine()) != null)   {

     // Print the content on the console
     System.out.println(strLine);
     }
     //Close the input stream
     in.close();
    }
    catch (Exception e){//Catch exception if any
       System.err.println("Error: " + e.getMessage());
    }
    }
}