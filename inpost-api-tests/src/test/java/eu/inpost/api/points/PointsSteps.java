package eu.inpost.api.points;

import eu.inpost.util.JsonReaderWriter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PointsSteps {

    @Then("^Parcel Lockers found$")
    public void parcelLockersFound() {
        log.info(getCurrentMethodName());
    }

    @And("^Parcel Lockers name, postal code, coordinates are saved to file$")
    public void parcelLockersNamePostalCodeCoordinatesAreSavedToFile() {
        log.info(getCurrentMethodName());
    }

    @When("searching for Parcel Lockers by city {string}")
    public void searchingForParcelLockersByCity(String city) {
        log.info(getCurrentMethodName());

        //RestAssured.urlEncodingEnabled = true;

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when()
                .get("https://api-pl-points.easypack24.net/v1/points/?per_page=2&city=" + city);

        String responseBody = response.getBody().asString();

        log.info("Response: \n" +
                responseBody);

        ParcelPointsData parcelPointsData = JsonReaderWriter.fromJson(
                responseBody, ParcelPointsData.class);

        log.info("JSON object: \n" +
                parcelPointsData);
    }

    @When("searching for Parcel Lockers by several cities {string}")
    public void searchingForParcelLockersBySeveralCities(String cities) {
        log.info(getCurrentMethodName());
    }

    private String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
