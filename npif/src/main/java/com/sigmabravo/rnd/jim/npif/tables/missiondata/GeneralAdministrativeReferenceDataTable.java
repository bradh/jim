package com.sigmabravo.rnd.jim.npif.tables.missiondata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.time.ZonedDateTime;

public class GeneralAdministrativeReferenceDataTable extends DataTable {
    private String missionNumber;
    private ZonedDateTime missionStartTime;
    private String projectIdentifierCode;
    private int numberOfTargets;
    private int numberOfRequesters;

    public String getMissionNumber() {
        return missionNumber;
    }

    public void setMissionNumber(String missionNumber) {
        this.missionNumber = missionNumber;
    }

    public ZonedDateTime getMissionStartTime() {
        return missionStartTime.plusHours(0);
    }

    public void setMissionStartTime(ZonedDateTime missionStartTime) {
        this.missionStartTime = missionStartTime.plusHours(0);
    }

    public String getProjectIdentifierCode() {
        return projectIdentifierCode;
    }

    public void setProjectIdentifierCode(String projectIdentifierCode) {
        this.projectIdentifierCode = projectIdentifierCode;
    }

    public int getNumberOfTargets() {
        return numberOfTargets;
    }

    public void setNumberOfTargets(int numberOfTargets) {
        this.numberOfTargets = numberOfTargets;
    }

    public int getNumberOfRequesters() {
        return numberOfRequesters;
    }

    public void setNumberOfRequesters(int numberOfRequesters) {
        this.numberOfRequesters = numberOfRequesters;
    }
}
