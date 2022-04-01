package net.frogmouth.rnd.jim.s4607.hrr;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.s4607.segment.Segment;
import net.frogmouth.rnd.jim.s4607.segment.SegmentType;

/**
 * High Range Resolution (HRR) Segment.
 *
 * <p>The HRR Segment provides data on High-Range Resolution (HRR) targets or High Range Resolution
 * Range Doppler Maps (RDM) for a specified area.
 *
 * <p>Data may also be formatted Range-Pulse format if desired. It is referenced to the MTI Report
 * Index field (Conditional) of the corresponding Target Report in the Dwell Segment and shall be
 * sent each time an HRR dwell is processed. Range Doppler Maps (RDMs) that have no corresponding
 * target detections may be packaged into this segment. Consequently, the MTI Report Index is
 * Conditional and omitted in such a case.
 */
public class HighRangeResolutionSegment extends Segment {

    private int revisitIndex;
    private int dwellIndex;
    private boolean lastDwellOfRevisit;
    private Integer mtiReportIndex;
    private Integer numberOfTargetScatterers;
    private Integer numberOfRangeSamplesOrTotalScatterers;
    private int numberOfDopplerSamples;
    private Integer meanClutterPower;
    private int detectionThreshold;
    private double rangeResolution;
    private double rangeBinSpacing;
    private double dopplerResolution;
    private double dopplerBinSpacing;
    private Double centreFrequency;
    private int compressionType; // possibly an enumeration type?
    private int rangeWeightingFunctionType; // possibly an enumeration type?
    private int dopplerWeightingFunctionType; // possibly an enumeration type?
    private double maximumPixelPower;
    private Integer maximumRadarCrossSection;
    private Integer rangeOfOrigin;
    private Double dopplerOfOrigin;
    private TypeOfHrrRdm typeOfHrrRdm;
    private ProcessingMask processingMask;
    private int numBytesMagnititude;
    private int numBytesPhase;
    private Integer rangeExtentInPixels;
    private Long rangeToNearestEdgeInChip;
    private Integer indexOfZeroVelocityBin;
    private Double targetRadialElectricalLength;
    private Double electricalLengthUncertainty;
    private List<ScattererRecord> scattererRecords = new ArrayList<>();

    @Override
    public SegmentType getSegmentType() {
        return SegmentType.HRRSegment;
    }

    /**
     * Revisit Index (H2).
     *
     * <p>The sequential count of a revisit of the bounding area for a given job ID.
     *
     * <p>This field is mandatory.
     *
     * @return revisit index in the range 0 to 65535.
     */
    public int getRevisitIndex() {
        return revisitIndex;
    }

    /**
     * Set the Revisit Index (H2).
     *
     * <p>The sequential count of a revisit of the bounding area for a given job ID.
     *
     * <p>This field is mandatory.
     *
     * @param revisitIndex revisit index in the valid range 0 to 65535.
     */
    public void setRevisitIndex(int revisitIndex) {
        this.revisitIndex = revisitIndex;
    }

    /**
     * Dwell Index (H3).
     *
     * <p>The sequential count of a dwell within the revisit of a particular bounding area for a
     * given job ID. A dwell index of {@code 0} indicates the first dwell of the revisit. (Note:
     * Revisit counts are allowed to “wrap” when the allowable range of revisits is exceeded.)
     *
     * <p>This field is mandatory.
     *
     * @return dwell index in range 0 to 65535.
     */
    public int getDwellIndex() {
        return dwellIndex;
    }

    /**
     * Set the Dwell Index (H3).
     *
     * <p>The sequential count of a dwell within the revisit of a particular bounding area for a
     * given job ID. A dwell index of {@code 0} indicates the first dwell of the revisit. (Note:
     * Revisit counts are allowed to “wrap” when the allowable range of revisits is exceeded.)
     *
     * <p>This field is mandatory.
     *
     * @param dwellIndex dwell index in the valid range 0 to 65535.
     */
    public void setDwellIndex(int dwellIndex) {
        this.dwellIndex = dwellIndex;
    }

