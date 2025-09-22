package com.heber.jsoncsv;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Transforms JSON data into a structure suitable for CSV writing.
 */
public class DataTransformer {

    /**
     * Transforms a list of JSON objects into a structure suitable for CSV writing.
     * @param jsonData List of maps representing JSON data.
     * @return A 2D list (rows and columns) ready for CSV export.
     */
    public List<List<String>> transform(List<Map<String, Object>> jsonData) {
        List<List<String>> csvData = new ArrayList<>();

        if (jsonData.isEmpty()) return csvData;

        // Headers (column names)
        List<String> headers = new ArrayList<>(jsonData.get(0).keySet());
        csvData.add(headers);

        // Rows (values)
        for (Map<String, Object> record : jsonData) {
            List<String> row = new ArrayList<>();
            for (String header : headers) {
                Object value = record.get(header);
                row.add(value != null ? value.toString() : "");
            }
            csvData.add(row);
        }

        return csvData;
    }
}

