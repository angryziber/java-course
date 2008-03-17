package net.azib.java.students.t040719;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


/**
 * LessonFive
 *
 * @author t040719
 */
public class LessonFive {
	public static void main(String[] args){
		int n=0;
		Scanner s=new Scanner(System.in);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		do {
			System.out.println("How many dates do you want to enter?");		
		} while (!s.hasNextInt());
		n=s.nextInt();
		String[] dates= new String[n];
		System.out.println("Will ask you "+n+" dates in the following format ("+  ((SimpleDateFormat)df).toPattern() +")");
		for(int i=0; i<n; i++){
			System.out.print("Enter "+(i+1)+". date:");
			try{
				dates[i]= df.format(df.parse(s.next())).toString();
			}
			catch (ParseException e){
				System.out.println("Vale format");
				i--;
			}
		}
		for(int i=0; i<n;i++){
			System.out.println(dates[i]);
		}
	}
}
