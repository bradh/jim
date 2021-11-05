package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class SensorIndexDataTable extends DataTable {
    private List<SensorIndexDataTableEntry> entries = new ArrayList<>();

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getSegmentNumber() {
        return (getHeader().getDataFileAddress() & 0x00FF);
    }

    public List<SensorIndexDataTableEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    public void addEntry(SensorIndexDataTableEntry entry) {
        entries.add(entry);
    }
}
