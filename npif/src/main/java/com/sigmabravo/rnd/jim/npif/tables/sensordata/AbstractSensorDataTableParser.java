package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;
import java.nio.MappedByteBuffer;

public abstract class AbstractSensorDataTableParser extends DataTableParser {

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return sourceAddressValid(sourceAddress) && (fileAddressValid(fileAddress));
    }

    private boolean sourceAddressValid(final int sourceAddress) {
        return (sourceAddress >= 0x80) && (sourceAddress <= 0xBF);
    }

    protected abstract boolean fileAddressValid(final int fileAddress);

    protected byte[] readBytes(MappedByteBuffer mappedByteBuffer, int offset, int dataFileSize) {
        byte[] dest = new byte[dataFileSize];
        mappedByteBuffer.position(offset).get(dest);
        return dest;
    }
}
