package eu.inpost.api.points;

import eu.inpost.util.Environment;
import eu.inpost.util.ParcelPointsFileWriter;
import eu.inpost.util.json.JsonReaderWriter;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static eu.inpost.util.PrettyLogs.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.assertj.core.api.SoftAssertions;

@Log4j2
public class PointsSteps {

    private static final String PER_PAGE = "10000";
    private static final String TYPE_PARCEL_LOCKER = "parcel_locker";

    List<String> citiesList = new ArrayList<>();

    Response response;
    ParcelPointsData parcelLockersData;

    @When("executing Parcel Lockers search by city {string}")
    public void searchingForParcelLockersByCity(String cities) {
        this.citiesList = Arrays.asList(cities.split(","));

        String url = "https://" + Environment.getHost() + "/v1/points/?" +
                "per_page=" + PER_PAGE +
                "&type=" + TYPE_PARCEL_LOCKER +
                "&city=" + cities;
        log.info("URL to call: " + url);

        response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .get(url);
    }

    @When("executing Parcel Lockers search by cities {string}")
    public void searchingForParcelLockersByCities(String cities) {
        searchingForParcelLockersByCity(cities);
    }

    @Then("^Parcel Lockers found for city$")
    public void parcelLockersFoundForCity() {
        print(response);
        assertThat("The call should have gone well (status=200)", response.statusCode(), is(equalTo(200)));

        String responseBody = response.getBody().asString();
        parcelLockersData = JsonReaderWriter.fromJson(responseBody, ParcelPointsData.class);
        print(parcelLockersData);
        log.info("Total parcel lockers found: " + parcelLockersData.count);

        SoftAssertions softly = new SoftAssertions();
        citiesList.forEach(city -> {
            List<ParcelPointsData.Point> pointsInCity = parcelLockersData.inCity(city);
            softly.assertThat(pointsInCity.size())
                    .as("At least one parcel locker should be found in `" + city + "'")
                    .isGreaterThanOrEqualTo(1);
            ParcelPointsFileWriter.writeToFileCityRelatedData(city, pointsInCity);
        });
        softly.assertAll();
    }

    @Then("^Parcel Lockers NOT found for city$")
    public void parcelLockersNotFoundForCity() {
        print(response);
        assertThat("The call should have gone well (status=200)", response.statusCode(), is(equalTo(200)));

        String responseBody = response.getBody().asString();
        parcelLockersData = JsonReaderWriter.fromJson(responseBody, ParcelPointsData.class);
        print(parcelLockersData);
        log.info("Total parcel lockers found: " + parcelLockersData.count);

        SoftAssertions softly = new SoftAssertions();
        citiesList.forEach(city -> {
            List<ParcelPointsData.Point> pointsInCity = parcelLockersData.inCity(city);
            softly.assertThat(pointsInCity.size())
                    .as("No parcel locker should be found in `" + city + "'")
                    .isEqualTo(0);
            ParcelPointsFileWriter.writeToFileCityRelatedData(city, pointsInCity);
        });
        softly.assertAll();
    }

    @Then("^Parcel Lockers found for each city$")
    public void parcelLockersFoundForEachCity() {
        parcelLockersFoundForCity();
    }

    @Then("^Parcel Lockers NOT found for each city$")
    public void parcelLockersNotFoundForEachCity() {
        parcelLockersNotFoundForCity();
    }
}
