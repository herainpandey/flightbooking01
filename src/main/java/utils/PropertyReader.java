package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static String getDataFromProperity(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\user.properties");
        properties.load(stream);
       return properties.getProperty(key);
    }
}
