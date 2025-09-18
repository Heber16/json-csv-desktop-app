package com.heber.jsoncsv;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    @Test
    void testReadJson() {
        JsonReader reader = new JsonReader();
        List<Map<String, Object>> data = reader.readJson("src/main/resources/datos.json");
        assertNotNull(data);
        assertFalse(data.isEmpty());
    }
}
