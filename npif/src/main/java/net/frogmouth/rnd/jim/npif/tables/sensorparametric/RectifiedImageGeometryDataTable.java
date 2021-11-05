package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class RectifiedImageGeometryDataTable extends DataTable {

    private double axx;
    private double axy;
    private double ayx;
    private double ayy;
    private double cx;
    private double cy;
    private double data1;
    private double data2;
    private double data3;
    private double data4;
    private double data5;
    private double data6;
    private double data7;
    private double data8;
    private double data9;
    private double data10;
    private double data11;
    private double data12;
    private double data13;
    private double data14;
    private double data15;
    private double data16;
    private double data17;
    private double data18;
    private double data19;
    private double data20;
    private double nearRangePointDepressionAngle;
    private double farRangePointDepressionAngle;
    private int projectionType;
    private int terrainModel;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getAxx() {
        return axx;
    }

    public void setAxx(double axx) {
        this.axx = axx;
    }

    public double getAxy() {
        return axy;
    }

    public void setAxy(double axy) {
        this.axy = axy;
    }

    public double getAyx() {
        return ayx;
    }

    public void setAyx(double ayx) {
        this.ayx = ayx;
    }

    public double getAyy() {
        return ayy;
    }

    public void setAyy(double ayy) {
        this.ayy = ayy;
    }

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public double getData1() {
        return data1;
    }

    public void setData1(double data1) {
        this.data1 = data1;
    }

    public double getData2() {
        return data2;
    }

    public void setData2(double data2) {
        this.data2 = data2;
    }

    public double getData3() {
        return data3;
    }

    public void setData3(double data3) {
        this.data3 = data3;
    }

    public double getData4() {
        return data4;
    }

    public void setData4(double data4) {
        this.data4 = data4;
    }

    public double getData5() {
        return data5;
    }

    public void setData5(double data5) {
        this.data5 = data5;
    }

    public double getData6() {
        return data6;
    }

    public void setData6(double data6) {
        this.data6 = data6;
    }

    public double getData7() {
        return data7;
    }

    public void setData7(double data7) {
        this.data7 = data7;
    }

    public double getData8() {
        return data8;
    }

    public void setData8(double data8) {
        this.data8 = data8;
    }

    public double getData9() {
        return data9;
    }

    public void setData9(double data9) {
        this.data9 = data9;
    }

    public double getData10() {
        return data10;
    }

    public void setData10(double data10) {
        this.data10 = data10;
    }

    public double getData11() {
        return data11;
    }

    public void setData11(double data11) {
        this.data11 = data11;
    }

    public double getData12() {
        return data12;
    }

    public void setData12(double data12) {
        this.data12 = data12;
    }

    public double getData13() {
        return data13;
    }

    public void setData13(double data13) {
        this.data13 = data13;
    }

    public double getData14() {
        return data14;
    }

    public void setData14(double data14) {
        this.data14 = data14;
    }

    public double getData15() {
        return data15;
    }

    public void setData15(double data15) {
        this.data15 = data15;
    }

    public double getData16() {
        return data16;
    }

    public void setData16(double data16) {
        this.data16 = data16;
    }

    public double getData17() {
        return data17;
    }

    public void setData17(double data17) {
        this.data17 = data17;
    }

    public double getData18() {
        return data18;
    }

    public void setData18(double data18) {
        this.data18 = data18;
    }

    public double getData19() {
        return data19;
    }

    public void setData19(double data19) {
        this.data19 = data19;
    }

    public double getData20() {
        return data20;
    }

    public void setData20(double data20) {
        this.data20 = data20;
    }

    public double getNearRangePointDepressionAngle() {
        return nearRangePointDepressionAngle;
    }

    public double getNearRangePointDepressionAngleDegrees() {
        return radiansToDegrees(getNearRangePointDepressionAngle());
    }

    public void setNearRangePointDepressionAngle(double nearRangePointDepressionAngle) {
        this.nearRangePointDepressionAngle = nearRangePointDepressionAngle;
    }

    public double getFarRangePointDepressionAngle() {
        return farRangePointDepressionAngle;
    }

    public double getFarRangePointDepressionAngleDegrees() {
        return radiansToDegrees(getFarRangePointDepressionAngle());
    }

    public void setFarRangePointDepressionAngle(double farRangePointDepressionAngle) {
        this.farRangePointDepressionAngle = farRangePointDepressionAngle;
    }

    public int getProjectionType() {
        return projectionType;
    }

    public String getProjectionTypeAsText() {
        switch (getProjectionType()) {
            case 0x00:
                return "Unused";
            case 0x01:
                return "Cartesian plane projection";
            case 0x02:
                return "Stereographic";
            case 0x03:
                return "Transverse Mercator";
            case 0x04:
                return "Mercator";
            default:
                return "Unknown projection type (" + getProjectionType() + ")";
        }
    }

    public void setProjectionType(int projectionType) {
        this.projectionType = projectionType;
    }

    public int getTerrainModel() {
        return terrainModel;
    }

    public String getTerrainModelAsText() {
        switch (getTerrainModel()) {
            case 0x00:
                return "No DTM used";
            case 0x01:
                return "DTED";
            case 0xFF:
                return "other DTM used";
            default:
                return "Unknown terrain model (" + getTerrainModel() + ")";
        }
    }

    public void setTerrainModel(int terrainModel) {
        this.terrainModel = terrainModel;
    }
}
