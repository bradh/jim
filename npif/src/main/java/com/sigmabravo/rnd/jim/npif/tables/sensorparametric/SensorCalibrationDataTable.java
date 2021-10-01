package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.time.ZonedDateTime;

public class SensorCalibrationDataTable extends DataTable {
    private ZonedDateTime calibrationDate;
    private String calibrationAgency;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public ZonedDateTime getCalibrationDate() {
        return calibrationDate.plusHours(0);
    }

    public void setCalibrationDate(ZonedDateTime calibrationDate) {
        this.calibrationDate = calibrationDate.plusHours(0);
    }

    public String getCalibrationAgency() {
        return calibrationAgency;
    }

    public void setCalibrationAgency(String calibrationAgency) {
        this.calibrationAgency = calibrationAgency;
    }
}
