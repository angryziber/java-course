package net.azib.java.students.t110013.homework.writers;

/**
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

    public abstract AthletesWriter newInstance(String parameter);

    public String getName() {
        return name;
    }

    public boolean isParametrizable() {
        return parametrizable;
    }
}
