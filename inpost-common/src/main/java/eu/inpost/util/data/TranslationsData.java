package eu.inpost.util.data;

import eu.inpost.util.json.JsonReaderWriter;
import lombok.Getter;

@Getter
public class TranslationsData {
    Language PL;
    Language EN;

    @Getter
    public class Language {
        String language;
        String lang_code;
        Status statuses;
        UrlPath url_paths;

        @Getter
        public class Status {
          String collected;
          String label_nullified;
        }

        @Getter
        public class UrlPath {
            String find_parcel;
        }
    }

    @Override
    public String toString() {
        return JsonReaderWriter.toJson(this);
    }
}
