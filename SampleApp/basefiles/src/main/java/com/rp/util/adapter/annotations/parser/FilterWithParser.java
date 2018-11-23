package com.rp.util.adapter.annotations.parser;

import android.text.TextUtils;

import com.rp.util.adapter.annotations.FilterWith;

import java.lang.reflect.Field;

public class FilterWithParser {

    public static <E> boolean isQueryAvailable(E model, String query) {

        Class<?> modelClass = model.getClass();
        if (modelClass.isAnnotationPresent(FilterWith.class)) {

            FilterWith annotation = modelClass.getAnnotation(FilterWith.class);
            String[] value = annotation.values();

            for (String s : value) {

                Field field = null;

                try {
                    field = modelClass.getDeclaredField(s);
                    field.setAccessible(true);
                    String fieldValue = field.get(model).toString();

                    if (fieldValue.contains(query)) {
                        return true;
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

        return false;
    }
}
