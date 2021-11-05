package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class ReferenceTrackDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00010301;

    public ReferenceTrackDataTableParser() {}

    @Override
    public ReferenceTrackDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        ReferenceTrackDataTable dataTable = new ReferenceTrackDataTable();
        dataTable.setName("Reference Track");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setSensorVirtualPositionGeoLocation(this.readPosition(mappedByteBuffer, offset));
        offset += 16;
        dataTable.setSensorVirtualPositionMSLAltitude(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setSensorVirtualPositionAGLAltitude(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setSensorVirtualPositionGPSAltitude(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setReferenceTrackNorth(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setReferenceTrackEast(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setReferenceTrackDown(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setReferenceTrackSpeed(this.readDouble(mappedByteBuffer, offset, 8));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
