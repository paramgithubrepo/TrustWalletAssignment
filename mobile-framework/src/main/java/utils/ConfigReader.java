package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public void loadConfig() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Properties cmdproperties = System.getProperties();
        for (Map.Entry<Object, Object> entry : cmdproperties.entrySet()) {
            properties.setProperty(entry.getKey().toString(), entry.getValue().toString());
        }
    }


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
