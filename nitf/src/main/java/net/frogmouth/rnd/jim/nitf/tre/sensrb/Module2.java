package net.frogmouth.rnd.jim.nitf.tre.sensrb;

public class Module2 {
    private String detection;
    private int rowDetectors;
    private int columnDetectors;
    private double rowMetric;
    private double columnMetric;
    private double focalLength;
    private String rowFieldOfView;
    private String columnFieldOfView;
    private String calibrated;

    public Module2() {}

    public Module2(Module2 other) {
        this.detection = other.detection;
        this.rowDetectors = other.rowDetectors;
        this.columnDetectors = other.columnDetectors;
        this.rowMetric = other.rowMetric;
        this.columnMetric = other.columnMetric;
        this.focalLength = other.focalLength;
        this.rowFieldOfView = other.rowFieldOfView;
        this.columnFieldOfView = other.columnFieldOfView;
        this.calibrated = other.calibrated;
    }

    public String getDetection() {
        return detection;
    }

    public void setDetection(String detection) {
        this.detection = detection;
    }

    public int getRowDetectors() {
        return rowDetectors;
    }

    public void setRowDetectors(int rowDetectors) {
        this.rowDetectors = rowDetectors;
    }

    public int getColumnDetectors() {
        return columnDetectors;
    }

    public void setColumnDetectors(int columnDetectors) {
        this.columnDetectors = columnDetectors;
    }

    public double getRowMetric() {
        return rowMetric;
    }

    public void setRowMetric(double rowMetric) {
        this.rowMetric = rowMetric;
    }

    public double getColumnMetric() {
        return columnMetric;
    }

    public void setColumnMetric(double columnMetric) {
        this.columnMetric = columnMetric;
    }

    public double getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(double focalLength) {
        this.focalLength = focalLength;
    }

    public String getRowFieldOfView() {
        return rowFieldOfView;
    }

    public void setRowFieldOfView(String rowFieldOfView) {
        this.rowFieldOfView = rowFieldOfView;
    }

    public String getColumnFieldOfView() {
        return columnFieldOfView;
    }

    public void setColumnFieldOfView(String columnFieldOfView) {
        this.columnFieldOfView = columnFieldOfView;
    }

    public String getCalibrated() {
        return calibrated;
    }

    public void setCalibrated(String calibrated) {
        this.calibrated = calibrated;
    }
}
