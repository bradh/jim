package net.frogmouth.rnd.jim.npif.tables.missiondata;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class RequesterRemarksDataTable extends DataTable {
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getRequesterId() {
        return ((getHeader().getDataFileAddress() & 0x7F) - 0x60);
    }
}
