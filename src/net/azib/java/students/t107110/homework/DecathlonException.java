package net.azib.java.students.t107110.homework;

/**
 * @author Eduard Shustrov
 */
public class DecathlonException extends Exception {
	private final String englishMessage;

	public DecathlonException(final String englishMessage, final String localizedMessage) {
		super(localizedMessage);
		this.englishMessage = englishMessage;
	}

	public DecathlonException(final String englishMessage, final String localizedMessage, final Throwable cause) {
		super(localizedMessage, cause);
		this.englishMessage = englishMessage;
	}

	@Override
	public String getLocalizedMessage() {
		return englishMessage;
	}

	public static DecathlonException decathlonException(final Message messageID, final String... args) {
		return new DecathlonException(MessageLoader.getEnglishMessage(messageID, args),
				MessageLoader.getLocalizedMessage(messageID, args));
	}

	public static DecathlonException decathlonException(final Throwable cause,
	                                                    final Message messageID, final String... args) {
		return new DecathlonException(MessageLoader.getEnglishMessage(messageID, args),
				MessageLoader.getLocalizedMessage(messageID, args), cause);
	}
}
