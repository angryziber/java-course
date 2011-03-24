package net.azib.java.lessons.text;

import org.junit.Test;

import java.text.Collator;
import java.util.Locale;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollatorTest {
	@Test
	public void überAndZeitInEstoniaAndGermany() {
		Collator estonian = Collator.getInstance(new Locale("et"));
		Collator german = Collator.getInstance(Locale.GERMANY);

		assertTrue(estonian.compare("über", "zeit") > 0);
		assertTrue(german.compare("über", "zeit") < 0);
	}

	@Test
	public void üAndUAreTheSame() {
		Collator german = Collator.getInstance(Locale.GERMANY);
		german.setStrength(Collator.PRIMARY);
		assertEquals(0, german.compare("ü", "u"));

		german.setStrength(Collator.IDENTICAL);
		assertEquals(1, german.compare("ü", "u"));
	}
}
