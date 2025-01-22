package com.mihnita.colorlog.jdk;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.AnsiPrintStream;

import java.util.logging.LogRecord;

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
