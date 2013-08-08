import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.xml.DOMConfigurator;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColorLog4jXmlTest extends ColorBaseTest {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log-log4j");

	{ // configure logging
		DOMConfigurator.configure(getTargetDir() + "log4jXml.xml");

		System.out.println("===================================================");
		System.out.println("===== Color logger - log4j - XML configuration ====");
		System.out.println("===================================================");
	}

	@Test
	public void testColorLogging() {

		logger.fatal("fatal with XML");
		logger.error("error with XML");
		logger.warn("warn with XML");
		logger.info("info with XML");
		logger.debug("debug with XML");
		logger.trace("trace with XML");

		pressEnter();
	}
}
