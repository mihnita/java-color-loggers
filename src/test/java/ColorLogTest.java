import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

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

	static boolean waitForEnter = false;
	static void pressEnter() {
		if (waitForEnter) {
	        System.out.println("Press ENTER to continue...");
			Scanner scan = new Scanner (System.in);
			scan.nextLine();
		}
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

		pressEnter();
	}

	@Test
	public void colorLoggingLog4j() {
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

		pressEnter();
	}

	@Test
	public void colorLoggingLogback() {
		org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("log-logback");

		System.out.println("===============================");
		System.out.println("==== Color logger - logback ===");
		System.out.println("===============================");

		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");

		pressEnter();
	}

	public static void main(String[] argv) {
		waitForEnter = true;
		JUnitCore.runClasses(new Class[] { ColorLogTest.class });
	}
}
