package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

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

    public double getAzimuthBeamwidthDegrees() {
        return radiansToDegrees(getAzimuthBeamwidth());
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

    public String getRadarModeAsText() {
        switch (getRadarMode()) {
            case 0x00:
                return "Swath";
            case 0x01:
                return "Spotlight";
            case 0x02:
                return "Real beam ground map";
            case 0x03:
                return "Enhanced real beam ground map";
            case 0x04:
                return "Doppler beam sharpened map";
            case 0x05:
                return "SAR overlaid with MTI";
            case 0x06:
                return "Interferometric SAR";
            case 0x07:
                return "Polarimetric SAR";
            case 0x08:
                return "Inverse SAR";
            case 0x09:
                return "Side-looking Array SAR (SLAR)";
            default:
                return "Unknown radar mode (" + getRadarMode() + ")";
        }
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

    public String getInterpulseModulationTypeAsText() {
        switch (getInterpulseModulationType()) {
            case 0x00:
                return "None";
            case 0x01:
                return "Chirp";
            case 0x02:
                return "Binary phase code – Barker";
            case 0x03:
                return "Binary phase code – Galois";
            case 0x04:
                return "Quadrature phase code";
            default:
                return "Unknown interpulse modulation type (" + getInterpulseModulationType() + ")";
        }
    }

    public void setInterpulseModulationType(int interpulseModulationType) {
        this.interpulseModulationType = interpulseModulationType;
    }

    public int getPulseToPulseModulationType() {
        return pulseToPulseModulationType;
    }

    public String getPulseToPulseModulationTypeAsText() {
        switch (getPulseToPulseModulationType()) {
            case 0x00:
                return "None";
            case 0x01:
                return "Linear step";
            case 0x02:
                return "Pseudo-random step";
            case 0x03:
                return "Pseudo-random";
            case 0x04:
                return "Step plus pseudo-random";
            default:
                return "Unknown pulse-to-pulse modulation type ("
                        + getPulseToPulseModulationType()
                        + ")";
        }
    }

    public void setPulseToPulseModulationType(int pulseToPulseModulationType) {
        this.pulseToPulseModulationType = pulseToPulseModulationType;
    }

    public int getRangeCompressionProcessingAlgorithm() {
        return rangeCompressionProcessingAlgorithm;
    }

    public String getRangeCompressionProcessingAlgorithmAsText() {
        switch (getRangeCompressionProcessingAlgorithm()) {
            case 0x00:
                return "None";
            case 0x01:
                return "Stretch compression";
            case 0x02:
                return "Analogue matched filter";
            case 0x03:
                return "Digital matched filter";
            case 0x04:
                return "Stretch plus matched filter";
            case 0x05:
                return "Step plus matched filter";
            default:
                return "Unknown range compression processing algorithm ("
                        + getRangeCompressionProcessingAlgorithm()
                        + ")";
        }
    }

    public void setRangeCompressionProcessingAlgorithm(int rangeCompressionProcessingAlgorithm) {
        this.rangeCompressionProcessingAlgorithm = rangeCompressionProcessingAlgorithm;
    }

    public int getAzimuthCompressionProcessingAlgorithm() {
        return azimuthCompressionProcessingAlgorithm;
    }

    public String getAzimuthCompressionProcessingAlgorithmAsText() {
        switch (getAzimuthCompressionProcessingAlgorithm()) {
            case 0x00:
                return "None";
            case 0x01:
                return "Enhanced real beam";
            case 0x02:
                return "Real beam";
            case 0x03:
                return "Doppler";
            case 0x04:
                return "Polar format";
            case 0x05:
                return "Range migration";
            case 0x06:
                return "Chirp scaling";
            default:
                return "Unknown azimuth compression processing algorithm ("
                        + getAzimuthCompressionProcessingAlgorithm()
                        + ")";
        }
    }

    public void setAzimuthCompressionProcessingAlgorithm(
            int azimuthCompressionProcessingAlgorithm) {
        this.azimuthCompressionProcessingAlgorithm = azimuthCompressionProcessingAlgorithm;
    }

    public int getAutofocusProcessingAlgorithms() {
        return autofocusProcessingAlgorithms;
    }

    public String getAutofocusProcessingAlgorithmsAsText() {
        switch (getAutofocusProcessingAlgorithms()) {
            case 0x00:
                return "None";
            case 0x01:
                return "Motion compensation (MOCO) only";
            case 0x02:
                return "Phase gradient plus MOCO";
            case 0x03:
                return "Phase difference plus MOCO";
            case 0x04:
                return "Multilook registration plus MOCO";
            case 0x05:
                return "Contrast optimisation plus MOCO";
            case 0x06:
                return "Prominent point processing plus MOCO";
            case 0x07:
                return "Mapdrift plus MOCO";
            case 0x08:
                return "Multiple Aperture Mapdrift plus MOCO";
            default:
                return "Unknown autofocus processing algorithms ("
                        + getAutofocusProcessingAlgorithms()
                        + ")";
        }
    }

    public void setAutofocusProcessingAlgorithms(int autofocusProcessingAlgorithms) {
        this.autofocusProcessingAlgorithms = autofocusProcessingAlgorithms;
    }

    public int getRangeProcessingWeighting() {
        return rangeProcessingWeighting;
    }

    public String getRangeProcessingWeightingAsText() {
        switch (getRangeProcessingWeighting()) {
            case 0x00:
                return "Uniform";
            case 0x01:
                return "-20dB m = 6 Taylor";
            case 0x02:
                return "-25dB m = 12 Taylor";
            case 0x03:
                return "-30dB m = 23 Taylor";
            case 0x04:
                return "-35dB m = 44 Taylor";
            case 0x05:
                return "-40dB m = 81 Taylor";
            case 0x06:
                return "-40dB m = 6 Dolph-Chebyshev";
            case 0x07:
                return "-50dB m = 6 Dolph-Chebyshev";
            case 0x08:
                return "-60dB m = 6 Dolph-Chebyshev";
            case 0x09:
                return "Spatially varying apodisation";
            default:
                return "Unknown range processing weighting (" + getRangeProcessingWeighting() + ")";
        }
    }

    public void setRangeProcessingWeighting(int rangeProcessingWeighting) {
        this.rangeProcessingWeighting = rangeProcessingWeighting;
    }

    public int getAzimuthProcessingWeighting() {
        return azimuthProcessingWeighting;
    }

    public String getAzimuthProcessingWeightingAsText() {
        switch (getAzimuthProcessingWeighting()) {
            case 0x00:
                return "Uniform";
            case 0x01:
                return "-20dB m = 6 Taylor";
            case 0x02:
                return "-25dB m = 12 Taylor";
            case 0x03:
                return "-30dB m = 23 Taylor";
            case 0x04:
                return "-35dB m = 44 Taylor";
            case 0x05:
                return "-40dB m = 81 Taylor";
            case 0x06:
                return "-40dB m = 6 Dolph-Chebyshev";
            case 0x07:
                return "-50dB m = 6 Dolph-Chebyshev";
            case 0x08:
                return "-60dB m = 6 Dolph-Chebyshev";
            case 0x09:
                return "Spatially varying apodisation";
            default:
                return "Unknown azimuth processing weighting ("
                        + getAzimuthProcessingWeighting()
                        + ")";
        }
    }

    public void setAzimuthProcessingWeighting(int azimuthProcessingWeighting) {
        this.azimuthProcessingWeighting = azimuthProcessingWeighting;
    }

    public int getAntennaAzimuthWeighting() {
        return antennaAzimuthWeighting;
    }

    public String getAntennaAzimuthWeightingAsText() {
        switch (getAntennaAzimuthWeighting()) {
            case 0x00:
                return "Uniform";
            case 0x01:
                return "-20dB m = 6 Taylor";
            case 0x02:
                return "-25dB m = 12 Taylor";
            case 0x03:
                return "-30dB m = 23 Taylor";
            case 0x04:
                return "-35dB m = 44 Taylor";
            case 0x05:
                return "-40dB m = 81 Taylor";
            case 0x06:
                return "-40dB m = 6 Dolph-Chebyshev";
            case 0x07:
                return "-50dB m = 6 Dolph-Chebyshev";
            case 0x08:
                return "-60dB m = 6 Dolph-Chebyshev";
            default:
                return "Unknown antenna azimuth weighting (" + getAntennaAzimuthWeighting() + ")";
        }
    }

    public void setAntennaAzimuthWeighting(int antennaAzimuthWeighting) {
        this.antennaAzimuthWeighting = antennaAzimuthWeighting;
    }

    public int getAntennaElevationWeighting() {
        return antennaElevationWeighting;
    }

    public String getAntennaElevationWeightingAsText() {
        switch (getAntennaElevationWeighting()) {
            case 0x00:
                return "Uniform";
            case 0x01:
                return "-20dB m = 6 Taylor";
            case 0x02:
                return "-25dB m = 12 Taylor";
            case 0x03:
                return "-30dB m = 23 Taylor";
            case 0x04:
                return "-35dB m = 44 Taylor";
            case 0x05:
                return "-40dB m = 81 Taylor";
            case 0x06:
                return "-40dB m = 6 Dolph-Chebyshev";
            case 0x07:
                return "-50dB m = 6 Dolph-Chebyshev";
            case 0x08:
                return "-60dB m = 6 Dolph-Chebyshev";
            default:
                return "Unknown antenna elevation weighting ("
                        + getAntennaElevationWeighting()
                        + ")";
        }
    }

    public void setAntennaElevationWeighting(int antennaElevationWeighting) {
        this.antennaElevationWeighting = antennaElevationWeighting;
    }
}