    /**
     * Last Dwell Of Revisit (H4).
     *
     * <p>A flag to indicate, when set to {@code true}, that this is the last dwell of the revisit.
     * A Dwell Index (field H3) of {@code 0} with the Last Dwell of Revisit flag set to {@code true}
     * indicates there are no other dwells within that revisit.
     *
     * <p>This field is mandatory.
     *
     * @return last dwell of revisit flag (true or false).
     */
    public boolean getLastDwellOfRevisit() {
        return lastDwellOfRevisit;
    }

    /**
     * Set the Last Dwell Of Revisit (H4).
     *
     * <p>A flag to indicate, when set to {@code true}, that this is the last dwell of the revisit.
     * A Dwell Index (field H3) of {@code 0} with the Last Dwell of Revisit flag set to {@code true}
     * indicates there are no other dwells within that revisit.
     *
     * <p>This field is mandatory.
     *
     * @param lastDwellOfRevisit last dwell of revisit flag (true or false).
     */
    public void setLastDwellOfRevisit(boolean lastDwellOfRevisit) {
        this.lastDwellOfRevisit = lastDwellOfRevisit;
    }

    /**
     * MTI Report Index (H5).
     *
     * <p>The sequential index of the associated MTI Report, field D32.1 of the Dwell Segment.
     *
     * <p>This field is conditional, and is used in conjunction with the 1-D HRR Profile, 2-D HRR
     * Profile, Sparse HRR Chip and Oversized HRR Chip data types.
     *
     * @return the MTI report index as an integer in the range 0 to 65535.
     */
    public Integer getMtiReportIndex() {
        return mtiReportIndex;
    }

    /**
     * Set the MTI Report Index (H5).
     *
     * <p>The sequential index of the associated MTI Report, field D32.1 of the Dwell Segment.
     *
     * <p>This field is conditional, and is used in conjunction with the 1-D HRR Profile, 2-D HRR
     * Profile, Sparse HRR Chip and Oversized HRR Chip data types.
     *
     * @param index the MTI report index as an integer in the valid range 0 to 65535.
     */
    public void setMtiReportIndex(Integer index) {
        this.mtiReportIndex = index;
    }

    /**
     * Number of Target Scatterers (H6).
     *
     * <p>Number of Range Doppler pixels that exceed target scatterer threshold and are reported in
     * this segment.
     *
     * <p>This field is conditional - either H6 or H7 or both must be reported.
     *
     * @return the number of target scatterers in the range 0 to 65535.
     */
    public Integer getNumberOfTargetScatterers() {
        return numberOfTargetScatterers;
    }

    /**
     * Set the Number of Target Scatterers (H6).
     *
     * <p>Number of Range Doppler pixels that exceed target scatterer threshold and are reported in
     * this segment.
     *
     * <p>This field is conditional - either H6 or H7 or both must be reported.
     *
     * @param targetScatterers the number of target scatterers in the range 0 to 65535.
     */
    public void setNumberOfTargetScatterers(Integer targetScatterers) {
        this.numberOfTargetScatterers = targetScatterers;
    }

    /**
     * Number Of Range Samples/Total Scatterers (H7).
     *
     * <p>Number of Range Bins/Samples in a Range Doppler Chip. When used with a Sparse HRR chip
     * this field shall define the total number of scatterer records.
     *
     * <p>This field is conditional - either H6 or H7 or both must be reported.
     *
     * @return the number of range samples / total scatterers as an integer in the range 0 to 65535.
     */
    public Integer getNumberOfRangeSamplesOrTotalScatterers() {
        return numberOfRangeSamplesOrTotalScatterers;
    }

    /**
     * Set the Number Of Range Samples/Total Scatterers (H7).
     *
     * <p>Number of Range Bins/Samples in a Range Doppler Chip. When used with a Sparse HRR chip
     * this field shall define the total number of scatterer records.
     *
     * <p>This field is conditional - either H6 or H7 or both must be reported.
     *
     * @param num the number of range samples / total scatterers as an integer in the range 0 to
     *     65535.
     */
    public void setNumberOfRangeSamplesOrTotalScatterers(Integer num) {
        this.numberOfRangeSamplesOrTotalScatterers = num;
    }

