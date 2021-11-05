package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.npif.tables.Position;

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
        return collectionStartTime.plusHours(0);
    }

    public void setCollectionStartTime(ZonedDateTime collectionStartTime) {
        this.collectionStartTime = collectionStartTime.plusHours(0);
    }

    public ZonedDateTime getCollectionStopTime() {
        return collectionStopTime.plusHours(0);
    }

    public void setCollectionStopTime(ZonedDateTime collectionStopTime) {
        this.collectionStopTime = collectionStopTime.plusHours(0);
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
        return new Position(aircraftLocationAtCollectionStartTime);
    }

    public void setAircraftLocationAtCollectionStartTime(
            Position aircraftLocationAtCollectionStartTime) {
        this.aircraftLocationAtCollectionStartTime =
                new Position(aircraftLocationAtCollectionStartTime);
    }

    public Position getAircraftLocationAtCollectionEndTime() {
        return new Position(aircraftLocationAtCollectionEndTime);
    }

    public void setAircraftLocationAtCollectionEndTime(
            Position aircraftLocationAtCollectionEndTime) {
        this.aircraftLocationAtCollectionEndTime =
                new Position(aircraftLocationAtCollectionEndTime);
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
