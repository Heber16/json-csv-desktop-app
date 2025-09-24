package org.example;

import com.heber.jsoncsv.JsonReader;
import com.heber.jsoncsv.CsvWriter;
import com.heber.jsoncsv.DataTransformer;

import java.util.List;
import java.util.Map;

/**
 * Main class for converting a JSON file into a CSV file.
 * <p>
 * Usage:
 * java -jar proyecto.jar <input.json> <output.csv> <delimiter>
 * Example:
 * java -jar proyecto.jar src/main/resources/datos.json src/main/resources/data.csv ";"
 * </p>
 *
 * This program reads a JSON file, transforms it into a CSV-compatible format,
 * and writes the result to a CSV file. The user can specify the delimiter for the CSV.
 */
public class Main {
    public static void main(String[] args) {
        // Validate command-line arguments
        if (args.length < 3) {
            System.out.println("Usage: java -jar proyecto.jar <input.json> <output.csv> <delimiter>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
//        String delimiter = args[2];
        String configFile = "src/main/resources/config.json";

        try {
            System.out.println("Reading config file from: " + configFile);
            JsonReader reader = new JsonReader();
            List<Map<String, Object>> config = reader.readJson(configFile);
            Object filePath = config.get(0).get("filePath");
            Object destinationPath = config.get(0).get("destinationPath");
            Object delimiter = config.get(0).get("delimiter");

            // Step 1: Read JSON
            System.out.println("Reading JSON from: " + inputFile);
            List<Map<String, Object>> jsonData = reader.readJson(filePath.toString());


            // Step 2: Transform data
            System.out.println("Transforming data...");
            DataTransformer transformer = new DataTransformer();
            List<List<String>> csvData = transformer.transform(jsonData);


            // Step 3: Write CSV
            System.out.println("Writing CSV to: " + outputFile + " with delimiter '" + delimiter + "'");
            CsvWriter writer = new CsvWriter();
            writer.writeCsv(destinationPath.toString(), csvData, delimiter.toString());

            System.out.println("Process completed successfully!");
        } catch (Exception e) {
            System.err.println("Error during process: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

