import java.net.URISyntaxException;
import java.net.URL;

import org.junit.runner.JUnitCore;

class ColorBaseTest {

    static String getTargetDir() {
        URL url = ColorBaseTest.class.getResource(".");
        if (null == url)
            return ".";

        try {
            return url.toURI().getPath();
        } catch (URISyntaxException e) {
			e.printStackTrace();
        }

        return ".";
    }

    public static void main(String[] argv) {
        Class<?> [] classesArray = {
            ColorLog4jTest.class,
            ColorLog4jXmlTest.class
        };
        JUnitCore.runClasses(classesArray);
    }
}
