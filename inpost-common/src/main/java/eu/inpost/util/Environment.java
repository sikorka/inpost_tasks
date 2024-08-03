package eu.inpost.util;

import lombok.extern.log4j.Log4j2;
import java.util.Properties;

@Log4j2
public class Environment {
    private static final String ENVIRONMENT_PROPERTIES_FILE_NAME = "environment.properties";

    private static final String ENVIRONMENT_NAME_KEY = "ENVIRONMENT_NAME";
    private static final String HOST_KEY = "HOST";
    private static final String GUI_HOST_KEY = "GUI_HOST";

    private Properties properties;

    private static Environment environment = new Environment();

    private Environment() {
        log.debug("Reading env properties...");
        properties = PropertiesReader.readResourcesPropertiesFrom(ENVIRONMENT_PROPERTIES_FILE_NAME);
        log.debug("Reading env properties done. ");

        PrettyLogs.print(properties);
    }

    static {
        PrettyLogs.print(System.getProperties());
    }

    public static String getHost() {
        return getProperty(HOST_KEY);
    }

    public static String getGuiHost() {
        return getProperty(GUI_HOST_KEY);
    }

    public static String getEnvironmentName() {
        return getProperty(ENVIRONMENT_NAME_KEY);
    }

    private static String getProperty(String propertyKey) {
        if (environment.properties == null) {
            log.error("Properties not initialized!");

            return null;
        } else {
            String value = environment.properties.getProperty(propertyKey);
            if (value == null) {
                log.error("Missing property '" + propertyKey + "' from environment properties!");
            }

            return value;
        }
    }
}
