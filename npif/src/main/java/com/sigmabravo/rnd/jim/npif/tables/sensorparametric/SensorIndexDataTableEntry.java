package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.time.ZonedDateTime;

public class SensorIndexDataTableEntry {
    private ZonedDateTime collectionStartTime;
    private ZonedDateTime collectionStopTime;
    private long startHeaderTimeTag;
    private long endHeaderTimeTag;
    private Position aircraftLocationAtCollectionStartTime;
    private Position aircraftLocationAtCollectionEndTime;
    private long sensorStartPosition;
    private long sensorEndPosition;

    public ZonedDateTime getCollectionStartTime() {
        return collectionStartTime;
    }

    public void setCollectionStartTime(ZonedDateTime collectionStartTime) {
        this.collectionStartTime = collectionStartTime;
    }

    public ZonedDateTime getCollectionStopTime() {
        return collectionStopTime;
    }

    public void setCollectionStopTime(ZonedDateTime collectionStopTime) {
        this.collectionStopTime = collectionStopTime;
    }

    public long getStartHeaderTimeTag() {
        return startHeaderTimeTag;
    }

    public void setStartHeaderTimeTag(long startHeaderTimeTag) {
        this.startHeaderTimeTag = startHeaderTimeTag;
    }

    public long getEndHeaderTimeTag() {
        return endHeaderTimeTag;
    }

    public void setEndHeaderTimeTag(long endHeaderTimeTag) {
        this.endHeaderTimeTag = endHeaderTimeTag;
    }

    public Position getAircraftLocationAtCollectionStartTime() {
        return aircraftLocationAtCollectionStartTime;
    }

    public void setAircraftLocationAtCollectionStartTime(
            Position aircraftLocationAtCollectionStartTime) {
        this.aircraftLocationAtCollectionStartTime = aircraftLocationAtCollectionStartTime;
    }

    public Position getAircraftLocationAtCollectionEndTime() {
        return aircraftLocationAtCollectionEndTime;
    }

    public void setAircraftLocationAtCollectionEndTime(
            Position aircraftLocationAtCollectionEndTime) {
        this.aircraftLocationAtCollectionEndTime = aircraftLocationAtCollectionEndTime;
    }

    public long getSensorStartPosition() {
        return sensorStartPosition;
    }

    public void setSensorStartPosition(long sensorStartPosition) {
        this.sensorStartPosition = sensorStartPosition;
    }

    public long getSensorEndPosition() {
        return sensorEndPosition;
    }

    public void setSensorEndPosition(long sensorEndPosition) {
        this.sensorEndPosition = sensorEndPosition;
    }
}
