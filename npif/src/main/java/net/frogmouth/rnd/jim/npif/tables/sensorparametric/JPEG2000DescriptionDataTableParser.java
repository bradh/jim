package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class JPEG2000DescriptionDataTableParser extends AbstractSensorParametricDataTableParser {

    public JPEG2000DescriptionDataTableParser() {}

    @Override
    public JPEG2000DescriptionDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        JPEG2000DescriptionDataTable dataTable = new JPEG2000DescriptionDataTable();
        dataTable.setName("JPEG 2000 Description");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setCodestreamCapability(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setProgressionOrder(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setNumberOfDecompositionLevels(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setNumberOfLayers(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setNumberOfComponents(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setJpeg2000TilingPerformed(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setIrep(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == 0x00000103);
    }
}
