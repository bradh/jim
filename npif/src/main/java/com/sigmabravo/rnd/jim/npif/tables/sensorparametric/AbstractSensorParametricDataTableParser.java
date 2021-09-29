package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTableParser;

public abstract class AbstractSensorParametricDataTableParser extends DataTableParser {

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return sourceAddressValid(sourceAddress) && (fileAddressValid(fileAddress));
    }

    private boolean sourceAddressValid(final int sourceAddress) {
        return (sourceAddress >= 0x40) && (sourceAddress <= 0x7F);
    }

    protected abstract boolean fileAddressValid(final int fileAddress);
}
