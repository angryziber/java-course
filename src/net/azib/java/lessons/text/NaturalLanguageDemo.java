package net.azib.java.lessons.text;

import static org.junit.Assert.assertEquals;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Locale;

import org.junit.Test;

/**
 * NaturalLanguageDemo
 *
 * @author anton
 */
public class NaturalLanguageDemo {
	@Test
	public void collator() throws Exception {
		Collator collator = Collator.getInstance(new Locale("et"));		
		assertEquals(1, collator.compare("ä", "b"));

		collator = Collator.getInstance(new Locale("de"));		
		assertEquals(-1, collator.compare("ä", "b"));
		
		RuleBasedCollator c = (RuleBasedCollator) collator;
		System.out.println(c.getRules());
	}
}
