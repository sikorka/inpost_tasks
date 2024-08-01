package eu.inpost.util;

import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class PropertiesReaderTest {
    @Test
    public void whenTestPropertiesReadThenKeyValueCorrect() {
        Properties properties = PropertiesReader.readResourcesPropertiesFrom("test.properties");

        assertThat(properties.getProperty("key"), equalTo("value"));
    }
}