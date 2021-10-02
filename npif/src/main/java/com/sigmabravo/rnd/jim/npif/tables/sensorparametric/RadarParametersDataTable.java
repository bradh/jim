package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;

/*
	The sensor number is encoded into the Source Address. The binary form of the Source Address is: 01xxxxxx, where xxxxxx is the sensor number.
	If a single sensor is used in different modes and the modes are simultaneous then each mode must have its own sensor number and this table is sent for each
	sensor number.
	If a single sensor is used in different modes and the modes are serial then only one sensor number is required but this table must be sent each time the mode
	changes.
*/
public class RadarParametersDataTable extends DataTable {
    private double processedResolutionInVld;
    private double processedResolutionInCvld;
    private double wavelength;
    private double averagePower;
    private double antennaGain;
    private double prf;
    private double radiometricScaleFactor;
    private double apertureTime;
    private double pulseCompressionRatio;
    private double azimuthBeamwidth;
    private double interpulseTransmitBandwidth;
    private double instantaneousReceiverBandwidth;
    private double aToDConverterSampleRate;
    private int radarMode;
    private int processedNumberOfLooks;
    private int preSummingInRange;
    private int preSummingInAzimuth;
    private int numberOfAToDConverterBits;
    private int interpulseModulationType;
    private int pulseToPulseModulationType;
    private int rangeCompressionProcessingAlgorithm;
    private int azimuthCompressionProcessingAlgorithm;
    private int autofocusProcessingAlgorithms;
    private int rangeProcessingWeighting;
    private int azimuthProcessingWeighting;
    private int antennaAzimuthWeighting;
    private int antennaElevationWeighting;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public double getProcessedResolutionInVld() {
        return processedResolutionInVld;
    }

    public void setProcessedResolutionInVld(double processedResolutionInVld) {
        this.processedResolutionInVld = processedResolutionInVld;
    }

    public double getProcessedResolutionInCvld() {
        return processedResolutionInCvld;
    }

    public void setProcessedResolutionInCvld(double processedResolutionInCvld) {
        this.processedResolutionInCvld = processedResolutionInCvld;
    }

    public double getWavelength() {
        return wavelength;
    }

    public void setWavelength(double wavelength) {
        this.wavelength = wavelength;
    }

    public double getAveragePower() {
        return averagePower;
    }

    public void setAveragePower(double averagePower) {
        this.averagePower = averagePower;
    }

    public double getAntennaGain() {
        return antennaGain;
    }

    public void setAntennaGain(double antennaGain) {
        this.antennaGain = antennaGain;
    }

    public double getPrf() {
        return prf;
    }

    public void setPrf(double prf) {
        this.prf = prf;
    }

    public double getRadiometricScaleFactor() {
        return radiometricScaleFactor;
    }

    public void setRadiometricScaleFactor(double radiometricScaleFactor) {
        this.radiometricScaleFactor = radiometricScaleFactor;
    }

    public double getApertureTime() {
        return apertureTime;
    }

    public void setApertureTime(double apertureTime) {
        this.apertureTime = apertureTime;
    }

    public double getPulseCompressionRatio() {
        return pulseCompressionRatio;
    }

    public void setPulseCompressionRatio(double pulseCompressionRatio) {
        this.pulseCompressionRatio = pulseCompressionRatio;
    }

    public double getAzimuthBeamwidth() {
        return azimuthBeamwidth;
    }

    public void setAzimuthBeamwidth(double azimuthBeamwidth) {
        this.azimuthBeamwidth = azimuthBeamwidth;
    }

    public double getInterpulseTransmitBandwidth() {
        return interpulseTransmitBandwidth;
    }

    public void setInterpulseTransmitBandwidth(double interpulseTransmitBandwidth) {
        this.interpulseTransmitBandwidth = interpulseTransmitBandwidth;
    }

    public double getInstantaneousReceiverBandwidth() {
        return instantaneousReceiverBandwidth;
    }

