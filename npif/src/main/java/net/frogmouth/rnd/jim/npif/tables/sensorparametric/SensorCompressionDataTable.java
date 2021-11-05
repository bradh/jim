package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	Identifies the algorithms and parameters of the imagery compression scheme used. This file defines the compression scheme used on the image data. If the sensor
	data is not compressed then this file is not used.
	The compression flag of the header, which is a boolean, cannot specify what kind of compression (JPEG or JPEG 2000) has been used. Therefore, for a given
	sensor, once a compression type has been set, it is assumed that there is no change on the compression type as long as no new compression table is sent again.
*/
public class SensorCompressionDataTable extends DataTable {
    private int compressionAlgorithm;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getCompressionAlgorithm() {
        return compressionAlgorithm;
    }

    public String getCompressionAlgorithmAsText() {
        switch (getCompressionAlgorithm()) {
            case 0x02:
                return "JPEG (ISO/IEC 10918-1:1994)";
            case 0x03:
                return "JPEG 2000 (ISO/IEC 15444-1)";
            default:
                return "Unknown Compression Algorithm (" + getCompressionAlgorithm() + ")";
        }
    }

    public void setCompressionAlgorithm(int compressionAlgorithm) {
        this.compressionAlgorithm = compressionAlgorithm;
    }
}
