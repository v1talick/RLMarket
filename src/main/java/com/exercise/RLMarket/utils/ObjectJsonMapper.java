package com.exercise.RLMarket.utils;

import com.exercise.RLMarket.enteties.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class ObjectJsonMapper {
    private static String jsonToString(String fileName) {
        StringBuilder result = new StringBuilder();
        ClassLoader classLoader = ObjectJsonMapper.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static List<Item> stringToItemsList() throws IOException{
        String json = jsonToString("ProductDump.json");

        List<Item> jsonItems = new ObjectMapper().
//                readerFor(Item.class).
                readValue(json, new TypeReference<List<Item>>(){});

        return jsonItems;
    }
}
