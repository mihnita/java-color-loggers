import org.junit.Test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

@SuppressWarnings("javadoc")
public class ColorLogbackTest extends ColorBaseTest {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("log-logback");

    static {
        System.out.println("===============================");
        System.out.println("==== Color logger - logback ===");
        System.out.println("===============================");
    }

    private static void selectLoggingConfigFile(String configFileName) {
        LoggerContext context = (LoggerContext) org.slf4j.LoggerFactory.getILoggerFactory();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);
            context.reset();
            configurator.doConfigure(getTargetDir() + configFileName);
        } catch (@SuppressWarnings("unused") JoranException e) {
            // StatusPrinter will handle this
        }
        StatusPrinter.printInCaseOfErrorsOrWarnings(context);
    }

    private void doTheLogging(String configFileName) {
        selectLoggingConfigFile(configFileName);

        System.out.println();
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }

    @Test
    public void colorLoggingLogback() {
        doTheLogging("logbackNormal.xml");
        doTheLogging("logbackNormalRegion.xml");
        doTheLogging("logbackColorEsc.xml");
        doTheLogging("logbackColorEscRegion.xml");
        System.out.println();
    }
}
