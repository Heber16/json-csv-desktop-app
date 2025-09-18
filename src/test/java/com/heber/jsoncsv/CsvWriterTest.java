package com.heber.jsoncsv;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CsvWriterTest {
    @Test
    void testWriteCsv() {
        CsvWriter writer = new CsvWriter();

        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> row = new HashMap<>();
        row.put("Name", "Phil");
        row.put("Age", 25);
        data.add(row);

        String filePath = "src/main/resources/test_output.csv";
        writer.writeCsv(filePath, data);

        File file = new File(filePath);
        assertTrue(file.exists());

        // Delete file after the test
        file.delete();
    }
}
