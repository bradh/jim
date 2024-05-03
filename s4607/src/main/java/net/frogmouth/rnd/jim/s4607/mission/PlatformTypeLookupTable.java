package net.frogmouth.rnd.jim.s4607.mission;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Platform Type lookup table.
 *
 * <p>This singleton class provides a mapping between the enumeration values (number) for Platform
 * Type used within the Mission Segment, and text labels.
 */
public class PlatformTypeLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(PlatformTypeLookupTable.class);

    private PlatformTypeLookupTable() {
        Properties prop = new Properties();
        try (InputStream inputStream =
                PlatformTypeLookupTable.class.getResourceAsStream("/PlatformType.properties")) {
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
     * <p>For example, passing {@code 23} would return "Paul Revere".
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
    public static synchronized PlatformTypeLookupTable getInstance() {
        return PlatformTypeLookupTableHolder.INSTANCE;
    }

    private static class PlatformTypeLookupTableHolder {
        private static final PlatformTypeLookupTable INSTANCE = new PlatformTypeLookupTable();
    }
}
