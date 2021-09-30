package com.sigmabravo.rnd.jim.npif.tables.sensordata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

public class AbstractSensorDataTable extends DataTable {

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0xFF) - 0x80;
    }
}
