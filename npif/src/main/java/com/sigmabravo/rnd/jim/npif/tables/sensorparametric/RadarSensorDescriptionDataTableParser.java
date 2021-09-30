package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class RadarSensorDescriptionDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00010001;

    public RadarSensorDescriptionDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RadarSensorDescriptionDataTable dataTable = new RadarSensorDescriptionDataTable();
        dataTable.setName("RADAR Sensor Description");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setImageLength(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setImageWidth(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setPacketsPerImage(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setTileLength(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setTileWidth(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setPhysicalCoordinateSystem(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setCoordinateSystemOrientation(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setSensorMode(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setPixelSize(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setElementsPerPixel(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setDataOrdering(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setVldOrientation(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
