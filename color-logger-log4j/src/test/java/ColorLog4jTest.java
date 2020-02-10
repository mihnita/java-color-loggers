import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ColorLog4jTest extends ColorBaseTest {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log-log4j");

    static {
        System.out.println("===============================");
        System.out.println("===== Color logger - log4j ====");
        System.out.println("===============================");
    }

    private static void selectLoggingConfigFile(String configFileName) {
        PropertyConfigurator.configure(getTargetDir() + configFileName);
    }

    private void doTheLogging(String configFileName) {
        selectLoggingConfigFile(configFileName);

        System.out.println();
        logger.fatal("fatal");
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
        logger.warn("warn with XML and exception",
                new NullPointerException("Just testing"));
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
