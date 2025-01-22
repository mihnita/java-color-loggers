package com.mihnita.colorlog.logback;

import static ch.qos.logback.core.pattern.color.ANSIConstants.BLACK_FG;
import static ch.qos.logback.core.pattern.color.ANSIConstants.BOLD;
import static ch.qos.logback.core.pattern.color.ANSIConstants.CYAN_FG;
import static ch.qos.logback.core.pattern.color.ANSIConstants.DEFAULT_FG;
import static ch.qos.logback.core.pattern.color.ANSIConstants.GREEN_FG;
import static ch.qos.logback.core.pattern.color.ANSIConstants.RED_FG;
import static ch.qos.logback.core.pattern.color.ANSIConstants.YELLOW_FG;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.pattern.color.HighlightingCompositeConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

@SuppressWarnings("javadoc")
public class CustomHighlightingCompositeConverter extends HighlightingCompositeConverter {
    static String errorColor   = BOLD + RED_FG;
    static String warningColor = BOLD + YELLOW_FG;
    static String infoColor    = GREEN_FG;
    static String debugColor   = CYAN_FG;
    static String traceColor   = BOLD + BLACK_FG;

    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        Level level = event.getLevel();
        switch (level.toInt()) {
            case Level.ERROR_INT: return errorColor;
            case Level.WARN_INT:  return warningColor;
            case Level.INFO_INT:  return infoColor;
            case Level.DEBUG_INT: return debugColor;
            case Level.TRACE_INT: return traceColor;
            default: return DEFAULT_FG;
        }
    }
}
