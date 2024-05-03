package net.frogmouth.rnd.jim.s4607.packet;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Security Classification lookup table.
 *
 * <p>This singleton class provides a mapping between the enumeration values (number) for Security
 * Classification used within the Packet Header, and text labels.
 */
public class SecurityClassificationLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(SecurityClassificationLookupTable.class);

    private SecurityClassificationLookupTable() {
        Properties prop = new Properties();
        try (InputStream inputStream =
                SecurityClassificationLookupTable.class.getResourceAsStream(
                        "/PacketSecurityClassification.properties")) {
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

    private String getKeyForValue(int key) {
        return getInstance().enumerationLookup.getOrDefault(key, "UNKNOWN");
    }

    /**
     * Look up a Security Classification value by key.
     *
     * <p>For example, looking up 5 will return "Unclassified".
     *
     * @param key the integer key
     * @return the corresponding String description.
     */
    public static String getValue(int key) {
        return getInstance().getKeyForValue(key);
    }

    /**
     * Get the singleton instance of this lookup table.
     *
     * @return instance value
     */
    public static synchronized SecurityClassificationLookupTable getInstance() {
        return SecurityClassificationLookupTableHolder.INSTANCE;
    }

    private static class SecurityClassificationLookupTableHolder {

        private static final SecurityClassificationLookupTable INSTANCE =
                new SecurityClassificationLookupTable();
    }
}
