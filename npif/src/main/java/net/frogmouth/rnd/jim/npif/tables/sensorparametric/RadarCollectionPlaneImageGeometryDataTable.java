package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

public class RadarCollectionPlaneImageGeometryDataTable extends DataTable {
    private double alpha;
    private double virtualDistanceToTheFirstPixelInTheImage;
    private double pixelIntervalInTheVirtualLookDirection;
    private double pixelIntervalInTheCrossVirtualLookDirection;
    private int unitsOfMeasurementForCrossVirtualLookDirection;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getAlpha() {
        return alpha;
    }

    public double getAlphaDegrees() {
        return radiansToDegrees(getAlpha());
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getVirtualDistanceToTheFirstPixelInTheImage() {
        return virtualDistanceToTheFirstPixelInTheImage;
    }

    public void setVirtualDistanceToTheFirstPixelInTheImage(
            double virtualDistanceToTheFirstPixelInTheImage) {
        this.virtualDistanceToTheFirstPixelInTheImage = virtualDistanceToTheFirstPixelInTheImage;
    }

    public double getPixelIntervalInTheVirtualLookDirection() {
        return pixelIntervalInTheVirtualLookDirection;
    }

    public void setPixelIntervalInTheVirtualLookDirection(
            double pixelIntervalInTheVirtualLookDirection) {
        this.pixelIntervalInTheVirtualLookDirection = pixelIntervalInTheVirtualLookDirection;
    }

    public double getPixelIntervalInTheCrossVirtualLookDirection() {
        return pixelIntervalInTheCrossVirtualLookDirection;
    }

    public void setPixelIntervalInTheCrossVirtualLookDirection(
            double pixelIntervalInTheCrossVirtualLookDirection) {
        this.pixelIntervalInTheCrossVirtualLookDirection =
                pixelIntervalInTheCrossVirtualLookDirection;
    }

    public int getUnitsOfMeasurementForCrossVirtualLookDirection() {
        return unitsOfMeasurementForCrossVirtualLookDirection;
    }

    public String getUnitsOfMeasurementForCrossVirtualLookDirectionAsText() {
        switch (getUnitsOfMeasurementForCrossVirtualLookDirection()) {
            case 0x00:
                return "angular (radians)";
            case 0x01:
                return "distance (metres)";
            default:
                return "Unknown units of measurement ("
                        + getUnitsOfMeasurementForCrossVirtualLookDirection()
                        + ")";
        }
    }

    public void setUnitsOfMeasurementForCrossVirtualLookDirection(
            int unitsOfMeasurementForCrossVirtualLookDirection) {
        this.unitsOfMeasurementForCrossVirtualLookDirection =
                unitsOfMeasurementForCrossVirtualLookDirection;
    }
}
