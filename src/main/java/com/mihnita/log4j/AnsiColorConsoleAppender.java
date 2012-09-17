package com.mihnita.log4j;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

// Color Console Appender for log4j: using ANSI sequences directly (no dependencies)

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
		hackPatternString();

		qw.write(getColour(event.getLevel()));
		qw.write(getLayout().format(event));

		if (immediateFlush)
			qw.flush();
	}
}
