package net.frogmouth.rnd.jim.npif.tables.missiondata;

import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class AirTaskingOrderDataTable extends DataTable {
    private String airTaskingOrderTitle;
    private String airTaskingOrderOriginator;
    private String airTaskingOrderSerial;
    private ZonedDateTime dateTimeGroup;
    private String qualifier;
    private int qualifierSerialNumber;

    public String getAirTaskingOrderTitle() {
        return airTaskingOrderTitle;
    }

    public void setAirTaskingOrderTitle(String airTaskingOrderTitle) {
        this.airTaskingOrderTitle = airTaskingOrderTitle;
    }

    public String getAirTaskingOrderOriginator() {
        return airTaskingOrderOriginator;
    }

    public void setAirTaskingOrderOriginator(String airTaskingOrderOriginator) {
        this.airTaskingOrderOriginator = airTaskingOrderOriginator;
    }

    public String getAirTaskingOrderSerial() {
        return airTaskingOrderSerial;
    }

    public void setAirTaskingOrderSerial(String airTaskingOrderSerial) {
        this.airTaskingOrderSerial = airTaskingOrderSerial;
    }

    public ZonedDateTime getDateTimeGroup() {
        return dateTimeGroup.plusHours(0);
    }

    public void setDateTimeGroup(ZonedDateTime dateTimeGroup) {
        this.dateTimeGroup = dateTimeGroup.plusHours(0);
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public int getQualifierSerialNumber() {
        return qualifierSerialNumber;
    }

    public void setQualifierSerialNumber(int qualifierSerialNumber) {
        this.qualifierSerialNumber = qualifierSerialNumber;
    }
}
