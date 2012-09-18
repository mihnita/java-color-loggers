package com.mihnita.tests;

import org.apache.log4j.Logger;

import org.junit.Test;

public class ColorAppendersTest {

	@Test
	public void testColorLogging () {
		Logger logger = Logger.getLogger(ColorAppendersTest.class);
		logger.fatal("fatal");
		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
	}
}
