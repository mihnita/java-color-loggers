package com.mihnita.colorlog.jdk;

import java.util.logging.LogRecord;
// Color Console Handler for jdk: using jansi (http://jansi.fusesource.org/)
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.AnsiPrintStream;

@SuppressWarnings("javadoc")
public class JAnsiColorConsoleHandler extends BaseColorConsoleHandler {
    @Override
    public void publish(LogRecord record) {
        try (AnsiPrintStream err = AnsiConsole.err()) {
            err.print(logRecordToString(record));
            err.flush();
        }
    }
}
