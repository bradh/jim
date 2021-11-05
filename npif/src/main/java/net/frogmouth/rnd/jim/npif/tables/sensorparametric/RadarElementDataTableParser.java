package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class RadarElementDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00011000;
    private static final int LEN_ONE_ELEMENT =
            1 + 2 + 2 + 1 + 2 + 8 + 8 + 8 + 8 + 8 + 8 + 8 + 8 + 8 + 1 + 1 + 1;

    public RadarElementDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RadarElementDataTable dataTable = new RadarElementDataTable();
        dataTable.setName("RADAR Element");
        dataTable.setSourceFile("Sensor Parametric");
        int numEntries = header.getDataFileSize() / LEN_ONE_ELEMENT;
        for (int i = 0; i < numEntries; i++) {
            RadarElementDataTableEntry entry = new RadarElementDataTableEntry();
            entry.setElementSize(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
            offset += 1;
            entry.setElementBitOffset(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
            offset += 2;
            entry.setSensorElementID(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
            offset += 2;
            entry.setTypeOfElement(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
            offset += 1;
            entry.setPhysicalCharacteristic(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
            offset += 2;
            entry.setRfCentreFrequency(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setRfBandwidth(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setMeanDopplerFrequency(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setLookCentreFrequency(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setLookBandwidth(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setMinimumElementValue(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setMaximumElementValue(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setMinimumPhysicalValue(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setMaximumPhysicalValue(this.readDouble(mappedByteBuffer, offset, 8));
            offset += 8;
            entry.setPolarisation(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
            offset += 1;
            entry.setUseOfElement(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
            offset += 1;
            entry.setTransferFunctionType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
            offset += 1;
            dataTable.addEntry(entry);
        }
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
