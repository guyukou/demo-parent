package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.util.Map;

/**
 * @author guyu
 * created at 2019-09-29 09:55
 */
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectReader MAP_READER = MAPPER.readerFor(Map.class);
    private static final ObjectWriter OBJECT_WRITER = MAPPER.writerFor(Object.class);

    public static Map<String, Object> toMap(String str) {
        try {
            return MAP_READER.readValue(str);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toString(Object obj) {
        try {
            return OBJECT_WRITER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
