package com.sigmabravo.rnd.jim.npif.tables.segmentevent;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.time.ZonedDateTime;

/*
	Functions as a directory used to identify segments that occurred during a record on the transport media. The indexing scheme utilising this data is based on the fact
	that the structure consists of chronologically ordered data.
	File Addressing scheme is $0000 xx00 where xx represents the segment number.
*/
public class SegmentIndexDataTable extends DataTable {
    private int startOfDataSegment;
    private int endOfDataSegment;
    private ZonedDateTime startTimeOfRecording;
    private ZonedDateTime stopTimeOfRecording;
    private int startOfHeaderTimeTag;
    private int endOfHeaderTimeTag;
    private Position aircraftLocationAtTheStartOfRecordingOfTheSegment;
    private Position aircraftLocationAtTheEndOfRecordingOfTheSegment;

    public int getStartOfDataSegment() {
        return startOfDataSegment;
    }

    public void setStartOfDataSegment(int startOfDataSegment) {
        this.startOfDataSegment = startOfDataSegment;
    }

    public int getEndOfDataSegment() {
        return endOfDataSegment;
    }

    public void setEndOfDataSegment(int endOfDataSegment) {
        this.endOfDataSegment = endOfDataSegment;
    }

    public ZonedDateTime getStartTimeOfRecording() {
        return startTimeOfRecording.plusHours(0);
    }

    public void setStartTimeOfRecording(ZonedDateTime startTimeOfRecording) {
        this.startTimeOfRecording = startTimeOfRecording.plusHours(0);
    }

    public ZonedDateTime getStopTimeOfRecording() {
        return stopTimeOfRecording.plusHours(0);
    }

    public void setStopTimeOfRecording(ZonedDateTime stopTimeOfRecording) {
        this.stopTimeOfRecording = stopTimeOfRecording.plusHours(0);
    }

    public int getStartOfHeaderTimeTag() {
        return startOfHeaderTimeTag;
    }

    public void setStartOfHeaderTimeTag(int startOfHeaderTimeTag) {
        this.startOfHeaderTimeTag = startOfHeaderTimeTag;
    }

    public int getEndOfHeaderTimeTag() {
        return endOfHeaderTimeTag;
    }

    public void setEndOfHeaderTimeTag(int endOfHeaderTimeTag) {
        this.endOfHeaderTimeTag = endOfHeaderTimeTag;
    }

    public Position getAircraftLocationAtTheStartOfRecordingOfTheSegment() {
        return new Position(aircraftLocationAtTheStartOfRecordingOfTheSegment);
    }

    public void setAircraftLocationAtTheStartOfRecordingOfTheSegment(
            Position aircraftLocationAtTheStartOfRecordingOfTheSegment) {
        this.aircraftLocationAtTheStartOfRecordingOfTheSegment =
                new Position(aircraftLocationAtTheStartOfRecordingOfTheSegment);
    }

    public Position getAircraftLocationAtTheEndOfRecordingOfTheSegment() {
        return new Position(aircraftLocationAtTheEndOfRecordingOfTheSegment);
    }

    public void setAircraftLocationAtTheEndOfRecordingOfTheSegment(
            Position aircraftLocationAtTheEndOfRecordingOfTheSegment) {
        this.aircraftLocationAtTheEndOfRecordingOfTheSegment =
                new Position(aircraftLocationAtTheEndOfRecordingOfTheSegment);
    }

    public int getSegmentNumber() {
        return ((getHeader().getDataFileAddress() & 0x0000FF00) >> 8);
    }
}
