package net.azib.java.lessons.exception;

/**
 * PetNameException
 *
 * @author anton
 */
public class PetNameException extends IllegalArgumentException {
	
	public PetNameException() {		
	}

	public PetNameException(Throwable cause) {
		super(cause);
	}
}
