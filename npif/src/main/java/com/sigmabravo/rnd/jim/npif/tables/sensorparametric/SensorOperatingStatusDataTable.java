package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

public class SensorOperatingStatusDataTable extends DataTable {
    private String status;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
