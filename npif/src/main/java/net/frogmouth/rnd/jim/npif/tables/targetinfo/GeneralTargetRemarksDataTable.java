package net.frogmouth.rnd.jim.npif.tables.targetinfo;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	File Addressing scheme is $0000 3xxy where xx represents the target number, and y the location number.
	A-6         Platform Data Tables
	Platform data is provided for both the interpreter and exploitation processing equipment. This data describes information about the collection platform on which the
	sensor suite is located.
	Any sensor can be associated with any of the dynamic data tables by the Platform ID and by the File Address of the Sensor Identification Data Table.
	Note:
	Only one Dynamic Data Table is required per Platform ID, i.e. Minimum or Comprehensive.
*/
public class GeneralTargetRemarksDataTable extends DataTable {
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getTargetNumber() {
        return ((getHeader().getDataFileAddress() & 0x00000FF0) >> 4);
    }

    public int getLocationNumber() {
        return (getHeader().getDataFileAddress() & 0x0000000F);
    }
}
