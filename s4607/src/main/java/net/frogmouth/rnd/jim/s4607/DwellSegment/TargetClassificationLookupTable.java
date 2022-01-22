package net.frogmouth.rnd.jim.s4607.DwellSegment;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Target Classification lookup table.
 *
 * <p>This singleton class provides a mapping between the enumeration values (number) for Target
 * Classification used within the Target part of the Dwell Segment, and text labels.
 *
 * <p>Classification in this context is the kind of target, and is unrelated to security
 * classification.
 */
public class TargetClassificationLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();
    private final Logger LOG = LoggerFactory.getLogger(TargetClassificationLookupTable.class);

    private TargetClassificationLookupTable() {
        Properties prop = new Properties();
        try (InputStream inputStream =
                TargetClassificationLookupTable.class.getResourceAsStream(
                        "/TargetClassification.properties")) {
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
        return getInstance().enumerationLookup.getOrDefault(key, "Available for Future Use");
    }

    /**
     * Get the text description of a given enumeration value.
     *
     * @param key the enumeration value as an integer.
     * @return the corresponding text description.
     */
    public static String getValue(Integer key) {
        if (key == null) {
            return "[Not Provided]";
        }
        return getInstance().getKeyForValue(key);
    }

    /**
     * Get an instance of the singleton.
     *
     * @return the lookup table instance.
     */
    public static TargetClassificationLookupTable getInstance() {
        return TargetClassificationLookupTableHolder.INSTANCE;
    }

    private static class TargetClassificationLookupTableHolder {

        private static final TargetClassificationLookupTable INSTANCE =
                new TargetClassificationLookupTable();
    }
}
