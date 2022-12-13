package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.io.ByteArrayOutputStream;

public class Module4 {
    private String method;
    private String mode;
    private int rowCount;
    private int columnCount;
    private int rowSet;
    private int columnSet;
    private double rowRate;
    private double columnRate;
    private int firstPixelRow;
    private int firstPixelColumn;
    private double[] transformParams;

    public Module4() {}

    public Module4(Module4 other) {
        this.method = other.method;
        this.mode = other.mode;
        this.rowCount = other.rowCount;
        this.columnCount = other.columnCount;
        this.rowSet = other.rowSet;
        this.columnSet = other.columnSet;
        this.rowRate = other.rowRate;
        this.columnRate = other.columnRate;
        this.firstPixelRow = other.firstPixelRow;
        this.firstPixelColumn = other.firstPixelColumn;
        this.transformParams = other.transformParams;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getRowSet() {
        return rowSet;
    }

    public void setRowSet(int rowSet) {
        this.rowSet = rowSet;
    }

    public int getColumnSet() {
        return columnSet;
    }

    public void setColumnSet(int columnSet) {
        this.columnSet = columnSet;
    }

    public double getRowRate() {
        return rowRate;
    }

    public void setRowRate(double rowRate) {
        this.rowRate = rowRate;
    }

    public double getColumnRate() {
        return columnRate;
    }

    public void setColumnRate(double columnRate) {
        this.columnRate = columnRate;
    }

    public int getFirstPixelRow() {
        return firstPixelRow;
    }

    public void setFirstPixelRow(int firstPixelRow) {
        this.firstPixelRow = firstPixelRow;
    }

    public int getFirstPixelColumn() {
        return firstPixelColumn;
    }

    public void setFirstPixelColumn(int firstPixelColumn) {
        this.firstPixelColumn = firstPixelColumn;
    }

    public double[] getTransformParams() {
        return transformParams.clone();
    }

    public void setTransformParams(double[] transformParams) {
        this.transformParams = transformParams.clone();
    }

    void appendBytes(ByteArrayOutputStream baos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
        // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
