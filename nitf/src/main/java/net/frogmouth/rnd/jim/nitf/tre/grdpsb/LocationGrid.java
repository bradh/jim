package net.frogmouth.rnd.jim.nitf.tre.grdpsb;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class LocationGrid extends TreePart {
    private Double locationGridElevation;
    private String locationGridId;
    private double dataDensityInColumns;
    private double dataDensityInRows;
    private double originInColumns;
    private double originInRows;

    @TREOrder(order = 1)
    @TREField(label = "ZVL")
    public Double getLocationGridElevation() {
        return locationGridElevation;
    }

    public void setLocationGridElevation(Double locationGridElevation) {
        this.locationGridElevation = locationGridElevation;
    }

    @TREOrder(order = 2)
    @TREField(label = "BAD")
    public String getLocationGridId() {
        return locationGridId;
    }

    public void setLocationGridId(String locationGridId) {
        this.locationGridId = locationGridId;
    }

    @TREOrder(order = 3)
    @TREField(label = "LOD")
    public double getDataDensityInColumns() {
        return dataDensityInColumns;
    }

    public void setDataDensityInColumns(double dataDensityInColumns) {
        this.dataDensityInColumns = dataDensityInColumns;
    }

    @TREOrder(order = 4)
    @TREField(label = "LAD")
    public double getDataDensityInRows() {
        return dataDensityInRows;
    }

    public void setDataDensityInRows(double dataDensityInRows) {
        this.dataDensityInRows = dataDensityInRows;
    }

    @TREOrder(order = 5)
    @TREField(label = "LSO")
    public double getOriginInColumns() {
        return originInColumns;
    }

    public void setOriginInColumns(double originInColumns) {
        this.originInColumns = originInColumns;
    }

    @TREOrder(order = 6)
    @TREField(label = "PSO")
    public double getOriginInRows() {
        return originInRows;
    }

    public void setOriginInRows(double originInRows) {
        this.originInRows = originInRows;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Grid: " + getLocationGridId().trim();
    }
}
