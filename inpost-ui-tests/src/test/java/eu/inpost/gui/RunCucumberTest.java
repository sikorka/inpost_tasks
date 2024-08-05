package eu.inpost.gui;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("eu.inpost.gui")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,html:target/cucumber.html,json:target/cucumber.json")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "eu.inpost.gui")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/eu/inpost/gui/search.feature")
public class RunCucumberTest {

}