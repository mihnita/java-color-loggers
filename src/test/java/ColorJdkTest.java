import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColorJdkTest extends ColorBaseTest {
	java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log-jdk");

	{ // configure logging
		System.out.println("===============================");
		System.out.println("====== Color logger - jdk =====");
		System.out.println("===============================");

		String root = getTargetDir();
		InputStream ins = null;
		try {
			ins = new FileInputStream(root + "logJdk.properties");
			java.util.logging.LogManager.getLogManager().readConfiguration(ins);
		} catch (IOException e) {
			logger.severe("Error loading custom logging configuration:" + root);
		} finally {
		    if (null != ins) try { ins.close(); } catch (IOException e) { e.printStackTrace(); }
		}
	}

	@Test
	public void colorLoggingJdkTest() {

		logger.severe("severe");
		logger.warning("warning");
		logger.info("info");
		logger.config("config");
		logger.fine("fine");
		logger.finer("finer");
		logger.finest("finest");

		pressEnter();
	}
}
