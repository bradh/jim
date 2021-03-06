package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class GimbalsPositionDataTableParser extends AbstractSensorParametricDataTableParser {

    public GimbalsPositionDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        GimbalsPositionDataTable dataTable = new GimbalsPositionDataTable();
        dataTable.setName("Gimbals Position");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setxVectorComponent(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setyVectorComponent(this.readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setzVectorComponent(this.readDouble(mappedByteBuffer, offset, 8));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return ((fileAddress >= 0x00000050) && (fileAddress <= 0x0000005F));
    }
}