    /**
     * Number Of Doppler Samples/Pulses (H8).
     *
     * <p>Number of Doppler bins in a Range-Doppler chip.
     *
     * <p>This field is mandatory.
     *
     * @return number of Doppler samples as an integer in the range 0 to 65535.
     */
    public int getNumberOfDopplerSamples() {
        return numberOfDopplerSamples;
    }

    /**
     * Number Of Doppler Samples/Pulses (H8).
     *
     * <p>Number of Doppler bins in a Range-Doppler chip.
     *
     * <p>This field is mandatory.
     *
     * @param samples number of Doppler samples as an integer in the valid range 0 to 65535.
     */
    public void setNumberOfDopplerSamples(int samples) {
        this.numberOfDopplerSamples = samples;
    }

    /**
     * Mean Clutter Power Relative To Peak Scatterer (H9).
     *
     * <p>The Peak Scatter returns the maximum power level (e.g. in milliWatts, or dBm) registered
     * by the sensor.
     *
     * <p>Mean power of non-target pixels (residual clutter power) is computed after range Doppler
     * chip formation, and expressed as an uncalibrated power in quarter-decibels (dB/4). The value
     * is calculated by: (a) converting the Mean Clutter Power Relative to Peak Scatterer to
     * decibels (dB), with the maximum value constrained to 63.75 dB; (b) multiplying that value by
     * 4; and (c) rounding to the nearest integer.
     *
     * <p>This field is conditional, and must be used in conjunction with the Sparse HRR chip data
     * type.
     *
     * @return the mean clutter power (relative to the peak scatterer) in dB/4.
     */
    public Integer getMeanClutterPower() {
        return meanClutterPower;
    }

    /**
     * Set the Mean Clutter Power Relative To Peak Scatterer (H9).
     *
     * <p>The Peak Scatter returns the maximum power level (e.g. in milliWatts, or dBm) registered
     * by the sensor.
     *
     * <p>Mean power of non-target pixels (residual clutter power) is computed after range Doppler
     * chip formation, and expressed as an uncalibrated power in quarter-decibels (dB/4). The value
     * is calculated by: (a) converting the Mean Clutter Power Relative to Peak Scatterer to
     * decibels (dB), with the maximum value constrained to 63.75 dB; (b) multiplying that value by
     * 4; and (c) rounding to the nearest integer.
     *
     * <p>This field is conditional, and must be used in conjunction with the Sparse HRR chip data
     * type.
     *
     * @param power the mean clutter power (relative to the peak scatterer) in dB/4.
     */
    public void setMeanClutterPower(Integer power) {
        this.meanClutterPower = power;
    }

    /**
     * Detection Threshold Relative To Peak Scatterer (H10).
     *
     * <p>Detection threshold used to isolate significant target scatterer pixels, expressed as
     * power relative to clutter mean in negative quarter-decibels (-dB/4). The value is calculated
     * by: (a) converting the Detection Threshold Relative to Peak Scatterer to decibels (dB), a
     * negative quantity with the maximum absolute value constrained to 63.75 dB; (b) multiplying
     * that value by 4; (c) removing the negative sign; and (d) rounding to the nearest integer.
     *
     * <p>This field is mandatory.
     *
     * @return the detection threshold relative to peak scatterer, in negative dB/4.
     */
    public int getDetectionThreshold() {
        return detectionThreshold;
    }

    /**
     * Set the Detection Threshold Relative To Peak Scatterer (H10).
     *
     * <p>Detection threshold used to isolate significant target scatterer pixels, expressed as
     * power relative to clutter mean in negative quarter-decibels (-dB/4). The value is calculated
     * by: (a) converting the Detection Threshold Relative to Peak Scatterer to decibels (dB), a
     * negative quantity with the maximum absolute value constrained to 63.75 dB; (b) multiplying
     * that value by 4; (c) removing the negative sign; and (d) rounding to the nearest integer.
     *
     * <p>This field is mandatory.
     *
     * @param threshold the detection threshold relative to peak scatterer, in negative dB/4.
     */
    public void setDetectionThreshold(int threshold) {
        this.detectionThreshold = threshold;
    }

