package net.frogmouth.rnd.jim.s4607.DwellSegment;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static String getValue(Integer key) {
        if (key == null) {
            return "[Not Provided]";
        }
        return getInstance().getKeyForValue(key);
    }

    public static TargetClassificationLookupTable getInstance() {
        return TargetClassificationLookupTableHolder.INSTANCE;
    }

    private static class TargetClassificationLookupTableHolder {

        private static final TargetClassificationLookupTable INSTANCE =
                new TargetClassificationLookupTable();
    }
}
