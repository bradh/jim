package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

public class PassiveSensorDescriptionDataTable extends DataTable {
    private int frameOrSwathSize;
    private double activeLineTime;
    private int lineSizeOfActiveData;
    private int packetsPerFrameOrSwath;
    private int sizeOfTileInTheHighFrequencyScanningDirection;
    private int sizeOfTileInTheLowFrequencyScanningDirection;
    private int numberOfTilesAcrossALine;
    private int numberOfSwathsPerFrame;
    private int sensorMode;
    private int pixelSize;
    private int elementsPerPixel;
    private int dataOrdering;
    private double lineFOV;
    private double frameOrSwathFOV;
    private int numberOfFields;
    private int highFrequencyScanningDirection;
    private int lowFrequencyScanningDirection;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getFrameOrSwathSize() {
        return frameOrSwathSize;
    }

    public void setFrameOrSwathSize(int frameOrSwathSize) {
        this.frameOrSwathSize = frameOrSwathSize;
    }

    public double getActiveLineTime() {
        return activeLineTime;
    }

    public void setActiveLineTime(double activeLineTime) {
        this.activeLineTime = activeLineTime;
    }

    public int getLineSizeOfActiveData() {
        return lineSizeOfActiveData;
    }

    public void setLineSizeOfActiveData(int lineSizeOfActiveData) {
        this.lineSizeOfActiveData = lineSizeOfActiveData;
    }

    public int getPacketsPerFrameOrSwath() {
        return packetsPerFrameOrSwath;
    }

    public void setPacketsPerFrameOrSwath(int packetsPerFrameOrSwath) {
        this.packetsPerFrameOrSwath = packetsPerFrameOrSwath;
    }

    public int getSizeOfTileInTheHighFrequencyScanningDirection() {
        return sizeOfTileInTheHighFrequencyScanningDirection;
    }

    public void setSizeOfTileInTheHighFrequencyScanningDirection(
            int sizeOfTileInTheHighFrequencyScanningDirection) {
        this.sizeOfTileInTheHighFrequencyScanningDirection =
                sizeOfTileInTheHighFrequencyScanningDirection;
    }

    public int getSizeOfTileInTheLowFrequencyScanningDirection() {
        return sizeOfTileInTheLowFrequencyScanningDirection;
    }

    public void setSizeOfTileInTheLowFrequencyScanningDirection(
            int sizeOfTileInTheLowFrequencyScanningDirection) {
        this.sizeOfTileInTheLowFrequencyScanningDirection =
                sizeOfTileInTheLowFrequencyScanningDirection;
    }

    public int getNumberOfTilesAcrossALine() {
        return numberOfTilesAcrossALine;
    }

    public void setNumberOfTilesAcrossALine(int numberOfTilesAcrossALine) {
        this.numberOfTilesAcrossALine = numberOfTilesAcrossALine;
    }

    public int getNumberOfSwathsPerFrame() {
        return numberOfSwathsPerFrame;
    }

    public void setNumberOfSwathsPerFrame(int numberOfSwathsPerFrame) {
        this.numberOfSwathsPerFrame = numberOfSwathsPerFrame;
    }

    public int getSensorMode() {
        return sensorMode;
    }

    public String getSensorModeAsText() {
        switch (getSensorMode()) {
            case 0x00:
                return "Off";
            case 0x01:
                return "On";
            case 0x02:
                return "Standby";
            case 0x04:
                return "Test";
            case 0x05:
                return "Fail";
            default:
                return "Unknown Sensor Mode (" + getSensorMode() + ")";
        }
    }

    public void setSensorMode(int sensorMode) {
        this.sensorMode = sensorMode;
    }

    public int getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(int pixelSize) {
        this.pixelSize = pixelSize;
    }

    public int getElementsPerPixel() {
        return elementsPerPixel;
    }

    public void setElementsPerPixel(int elementsPerPixel) {
        this.elementsPerPixel = elementsPerPixel;
    }

    public int getDataOrdering() {
        return dataOrdering;
    }

    public String getDataOrderingAsText() {
        switch (getDataOrdering()) {
            case 0x00:
                return "INACTIVE (Unispectral data)";
            case 0x01:
                return "BAND INTERLEAVED BY PIXEL";
            case 0x02:
                return "BAND SEQUENTIAL";
            case 0x03:
                return "BAND INTERLEAVED BY LINE";
            default:
                return "Unknown data ordering (" + getDataOrdering() + ")";
        }
    }

    public void setDataOrdering(int dataOrdering) {
        this.dataOrdering = dataOrdering;
    }

    public double getLineFOV() {
        return lineFOV;
    }

    public double getLineFOVDegrees() {
        return radiansToDegrees(getLineFOV());
    }

    public void setLineFOV(double lineFOV) {
        this.lineFOV = lineFOV;
    }

    public double getFrameOrSwathFOV() {
        return frameOrSwathFOV;
    }

    public double getFrameOrSwathFOVDegrees() {
        return radiansToDegrees(getFrameOrSwathFOV());
    }

    public void setFrameOrSwathFOV(double frameOrSwathFOV) {
        this.frameOrSwathFOV = frameOrSwathFOV;
    }

    public int getNumberOfFields() {
        return numberOfFields;
    }

    public String getNumberOfFieldsAsText() {
        switch (getNumberOfFields()) {
            case 0x00:
                return "INVALID";
            case 0x01:
                return "NON-INTERLACED FRAMING SENSOR";
            default:
                return "" + getNumberOfFields() + " FIELDS";
        }
    }

    public void setNumberOfFields(int numberOfFields) {
        this.numberOfFields = numberOfFields;
    }

    public int getHighFrequencyScanningDirection() {
        return highFrequencyScanningDirection;
    }

    public String getHighFrequencyScanningDirectionAsText() {
        switch (getHighFrequencyScanningDirection()) {
            case 0x00:
                return "negative direction";
            case 0x01:
                return "positive direction";
            default:
                return "Unknown high frequency scan direction ("
                        + getHighFrequencyScanningDirection()
                        + ")";
        }
    }

    public void setHighFrequencyScanningDirection(int highFrequencyScanningDirection) {
        this.highFrequencyScanningDirection = highFrequencyScanningDirection;
    }

    public int getLowFrequencyScanningDirection() {
        return lowFrequencyScanningDirection;
    }

    public String getLowFrequencyScanningDirectionAsText() {
        switch (getLowFrequencyScanningDirection()) {
            case 0x00:
                return "negative direction";
            case 0x01:
                return "positive direction";
            default:
                return "Unknown low frequency scan direction ("
                        + getLowFrequencyScanningDirection()
                        + ")";
        }
    }

    public void setLowFrequencyScanningDirection(int lowFrequencyScanningDirection) {
        this.lowFrequencyScanningDirection = lowFrequencyScanningDirection;
    }
}
