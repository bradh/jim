package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

public class RadarElementDataTableEntry {
    private int elementSize;
    private int elementBitOffset;
    private int sensorElementID;
    private int typeOfElement;
    private int physicalCharacteristic;
    private double rfCentreFrequency;
    private double rfBandwidth;
    private double meanDopplerFrequency;
    private double lookCentreFrequency;
    private double lookBandwidth;
    private double minimumElementValue;
    private double maximumElementValue;
    private double minimumPhysicalValue;
    private double maximumPhysicalValue;
    private int polarisation;
    private int useOfElement;
    private int transferFunctionType;

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

    public int getTypeOfElement() {
        return typeOfElement;
    }

    public String getTypeOfElementAsText() {
        switch (getTypeOfElement()) {
            case 0x00:
                return "Unsigned Binary";
            case 0x01:
                return "Signed Binary";
            case 0x02:
                return "Real Number";
            case 0x03:
                return "Short Float (IEEE 32-bit definition)";
            default:
                return "Unknown element type (" + getTypeOfElement() + ")";
        }
    }

    public void setTypeOfElement(int typeOfElement) {
        this.typeOfElement = typeOfElement;
    }

    public int getPhysicalCharacteristic() {
        return physicalCharacteristic;
    }

    public String getPhysicalCharacteristicAsText() {
        switch (getPhysicalCharacteristic()) {
            case 0x00:
                return "Radar measurement";
            case 0x01:
                return "Height";
            case 0x02:
                return "Velocity (image referenced (x, y))";
            case 0x03:
                return "Velocity (ground referenced (N, E))";
            case 0x04:
                return "Radial velocity component from antenna to pixel";
            case 0x05:
                return "MTI indication";
            case 0x06:
                return "Radar measurement MTI";
            case 0x07:
                return "Pixel validity";
            default:
                return "Unknown physical characteristic (" + getPhysicalCharacteristic() + ")";
        }
    }

    public void setPhysicalCharacteristic(int physicalCharacteristic) {
        this.physicalCharacteristic = physicalCharacteristic;
    }

    public double getRfCentreFrequency() {
        return rfCentreFrequency;
    }

    public void setRfCentreFrequency(double rfCentreFrequency) {
        this.rfCentreFrequency = rfCentreFrequency;
    }

    public double getRfBandwidth() {
        return rfBandwidth;
    }

    public void setRfBandwidth(double rfBandwidth) {
        this.rfBandwidth = rfBandwidth;
    }

    public double getMeanDopplerFrequency() {
        return meanDopplerFrequency;
    }

    public void setMeanDopplerFrequency(double meanDopplerFrequency) {
        this.meanDopplerFrequency = meanDopplerFrequency;
    }

    public double getLookCentreFrequency() {
        return lookCentreFrequency;
    }

    public void setLookCentreFrequency(double lookCentreFrequency) {
        this.lookCentreFrequency = lookCentreFrequency;
    }

    public double getLookBandwidth() {
        return lookBandwidth;
    }

    public void setLookBandwidth(double lookBandwidth) {
        this.lookBandwidth = lookBandwidth;
    }

    public double getMinimumElementValue() {
        return minimumElementValue;
    }

    public void setMinimumElementValue(double minimumElementValue) {
        this.minimumElementValue = minimumElementValue;
    }

    public double getMaximumElementValue() {
        return maximumElementValue;
    }

    public void setMaximumElementValue(double maximumElementValue) {
        this.maximumElementValue = maximumElementValue;
    }

    public double getMinimumPhysicalValue() {
        return minimumPhysicalValue;
    }

    public void setMinimumPhysicalValue(double minimumPhysicalValue) {
        this.minimumPhysicalValue = minimumPhysicalValue;
    }

    public double getMaximumPhysicalValue() {
        return maximumPhysicalValue;
    }

    public void setMaximumPhysicalValue(double maximumPhysicalValue) {
        this.maximumPhysicalValue = maximumPhysicalValue;
    }

    public int getPolarisation() {
        return polarisation;
    }

    public String getPolarisationAsText() {
        switch (getPolarisation()) {
            case 0x00:
                return "HH";
            case 0x01:
                return "VV";
            case 0x02:
                return "HV";
            case 0x03:
                return "VH";
            case 0xFF:
                return "Polarisation unassigned";
            default:
                return "Unknown polarisation (" + getPolarisation() + ")";
        }
    }

    public void setPolarisation(int polarisation) {
        this.polarisation = polarisation;
    }

    public int getUseOfElement() {
        return useOfElement;
    }

    public String getUseOfElementAsText() {
        switch (getUseOfElement()) {
            case 0x00:
                return "Magnitude Radar Measurement";
            case 0x01:
                return "Phase";
            case 0x02:
                return "In phase (I)";
            case 0x03:
                return "Quadrature (Q)";
            case 0x04:
                return "Velocity Magnitude";
            case 0x05:
                return "Velocity Direction Angle";
            case 0x06:
                return "Radial Velocity";
            case 0x07:
                return "vx or vN";
            case 0x08:
                return "vy or vE";
            case 0x09:
                return "Value";
            case 0x10:
                return "Magnitude squared";
            default:
                return "Unknown use of element (" + getUseOfElement() + ")";
        }
    }

    public void setUseOfElement(int useOfElement) {
        this.useOfElement = useOfElement;
    }

    public int getTransferFunctionType() {
        return transferFunctionType;
    }

    public String getTransferFunctionTypeAsText() {
        switch (getTransferFunctionType()) {
            case 0x00:
                return "Linear";
            case 0x01:
                return "Logarithmic (natural)";
            case 0x02:
                return "Exponential";
            default:
                return "Unknown transfer function (" + getTransferFunctionTypeAsText() + ")";
        }
    }

    public void setTransferFunctionType(int transferFunctionType) {
        this.transferFunctionType = transferFunctionType;
    }
}
