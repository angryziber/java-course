package net.azib.java.lessons.text;

import java.text.*;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatDemo {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(new Locale("et_EE"));
		System.out.println(Currency.getInstance(Locale.GERMANY));

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		currency.setCurrency(Currency.getInstance("EUR"));
		System.out.println(currency.format(1000000.123));

		NumberFormat format = NumberFormat.getInstance();
		System.out.println(format.format(1000000.123));

		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator('-');
		format = new DecimalFormat("#,##.00#", symbols);
		System.out.println(format.format(1000000.123));

		format = new ChoiceFormat(new double[] {0,1,2}, new String[] {"no files", "one file", "many files"});
		System.out.println(format.format(0));
		System.out.println(format.format(1));
		System.out.println(format.format(15));

		System.out.println(format.parse("one file"));

		MessageFormat messageFormat = new MessageFormat("You have {0,choice,0#no files|1#one file|2<{0} files}");
		System.out.println(messageFormat.format(new Object[] {5}));
	}
}
