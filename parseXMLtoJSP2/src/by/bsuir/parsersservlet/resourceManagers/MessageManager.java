package by.bsuir.parsersservlet.resourceManagers;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class MessageManager {
    private final static PropertyResourceBundle resourceBundle =
            (PropertyResourceBundle) PropertyResourceBundle.getBundle("resources.messages");
    // класс извлекает информацию из файла messages.properties
    private MessageManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
