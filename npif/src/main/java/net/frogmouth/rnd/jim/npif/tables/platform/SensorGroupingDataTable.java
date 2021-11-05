package net.frogmouth.rnd.jim.npif.tables.platform;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	The Group ID number is encoded into the last Byte of the File Address.
	This table is of variable length dependent upon the number of sensors in the group.
	Table size = (n + 4) bytes.
	A-7         Segment/Event Data Tables
*/
public class SensorGroupingDataTable extends DataTable {
    private int groupType;
    private int numberOfSensorNumbersWithinTheGroup;
    private int coverageRelationship;
    private int timingRelationship;
    private final List<Integer> sensorNumbers = new ArrayList<>();

    public int getGroupType() {
        return groupType;
    }

    public String getGroupTypeAsText() {
        switch (getGroupType()) {
            case 0x00:
                return "Coverage";
            case 0x01:
                return "Spectral";
            default:
                return "Unknown group type (" + getGroupType() + ")";
        }
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public int getNumberOfSensorNumbersWithinTheGroup() {
        return numberOfSensorNumbersWithinTheGroup;
    }

    public void setNumberOfSensorNumbersWithinTheGroup(int numberOfSensorNumbersWithinTheGroup) {
        this.numberOfSensorNumbersWithinTheGroup = numberOfSensorNumbersWithinTheGroup;
    }

    public int getCoverageRelationship() {
        return coverageRelationship;
    }

    public String getCoverageRelationshipAsText() {
        switch (getCoverageRelationship()) {
            case 0:
                return "NONE";
            case 1:
                return "100% Overlapped (nominally identical coverage)";
            case 2:
                return "less than 100% Overlapped";
            case 3:
                return "Abutted";
            default:
                return "Unknown coverage relationship (" + getCoverageRelationship() + ")";
        }
    }

    public void setCoverageRelationship(int coverageRelationship) {
        this.coverageRelationship = coverageRelationship;
    }

    public int getTimingRelationship() {
        return timingRelationship;
    }

    public String getTimingRelationshipAsText() {
        switch (getTimingRelationship()) {
            case 0x00:
                return "Simultaneous";
            case 0x01:
                return "Sequential";
            case 0xFF:
                return "No timing relationship";
            default:
                return "Unknown timing relationship (" + getTimingRelationship() + ")";
        }
    }

    public void setTimingRelationship(int timingRelationship) {
        this.timingRelationship = timingRelationship;
    }

    public void addSensorNumber(int sensorNumber) {
        this.sensorNumbers.add(sensorNumber);
    }

    public List<Integer> getSensorNumbers() {
        return new ArrayList<>(sensorNumbers);
    }
}
