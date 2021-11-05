package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class RectifiedImageGeometryDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00010302;

    public RectifiedImageGeometryDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RectifiedImageGeometryDataTable dataTable = new RectifiedImageGeometryDataTable();
        dataTable.setName("Rectified Image Geometry");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setAxx(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAxy(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAyx(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAyy(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setCx(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setCy(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData1(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData2(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData3(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData4(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData5(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData6(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData7(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData8(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData9(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData10(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData11(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData12(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData13(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData14(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData15(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData16(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData17(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData18(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData19(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setData20(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setNearRangePointDepressionAngle(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setFarRangePointDepressionAngle(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setProjectionType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTerrainModel(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
