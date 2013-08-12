import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.junit.runner.JUnitCore;

public class ColorBaseTest {
    static boolean waitForEnter = false;

    public static String getTargetDir() {
        URL url = ColorBaseTest.class.getResource(".");
        if (null == url)
            return ".";

        try {
            return url.toURI().getPath();
        } catch (URISyntaxException e) {
        }

        return ".";
    }

    static void pressEnter() {
        if (waitForEnter) {
            System.out.println("Press ENTER to continue...");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            scan.close();
        }
    }

    public static void main(String[] argv) {
        waitForEnter = true;
        Class<?> [] classesArray = {
            ColorJdkTest.class,
            ColorLog4jTest.class,
            ColorLog4jXmlTest.class,
            ColorLogbackTest.class
        };
        JUnitCore.runClasses(classesArray);
    }
}
