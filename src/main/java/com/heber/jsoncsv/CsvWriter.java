package com.heber.jsoncsv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Utility class for writing data to CSV files.
 */
public class CsvWriter {
    /**
     * Writes data to a CSV file.
     * @param filePath path of the CSV to create
     * @param data list of maps (each map = row)
     */
    public void writeCsv(String filePath, List<Map<String, Object>> data) {
        if (data == null || data.isEmpty()) return;

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Headers
            String[] headers = data.get(0).keySet().toArray(new String[0]);
            writer.writeNext(headers);

            // Rows
            for (Map<String, Object> row : data) {
                String[] values = row.values().stream()
                        .map(Object::toString)
                        .toArray(String[]::new);
                writer.writeNext(values);
            }
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}

