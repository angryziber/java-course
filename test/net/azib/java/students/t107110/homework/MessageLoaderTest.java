package net.azib.java.students.t107110.homework;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class MessageLoaderTest {
	@Before
	public void prepare() {
		Locale.setDefault(Locale.FRENCH);
	}

	@Test
	public void canBeCreated() {
		new MessageLoader();
	}

	@Test
	public void localizedMessage() {
		assertThat(MessageLoader.getLocalizedMessage(Message.NO_INPUT_FILE),
				is("Fichier de saisie n'est pas spécifiée"));
	}

	@Test
	public void englishMessage() {
		assertThat(MessageLoader.getEnglishMessage(Message.NO_INPUT_FILE), is("No input file specified"));
	}
}
