package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
This table is used to mark the position of an event in the data segment.
Table Requirement       :        CONDITIONAL on an event occurring.
*/
public class EventMarkerDataTable extends DataTable {

    private int eventNumber;
    private int eventType;
    private int primarySensorNumber;
    private int secondarySensorNumber;
    private int thirdSensorNumber;
    private int targetNumber;

    public int getEventNumber() {
        return eventNumber;
    }

    public String getEventTypeAsText() {
        switch (getEventType()) {
            case 0x00:
                return "Pre-programmed Point Event/Target";
            case 0x01:
                return "Pre-programmed Duration START";
            case 0x02:
                return "Pre-programmed Duration END";
            case 0x03:
                return "Manual Point Event/Target";
            case 0x04:
                return "Manual Duration START";
            case 0x05:
                return "Manual Duration END";
            case 0x06:
                return "Recce Waypoint";
            case 0x07:
                return "Automatically Generated Event";
            default:
                return "Unknown event type (" + getEventType() + ")";
        }
    }

    public void setEventNumber(int eventNumber) {
        this.eventNumber = eventNumber;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getPrimarySensorNumber() {
        return primarySensorNumber;
    }

    public void setPrimarySensorNumber(int primarySensorNumber) {
        this.primarySensorNumber = primarySensorNumber;
    }

    public int getSecondarySensorNumber() {
        return secondarySensorNumber;
    }

    public void setSecondarySensorNumber(int secondarySensorNumber) {
        this.secondarySensorNumber = secondarySensorNumber;
    }

    public int getThirdSensorNumber() {
        return thirdSensorNumber;
    }

    public void setThirdSensorNumber(int thirdSensorNumber) {
        this.thirdSensorNumber = thirdSensorNumber;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }
}
