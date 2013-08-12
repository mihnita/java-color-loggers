import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

public class ColorLog4jTest extends ColorBaseTest {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log-log4j");

	{
		System.out.println("===============================");
		System.out.println("===== Color logger - log4j ====");
		System.out.println("===============================");
	}

	public void doTheLogging(String configFileName) {
		PropertyConfigurator.configure(getTargetDir() + configFileName);

		System.out.println();
		logger.fatal("fatal");
		logger.error("error");
		logger.warn("warn");
		logger.info("info");
		logger.debug("debug");
		logger.trace("trace");
	}

	@Test
	public void colorLoggingLog4j() {
		doTheLogging("log4jPropNormal.properties");
		doTheLogging("log4jPropColorEsc.properties");
		doTheLogging("log4jPropColorEscRegion.properties");
		doTheLogging("log4jPropColorJansi.properties");
		doTheLogging("log4jPropColorJansiRegion.properties");
		System.out.println();
	}
}
