import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColorLog4jTest extends ColorBaseTest {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log-log4j");

	{ // configure logging
		PropertyConfigurator.configure(getTargetDir() + "log4jProp.properties");

		System.out.println("===============================");
		System.out.println("===== Color logger - log4j ====");
		System.out.println("===============================");
	}

	@Test
	public void colorLoggingLog4j() {

		logger.fatal("fatal");
		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");

		pressEnter();
	}
}
