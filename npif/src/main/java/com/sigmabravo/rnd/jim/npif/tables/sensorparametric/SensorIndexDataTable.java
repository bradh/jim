package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.util.ArrayList;
import java.util.List;

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
