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
    private double pRF;
    private double radiometricScaleFactor;
    private double apertureTime;
    private double pulseCompressionRatio;
    private double azimuthBeamwidth;
    private double interpulseTransmitBandwidth;
    private double instantaneousReceiver;
    private double aToDConverterSampleRate;
    private int rADARMode;
    private int processedNumberOfLooks;
    private int preSummingInRange;
    private int preSummingInAzimuth;
    private int numberOfAToDConverterBits;
    private int interpulseModulationType;
    private int pulseToPulseModulationType;
    private int rangeCompressionProcessing;
    private int azimuthCompression;
    private int autofocusProcessing;
    private int rangeProcessingWeighting;
    private int azimuthProcessingWeighting;
    private int antennaAzimuthWeighting;
    private int antennaElevationWeighting;
}
