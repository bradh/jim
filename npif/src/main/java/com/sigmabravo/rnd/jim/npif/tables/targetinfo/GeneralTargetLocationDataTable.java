package com.sigmabravo.rnd.jim.npif.tables.targetinfo;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Position;
import java.time.ZonedDateTime;

/*
	This file is used to determine the target location.
	File Addressing scheme is $0000 1xxy where xx represents the target number, and y the location number.
*/
public class GeneralTargetLocationDataTable extends DataTable {
    private Position startTargetOrCornerLocation;
    private double startTargetOrCornerElevation;
    private double targetDiameterOrWidth;
    private String mapSeries;
    private String sheetNumberOfTargetLocation;
    private double inverseMapScale;
    private int mapEditionNumber;
    private ZonedDateTime mapEditionDate;

    public Position getStartTargetOrCornerLocation() {
        return new Position(startTargetOrCornerLocation);
    }

    public void setStartTargetOrCornerLocation(Position position) {
        this.startTargetOrCornerLocation = new Position(position);
    }

    public double getStartTargetOrCornerElevation() {
        return startTargetOrCornerElevation;
    }

    public void setStartTargetOrCornerElevation(double startTargetOrCornerElevation) {
        this.startTargetOrCornerElevation = startTargetOrCornerElevation;
    }

    public double getTargetDiameterOrWidth() {
        return targetDiameterOrWidth;
    }

    public void setTargetDiameterOrWidth(double targetDiameterOrWidth) {
        this.targetDiameterOrWidth = targetDiameterOrWidth;
    }

    public String getMapSeries() {
        return mapSeries;
    }

    public void setMapSeries(String mapSeries) {
        this.mapSeries = mapSeries;
    }

    public String getSheetNumberOfTargetLocation() {
        return sheetNumberOfTargetLocation;
    }

    public void setSheetNumberOfTargetLocation(String sheetNumberOfTargetLocation) {
        this.sheetNumberOfTargetLocation = sheetNumberOfTargetLocation;
    }

    public double getInverseMapScale() {
        return inverseMapScale;
    }

    public void setInverseMapScale(double inverseMapScale) {
        this.inverseMapScale = inverseMapScale;
    }

    public int getMapEditionNumber() {
        return mapEditionNumber;
    }

    public void setMapEditionNumber(int mapEditionNumber) {
        this.mapEditionNumber = mapEditionNumber;
    }

    public ZonedDateTime getMapEditionDate() {
        if (mapEditionDate == null) {
            return null;
        } else {
            return mapEditionDate.plusHours(0);
        }
    }

    public void setMapEditionDate(ZonedDateTime mapEditionDate) {
        if (mapEditionDate == null) {
            this.mapEditionDate = null;
        } else {
            this.mapEditionDate = mapEditionDate.plusHours(0);
        }
    }
}
