import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ColorLogbackTest extends ColorBaseTest {
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("log-logback");

	{ // configure logging
		System.out.println("===============================");
		System.out.println("==== Color logger - logback ===");
		System.out.println("===============================");
	}
/*
// http://logback.qos.ch/manual/configuration.html

    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    
    try {
      JoranConfigurator configurator = new JoranConfigurator();
      configurator.setContext(context);
      // Call context.reset() to clear any previous configuration, e.g. default 
      // configuration. For multi-step configuration, omit calling context.reset().
      context.reset(); 
      configurator.doConfigure(args[0]);
    } catch (JoranException je) {
      // StatusPrinter will handle this
    }
    StatusPrinter.printInCaseOfErrorsOrWarnings(context);
*/

	@Test
	public void colorLoggingLogback() {

		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");

		pressEnter();
	}
}
