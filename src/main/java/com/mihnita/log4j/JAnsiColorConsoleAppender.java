package com.mihnita.log4j;

import java.io.PrintStream;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import org.fusesource.jansi.AnsiConsole;

// Color Console Appender for log4j: using jansi (http://jansi.fusesource.org/)

public class JAnsiColorConsoleAppender extends BaseColorConsoleAppender {
	String gTarget = null;
	boolean usingStdErr;

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
		hackPatternString();
		PrintStream currentOutput = usingStdErr ? AnsiConsole.err
				: AnsiConsole.out;

		currentOutput.print(getColour(event.getLevel()));
		currentOutput.print(getLayout().format(event));

		if (immediateFlush)
			currentOutput.flush();
	}

	@Override
	protected void hackPatternString() {
		String theTarget = getTarget();
		if (gTarget != theTarget) // I really want to have the same object, not just equal content
			usingStdErr = SYSTEM_ERR.equalsIgnoreCase(theTarget);

		super.hackPatternString();
	}
}
