package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class SensorCalibrationDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000002;

    public SensorCalibrationDataTableParser() {}

    @Override
    public SensorCalibrationDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SensorCalibrationDataTable dataTable = new SensorCalibrationDataTable();
        dataTable.setName("Sensor Calibration");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setCalibrationDate(readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setCalibrationAgency(readASCII(mappedByteBuffer, offset, 91));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