    /**
     * Range Resolution (H11).
     *
     * <p>3dB range impulse response of the radar, expressed in centimetres.
     *
     * <p>This field is mandatory.
     *
     * @return the range resolution of the radar sensor, in centimetres (with a valid range of 0.001
     *     to 255.9921875), or 0 for no-statement.
     */
    public double getRangeResolution() {
        return rangeResolution;
    }

    /**
     * Set the Range Resolution (H11).
     *
     * <p>3dB range impulse response of the radar, expressed in centimetres.
     *
     * <p>This field is mandatory.
     *
     * @param resolution the range resolution of the radar sensor, in centimetres (with a valid
     *     range of 0.001 to 255.9921875), or 0 for no-statement.
     */
    public void setRangeResolution(double resolution) {
        this.rangeResolution = resolution;
    }

    /**
     * Range Bin Spacing (H12).
     *
     * <p>Slant Range pixel spacing after over sampling, expressed in centimetres.
     *
     * <p>This field is mandatory.
     *
     * @return the range bin spacing in centimetres (with a valid range of 0.001 to 255.9921875), or
     *     0 for no-statement.
     */
    public double getRangeBinSpacing() {
        return rangeBinSpacing;
    }

    /**
     * Set the Range Bin Spacing (H12).
     *
     * <p>Slant Range pixel spacing after over sampling, expressed in centimetres.
     *
     * <p>This field is mandatory.
     *
     * @param spacing the range bin spacing in centimetres (with a valid range of 0.001 to
     *     255.9921875), or 0 for no-statement.
     */
    public void setRangeBinSpacing(double spacing) {
        this.rangeBinSpacing = spacing;
    }

    /**
     * Doppler Resolution (H13).
     *
     * <p>3dB Doppler resolution of the radar, expressed in Hertz.
     *
     * <p>This field is mandatory.
     *
     * @return the Doppler resolution in Hertz (Hz).
     */
    public double getDopplerResolution() {
        return dopplerResolution;
    }

    /**
     * Set the Doppler Resolution (H13).
     *
     * <p>3dB Doppler resolution of the radar, expressed in Hertz.
     *
     * <p>This field is mandatory.
     *
     * @param resolution the Doppler resolution in Hertz (Hz).
     */
    public void setDopplerResolution(double resolution) {
        this.dopplerResolution = resolution;
    }

    /**
     * Doppler Bin Spacing / PRF (H14).
     *
     * <p>Doppler pixel spacing after over sampling, expressed in Hertz.
     *
     * <p>This field is mandatory.
     *
     * @return the Doppler bin spacing, in Hertz (Hz).
     */
    public double getDopplerBinSpacing() {
        return dopplerBinSpacing;
    }

    /**
     * Set the Doppler Bin Spacing / PRF (H14).
     *
     * <p>Doppler pixel spacing after over sampling, expressed in Hertz.
     *
     * <p>This field is mandatory.
     *
     * @param spacing the Doppler bin spacing, in Hertz (Hz), with a valid range of +/-0.000001 to
     *     32767.
     */
    public void setDopplerBinSpacing(double spacing) {
        this.dopplerBinSpacing = spacing;
    }

    /**
     * Centre Frequency (H15).
     *
     * <p>Centre frequency of the radar in GHz.
     *
     * <p>This field is conditional, and must be used in conjunction with all HRR/Range Doppler Maps
     * (RDM) data types except 1-D HRR Profile and Sparse HRR Chip. This field is optional for 1-D
     * HRR Profile and Sparse HRR Chip.
     *
     * @return the centre frequency in GHz.
     */
    public Double getCentreFrequency() {
        return centreFrequency;
    }

    /**
     * Set the Centre Frequency (H15).
     *
     * <p>Centre frequency of the radar in GHz.
     *
     * <p>This field is conditional, and must be used in conjunction with all HRR/Range Doppler Maps
     * (RDM) data types except 1-D HRR Profile and Sparse HRR Chip. This field is optional for 1-D
     * HRR Profile and Sparse HRR Chip.
     *
     * @param frequency the centre frequency in GHz, with a valid range of 2.384e-7 to 255.9921875.
     */
    public void setCentreFrequency(Double frequency) {
        this.centreFrequency = frequency;
    }

