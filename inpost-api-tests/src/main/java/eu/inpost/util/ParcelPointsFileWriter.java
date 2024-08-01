package eu.inpost.util;

import eu.inpost.api.points.ParcelPointsData;
import eu.inpost.api.points.ParcelPointsData.Point;
import eu.inpost.util.json.JsonReaderWriter;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@UtilityClass
@Log4j2
public class ParcelPointsFileWriter {

    public static void writeToFilesCityRelatedData(String cityName, ParcelPointsData data) {
        writeToFileCityRelatedData(cityName, data.inCity(cityName));
    }

    public static void writeToFileCityRelatedData(String cityName, List<Point> listOfPointsInCity) {
        String fileName = getCityFileName(cityName);

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            log.info("There are " + listOfPointsInCity.size() + " points in city '" + cityName + "' found. ");

            log.info("Saving city data to file: '" + fileName + "'...");
            fileWriter.write(JsonReaderWriter.toJson(listOfPointsInCity));
            log.info("Saving city data done. ");
        } catch (IOException e) {
            log.error("Could not write to file: " + fileName);
        }
    }

    private static String getCityFileName(String cityName) {
        return "parcellockers." + cityName + ".json";
    }
}
