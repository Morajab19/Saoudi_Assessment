package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final String configFile = "src/test/resources/config.properties";

    public static String getBrowser() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(configFile)) {
            properties.load(fileInputStream);
            return properties.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
            return "chrome"; // Default browser will be chrome in case of any reading error
        }
    }

}
