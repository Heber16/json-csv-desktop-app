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
     * Writes data to a CSV file (Sprint 2 version).
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

    /**
     * Writes transformed CSV data to a file (Sprint 3 version).
     * @param filePath path of the CSV to create
     * @param data 2D list representing CSV rows and columns
     * @param delimiter the delimiter to separate values (e.g., "," or ";")
     */
    public void writeCsv(String filePath, List<List<String>> data, String delimiter) {
        if (data == null || data.isEmpty()) return;

        try (CSVWriter writer = new CSVWriter(
                new FileWriter(filePath),
                delimiter.charAt(0),
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {

            for (List<String> row : data) {
                writer.writeNext(row.toArray(new String[0]));
            }

        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}


