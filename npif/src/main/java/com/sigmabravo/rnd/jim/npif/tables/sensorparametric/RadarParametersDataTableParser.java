package com.sigmabravo.rnd.jim.npif.tables.sensorparametric;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import com.sigmabravo.rnd.jim.npif.tables.Header;
import java.nio.MappedByteBuffer;

public class RadarParametersDataTableParser extends AbstractSensorParametricDataTableParser {

    private static final int FILE_ADDRESS_SUPPORTED = 0x00010304;

    public RadarParametersDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RadarParametersDataTable dataTable = new RadarParametersDataTable();
        dataTable.setName("RADAR Parameters");
        dataTable.setSourceFile("Sensor Parametric");
        dataTable.setProcessedResolutionInVld(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setProcessedResolutionInCvld(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setWavelength(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAveragePower(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAntennaGain(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPrf(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRadiometricScaleFactor(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setApertureTime(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setPulseCompressionRatio(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setAzimuthBeamwidth(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setInterpulseTransmitBandwidth(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setInstantaneousReceiverBandwidth(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setaToDConverterSampleRate(readDouble(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRadarMode(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setProcessedNumberOfLooks(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setPreSummingInRange(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setPreSummingInAzimuth(this.readUnsignedBinary(mappedByteBuffer, offset, 2));
        offset += 2;
        dataTable.setNumberOfAToDConverterBits(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setInterpulseModulationType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setPulseToPulseModulationType(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setRangeCompressionProcessingAlgorithm(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setAzimuthCompressionProcessingAlgorithm(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setAutofocusProcessingAlgorithms(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setRangeProcessingWeighting(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setAzimuthProcessingWeighting(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setAntennaAzimuthWeighting(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setAntennaElevationWeighting(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        return dataTable;
    }

    @Override
    protected boolean fileAddressValid(final int fileAddress) {
        return (fileAddress == FILE_ADDRESS_SUPPORTED);
    }
}
