package ch.pearcenet.tui.exceptions;

import java.io.IOException;

public class CsvSyntaxException extends IOException {

    public CsvSyntaxException(String msg) {
        super(msg);
    }

}
