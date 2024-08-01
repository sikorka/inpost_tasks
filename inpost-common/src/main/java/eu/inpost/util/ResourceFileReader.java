package eu.inpost.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;

@Log4j2
@UtilityClass
public final class ResourceFileReader {

    public static InputStream getInputStreamFromResources(String fileName) {
        log.debug("Reading '" + fileName + "'...");

        if (StringUtils.isBlank(fileName)) {
            log.info("File name is null.");
            return null;
        }

        InputStream inputStream = ResourceFileReader.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            log.error("Could not read '" + fileName + "'!");
        } else {
            log.debug("Reading '" + fileName + "' done.");
        }

        return inputStream;
    }

}
