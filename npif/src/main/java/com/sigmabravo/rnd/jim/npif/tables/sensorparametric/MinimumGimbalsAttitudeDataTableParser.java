package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class MinimumGimbalsAttitudeDataTableParser extends AbstractSensorParametricDataTableParser {

    public MinimumGimbalsAttitudeDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        MinimumGimbalsAttitudeDataTable dataTable = new MinimumGimbalsAttitudeDataTable();
        dataTable.setName("Minimum Gimbals Attitude");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setRotationAboutZAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAboutYAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRotationAboutXAxis(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return ((fileAddress >= 0x00000060) && (fileAddress <= 0x0000006F));
    }
}
