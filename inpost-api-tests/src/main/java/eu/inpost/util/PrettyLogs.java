package eu.inpost.util;

import eu.inpost.api.points.ParcelPointsData;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

@Log4j2
@UtilityClass
public final class PrettyLogs {

    public static final int MAX_LENGTH_TO_LOG_DEFAULT = 1000;
    public static int maxLengthToLog = MAX_LENGTH_TO_LOG_DEFAULT;

    public static void print(Response response, int maxBodyLength) {
        log.info("Printing response...");
        if (response == null) {
            log.info("Response was null!");
        } else {
            log.info("status: " + response.statusLine());
            log.info("body: \n" + StringUtils.abbreviate(response.getBody().asString(), maxBodyLength));
        }
        log.info("Printing response done.");
    }

    public static void print(Response response) {
        print(response, maxLengthToLog);
    }

    public static void print(ParcelPointsData parcelPointsData) {
        log.info("Parcel Points JSON object: \n" +
                StringUtils.abbreviate(parcelPointsData.toJson(), maxLengthToLog));
    }

    public static void print(Properties props) {
        if (props == null || props.isEmpty()) {
            log.info("Properties are empty.");
            return;
        }

        props.stringPropertyNames().forEach(key ->
                log.info(key + "=" + props.get(key)));
    }
}
