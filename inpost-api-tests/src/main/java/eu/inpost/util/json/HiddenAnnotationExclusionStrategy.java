package eu.inpost.util.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public final class HiddenAnnotationExclusionStrategy implements ExclusionStrategy {
    public boolean shouldSkipClass(Class<?> clazz) {
        return clazz.getAnnotation(Hidden.class) != null;
    }

    public boolean shouldSkipField(FieldAttributes field) {
        return field.getAnnotation(Hidden.class) != null;
    }
}
