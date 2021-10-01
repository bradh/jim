package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.util.ArrayList;
import java.util.List;

public class RadarElementDataTable extends DataTable {
    private final List<RadarElementDataTableEntry> entries = new ArrayList<>();

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public List<RadarElementDataTableEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    public void addEntry(RadarElementDataTableEntry entry) {
        entries.add(entry);
    }
}
