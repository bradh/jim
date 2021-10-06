package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class VirtualSensorDefinitionDataTableParser
        extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00010303;

    public VirtualSensorDefinitionDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        VirtualSensorDefinitionDataTable dataTable = new VirtualSensorDefinitionDataTable();
        dataTable.setName("Virtual Sensor Definition");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setTransmitPhaseDifference(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setReceivePhaseDifference(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setTransmitAntenna1SensorNumber(
                this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setTransmitAntenna2SensorNumber(
                this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setReceiveAntenna1SensorNumber(
                this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setReceiveAntenna2SensorNumber(
                this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setCombinationOperation(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
