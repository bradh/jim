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
    private long startOfDataSegment;
    private long endOfDataSegment;
    private ZonedDateTime startTimeOfRecording;
    private ZonedDateTime stopTimeOfRecording;
    private long startOfHeaderTimeTag;
    private long endOfHeaderTimeTag;
    private Position aircraftLocationAtTheStartOfRecordingOfTheSegment;
    private Position aircraftLocationAtTheEndOfRecordingOfTheSegment;

    public long getStartOfDataSegment() {
        return startOfDataSegment;
    }

    public void setStartOfDataSegment(long startOfDataSegment) {
        this.startOfDataSegment = startOfDataSegment;
    }

    public long getEndOfDataSegment() {
        return endOfDataSegment;
    }

    public void setEndOfDataSegment(long endOfDataSegment) {
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

    public long getStartOfHeaderTimeTag() {
        return startOfHeaderTimeTag;
    }

    public void setStartOfHeaderTimeTag(long startOfHeaderTimeTag) {
        this.startOfHeaderTimeTag = startOfHeaderTimeTag;
    }

    public long getEndOfHeaderTimeTag() {
        return endOfHeaderTimeTag;
    }

    public void setEndOfHeaderTimeTag(long endOfHeaderTimeTag) {
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
