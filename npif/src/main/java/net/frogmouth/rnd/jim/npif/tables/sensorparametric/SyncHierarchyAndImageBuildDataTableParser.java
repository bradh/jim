package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class SyncHierarchyAndImageBuildDataTableParser
        extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00000003;

    public SyncHierarchyAndImageBuildDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        SyncHierarchyAndImageBuildDataTable dataTable = new SyncHierarchyAndImageBuildDataTable();
        dataTable.setName("Sync Hierarchy and Image Build");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setSuperFrameHierarchy(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setFrameHierarchy(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setFieldHierarchy(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setSwathHierarchy(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTileHierarchy(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setLineHierarchy(readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setBuildDirectionOfTileImageComponents(
                readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setFrameCoverageRelationship(readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
