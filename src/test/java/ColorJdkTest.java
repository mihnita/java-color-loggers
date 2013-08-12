import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class ColorJdkTest extends ColorBaseTest {
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger("log-jdk");

    {
        System.out.println("===============================");
        System.out.println("====== Color logger - jdk =====");
        System.out.println("===============================");
    }

    public void doTheLogging(String configFileName) {
        InputStream ins = null;
        try {
            ins = new FileInputStream(getTargetDir() + configFileName);
            java.util.logging.LogManager.getLogManager().readConfiguration(ins);
        } catch (IOException e) {
            logger.severe("Error loading custom logging configuration " + configFileName);
        } finally {
            if (null != ins)
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        System.out.println();
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void colorLoggingJdkTest() {
        doTheLogging("logJdkNormal.properties");
        doTheLogging("logJdkColorEsc.properties");
        doTheLogging("logJdkColorJansi.properties");
    }
}
