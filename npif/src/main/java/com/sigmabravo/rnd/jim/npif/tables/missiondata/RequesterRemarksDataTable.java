package com.sigmabravo.rnd.jim.npif.tables.missiondata;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The least significant bits of the file address are used to associate the requester remarks with the appropriate requester.
	File Addressing scheme is $0000 00xx where bits 0-4 represents the Requester Index Number as an offset from $0000 0060.
	A-5          Target Data Tables
*/
public class RequesterRemarksDataTable extends DataTable {
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
