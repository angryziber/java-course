package net.azib.java.students.t104887.Lecture6;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 24.03.11
 * Time: 15:41
 * To change this template use File | Settings | File Templates.
 */
public class lecture {
	public static void main(String[] args) {
		NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en_US"));
		System.out.println(currency.format(1000000000.123));

		NumberFormat anotherCurrency = NumberFormat.getNumberInstance();
		anotherCurrency.setCurrency(Currency.getInstance("RUB"));

		System.out.println(anotherCurrency.format(1000000000000.123));

		Format format = new ChoiceFormat(new double[]{0, 1, 2}, new String[]{"zero", "one", "two"});

		System.out.println(format.format(0));
		System.out.println(format.format(1));
		System.out.println(format.format(2));
		System.out.println(format.format(3));

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name = scanner.next("[a-z][A-Z]+");
		System.out.println("Hello " + name);


	}
}
