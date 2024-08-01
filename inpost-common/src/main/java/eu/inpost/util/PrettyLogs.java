package eu.inpost.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.util.Properties;

@Log4j2
@UtilityClass
public final class PrettyLogs {

    public static void print(Properties properties) {
        if (properties == null || properties.isEmpty()) {
            log.info("Properties are empty.");
            return;
        }

        properties.stringPropertyNames().forEach(key ->
                log.info(key + "=" + properties.get(key)));
    }
}
