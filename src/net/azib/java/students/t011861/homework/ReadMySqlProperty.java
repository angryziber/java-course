package net.azib.java.students.t011861.homework;

import java.io.*;
import java.util.*;

/**
 * ReadMySqlProperty
 * Class is responsible for to import data from db.properties files.
 * @author 011861
 */

public class ReadMySqlProperty {

 
	private String url = "";
	private String driver = "";
	private String user = "";
	private String passwd = "";
	/**
	 * Return URL from db.properties file for creating database connection 
	 * @return url string
	 */
	public String getUrl() 
		{
			return url;
		}
	/**
	 * Return driver from db.properties file for creating database connection 
	 * @return driver string
	 */
	public String getDriver() 
	{
		return driver;
	}
	/**
	 * Return username from db.properties file for creating database connection 
	 * @return username string
	 */
	public String getUser() 
	{
		return user;
	}
	/**
	 * Return password from db.properties file for creating database connection 
	 * @return password string
	 */
	public String getPasswd() 
	{
		return passwd;
	}
	
	private File getFile() throws IOException
	{
		File dir1 = new File (".");
	    String path = String.valueOf(dir1.getCanonicalPath().toString());
		File f = new File(path + "/src/net/azib/java/students/t011861/homework/db.properties");
		return f;
	}
	public ReadMySqlProperty(){
    try {
    	Properties properties = new Properties();
        FileInputStream inputFile = new FileInputStream(getFile());
        properties.load(inputFile);
        url = properties.getProperty("URL");
        //driver = properties.getProperty("DRIVER");
        user = properties.getProperty("USER");
        passwd = properties.getProperty("PASSWD");
    } 
    catch (FileNotFoundException e) 
    {
    	System.out.println(" db.properties file not found!");
    }
	catch (IOException e) 
	{
		System.out.println("Problem with file db.properties");
		e.printStackTrace();
	}
  }
}