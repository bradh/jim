package net.frogmouth.rnd.jim.s4607;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlatformTypeLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();
    private final Logger LOG = LoggerFactory.getLogger(PlatformTypeLookupTable.class);

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
            LOG.error(e.getMessage());
        }
    }

    private String getKeyForValue(int key) {
        return getInstance().enumerationLookup.getOrDefault(key, "Available for Future Use");
    }

    public static String getValue(int key) {
        return getInstance().getKeyForValue(key);
    }

    public static PlatformTypeLookupTable getInstance() {
        return PlatformTypeLookupTableHolder.INSTANCE;
    }

    private static class PlatformTypeLookupTableHolder {

        private static final PlatformTypeLookupTable INSTANCE = new PlatformTypeLookupTable();
    }
}
