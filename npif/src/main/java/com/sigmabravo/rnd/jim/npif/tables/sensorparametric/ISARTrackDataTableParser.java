package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class ISARTrackDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00010305;

    public ISARTrackDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        ISARTrackDataTable dataTable = new ISARTrackDataTable();
        dataTable.setName("ISAR Track");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setRoadCurvature(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRadialSpeedOfVehicle(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setTrackID(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setTrackType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setDirectionOfRoadCurvature(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setDirectionOfVehicleRadialVelocity(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
