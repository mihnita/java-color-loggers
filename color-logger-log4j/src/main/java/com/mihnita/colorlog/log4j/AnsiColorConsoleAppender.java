package com.mihnita.colorlog.log4j;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

/** Color Console Appender for log4j: using ANSI sequences directly (no dependencies) */
@SuppressWarnings("javadoc")
public class AnsiColorConsoleAppender extends BaseColorConsoleAppender {

    public AnsiColorConsoleAppender() {
        super();
    }

    public AnsiColorConsoleAppender(Layout layout) {
        super(layout);
    }

    public AnsiColorConsoleAppender(Layout layout, String target) {
        super(layout, target);
    }

    @Override
    protected void subAppend(LoggingEvent event) {
        if (!hackPatternString()) {
            qw.write(getColour(event.getLevel()));
            qw.write(getLayout().format(event));
        } else {
            String color = getColour(event.getLevel());
            qw.write(getLayout().format(event).replace(HIGHLIGHT_START, color));
        }

        if (immediateFlush) {
            qw.flush();
        }
    }
}
