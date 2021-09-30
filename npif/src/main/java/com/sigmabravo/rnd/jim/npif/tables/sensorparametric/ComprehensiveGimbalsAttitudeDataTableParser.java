package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class ComprehensiveGimbalsAttitudeDataTableParser
        extends AbstractSensorParametricDataTableParser {

    public ComprehensiveGimbalsAttitudeDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        ComprehensiveGimbalsAttitudeDataTable dataTable =
                new ComprehensiveGimbalsAttitudeDataTable();
        dataTable.setName("Comprehensive Gimbals Attitude");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setRotationAboutZAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAboutYAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAboutXAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationRateAboutZAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationRateAboutYAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationRateAboutXAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAccelerationAboutZAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAccelerationAboutYAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAccelerationAboutXAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return ((fileAddress >= 0x00000070) && (fileAddress <= 0x0000007F));
    }
}
