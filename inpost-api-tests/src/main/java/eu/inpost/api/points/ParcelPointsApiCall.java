package eu.inpost.api.points;

import eu.inpost.util.Environment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;

@Builder
@Log4j2
public class ParcelPointsApiCall {
    String perPage;
    String parcelLockerType;
    String city;

    public Response get() {
        String url = "https://" + Environment.getHost() + "/v1/points/?" +
                "per_page=" + perPage +
                "&type=" + parcelLockerType +
                "&city=" + city;
        log.info("URL to call: " + url);

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .get(url);
    }
}
