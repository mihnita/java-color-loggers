package com.mihnita.colorlog.jdk;

import java.util.logging.LogRecord;

/** Color Console Handler for jdk: using ANSI sequences directly (no dependencies) */
public class AnsiColorConsoleHandler extends BaseColorConsoleHandler {
    @Override
    public void publish(LogRecord record) {
        System.err.print(logRecordToString(record));
        System.err.flush();
    }
}
