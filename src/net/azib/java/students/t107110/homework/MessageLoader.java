package net.azib.java.students.t107110.homework;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * @author Eduard Shustrov
 */
public class MessageLoader {
	private static final String FILE_NAME_SUFFIX = "Messages";

	private final ResourceBundle messages;

	public MessageLoader(final Class<?> messageClass) {
		messages = ResourceBundle.getBundle(messageClass.getCanonicalName() + FILE_NAME_SUFFIX);
	}

	public String getMessage(final String messageKey, final String... args) {
		return new MessageFormat(messages.getString(messageKey)).format(args);
	}

	public IllegalArgumentException argumentException(final String message, final String... args) {
		return new IllegalArgumentException(getMessage(message, args));
	}
}
