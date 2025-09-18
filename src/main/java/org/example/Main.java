package org.example;

import com.heber.jsoncsv.JsonReader;
import com.heber.jsoncsv.CsvWriter;

import java.util.List;
import java.util.Map;

/**
 * Main class to demonstrate reading a JSON file and writing it to a CSV file.
 */
public class Main {
    public static void main(String[] args) {
        JsonReader reader = new JsonReader();
        CsvWriter writer = new CsvWriter();

        // Read JSON
        List<Map<String, Object>> data = reader.readJson("src/main/resources/datos.json");

        // Write CSV
        writer.writeCsv("src/main/resources/data.csv", data);

        System.out.println("Process completed.");
    }
}
