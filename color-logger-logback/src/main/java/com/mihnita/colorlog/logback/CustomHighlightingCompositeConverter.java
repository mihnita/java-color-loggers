package com.mihnita.colorlog.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

import static ch.qos.logback.core.pattern.color.ANSIConstants.*;

public class CustomHighlightingCompositeConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {
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
