package com.mihnita.tests;

import org.apache.log4j.Logger;

public class ColorAppendersTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ColorAppendersTest.class);
		logger.fatal("fatal");
		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
	}
}
