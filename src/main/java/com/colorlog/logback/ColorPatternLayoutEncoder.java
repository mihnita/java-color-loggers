package com.colorlog.logback;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;

public class ColorPatternLayoutEncoder extends PatternLayoutEncoder {

    @Override
    public void start() {
        super.start();

        PatternLayout patternLayout = (PatternLayout) this.layout;
        patternLayout.stop();
        patternLayout.getInstanceConverterMap().put("highlight", "com.colorlog.logback.CustomHighlightingCompositeConverter");
        patternLayout.start();

        this.layout = patternLayout;
    }

    @SuppressWarnings("static-method")
    public void setErrorColor(String value) {
        CustomHighlightingCompositeConverter.errorColor = value;
    }

    @SuppressWarnings("static-method")
    public void setWarningColor(String value) {
        CustomHighlightingCompositeConverter.warningColor = value;
    }

    @SuppressWarnings("static-method")
    public void setInfoColor(String value) {
        CustomHighlightingCompositeConverter.infoColor = value;
    }

    @SuppressWarnings("static-method")
    public void setDebugColor(String value) {
        CustomHighlightingCompositeConverter.debugColor = value;
    }

    @SuppressWarnings("static-method")
    public void setTraceColor(String value) {
        CustomHighlightingCompositeConverter.traceColor = value;
    }
}
