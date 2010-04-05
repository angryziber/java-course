package net.azib.java.students.t073857.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Email
 *
 * @author Joonas Vali
 */
public class Email {
	private static final int flags = Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
	private static final Pattern pat = Pattern.compile("[a-z0-9_.]+@[-a-z0-9.]+\\.[a-z]{2,4}", flags);
	private String user;
	private String domain; 
	
	public Email(String email){
		Matcher matcher = pat.matcher(email); 
		if(!matcher.matches()) throw new IllegalArgumentException(email+" is not a correct e-mail.");		
		String[] spl = email.split("@");
		user = spl[0];
		domain = spl[1];		
	}
	
	@Override
	public String toString(){
		return user+"@"+domain;
	}
	
	public String getDomain(){
		return domain;
	}
	
	public String getUser(){
		return user;
	}
}