    /**
     * Compression Type (H16).
     *
     * <p>An enumeration denoting the compression technique used.
     *
     * <p>This field is mandatory.
     *
     * @return 0 for no-statement, 1 for Threshold Decomposition (10x), 2-255 are reserved values.
     */
    public int getCompressionType() {
        return compressionType;
    }

    /**
     * Set the Compression Type (H16).
     *
     * <p>An enumeration denoting the compression technique used.
     *
     * <p>This field is mandatory.
     *
     * @param compression 0 for no-statement, 1 for Threshold Decomposition (10x), 2-255 are
     *     reserved values.
     */
    public void setCompressionType(int compression) {
        this.compressionType = compression;
    }

    /**
     * Range Weighting Function Type (H17).
     *
     * <p>An enumeration indicating the spectral weighting used in the range compression process.
     *
     * <p>This field is mandatory.
     *
     * @return 0 for no-statement, 1 for Taylor Weighting, 2 for other, 3-255 are reserved values.
     */
    public int getRangeWeightingFunctionType() {
        return rangeWeightingFunctionType;
    }

    /**
     * Set the Range Weighting Function Type (H17).
     *
     * <p>An enumeration indicating the spectral weighting used in the range compression process.
     *
     * <p>This field is mandatory.
     *
     * @param weighting 0 for no-statement, 1 for Taylor Weighting, 2 for other, 3-255 are reserved
     *     values.
     */
    public void setRangeWeightingFunctionType(int weighting) {
        this.rangeWeightingFunctionType = weighting;
    }

    /**
     * Doppler Weighting Function Type (H18).
     *
     * <p>An enumeration table indicating the spectral weighting used in the cross-range or Doppler
     * compression process.
     *
     * <p>This field is mandatory.
     *
     * @return 0 for no-statement, 1 for Taylor Weighting, 2 for other, 3-255 are reserved values.
     */
    public int getDopplerWeightingFunctionType() {
        return dopplerWeightingFunctionType;
    }

    /**
     * Set the Doppler Weighting Function Type (H18).
     *
     * <p>An enumeration table indicating the spectral weighting used in the cross-range or Doppler
     * compression process.
     *
     * <p>This field is mandatory.
     *
     * @param weighting 0 for no-statement, 1 for Taylor Weighting, 2 for other, 3-255 are reserved
     *     values.
     */
    public void setDopplerWeightingFunctionType(int weighting) {
        this.dopplerWeightingFunctionType = weighting;
    }

    /**
     * Maximum Pixel Power (H19).
     *
     * <p>Initial power of the peak scatterer, expressed in dB. The value is calculated by: (a)
     * converting the Maximum Pixel Power to decibels (dB), with the maximum value constrained to
     * 255.999, a minimum value of –255.999, and a smallest non-zero value of 0.001.
     *
     * <p>This field is mandatory.
     *
     * @return the maximum pixel power in dB, or 0 for no-statement.
     */
    public double getMaximumPixelPower() {
        return maximumPixelPower;
    }

    /**
     * Set the Maximum Pixel Power (H19).
     *
     * <p>Initial power of the peak scatterer, expressed in dB. The value is calculated by: (a)
     * converting the Maximum Pixel Power to decibels (dB), with the maximum value constrained to
     * 255.999, a minimum value of –255.999, and a smallest non-zero value of 0.001.
     *
     * <p>This field is mandatory.
     *
     * @param power the maximum pixel power in dB, or 0 for no-statement.
     */
    public void setMaximumPixelPower(double power) {
        this.maximumPixelPower = power;
    }

    /**
     * Maximum RCS (H20).
     *
     * <p>RCS of the peak scatterer, expressed in half-decibels (dB/2). The value is calculated by:
     * (a) converting the Maximum RCS to decibels (dB), with the maximum absolute value constrained
     * to 63.75 dB; (b) multiplying that value by 2; and (c) rounding to the nearest integer.
     *
     * <p>This field is optional.
     *
     * @return the Radar Cross Section in dB/2.
     */
    public Integer getMaximumRadarCrossSection() {
        return maximumRadarCrossSection;
    }

