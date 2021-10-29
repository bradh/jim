package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SensorSampleCoordinateDescriptionDataTableParser
        extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00001010;

    public SensorSampleCoordinateDescriptionDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorSampleCoordinateDescriptionDataTable dataTable =
                new SensorSampleCoordinateDescriptionDataTable();
        dataTable.setName("Sensor Sample Coordinate Description");
        dataTable.setSourceFile("Sensor Parametric");
        // TODO: need to parse properly
        return new DataTable();
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
