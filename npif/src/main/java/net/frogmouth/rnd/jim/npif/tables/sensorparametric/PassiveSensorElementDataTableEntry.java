/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

/** @author bradh */
public class PassiveSensorElementDataTableEntry {
    private int elementSize;
    private int elementBitOffset;
    private int sensorElementID;
    private double minimumWavelength;
    private double maximumWavelength;

    public int getElementSize() {
        return elementSize;
    }

    public void setElementSize(int elementSize) {
        this.elementSize = elementSize;
    }

    public int getElementBitOffset() {
        return elementBitOffset;
    }

    public void setElementBitOffset(int elementBitOffset) {
        this.elementBitOffset = elementBitOffset;
    }

    public int getSensorElementID() {
        return sensorElementID;
    }

    public void setSensorElementID(int sensorElementID) {
        this.sensorElementID = sensorElementID;
    }

    public double getMinimumWavelength() {
        return minimumWavelength;
    }

    public void setMinimumWavelength(double minimumWavelength) {
        this.minimumWavelength = minimumWavelength;
    }

    public double getMaximumWavelength() {
        return maximumWavelength;
    }

    public void setMaximumWavelength(double maximumWavelength) {
        this.maximumWavelength = maximumWavelength;
    }
}