    /**
     * Set the Maximum RCS (H20).
     *
     * <p>RCS of the peak scatterer, expressed in half-decibels (dB/2). The value is calculated by:
     * (a) converting the Maximum RCS to decibels (dB), with the maximum absolute value constrained
     * to 63.75 dB; (b) multiplying that value by 2; and (c) rounding to the nearest integer.
     *
     * <p>This field is optional.
     *
     * @param rcs the Radar Cross Section in dB/2.
     */
    public void setMaximumRadarCrossSection(Integer rcs) {
        this.maximumRadarCrossSection = rcs;
    }

    /**
     * Range of Origin (H21).
     *
     * <p>When the RDM does not correlate to a single MTI report index or when the centre range bin
     * does not correlate to the centre of the dwell; provide the range sample offset in meters from
     * Dwell Centre (positive is away from the sensor) of the first scatterer record.
     *
     * <p>This field is conditional. It must be used in conjunction with the Oversized HRR Chip and
     * RDM Chip data types, and is is optional for all other HRR/RDM data types.
     *
     * @return the range of origin in metres, in the range -32768 to 32767.
     */
    public Integer getRangeOfOrigin() {
        return rangeOfOrigin;
    }

    /**
     * Set the Range of Origin (H21).
     *
     * <p>When the RDM does not correlate to a single MTI report index or when the centre range bin
     * does not correlate to the centre of the dwell; provide the range sample offset in meters from
     * Dwell Centre (positive is away from the sensor) of the first scatterer record.
     *
     * <p>This field is conditional. It must be used in conjunction with the Oversized HRR Chip and
     * RDM Chip data types, and is is optional for all other HRR/RDM data types.
     *
     * @param range the range of origin in metres, in the range -32768 to 32767.
     */
    public void setRangeOfOrigin(Integer range) {
        this.rangeOfOrigin = range;
    }

    /**
     * Doppler of Origin (H22).
     *
     * <p>When the RDM does not correlate to a single MTI report index or the Centre Doppler bin
     * does not correlate to the Doppler centroid of the dwell; Doppler sample value in Hz of the
     * first scatterer record.
     *
     * <p>This field is conditional. It must be used in conjunction with Oversized HRR Chip and RDM
     * Chip data types, and is is optional for all other HRR/RDM data types.
     *
     * @return the Doppler value in Hz, in the range +/- 0.000001 to 32767.
     */
    public Double getDopplerOfOrigin() {
        return dopplerOfOrigin;
    }

    /**
     * Set the Doppler of Origin (H22).
     *
     * <p>When the RDM does not correlate to a single MTI report index or the Centre Doppler bin
     * does not correlate to the Doppler centroid of the dwell; Doppler sample value in Hz of the
     * first scatterer record.
     *
     * <p>This field is conditional. It must be used in conjunction with Oversized HRR Chip and RDM
     * Chip data types, and is is optional for all other HRR/RDM data types.
     *
     * @param doppler the Doppler value in Hz, in the range +/- 0.000001 to 32767.
     */
    public void setDopplerOfOrigin(Double doppler) {
        this.dopplerOfOrigin = doppler;
    }

    /**
     * Type of HRR/RDM (H23).
     *
     * <p>An enumeration field which designates the type of data being delivered.
     *
     * @return the HRR/RDM data type as an enumerated value.
     */
    public TypeOfHrrRdm getTypeOfHrrRdm() {
        return typeOfHrrRdm;
    }

    /**
     * Set the type of HRR/RDM (H23).
     *
     * <p>An enumeration field which designates the type of data being delivered.
     *
     * @param dataType the HRR/RDM data type as an enumerated value.
     */
    public void setTypeOfHrrRdm(TypeOfHrrRdm dataType) {
        this.typeOfHrrRdm = dataType;
    }

