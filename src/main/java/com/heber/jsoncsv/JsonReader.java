package com.heber.jsoncsv;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Utility class for reading JSON files and parsing them into Java objects.
 */
public class JsonReader {

    /**
     * Reads a JSON file and converts it into a list of maps.
     * @param filePath path of the JSON file
     * @return list of maps containing the data
     */
    public List<Map<String, Object>> readJson(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), new TypeReference<List<Map<String, Object>>>(){});
        } catch (IOException e) {
            System.err.println("Error reading JSON: " + e.getMessage());
            return null;
        }
    }
}
