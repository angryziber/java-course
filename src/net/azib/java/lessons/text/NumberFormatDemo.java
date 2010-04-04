package net.azib.java.lessons.text;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * NumberFormatDemo
 *
 * @author anton
 */
public class NumberFormatDemo {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("et", "EE"));
		
		NumberFormat format = NumberFormat.getInstance();
		System.out.println(format.format(123767676776676.123123));
				
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		System.out.println(currencyFormat.format(123));

		
		ChoiceFormat choice = new ChoiceFormat(new double[] {0, 1, 2}, new String[] {"no messages", "one message", "many messages"});
		System.out.println("You have " + choice.format(0));
		System.out.println("You have " + choice.format(1));
		System.out.println("You have " + choice.format(10));
	}
}
