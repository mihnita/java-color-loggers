package com.mihnita.colorlog.log4j;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

/** Color Console Appender for log4j: using ANSI sequences */
abstract class BaseColorConsoleAppender extends ConsoleAppender {
    private final Map<Level, String> levelToColor = new HashMap<>();
    private String gPattern = "";
    private boolean gPatternHighlight = false;
    static final String HIGHLIGHT_START = "{highlight}";
    private static final String HIGHLIGHT_END = "{/highlight}";

    private static final String COLOR_RESET = "\u001b[0m";

    {
        levelToColor.put(Level.FATAL, "\u001b[97;41m");
        levelToColor.put(Level.ERROR, "\u001b[91m");
        levelToColor.put(Level.WARN,  "\u001b[93m");
        levelToColor.put(Level.INFO,  "\u001b[22;32m");
        levelToColor.put(Level.DEBUG, "\u001b[22;36m");
        levelToColor.put(Level.TRACE, "\u001b[90m");
    }

    BaseColorConsoleAppender() {
        super();
    }

    BaseColorConsoleAppender(Layout layout) {
        super(layout);
    }

    BaseColorConsoleAppender(Layout layout, String target) {
        super(layout, target);
    }

    public void setFatalColour(String value) {
        levelToColor.put(Level.FATAL, value.replace("{esc}", "\u001b"));
    }

    public void setErrorColour(String value) {
        levelToColor.put(Level.ERROR, value.replace("{esc}", "\u001b"));
    }

    public void setWarnColour(String value) {
        levelToColor.put(Level.WARN, value.replace("{esc}", "\u001b"));
    }

    public void setInfoColour(String value) {
        levelToColor.put(Level.INFO, value.replace("{esc}", "\u001b"));
    }

    public void setDebugColour(String value) {
        levelToColor.put(Level.DEBUG, value.replace("{esc}", "\u001b"));
    }

    public void setTraceColour(String value) {
        levelToColor.put(Level.TRACE, value.replace("{esc}", "\u001b"));
    }

    String getColour(Level level) {
        String result = levelToColor.get(level);
        if (null == result)
            return levelToColor.get(Level.ERROR);
        return result;
    }

    /*
     * Adds a "reset color" before the newline to prevent some ugly artifacts
     */
    boolean hackPatternString() {
        EnhancedPatternLayout enhancedPatternLayout = null;
        PatternLayout patternLayout = null;
        String pattern;

        Class<?> c = this.getLayout().getClass();
        if (EnhancedPatternLayout.class.isAssignableFrom(c)) {
            enhancedPatternLayout = (EnhancedPatternLayout) this.getLayout();
            if (null == enhancedPatternLayout)
                return gPatternHighlight;
            pattern = enhancedPatternLayout.getConversionPattern();
        } else if (PatternLayout.class.isAssignableFrom(c)) {
            patternLayout = (PatternLayout) this.getLayout();
            if (null == patternLayout)
                return gPatternHighlight;
            pattern = patternLayout.getConversionPattern();
        } else
            return gPatternHighlight;

        if (gPattern.equals(pattern))
            return gPatternHighlight;

        int hiStart = pattern.indexOf(HIGHLIGHT_START);
        gPatternHighlight = (hiStart != -1);

        // If we have a {/highlight}, we put the COLOR_RESET there
        // Otherwise we put it at the end, or right before the final %n
        if (pattern.contains(HIGHLIGHT_END))
            gPattern = pattern.replace(HIGHLIGHT_END, COLOR_RESET);
        else if (pattern.endsWith("%n"))
            gPattern = pattern.substring(0, pattern.length() - 2) + COLOR_RESET + "%n";
        else
            gPattern = pattern + COLOR_RESET;

        if (null != enhancedPatternLayout) {
            enhancedPatternLayout.setConversionPattern(gPattern);
            this.setLayout(enhancedPatternLayout);
        }
        if (null != patternLayout) {
            patternLayout.setConversionPattern(gPattern);
            this.setLayout(patternLayout);
        }

        return gPatternHighlight;
    }

}
