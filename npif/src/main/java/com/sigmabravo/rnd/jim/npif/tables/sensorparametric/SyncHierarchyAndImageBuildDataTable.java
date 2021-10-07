package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

public class SyncHierarchyAndImageBuildDataTable extends DataTable {
    private int superFrameHierarchy;
    private int frameHierarchy;
    private int fieldHierarchy;
    private int swathHierarchy;
    private int tileHierarchy;
    private int lineHierarchy;
    private int buildDirectionOfTileImageComponents;
    private int frameCoverageRelationship;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getSuperFrameHierarchy() {
        return superFrameHierarchy;
    }

    public void setSuperFrameHierarchy(int superFrameHierarchy) {
        this.superFrameHierarchy = superFrameHierarchy;
    }

    public int getFrameHierarchy() {
        return frameHierarchy;
    }

    public void setFrameHierarchy(int frameHierarchy) {
        this.frameHierarchy = frameHierarchy;
    }

    public int getFieldHierarchy() {
        return fieldHierarchy;
    }

    public void setFieldHierarchy(int fieldHierarchy) {
        this.fieldHierarchy = fieldHierarchy;
    }

    public int getSwathHierarchy() {
        return swathHierarchy;
    }

    public void setSwathHierarchy(int swathHierarchy) {
        this.swathHierarchy = swathHierarchy;
    }

    public int getTileHierarchy() {
        return tileHierarchy;
    }

    public void setTileHierarchy(int tileHierarchy) {
        this.tileHierarchy = tileHierarchy;
    }

    public int getLineHierarchy() {
        return lineHierarchy;
    }

    public void setLineHierarchy(int lineHierarchy) {
        this.lineHierarchy = lineHierarchy;
    }

    public int getBuildDirectionOfTileImageComponents() {
        return buildDirectionOfTileImageComponents;
    }

    public String getBuildDirectionOfTileImageComponentsAsText() {
        switch (getBuildDirectionOfTileImageComponents()) {
            case 0x00:
                return "not used";
            case 0x01:
                return "PDA is X positive, SDA is Y positive";
            case 0x02:
                return "PDA is X positive, SDA is Y negative";
            case 0x03:
                return "PDA is X negative, SDA is Y positive";
            case 0x04:
                return "PDA is X negative, SDA is Y negative";
            case 0x05:
                return "PDA is Y positive, SDA is X positive";
            case 0x06:
                return "PDA is Y positive, SDA is X negative";
            case 0x07:
                return "PDA is Y negative, SDA is X positive";
            case 0x08:
                return "PDA is Y negative, SDA is X negative";
            default:
                return "Unknown build direction of tile image components ("
                        + getBuildDirectionOfTileImageComponents()
                        + ")";
        }
    }

    public void setBuildDirectionOfTileImageComponents(int buildDirectionOfTileImageComponents) {
        this.buildDirectionOfTileImageComponents = buildDirectionOfTileImageComponents;
    }

    public int getFrameCoverageRelationship() {
        return frameCoverageRelationship;
    }

    public String getFrameCoverageRelationshipAsText() {
        switch (getFrameCoverageRelationship()) {
            case 0x00:
                return "None";
            case 0x01:
                return "100% Overlapped (nominally identical coverage)";
            case 0x02:
                return "less than 100% Overlapped";
            case 0x03:
                return "Abutted";
            default:
                return "Unknown frame coverage relationship ("
                        + getFrameCoverageRelationship()
                        + ")";
        }
    }

    public void setFrameCoverageRelationship(int frameCoverageRelationship) {
        this.frameCoverageRelationship = frameCoverageRelationship;
    }
}
