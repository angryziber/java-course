package net.azib.java.students.t110013.homework.readers;

/**
 * Registers all input methods and appropriate AthletesReader implementations. Each input method is able to instantiate
 * a correct AthletesReader implementation.
 * @author Vadim
 */
public enum AthletesReaderTypes {
    CONSOLE("-console", false) {
        @Override
        public AthletesReader newInstance(String ignore) {
            return new ConsoleAthletesReader();
        }
    },
    CSV("-csv", true) {
        @Override
        public AthletesReader newInstance(String parameter) {
            return new CSVAthletesReader(parameter);
        }
    },
    DB("-db", true) {
        @Override
        public AthletesReader newInstance(String parameter) {
            return new DBAthletesReader(parameter);
        }
    };

    private final String name;
    private final boolean parametrizable;

    AthletesReaderTypes(String name, boolean parametrizable) {
        this.name = name;
        this.parametrizable = parametrizable;
    }

	/**
	 * An abstract method intended to provide one convenient way to instantiate different AthletesReader
	 * implementations.
	 * @param parameter a String specifying input method source
	 * @return a new instance of an appropriate AthletesReader implementation
	 */
    public abstract AthletesReader newInstance(String parameter);

	/**
	 * Returns the name of this input method. Intended to be used to validate input method arguments.
	 * @return a String representation of the input method name
	 */
    public String getName() {
        return name;
    }

	/**
	 * Indicates whether this input method should have specifying parameters or not.
	 * @return true if this input method should have specifying parameters, false if should not
	 */
    public boolean isParametrizable() {
        return parametrizable;
    }
}
