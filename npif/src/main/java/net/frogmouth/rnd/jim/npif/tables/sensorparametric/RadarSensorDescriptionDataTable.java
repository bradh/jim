package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	If Table A-9.3 “Sync Hierarchy and Image Data Structure Data Table” is not used, the build direction of FRAME and TILE image components, and of samples shall
	be by default “$01 = PDA is X positive, SDA is Y positive”.
	Two illustrative examples concerning Field 7, Image Coordinate System Orientation, are given below:
	Example 1:                                                                                   Example 2:
	Image Coordinate System Orientation = $02                                                    Image Coordinate System Orientation = $07
	Y                                                                                            Y
	vld is X negative,                                                                           vld is Y negative,
	cvld is Y positive                                                                           cvld is X negative
	cvld
	Padded                                                                                      Padded
	zeros                          cvld
	zeros
	Image Length
	Image Length
	X
	vld
	X
	Image Width                                                                                  Image Width
	vld
	Figure A-12 – Illustrative Examples of Image Coordinate System Orientation.
*/
public class RadarSensorDescriptionDataTable extends DataTable {
    private int imageLength;
    private int imageWidth;
    private int packetsPerImage;
    private int tileLength;
    private int tileWidth;
    private int physicalCoordinateSystem;
    private int coordinateSystemOrientation;
    private int sensorMode;
    private int pixelSize;
    private int elementsPerPixel;
    private int dataOrdering;
    private int vldOrientation;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getImageLength() {
        return imageLength;
    }

    public void setImageLength(int imageLength) {
        this.imageLength = imageLength;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getPacketsPerImage() {
        return packetsPerImage;
    }

    public void setPacketsPerImage(int packetsPerImage) {
        this.packetsPerImage = packetsPerImage;
    }

    public int getTileLength() {
        return tileLength;
    }

    public void setTileLength(int tileLength) {
        this.tileLength = tileLength;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public int getPhysicalCoordinateSystem() {
        return physicalCoordinateSystem;
    }

    public String getPhysicalCoordinateSystemAsText() {
        switch (getPhysicalCoordinateSystem()) {
            case 0x00:
                return "Range; Cross Range";
            case 0x01:
                return "Across Track; Along Track";
            case 0x02:
                return "Range; Azimuth";
            case 0x03:
                return "X; Y (Rectified imagery)";
            default:
                return "Unknown physical coordinate system (" + getPhysicalCoordinateSystem() + ")";
        }
    }

    public void setPhysicalCoordinateSystem(int physicalCoordinateSystem) {
        this.physicalCoordinateSystem = physicalCoordinateSystem;
    }

    public int getCoordinateSystemOrientation() {
        return coordinateSystemOrientation;
    }

    public String getCoordinateSystemOrientationAsText() {
        switch (getCoordinateSystemOrientation()) {
            case 0x00:
                return "vld is X positive; cvld is Y positive";
            case 0x01:
                return "vld is X positive; cvld is Y negative";
            case 0x02:
                return "vld is X negative; cvld is Y positive";
            case 0x03:
                return "vld is X negative; cvld is Y negative";
            case 0x04:
                return "vld is Y positive; cvld is X positive";
            case 0x05:
                return "vld is Y positive; cvld is X negative";
            case 0x06:
                return "vld is Y negative; cvld is X positive";
            case 0x07:
                return "vld is Y negative; cvld is X negative";
            case 0x08:
                return "Rectified imagery";
            default:
                return "Unknown coordinate system orientation ("
                        + getCoordinateSystemOrientation()
                        + ")";
        }
    }

    public void setCoordinateSystemOrientation(int coordinateSystemOrientation) {
        this.coordinateSystemOrientation = coordinateSystemOrientation;
    }

    public int getSensorMode() {
        return sensorMode;
    }

    public String getSensorModeAsText() {
        switch (getSensorMode()) {
            case 0x00:
                return "OFF";
            case 0x01:
                return "ON";
            case 0x02:
                return "STANDBY";
            case 0x04:
                return "TEST";
            case 0x05:
                return "FAIL";
            default:
                return "Unknown sensor mode + (" + getSensorMode() + ")";
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
                return "Inactive (Single element data)";
            case 0x01:
                return "Element interleaved by pixel";
            case 0x02:
                return "Element sequential";
            case 0x03:
                return "Element interleaved by line";
            default:
                return getDataOrdering() + ", UNKNOWN ENUMERATION ####****";
        }
    }

    public void setDataOrdering(int dataOrdering) {
        this.dataOrdering = dataOrdering;
    }

    public int getVldOrientation() {
        return vldOrientation;
    }

    public String getVldOrientationAsText() {
        switch (getVldOrientation()) {
            case 0x00:
                return "Unused";
            case 0x01:
                return "Starboard; i.e. value of alpha is positive";
            case 0x02:
                return "Port; i.e. value of alpha is negative";
            default:
                return "Unknown vld orientation (" + getVldOrientation() + ")";
        }
    }

    public void setVldOrientation(int vldOrientation) {
        this.vldOrientation = vldOrientation;
    }
}
