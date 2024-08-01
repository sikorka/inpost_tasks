package eu.inpost.api.points;

import com.google.gson.annotations.SerializedName;
import eu.inpost.util.Hidden;
import eu.inpost.util.JsonReaderWriter;

import java.util.List;

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

    class Point {
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

        //    "address_details": {
    //        "city": "Wrocław",
    //        "province": "dolnośląskie",
    //        "post_code": "50-011",
    //        "street": "Kościuszki",
    //        "building_number": "49",
    //        "flat_number": null
    //    },
        class AddressDetails {
            @Hidden
            String city;
            @SerializedName("post_code")
            String postCode;
        }

        @Override
        public String toString() {
            return JsonReaderWriter.toJson(this);
        }
    }

    @Override
    public String toString() {
        return JsonReaderWriter.toJson(this);
    }
}
