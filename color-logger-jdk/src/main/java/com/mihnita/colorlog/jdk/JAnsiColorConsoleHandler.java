package com.mihnita.colorlog.jdk;

import java.util.logging.LogRecord;
// Color Console Handler for jdk: using jansi (http://jansi.fusesource.org/)
import org.fusesource.jansi.AnsiConsole;

@SuppressWarnings("javadoc")
public class JAnsiColorConsoleHandler extends BaseColorConsoleHandler {
    @Override
    public void publish(LogRecord record) {
        AnsiConsole.err.print(logRecordToString(record));
        AnsiConsole.err.flush();
    }
}
