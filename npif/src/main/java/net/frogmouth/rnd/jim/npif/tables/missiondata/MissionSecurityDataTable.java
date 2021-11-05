package net.frogmouth.rnd.jim.npif.tables.missiondata;

import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class MissionSecurityDataTable extends DataTable {
    private String missionSecurityClassification;
    private ZonedDateTime date;
    private String authority;
    private String downgradingInstructions;

    public String getMissionSecurityClassification() {
        return missionSecurityClassification;
    }

    public void setMissionSecurityClassification(String missionSecurityClassification) {
        this.missionSecurityClassification = missionSecurityClassification;
    }

    public ZonedDateTime getDate() {
        return date.plusHours(0);
    }

    public void setDate(ZonedDateTime date) {
        this.date = date.plusHours(0);
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDowngradingInstructions() {
        return downgradingInstructions;
    }

    public void setDowngradingInstructions(String downgradingInstructions) {
        this.downgradingInstructions = downgradingInstructions;
    }
}
