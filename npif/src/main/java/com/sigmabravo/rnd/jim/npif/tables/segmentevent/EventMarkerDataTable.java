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
