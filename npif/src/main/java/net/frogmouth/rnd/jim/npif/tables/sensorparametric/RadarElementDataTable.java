package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

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
