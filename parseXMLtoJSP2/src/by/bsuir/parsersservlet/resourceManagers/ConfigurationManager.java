package by.bsuir.parsersservlet.resourceManagers;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static PropertyResourceBundle resourceBundle =
            (PropertyResourceBundle) PropertyResourceBundle.getBundle("resources.config");
    // класс извлекает информацию из файла config.properties
    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}