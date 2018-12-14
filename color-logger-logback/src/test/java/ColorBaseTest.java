import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import org.junit.runner.JUnitCore;

public class ColorBaseTest {

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

    public static void main(String[] argv) {
        Class<?> [] classesArray = {
            ColorLogbackTest.class,
        };
        JUnitCore.runClasses(classesArray);
    }
}
