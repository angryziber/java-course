package net.azib.java.students.t107110.homework;

import org.apache.log4j.PatternLayout;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Eduard Shustrov
 */
public class MessageLoader {
	private static final String MESSAGE_BASE = "Messages";
	private static final String MESSAGE_PACKAGE = MessageLoader.class.getCanonicalName().replaceAll("\\.[^.]*$", "");
	private static final ResourceBundle MESSAGES = ResourceBundle.getBundle(MESSAGE_PACKAGE + "." + MESSAGE_BASE);
	private static final ResourceBundle ENGLISH_MESSAGES =
			ResourceBundle.getBundle(MESSAGE_PACKAGE + "." + MESSAGE_BASE, Locale.ROOT);

	public static String getLocalizedMessage(final Message messageID, final String... args) {
		return getMessage(MESSAGES, messageID, args);
	}

	public static String getEnglishMessage(final Message messageID, final String... args) {
		return getMessage(ENGLISH_MESSAGES, messageID, args);
	}

	private static String getMessage(final ResourceBundle bundle, final Message messageID, final String[] args) {
		return new MessageFormat(bundle.getString(messageID.name())).format(args);
	}
}
