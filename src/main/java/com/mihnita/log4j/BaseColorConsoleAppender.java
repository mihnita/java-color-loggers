package com.mihnita.log4j;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

// Color Console Appender for log4j: using ANSI sequences

public abstract class BaseColorConsoleAppender extends ConsoleAppender {
	private Map<Level, String> levelToColor = new HashMap<Level, String>();
	private String gPattern = null;

	protected static final String COLOR_RESET = "\u001b[0m";
	{
		levelToColor.put(Level.FATAL, "\u001b[1;37;41m");
		levelToColor.put(Level.ERROR, "\u001b[1;31m");
		levelToColor.put(Level.WARN, "\u001b[1;33m");
		levelToColor.put(Level.INFO, "\u001b[22;32m");
		levelToColor.put(Level.DEBUG, "\u001b[22;36m");
		levelToColor.put(Level.TRACE, "\u001b[1;30m");
	}

	public BaseColorConsoleAppender() {
		super();
	}

	public BaseColorConsoleAppender(Layout layout) {
		super(layout);
	}

	public BaseColorConsoleAppender(Layout layout, String target) {
		super(layout, target);
	}

	public void setFatalColour(String value) {
		levelToColor.put(Level.FATAL, value);
	}

	public void setErrorColour(String value) {
		levelToColor.put(Level.ERROR, value);
	}

	public void setWarnColour(String value) {
		levelToColor.put(Level.WARN, value);
	}

	public void setInfoColour(String value) {
		levelToColor.put(Level.INFO, value);
	}

	public void setDebugColour(String value) {
		levelToColor.put(Level.DEBUG, value);
	}

	public void setTraceColour(String value) {
		levelToColor.put(Level.TRACE, value);
	}

	protected String getColour(Level level) {
		String result = levelToColor.get(level);
		if (null == result)
			return levelToColor.get(Level.ERROR);
		return result;
	}

	/*
	 * Adds a "reset color" before the newline to prevent some ugly artifacts
	 */
	protected void hackPatternString() {
		EnhancedPatternLayout enhancedPatternLayout = null;
		PatternLayout patternLayout = null;
		String pattern;

		Class<?> c = this.getLayout().getClass();
		if (EnhancedPatternLayout.class.isAssignableFrom(c)) {
			enhancedPatternLayout = (EnhancedPatternLayout) this.getLayout();
			if (null == enhancedPatternLayout)
				return;
			pattern = enhancedPatternLayout.getConversionPattern();
		} else if (PatternLayout.class.isAssignableFrom(c)) {
			patternLayout = (PatternLayout) this.getLayout();
			if (null == patternLayout)
				return;
			pattern = patternLayout.getConversionPattern();
		} else
			return;

		if (pattern == gPattern) // I really want to have the same object, not just equal content
			return;

		if (pattern.endsWith("%n"))
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
	}

}
