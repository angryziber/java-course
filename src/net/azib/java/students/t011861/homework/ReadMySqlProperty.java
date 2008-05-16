package net.azib.java.students.t011861.homework;

import java.io.*;
import java.util.*;
/**
 * ReadMySqlProperty
 * 
 * @author 011861
 */

public class ReadMySqlProperty {
	File f = new File("mysql.properties");
	private String url = "";
	private String driver = "";
	private String user = "";
	private String passwd = "";
	
	//Return URL from mysql.properties file for creating database connection
	public String getUrl() 
		{
			return url;
		}
	//Return Driver from mysql.properties file for creating database connection
	public String getDriver() 
	{
		return driver;
	}
	//Return Username from mysql.properties file for creating database connection
	public String getUser() 
	{
		return user;
	}
	//Return Password from mysql.properties file for creating database connection
	public String getPasswd() 
	{
		return passwd;
	}
	
	public ReadMySqlProperty(){
    try
    {
    	Properties properties = new Properties();
        FileInputStream inputFile = new FileInputStream(f);
        properties.load(inputFile);
        url = properties.getProperty("URL");
        driver = properties.getProperty("DRIVER");
        user = properties.getProperty("USER");
        passwd = properties.getProperty("PASSWD");
    } 
    catch (FileNotFoundException e) 
    {
    	System.out.println( f+ " file not found!");
    }
	catch (IOException e) 
	{
		System.out.println("Problem with file: "+f);
		e.printStackTrace();
	}
  }
}