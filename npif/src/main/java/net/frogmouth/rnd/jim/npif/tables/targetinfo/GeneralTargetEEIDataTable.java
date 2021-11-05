package net.frogmouth.rnd.jim.npif.tables.targetinfo;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	File Addressing scheme is $0000 2xxy where xx represents the target number, and y the location number.
*/
public class GeneralTargetEEIDataTable extends DataTable {
    private String targetCategoryEssentialElementsOfInformation;
    private int eeiTargetCategoryDesignationScheme;
    private String weatherOverTheTargetReportingCode;

    public String getTargetCategoryEssentialElementsOfInformation() {
        return targetCategoryEssentialElementsOfInformation;
    }

    public void setTargetCategoryEssentialElementsOfInformation(
            String targetCategoryEssentialElementsOfInformation) {
        this.targetCategoryEssentialElementsOfInformation =
                targetCategoryEssentialElementsOfInformation;
    }

    public int getEeiTargetCategoryDesignationScheme() {
        return eeiTargetCategoryDesignationScheme;
    }

    public String getEeiTargetCategoryDesignationSchemeAsText() {
        switch (getEeiTargetCategoryDesignationScheme()) {
            case 1:
                return "NATO STANAG 3596";
            default:
                return "Unknown (" + getEeiTargetCategoryDesignationScheme() + ")";
        }
    }

    public void setEeiTargetCategoryDesignationScheme(int eeiTargetCategoryDesignationScheme) {
        this.eeiTargetCategoryDesignationScheme = eeiTargetCategoryDesignationScheme;
    }

    public String getWeatherOverTheTargetReportingCode() {
        return weatherOverTheTargetReportingCode;
    }

    public void setWeatherOverTheTargetReportingCode(String weatherOverTheTargetReportingCode) {
        this.weatherOverTheTargetReportingCode = weatherOverTheTargetReportingCode;
    }

    public int getTargetNumber() {
        return ((getHeader().getDataFileAddress() & 0x00000FF0) >> 4);
    }

    public int getLocationNumber() {
        return (getHeader().getDataFileAddress() & 0x0000000F);
    }
}
