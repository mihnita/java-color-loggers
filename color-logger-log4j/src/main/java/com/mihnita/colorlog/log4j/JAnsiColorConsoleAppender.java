package com.mihnita.colorlog.log4j;

import java.io.PrintStream;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.fusesource.jansi.AnsiConsole;

/**
 * Color Console Appender for log4j: using jansi
 * (<a href="http://jansi.fusesource.org/">http://jansi.fusesource.org/</a>)
 * */
@SuppressWarnings("javadoc")
public class JAnsiColorConsoleAppender extends BaseColorConsoleAppender {
    private final String gTarget = null;
    private boolean usingStdErr;

    public JAnsiColorConsoleAppender() {
        super();
    }

    public JAnsiColorConsoleAppender(Layout layout) {
        super(layout);
    }

    public JAnsiColorConsoleAppender(Layout layout, String target) {
        super(layout, target);
    }

    @SuppressWarnings("static-method")
    public void setPassThrough(boolean value) {
        System.setProperty("jansi.passthrough", value ? "true" : "false");
    }

    @SuppressWarnings("static-method")
    public void setStrip(boolean value) {
        System.setProperty("jansi.strip", value ? "true" : "false");
    }

    @Override
    protected void subAppend(LoggingEvent event) {
        try (PrintStream currentOutput = usingStdErr ? AnsiConsole.err() : AnsiConsole.out()) {

            if (!hackPatternString()) {
                currentOutput.print(getColour(event.getLevel()));
                currentOutput.print(getLayout().format(event));
            } else {
                String color = getColour(event.getLevel());
                currentOutput.print(getLayout().format(event).replace(HIGHLIGHT_START, color));
            }

            if (immediateFlush) {
                currentOutput.flush();
            }
        }
    }

    @Override
    boolean hackPatternString() {
        String theTarget = getTarget();
        //no-inspection StringEquality
        if (gTarget != theTarget) { // I really want to have the same object, not just equal content
            usingStdErr = SYSTEM_ERR.equalsIgnoreCase(theTarget);
        }

        return super.hackPatternString();
    }
}
