package eu.inpost.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Type;

/** This util reads JSON into objects and serializes objects to JSON. */
@UtilityClass
public final class JsonReaderWriter {

    public static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
//            .serializeNulls()
            .disableHtmlEscaping()
            .setExclusionStrategies(new HiddenAnnotationExclusionStrategy())
            .create();

    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, (Type) clazz);
    }

    public static Object fromJson(String json, Type type) {
        return GSON.fromJson(json, type);
    }
}
