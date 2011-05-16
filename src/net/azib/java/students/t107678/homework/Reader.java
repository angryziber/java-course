package net.azib.java.students.t107678.homework;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

public interface Reader{

    public Record getNext() throws IOException, RecordFormatException, SQLException;

}

class RecordFormatException extends Exception {



    public RecordFormatException(Throwable cause) {
        super(cause);
    }

    public RecordFormatException(String message) {
        super(message);
    }
}


