package net.frogmouth.rnd.jim.s4607.jobdefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sensor Type lookup table.
 *
 * <p>This singleton class provides a mapping between the enumeration values (number) for Sensor
 * Type used within the Job Definition Segment, and text labels.
 */
public class SensorTypeLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(SensorTypeLookupTable.class);

    private SensorTypeLookupTable() {
        Properties prop = new Properties();
        try (InputStream inputStream =
                SensorTypeLookupTable.class.getResourceAsStream("/SensorType.properties")) {
            prop.load(inputStream);
            prop.entrySet()
                    .forEach(
                            entry -> {
                                int key = Integer.parseInt((String) entry.getKey());
                                enumerationLookup.put(key, (String) entry.getValue());
                            });
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private String getValueForKey(int key) {
        return getInstance().enumerationLookup.getOrDefault(key, "Available for Future Use");
    }

    /**
     * Get the value for a given enumeration value.
     *
     * <p>For example, passing {@code 22} would return "LSRS Sensor".
     *
     * @param key the enumeration value.
     * @return corresponding text label for the provided key, as a String.
     */
    public static String getValue(int key) {
        return getInstance().getValueForKey(key);
    }

    /**
     * Singleton instance lookup.
     *
     * @return the singleton instance.
     */
    public static SensorTypeLookupTable getInstance() {
        return SensorTypeLookupTableHolder.INSTANCE;
    }

    private static class SensorTypeLookupTableHolder {
        private static final SensorTypeLookupTable INSTANCE = new SensorTypeLookupTable();
    }
}
