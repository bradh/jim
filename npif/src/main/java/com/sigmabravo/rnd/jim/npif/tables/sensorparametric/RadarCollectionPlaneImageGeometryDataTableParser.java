package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class RadarCollectionPlaneImageGeometryDataTableParser
        extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00010300;

    public RadarCollectionPlaneImageGeometryDataTableParser() {}

    @Override
    public RadarCollectionPlaneImageGeometryDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RadarCollectionPlaneImageGeometryDataTable dataTable =
                new RadarCollectionPlaneImageGeometryDataTable();
        dataTable.setName("RADAR Collection Plane Image Geometry");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setAlpha(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setVirtualDistanceToTheFirstPixelInTheImage(
                this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPixelIntervalInTheVirtualLookDirection(
                this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPixelIntervalInTheCrossVirtualLookDirection(
                this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setUnitsOfMeasurementForCrossVirtualLookDirection(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
