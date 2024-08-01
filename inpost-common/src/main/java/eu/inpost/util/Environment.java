package eu.inpost.util;


import lombok.extern.log4j.Log4j2;

import java.util.Properties;

@Log4j2
public class Environment {
    private static final String ENVIRONMENT_PROPERTIES_FILE_NAME = "environment.properties";

    private static final String ENVIRONMENT_NAME_KEY = "ENVIRONMENT_NAME";
    private static final String HOST_KEY = "HOST";

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

    public static String environmentName = "prod";

    public static String host = "api-shipx-pl.easypack24.net";

    public static String getHost() {
        return getProperty(HOST_KEY);
    }

    public static String getEnvironmentName() {
        return getProperty(ENVIRONMENT_NAME_KEY);
    }

    private static String getProperty(String propertyName) {
        if (environment.properties == null) {
            log.error("Properties not initialized!");
            return null;
        } else {
            return environment.properties.getProperty(propertyName);
        }
    }
}
