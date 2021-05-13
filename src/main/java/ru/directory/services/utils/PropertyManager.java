package ru.directory.services.utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertyManager {
    private static Properties properties = new Properties();
    public static final String DEFAULT_PATH = getProperties().getProperty("path");

    private static Properties getProperties()  {
        try {
            properties.load(new FileReader("src/main/resources/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
