package com.sigmabravo.rnd.jim.s4607;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ClassificationLookupTable {

    private final Map<Integer, String> enumerationLookup = new HashMap<>();

    private ClassificationLookupTable() {
        Properties prop = new Properties();
        try (InputStream inputStream =
                ClassificationLookupTable.class.getResourceAsStream(
                        "/PacketSecurityClassification.properties")) {
            prop.load(inputStream);
            prop.entrySet()
                    .forEach(
                            entry -> {
                                int key = Integer.parseInt((String) entry.getKey());
                                enumerationLookup.put(key, (String) entry.getValue());
                            });
        } catch (FileNotFoundException e) {
            // TODO: LOG
            e.printStackTrace(System.out);
        } catch (IOException e) {
            // TODO: LOG
            e.printStackTrace(System.out);
        }
    }

    private String getKeyForValue(int key) {
        return getInstance().enumerationLookup.getOrDefault(key, "UNKNOWN");
    }

    public static String getValue(int key) {
        return getInstance().getKeyForValue(key);
    }

    public static ClassificationLookupTable getInstance() {
        return ClassificationLookupTableHolder.INSTANCE;
    }

    private static class ClassificationLookupTableHolder {

        private static final ClassificationLookupTable INSTANCE = new ClassificationLookupTable();
    }
}
