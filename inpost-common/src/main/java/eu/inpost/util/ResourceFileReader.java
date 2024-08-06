package eu.inpost.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@Log4j2
@UtilityClass
public final class ResourceFileReader {

    public static InputStream getInputStreamFromResources(String fileName) {
        log.debug("Reading '" + fileName + "'...");

        if (StringUtils.isBlank(fileName)) {
            log.info("File name is blank.");
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

    public static String getSmallFileContentFromResources(String jsonFileName) {
        log.info("Reading file '" + jsonFileName + "'...");

        if (StringUtils.isBlank(jsonFileName)) {
            log.info("File name is blank.");
            return null;
        }

        InputStream inputStream = ResourceFileReader.getInputStreamFromResources(jsonFileName);

        if (inputStream == null) {
            return null;
        }

        StringWriter writer = new StringWriter();
        String encoding = StandardCharsets.UTF_8.name();
        try {
            IOUtils.copy(inputStream, writer, encoding);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("There was a problem with reading the file ", e);
        }
        String string = writer.toString();
        log.debug(string);
        log.info("Reading file done.");

        return string;
    }
}
