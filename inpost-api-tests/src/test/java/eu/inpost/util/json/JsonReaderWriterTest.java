package eu.inpost.util.json;

import eu.inpost.api.points.ParcelPointsData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderWriterTest {

    private static final String JSON = "{\n  \"name\": \"some name\"\n}";

    @Test
    void toJson() {
        ParcelPointsData.Point point;
        String json;

        given:
        point = ParcelPointsData.Point.builder()
                .name("some name")
                .build();

        when:
        json = JsonReaderWriter.toJson(point);

        then:
        assertEquals(json, JSON);
    }

    @Test
    void fromJson() {
        ParcelPointsData.Point point;
        ParcelPointsData.Point point2;

        given:
        point = ParcelPointsData.Point.builder()
                .name("some name")
                .build();

        when:
        point2 = JsonReaderWriter.fromJson(JSON, ParcelPointsData.Point.class);

        then:
        assertEquals(point, point2);
    }
}