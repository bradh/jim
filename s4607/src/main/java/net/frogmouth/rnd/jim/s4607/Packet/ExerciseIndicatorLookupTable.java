package net.frogmouth.rnd.jim.s4607.Packet;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseIndicatorLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();
    private final Logger LOG = LoggerFactory.getLogger(ExerciseIndicatorLookupTable.class);

    private ExerciseIndicatorLookupTable() {
        Properties prop = new Properties();
        try (InputStream inputStream =
                ExerciseIndicatorLookupTable.class.getResourceAsStream(
                        "/ExerciseIndicator.properties")) {
            prop.load(inputStream);
            prop.entrySet()
                    .forEach(
                            entry -> {
                                int key = Integer.parseInt((String) entry.getKey());
                                enumerationLookup.put(key, (String) entry.getValue());
                            });
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    private String getKeyForValue(int key) {
        return getInstance().enumerationLookup.getOrDefault(key, "UNKNOWN");
    }

    public static String getValue(int key) {
        return getInstance().getKeyForValue(key);
    }

    public static ExerciseIndicatorLookupTable getInstance() {
        return ExerciseIndicatorLookupTableHolder.INSTANCE;
    }

    private static class ExerciseIndicatorLookupTableHolder {

        private static final ExerciseIndicatorLookupTable INSTANCE =
                new ExerciseIndicatorLookupTable();
    }
}
