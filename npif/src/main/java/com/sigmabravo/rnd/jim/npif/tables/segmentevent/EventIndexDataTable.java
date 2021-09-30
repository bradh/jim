package com.sigmabravo.rnd.jim.npif.tables.userdefined;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.time.ZonedDateTime;

/*
	The Event Index data structure keeps a chronological record of each event. The Event Index data structure can be thought of as a table of contents for the entire
	record.
	File Addressing scheme is $0000 xxyy where xx represents the segment number, and yy the event number. xx and yy have the range $01 to $FF.
	A-8         User Defined Data Tables
	A section of the address space has been reserved for user defined tables. The format and contents of the tables are to be determined by the user. The User Defined
	Tables must not contain any information necessary for the interpretation or exploitation of the data.
	Non host exploitation systems should be aware that data in these tables will be irrelevant to their system and should not be acted upon.
	The use of these tables must follow all of the protocols of other STANAG 7023 tables, e.g. a STANAG 7023 Sync and Header must precede the table.
	File Addressing scheme is $0000 xxxx where xxxx is determined by the user.
	A-9          Sensor Parametric Data Tables
	Auxiliary parameters are used to describe the sensor data thereby allowing destination equipment to decipher the sensor data and to produce a literal image.
	Sensor Parametric data is divided into two general categories:
	1) General sensor description data used to describe any sensor system regardless of the type of sensor. General descriptive data such as sensor identification
	parameters and sensor data compression information is included in this category.
	2) Sensor specific description data.
*/
public class EventIndexDataTable extends DataTable {
    private int eventType;
    private int targetNumber;
    private int targetSubSection;
    private int timeTag;
    private ZonedDateTime eventTime;
    private Position aircraftGeoLocation;
    private int primarySensorNumber;
    private int secondarySensorNumber;
    private int thirdSensorNumber;
    private int eventPositionInTheRecord;
    private String eventName;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public int getTargetSubSection() {
        return targetSubSection;
    }

    public void setTargetSubSection(int targetSubSection) {
        this.targetSubSection = targetSubSection;
    }

    public int getTimeTag() {
        return timeTag;
    }

    public void setTimeTag(int timeTag) {
        this.timeTag = timeTag;
    }

    public ZonedDateTime getEventTime() {
        return eventTime.plusHours(0);
    }

    public void setEventTime(ZonedDateTime eventTime) {
        this.eventTime = eventTime.plusHours(0);
    }

    public Position getAircraftGeoLocation() {
        return new Position(aircraftGeoLocation);
    }

    public void setAircraftGeoLocation(Position aircraftGeoLocation) {
        this.aircraftGeoLocation = new Position(aircraftGeoLocation);
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

    public int getEventPositionInTheRecord() {
        return eventPositionInTheRecord;
    }

    public void setEventPositionInTheRecord(int eventPositionInTheRecord) {
        this.eventPositionInTheRecord = eventPositionInTheRecord;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getSegmentNumber() {
        return ((getHeader().getDataFileAddress() & 0x0000FF00) >> 8);
    }

    public int getEventNumber() {
        return (getHeader().getDataFileAddress() & 0x000000FF);
    }
}