    /**
     * Processing Mask (H24).
     *
     * <p>A flag field to indicate the additional signal processing techniques applied to the data.
     * As no motion data is provided on a pulse basis, it is generally assumed that range processing
     * and motion compensation have been applied when necessary.
     *
     * <p>This field is mandatory.
     *
     * @return the processing mask
     */
    public ProcessingMask getProcessingMask() {
        return processingMask;
    }

    /**
     * Set the Processing Mask (H24).
     *
     * <p>A flag field to indicate the additional signal processing techniques applied to the data.
     * As no motion data is provided on a pulse basis, it is generally assumed that range processing
     * and motion compensation have been applied when necessary.
     *
     * <p>This field is mandatory.
     *
     * @param mask the processing mask
     */
    public void setProcessingMask(ProcessingMask mask) {
        this.processingMask = mask;
    }

    /**
     * Number of Bytes – Magnitude (H25).
     *
     * <p>This field shall be used to indicate the number of bytes to be used for the magnitude data
     * in the scatterer record.
     *
     * <p>This field is mandatory.
     *
     * @return the number of bytes for the magnitude data (1 or 2)
     */
    public int getNumBytesMagnititude() {
        return numBytesMagnititude;
    }

    /**
     * Set the Number of Bytes – Magnitude (H25).
     *
     * <p>This field shall be used to indicate the number of bytes to be used for the magnitude data
     * in the scatterer record.
     *
     * <p>This field is mandatory.
     *
     * @param numBytes the number of bytes for the magnitude data (1 or 2)
     */
    public void setNumBytesMagnititude(final int numBytes) {
        this.numBytesMagnititude = numBytes;
    }

    /**
     * Number of Bytes – Phase (H26).
     *
     * <p>This field shall be used to indicate the number of bytes to be used for the phase data in
     * the scatterer record. Only values of 0, 1 or 2 are allowed.
     *
     * <p>This field is mandatory.
     *
     * @return the number of bytes for the phase data.
     */
    public int getNumBytesPhase() {
        return numBytesPhase;
    }

    /**
     * Set the Number of Bytes – Phase (H26).
     *
     * <p>This field shall be used to indicate the number of bytes to be used for the phase data in
     * the scatterer record. Only values of 0, 1 or 2 are allowed.
     *
     * <p>This field is mandatory.
     *
     * @param numBytes the number of bytes for the phase data.
     */
    public void setNumBytesPhase(final int numBytes) {
        this.numBytesPhase = numBytes;
    }

    /**
     * Range Extent in Pixels (H27).
     *
     * <p>Number of pixels in the range dimension of the chip.
     *
     * <p>This field is optional.
     *
     * @return the range extent in pixels (0 to 255).
     */
    public Integer getRangeExtentInPixels() {
        return rangeExtentInPixels;
    }

    /**
     * Set the Range Extent in Pixels (H27).
     *
     * <p>Number of pixels in the range dimension of the chip.
     *
     * <p>This field is optional.
     *
     * @param pixels the range extent in pixels (0 to 255).
     */
    public void setRangeExtentInPixels(Integer pixels) {
        this.rangeExtentInPixels = pixels;
    }

    /**
     * Range To Nearest Edge In Chip (H28).
     *
     * <p>Distance from Range Bin to closest edge in the entire chip, expressed in centimetres.
     *
     * <p>This field is optional.
     *
     * @return the range in centimetres;
     */
    public Long getRangeToNearestEdgeInChip() {
        return rangeToNearestEdgeInChip;
    }

    /**
     * Set the Range To Nearest Edge In Chip (H28).
     *
     * <p>Distance from Range Bin to closest edge in the entire chip, expressed in centimetres.
     *
     * <p>This field is optional.
     *
     * @param range the range in centimetres;
     */
    public void setRangeToNearestEdgeInChip(Long range) {
        this.rangeToNearestEdgeInChip = range;
    }

    /**
     * Index Of Zero Velocity Bin (H29).
     *
     * <p>Relative velocity to skin line. This field shall be masked out if field H23 indicates a
     * 1-D HRR Profile.
     *
     * <p>This field is optional.
     *
     * @return the index of the zero velocity bin.
     */
    public Integer getIndexOfZeroVelocityBin() {
        return indexOfZeroVelocityBin;
    }