    public void setInstantaneousReceiverBandwidth(double instantaneousReceiverBandwidth) {
        this.instantaneousReceiverBandwidth = instantaneousReceiverBandwidth;
    }

    public double getaToDConverterSampleRate() {
        return aToDConverterSampleRate;
    }

    public void setaToDConverterSampleRate(double aToDConverterSampleRate) {
        this.aToDConverterSampleRate = aToDConverterSampleRate;
    }

    public int getRadarMode() {
        return radarMode;
    }

    public void setRadarMode(int radarMode) {
        this.radarMode = radarMode;
    }

    public int getProcessedNumberOfLooks() {
        return processedNumberOfLooks;
    }

    public void setProcessedNumberOfLooks(int processedNumberOfLooks) {
        this.processedNumberOfLooks = processedNumberOfLooks;
    }

    public int getPreSummingInRange() {
        return preSummingInRange;
    }

    public void setPreSummingInRange(int preSummingInRange) {
        this.preSummingInRange = preSummingInRange;
    }

    public int getPreSummingInAzimuth() {
        return preSummingInAzimuth;
    }

    public void setPreSummingInAzimuth(int preSummingInAzimuth) {
        this.preSummingInAzimuth = preSummingInAzimuth;
    }

    public int getNumberOfAToDConverterBits() {
        return numberOfAToDConverterBits;
    }

    public void setNumberOfAToDConverterBits(int numberOfAToDConverterBits) {
        this.numberOfAToDConverterBits = numberOfAToDConverterBits;
    }

    public int getInterpulseModulationType() {
        return interpulseModulationType;
    }

    public void setInterpulseModulationType(int interpulseModulationType) {
        this.interpulseModulationType = interpulseModulationType;
    }

    public int getPulseToPulseModulationType() {
        return pulseToPulseModulationType;
    }

    public void setPulseToPulseModulationType(int pulseToPulseModulationType) {
        this.pulseToPulseModulationType = pulseToPulseModulationType;
    }

    public int getRangeCompressionProcessingAlgorithm() {
        return rangeCompressionProcessingAlgorithm;
    }

    public void setRangeCompressionProcessingAlgorithm(int rangeCompressionProcessingAlgorithm) {
        this.rangeCompressionProcessingAlgorithm = rangeCompressionProcessingAlgorithm;
    }

    public int getAzimuthCompressionProcessingAlgorithm() {
        return azimuthCompressionProcessingAlgorithm;
    }

    public void setAzimuthCompressionProcessingAlgorithm(
            int azimuthCompressionProcessingAlgorithm) {
        this.azimuthCompressionProcessingAlgorithm = azimuthCompressionProcessingAlgorithm;
    }

    public int getAutofocusProcessingAlgorithms() {
        return autofocusProcessingAlgorithms;
    }

    public void setAutofocusProcessingAlgorithms(int autofocusProcessingAlgorithms) {
        this.autofocusProcessingAlgorithms = autofocusProcessingAlgorithms;
    }

    public int getRangeProcessingWeighting() {
        return rangeProcessingWeighting;
    }

    public void setRangeProcessingWeighting(int rangeProcessingWeighting) {
        this.rangeProcessingWeighting = rangeProcessingWeighting;
    }

    public int getAzimuthProcessingWeighting() {
        return azimuthProcessingWeighting;
    }

    public void setAzimuthProcessingWeighting(int azimuthProcessingWeighting) {
        this.azimuthProcessingWeighting = azimuthProcessingWeighting;
    }

    public int getAntennaAzimuthWeighting() {
        return antennaAzimuthWeighting;
    }

    public void setAntennaAzimuthWeighting(int antennaAzimuthWeighting) {
        this.antennaAzimuthWeighting = antennaAzimuthWeighting;
    }

    public int getAntennaElevationWeighting() {
        return antennaElevationWeighting;
    }

    public void setAntennaElevationWeighting(int antennaElevationWeighting) {
        this.antennaElevationWeighting = antennaElevationWeighting;
    }
}
