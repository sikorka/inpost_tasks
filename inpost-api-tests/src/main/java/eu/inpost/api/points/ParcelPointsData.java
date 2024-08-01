package eu.inpost.api.points;

import com.google.gson.annotations.SerializedName;
import eu.inpost.util.json.Hidden;
import eu.inpost.util.json.JsonReaderWriter;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ParcelPointsData {
    @Hidden
    String href; //    "href": "https://api-pl-points.easypack24.net/v1/points",
    @Hidden
    Integer count; //    "count": 569,
    @Hidden
    Integer page; //    "page": 1,
    @Hidden
    @SerializedName("per_page")
    Integer perPage; //    "per_page": 1000,
    @Hidden
    @SerializedName("total_pages")
    Integer totalPages; //    "total_pages": 1,

    List<Point> items;

    public List<Point> inCity(String cityName) {
        return items.stream()
                .filter(p -> p.getAddressDetails().getCity().equals(cityName))
                .collect(Collectors.toList());
    }

    @Data
    @Builder
    public static class Point {
        @Hidden
        String href; //    "href": "https://api-pl-points.easypack24.net/v1/points/POP-WRO103",
        String name; //    "name": "POP-WRO103",
        @Hidden
        List<String> type; //    "type": ["parcel_locker", "parcel_locker_superpop", "pok", "pop"],
        Location location;
        @SerializedName("address_details")
        AddressDetails addressDetails;

        class Location {
            Float longitude; //"longitude": 17.03539,
            Float latitude; //"latitude": 51.10205
        }

        @Data
        class AddressDetails {
            String city; //        "city": "Wrocław",
            @SerializedName("post_code")
            String postCode; //        "post_code": "50-011",
        }

    }

    @Override
    public String toString() {
        return toJson();
    }

    public String toJson() {
        return JsonReaderWriter.toJson(this);
    }
}
