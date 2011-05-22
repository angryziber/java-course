package net.azib.java.students.t107110.homework;

import org.junit.Test;

import java.util.Locale;

import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class DecathlonExceptionTest {
	private static final String ENGLISH = "No input file specified";
	private static final String FRENCH = "Fichier de saisie n'est pas spécifiée";

	@Test
	public void exceptionWithNoCause() {
		checkMessages(new DecathlonException(ENGLISH, FRENCH));
	}

	@Test
	public void exceptionWithCause() {
		final Throwable cause = new Exception();
		final Exception exception = new DecathlonException(ENGLISH, FRENCH, cause);

		checkMessages(exception);
		assertThat(exception.getCause(), is(cause));
	}

	@Test
	public void exceptionFromResourcesWithNoCause() {
		Locale.setDefault(Locale.FRENCH);
		checkMessages(decathlonException(Message.NO_INPUT_FILE));
	}

	@Test
	public void exceptionFromResourcesWithCause() {
		Locale.setDefault(Locale.FRENCH);
		final Throwable cause = new Exception();
		final Throwable exception = decathlonException(cause, Message.NO_INPUT_FILE);

		checkMessages(exception);
		assertThat(exception.getCause(), is(cause));
	}

	private void checkMessages(final Throwable exception) {
		assertThat(exception.getMessage(), is(FRENCH));
		assertThat(exception.getLocalizedMessage(), is(ENGLISH));
	}
}
