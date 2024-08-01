package eu.inpost.api.points;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("io.cucumber.skeleton")
//moved to pom.xml:
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.cucumber.skeleton")
//@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
public class RunCucumberTest {
}