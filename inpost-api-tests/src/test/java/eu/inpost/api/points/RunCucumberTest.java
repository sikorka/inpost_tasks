package eu.inpost.api.points;

import eu.inpost.util.PrettyLogs;
import io.restassured.RestAssured;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.SNIPPET_TYPE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("eu.inpost.api.points")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber.html,json:target/cucumber.json")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "eu.inpost.api.points")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/eu/inpost/api/points/search.feature")
public class RunCucumberTest {

    static {
        PrettyLogs.maxLengthToLog = 500;
        RestAssured.urlEncodingEnabled = false;
    }

}