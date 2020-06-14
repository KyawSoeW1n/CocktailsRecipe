package com.kyawsoewin.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class MapperUtils {
    private static Gson gson;

    public static <T> T transform(Object o, Class<T> clazz) throws JsonSyntaxException {
        if (gson == null) {
            gson = createGson();
        }
        return gson.fromJson(gson.toJson(o), clazz);
    }

    private static Gson createGson() {
        return new GsonBuilder()
                .create();
    }
}
