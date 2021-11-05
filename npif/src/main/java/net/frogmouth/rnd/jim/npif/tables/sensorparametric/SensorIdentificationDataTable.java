package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	The Platform ID (to be associated with the sensor number) is encoded in the upper bytes of the File Address, i.e. $00xx 0000.
	File Address $0000 0000 is by default associated with the Aircraft Platform ID. Values $0001 0000 to $0040 0000 are available for 64 Platform IDs. Each sensor can
	associate itself with any Platform ID.
	If the Sensor Modelling Method is VECTOR MODELLING then the following tables are to be used:
	Sensor sample “x” coordinate data table
	Sensor sample “y” coordinate data table
	Sensor sample “z” coordinate data table
*/
public class SensorIdentificationDataTable extends DataTable {
    private int sensorType;
    private String sensorSerialNumber;
    private String sensorModelNumber;
    private int sensorModellingMethod;
    private int numberOfGimbals;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getPlatformId() {
        return ((getHeader().getDataFileAddress() & 0x00FF0000) >> 16);
    }

    public int getSensorType() {
        return sensorType;
    }

    public String getSensorTypeAsText() {
        switch (getSensorType()) {
            case 0x00:
                return "Reserved";
            case 0x01:
                return "FRAMING";
            case 0x02:
                return "LINESCAN";
            case 0x03:
                return "PUSHBROOM";
            case 0x04:
                return "PAN FRAME";
            case 0x05:
                return "STEP FRAME";
            case 0x10:
                return "RADAR real (single mode)";
            case 0x11:
                return "MTI (other than 4607)";
            case 0x12:
                return "RADAR virtual";
            case 0x13:
                return "RADAR multi-mode";
            case 0x14:
                return "4607";
            case 0x15:
                return "4609";
            case 0x16:
                return "RANGE FINDER";
            default:
                return "Unknown sensor type (" + getSensorType() + ")";
        }
    }

    public void setSensorType(int sensorType) {
        this.sensorType = sensorType;
    }

    public String getSensorSerialNumber() {
        return sensorSerialNumber;
    }

    public void setSensorSerialNumber(String sensorSerialNumber) {
        this.sensorSerialNumber = sensorSerialNumber;
    }

    public String getSensorModelNumber() {
        return sensorModelNumber;
    }

    public void setSensorModelNumber(String sensorModelNumber) {
        this.sensorModelNumber = sensorModelNumber;
    }

    public int getSensorModellingMethod() {
        return sensorModellingMethod;
    }

    public String getSensorModellingMethodAsText() {
        switch (getSensorModellingMethod()) {
            case 0x00:
                return "BASIC SEQUENTIAL MODELLING";
            case 0x01:
                return "VECTOR MODELLING";
            case 0x02:
                return "COLLECTION PLANE";
            case 0x03:
                return "RECTIFIED IMAGE";
            case 0x04:
                return "ABSOLUTE VALUE (FOR RANGE FINDER)";
            case 0xFF:
                return "NOT APPLICABLE";
            default:
                return "RESERVED";
        }
    }

    public void setSensorModellingMethod(int sensorModellingMethod) {
        this.sensorModellingMethod = sensorModellingMethod;
    }

    public int getNumberOfGimbals() {
        return numberOfGimbals;
    }

    public void setNumberOfGimbals(int numberOfGimbals) {
        this.numberOfGimbals = numberOfGimbals;
    }
}
