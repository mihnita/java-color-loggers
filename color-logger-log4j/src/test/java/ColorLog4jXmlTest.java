import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ColorLog4jXmlTest extends ColorBaseTest {
    private final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("log-log4j");

    static {
        System.out.println("===================================================");
        System.out.println("===== Color logger - log4j - XML configuration ====");
        System.out.println("===================================================");
    }

    private static void selectLoggingConfigFile(String configFileName) {
        DOMConfigurator.configure(getTargetDir() + configFileName);
    }

    private void doTheLogging(String configFileName) {
        selectLoggingConfigFile(configFileName);

        System.out.println();
        logger.fatal("fatal with XML");
        logger.error("error with XML");
        logger.warn("warn with XML");
        logger.info("info with XML");
        logger.debug("debug with XML");
        logger.trace("trace with XML");
    }

    @Test
    public void colorLoggingLog4j() {
        doTheLogging("log4jXmlNormal.xml");
        doTheLogging("log4jXmlColorEsc.xml");
        doTheLogging("log4jXmlColorEscRegion.xml");
        doTheLogging("log4jXmlColorJansi.xml");
        doTheLogging("log4jXmlColorJansiRegion.xml");
        System.out.println();
    }
}
