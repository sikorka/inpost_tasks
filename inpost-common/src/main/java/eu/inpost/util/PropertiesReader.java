package eu.inpost.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.Properties;

@Log4j2
@UtilityClass
public final class PropertiesReader {

    public static Properties readResourcesPropertiesFrom(String fileName) {
        Properties properties = new Properties();

        if (StringUtils.isBlank(fileName)) {
            log.info("File name is blank.");
            return properties;
        }

        try {
            InputStream inputStream = ResourceFileReader.getInputStreamFromResources(fileName);
            properties.load(inputStream);
        } catch (Exception e) {
            log.error("Could not read file '" + fileName + "'!");
        }

        return properties;
    }
}
