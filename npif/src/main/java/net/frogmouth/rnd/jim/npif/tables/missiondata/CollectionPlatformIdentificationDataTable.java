package net.frogmouth.rnd.jim.npif.tables.missiondata;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class CollectionPlatformIdentificationDataTable extends DataTable {
    private String squadron;
    private String wing;
    private String aircraftType;
    private String aircraftTailNumber;
    private int sortieNumber;
    private String pilotID;

    public String getSquadron() {
        return squadron;
    }

    public void setSquadron(String squadron) {
        this.squadron = squadron;
    }

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAircraftTailNumber() {
        return aircraftTailNumber;
    }

    public void setAircraftTailNumber(String aircraftTailNumber) {
        this.aircraftTailNumber = aircraftTailNumber;
    }

    public int getSortieNumber() {
        return sortieNumber;
    }

    public void setSortieNumber(int sortieNumber) {
        this.sortieNumber = sortieNumber;
    }

    public String getPilotID() {
        return pilotID;
    }

    public void setPilotID(String pilotID) {
        this.pilotID = pilotID;
    }
}
