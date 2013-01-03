package com.colorlog.logback;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.PatternLayout;

public class ColorPatternLayoutEncoder extends PatternLayoutEncoder {

	@Override
	public void start() {
		super.start();

		PatternLayout patternLayout = (PatternLayout)this.layout;
		patternLayout.stop();
		patternLayout.defaultConverterMap.put("highlight", "com.colorlog.logback.CustomHighlightingCompositeConverter");
		patternLayout.start();

		this.layout = patternLayout;
	}

	public void setErrorColor(String value) {
		CustomHighlightingCompositeConverter.errorColor = value;
	}
	public void setWarningColor(String value) {
		CustomHighlightingCompositeConverter.warningColor = value;
	}
	public void setInfoColor(String value) {
		CustomHighlightingCompositeConverter.infoColor = value;
	}
	public void setDebugColor(String value) {
		CustomHighlightingCompositeConverter.debugColor = value;
	}
	public void setTraceColor(String value) {
		CustomHighlightingCompositeConverter.traceColor = value;
	}
}
