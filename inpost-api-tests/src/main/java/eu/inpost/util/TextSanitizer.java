package eu.inpost.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TextSanitizer {
    public String sanitizeCity(String text) {
        return text.trim();
    }
}
