package net.azib.java.students.t110013.homework.writers;

/**
 * Registers all output methods and appropriate AthletesWriter implementations. Each output method is able to instantiate
 * a correct AthletesWriter implementation.
 * @author Vadim
 */
public enum AthletesWriterTypes {
    CONSOLE("-console", false) {
        @Override
        public AthletesWriter newInstance(String ignore) {
            return new ConsoleAthletesWriter();
        }
    },
    CSV("-csv", true) {
        @Override
        public AthletesWriter newInstance(String parameter) {
            return new CSVAthletesWriter(parameter);
        }
    },
    XML("-xml", true) {
        @Override
        public AthletesWriter newInstance(String parameter) {
            return new XMLAthletesWriter(parameter);
        }
    },
    HTML("-html", true) {
        @Override
        public AthletesWriter newInstance(String parameter) {
            return new HTMLAthletesWriter(parameter);
        }
    };

    private final String name;
    private final boolean parametrizable;

    AthletesWriterTypes(String name, boolean parametrizable) {
        this.name = name;
        this.parametrizable = parametrizable;
    }

	/**
	 * An abstract method intended to provide one convenient way to instantiate different AthletesWriter
	 * implementations.
	 * @param parameter a String specifying output method destination
	 * @return a new instance of an appropriate AthletesWriter implementation
	 */
    public abstract AthletesWriter newInstance(String parameter);

	/**
	 * Returns the name of this output method. Intended to be used to validate output method arguments.
	 * @return a String representation of the output method name
	 */
    public String getName() {
        return name;
    }

	/**
	 * Indicates whether this output method should have specifying parameters or not.
	 * @return true if this output method should have specifying parameters, false if should not
	 */
    public boolean isParametrizable() {
        return parametrizable;
    }
}
