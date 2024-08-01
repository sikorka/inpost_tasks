package eu.inpost.util;

import eu.inpost.api.points.ParcelPointsData;
import eu.inpost.util.json.JsonReaderWriter;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@UtilityClass
@Log4j2
public class ParcelLockersFileWriter {

    public static void writeToFile(String cityName, ParcelPointsData data) {
        String fileName = getCityFileName(cityName);

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            List listOfPointsInCity = data.forCity(cityName);
            log.info("There were " + listOfPointsInCity.size() + "points in city found. ");

            log.info("Saving city data to file: " + fileName);
            fileWriter.write(JsonReaderWriter.toJson(listOfPointsInCity));
            log.info("Saving city data done. ");
        } catch (IOException e) {
            log.error("Could not write to file: " + fileName);

            throw new RuntimeException(e);
        }
    }

    private static String getCityFileName(String cityName) {
        return "parcellockers." + cityName + ".json";
    }
}
