package net.frogmouth.rnd.jim.s4607.JobDefinitionSegment;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Radar Mode lookup table.
 *
 * <p>This singleton class provides a mapping between the enumeration values (number) for Radar Mode
 * used within the Job Definition Segment, and text labels.
 */
public class RadarModeLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(RadarModeLookupTable.class);

    private RadarModeLookupTable() {
        Properties prop = new Properties();
        try (InputStream inputStream =
                RadarModeLookupTable.class.getResourceAsStream("/RadarMode.properties")) {
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
        return getInstance()
                .enumerationLookup
                .getOrDefault(key, "Available for Future Use [Reserved]");
    }

    /**
     * Get the value for a given enumeration value.
     *
     * <p>This includes the mode and the system.
     *
     * <p>For example, passing {@code 102} would return "MTI Arc Scan [Lynx I/II]".
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
    public static RadarModeLookupTable getInstance() {
        return SensorTypeLookupTableHolder.INSTANCE;
    }

    private static class SensorTypeLookupTableHolder {
        private static final RadarModeLookupTable INSTANCE = new RadarModeLookupTable();
    }
}
