package net.azib.java.students.t110013.homework.readers;

/**
 * //TODO class description
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
	 * //TODO method description
	 * @param parameter A
	 * @return A
	 */
    public abstract AthletesReader newInstance(String parameter);

	/**
	 * //TODO method description
	 * @return A
	 */
    public String getName() {
        return name;
    }

	/**
	 * //TODO method description
	 * @return A
	 */
    public boolean isParametrizable() {
        return parametrizable;
    }
}
