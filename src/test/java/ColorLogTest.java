import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColorLogTest {
	public static String getTargetDir() {
		URL url = ColorLogTest.class.getResource(".");
		if (null == url)
			return ".";

		try {
			return url.toURI().getPath();
		} catch (URISyntaxException e) {
		}

		return ".";
	}

	@Test
	public void colorLoggingJdkTest() {
		java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log-jdk");

		System.out.println("===============================");
		System.out.println("====== Color logger - jdk =====");
		System.out.println("===============================");

		String root = getTargetDir();
		try {
			InputStream ins = new FileInputStream(root + "logJdk.properties");
			java.util.logging.LogManager.getLogManager().readConfiguration(ins);
		} catch (IOException e) {
			logger.severe("Error loading custom logging configuration:" + root);
		}
		
		logger.severe("severe");
		logger.warning("warning");
		logger.info("info");
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");
	}

	@Test
	public void testColorLogging() {
		org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log-log4j");

		System.out.println("===============================");
		System.out.println("===== Color logger - log4j ====");
		System.out.println("===============================");

		logger.fatal("fatal");
		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
	}

	public static void main(String[] argv) {
		JUnitCore.runClasses(new Class[] { ColorLogTest.class });
	}
}