    /**
     * Set the Index Of Zero Velocity Bin (H29).
     *
     * <p>Relative velocity to skin line. This field shall be masked out if field H23 indicates a
     * 1-D HRR Profile.
     *
     * <p>This field is optional.
     *
     * @param index the index of the zero velocity bin.
     */
    public void setIndexOfZeroVelocityBin(Integer index) {
        this.indexOfZeroVelocityBin = index;
    }

    /**
     * Target Radial Electrical Length (H30).
     *
     * <p>Computed object length based upon HRR profile. This field shall be set to a value of "0"
     * if HRR is not performed.
     *
     * <p>This field is optional.
     *
     * @return the target radial electrical length in metres, or 0 for no HRR.
     */
    public Double getTargetRadialElectricalLength() {
        return targetRadialElectricalLength;
    }

    /**
     * Set the Target Radial Electrical Length (H30).
     *
     * <p>Computed object length based upon HRR profile. This field shall be set to a value of "0"
     * if HRR is not performed.
     *
     * <p>This field is optional.
     *
     * @param length the target radial electrical length in metres, or 0 for no HRR.
     */
    public void setTargetRadialElectricalLength(Double length) {
        this.targetRadialElectricalLength = length;
    }

    /**
     * Electrical Length Uncertainty (H31).
     *
     * <p>The standard deviation of estimate of the object length, expressed in meters.
     *
     * <p>This field is optional.
     *
     * @return the standard deviation of the length, in metres.
     */
    public Double getElectricalLengthUncertainty() {
        return electricalLengthUncertainty;
    }

    /**
     * Set the Electrical Length Uncertainty (H31).
     *
     * <p>The standard deviation of estimate of the object length, expressed in meters.
     *
     * <p>This field is optional.
     *
     * @param uncertainty the standard deviation of the length, in metres.
     */
    public void setElectricalLengthUncertainty(Double uncertainty) {
        this.electricalLengthUncertainty = uncertainty;
    }

    /**
     * HRR Scatterer Records.
     *
     * <p>A Scatterer Set is an array of Scatterer Records for each target pixel that exceeds the
     * target detection threshold. Alternatively, a complete range-Doppler map, regardless of
     * threshold, may be sent without respective range/Doppler indices for each scatterer. A set of
     * HRR/Range-Doppler Scatterer Records shall be transmitted for the associated MTI target (HRR
     * only) and shall be sent for each dwell processed.
     *
     * <p>Scatterer records within the record shall be ordered in range order (For example: all
     * Doppler samples at range 1 then all Doppler samples at range 2....) starting at near range.
     * Doppler samples shall be arranged sequentially from negative to positive Doppler. Hence the
     * origin is the scatterer at the nearest range and least Doppler value. In the case of
     * Range-Pulse data the origin would be the first pulse. The Phase of each scatterer is
     * optional.
     *
     * @return the scatterer records as a list.
     */
    public List<ScattererRecord> getScattererRecords() {
        return new ArrayList<>(scattererRecords);
    }

    /**
     * Add a HRR Scatterer Record.
     *
     * <p>A Scatterer Set is an array of Scatterer Records for each target pixel that exceeds the
     * target detection threshold. Alternatively, a complete range-Doppler map, regardless of
     * threshold, may be sent without respective range/Doppler indices for each scatterer. A set of
     * HRR/Range-Doppler Scatterer Records shall be transmitted for the associated MTI target (HRR
     * only) and shall be sent for each dwell processed.
     *
     * <p>Scatterer records within the record shall be ordered in range order (For example: all
     * Doppler samples at range 1 then all Doppler samples at range 2....) starting at near range.
     * Doppler samples shall be arranged sequentially from negative to positive Doppler. Hence the
     * origin is the scatterer at the nearest range and least Doppler value. In the case of
     * Range-Pulse data the origin would be the first pulse. The Phase of each scatterer is
     * optional.
     *
     * @param record the scatterer record to append.
     */
    public void addScattererRecord(ScattererRecord record) {
        scattererRecords.add(record);
    }
}
