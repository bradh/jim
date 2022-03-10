package net.frogmouth.rnd.jim.s4607.processinghistory;

import java.util.HashMap;
import java.util.Map;

/** Flag values for Processing Performed (C6.6). */
public enum ProcessingPerformedFlag {
    /** No Processing or Filtering. */
    NoProcessingOrFiltering(0x0000, "No Processing or Filtering", "No Processing or Filtering."),
    /**
     * Area Filtering.
     *
     * <p>Elimination of target reports that are outside an area of interest or to delete targets
     * within an area of exclusion.
     */
    AreaFiltering(
            0x0001,
            "Area Filtering",
            "Elimination of target reports that are outside an area of interest or to delete"
                    + " targets within an area of exclusion."),
    /**
     * Target Classification Filtering.
     *
     * <p>Elimination of target reports based on reported target classification or Target
     * Classification Uncertainty.
     */
    TargetClassificationFiltering(
            0x0002,
            "Target Classification Filtering",
            "Elimination of target reports based on reported target classification or"
                    + " Target Classification Uncertainty."),
    /**
     * LOS Velocity Filtering.
     *
     * <p>Elimination of target reports based on reported target LOS Velocity, such as target
     * velocity direction, elimination of high-speed targets, or elimination of low-speed targets.
     */
    LOSVelocityFiltering(
            0x0004,
            "LOS Velocity Filtering",
            "Elimination of target reports based on reported target LOS Velocity, such as"
                    + " target velocity direction, elimination of high-speed targets, or"
                    + " elimination of low-speed targets."),
    /**
     * SNR Filtering.
     *
     * <p>Elimination of target reports based on reported Target Signal to Noise Ratio (SNR).
     */
    SNRFiltering(
            0x0008,
            "SNR Filtering",
            "Elimination of target reports based on reported Target Signal to Noise Ratio (SNR)."),
    /**
     * De-clutter Filtering.
     *
     * <p>Elimination of target reports based on processing algorithms to reduce false target
     * reports. This filtering may eliminate targets based on reported LOS Velocity, SNR and other
     * data sources such as DFAD (coastal wave returns).
     */
    DeclutterFiltering(
            0x0010,
            "De-clutter Filtering",
            "Elimination of target reports based on processing algorithms to reduce false target"
                    + " reports. This filtering may eliminate targets based on reported LOS"
                    + " Velocity, SNR and other data sources such as DFAD (coastal wave returns)."),
    /**
     * Bandwidth Filtering.
     *
     * <p>Elimination of Dwell Segment fields or Target Report fields for transmission bandwidth
     * limitations, or receiving system exploitation.
     */
    BandwidthFiltering(
            0x0020,
            "Bandwidth Filtering",
            "Elimination of Dwell Segment fields or Target Report fields for transmission bandwidth"
                    + " limitations, or receiving system exploitation."),
    /**
     * Revisit Filtering.
     *
     * <p>Elimination of Dwell Segments with Target reports associated with an entire visit. This
     * will effectively change the revisit rate of the radar service.
     */
    RevisitFiltering(
            0x0040,
            "Revisit Filtering",
            "Elimination of Dwell Segments with Target reports associated with an entire visit."
                    + " This will effectively change the revisit rate of the radar service."),
    /**
     * Location Adjustment.
     *
     * <p>Adjustment of all reported Target Latitude, Target Longitudes, and Target Heights, based
     * on other data for some targets (e.g., beacons, Link16 PPLI Reports, survey data on fixed
     * rotators, etc.).
     */
    LocationAdjustment(
            0x0080,
            "Location Adjustment",
            "Adjustment of all reported Target Latitude, Target Longitudes, and Target Heights,"
                    + " based on other data for some targets (e.g., beacons, Link16 PPLI Reports,"
                    + " survey data on fixed rotators, etc.)."),
    /**
     * Geoid Adjustment.
     *
     * <p>Adjustment of all reported Target Latitudes, Target Longitudes, and Target Heights based
     * on the use of geoid elevation data.
     */
    GeoidAdjustment(
            0x0100,
            "Geoid Adjustment",
            "Adjustment of all reported Target Latitudes, Target Longitudes, and Target Heights"
                    + " based on the use of geoid elevation data."),
    /**
     * Location Registration.
     *
     * <p>Adjustment of all reported Target Latitudes and Target Longitudes in order to register
     * targets onto road networks or to register reported data to registered locations.
     */
    LocationRegistration(
            0x0200,
            "Location Registration",
            "Adjustment of all reported Target Latitudes and Target Longitudes in order to"
                    + " register targets onto road networks or to register reported data"
                    + " to registered locations."),
    /**
     * Time Filtering.
     *
     * <p>Elimination of dwells and targets that are outside a defined time window. This allows
     * editing of a job or mission to provide a segment of a job or mission that shows some relevant
     * event.
     */
    TimeFiltering(
            0x0400,
            "Time Filtering",
            "Elimination of dwells and targets that are outside a defined time window. This"
                    + " allows editing of a job or mission to provide a segment of a job or"
                    + " mission that shows some relevant event."),
    /**
     * Security Filtering.
     *
     * <p>The elimination of certain fields to lower the classification level of the data or to
     * enable release of the data to other nations.
     */
    SecurityFiltering(
            0x0800,
            "Security Filtering",
            "The elimination of certain fields to lower the classification level of the"
                    + " data or to enable release of the data to other nations."),

    /**
     * Data Augmentation.
     *
     * <p>The addition of data from a sensor receiving station to the data received from the sensor
     * platform to merge the data with other data, such as mission planning or job definition data.
     */
    DataAugmentation(
            0x1000,
            "Data Augmentation",
            "The addition of data from a sensor receiving station to the data received from"
                    + " the sensor platform to merge the data with other data, such as"
                    + " mission planning or job definition data."),
    /**
     * Target Coordinate Conversion.
     *
     * <p>Conversion of target coordinates from sensor range-azimuth into latitude-longitude
     * coordinates. The Job Definition segment will specify the geoid (J27) and elevation (J28)
     * models used during the coordinate conversion.
     */
    TargetCoordinateConversion(
            0x2000,
            "Target Coordinate Conversion",
            "Conversion of target coordinates from sensor range-azimuth into latitude-longitude"
                    + " coordinates. The Job Definition segment will specify the geoid (J27) and"
                    + " elevation (J28) models used during the coordinate conversion."),
    /**
     * Reserved (0x4000).
     *
     * <p>This value is reserved, and should not be used.
     */
    Reserved0x4000(0x4000, "Reserved (0x4000)", "Reserved - not valid."),
    /**
     * Reserved (0x8000).
     *
     * <p>This value is reserved, and should not be used.
     */
    Reserved0x8000(0x8000, "Reserved (0x8000)", "Reserved - not valid.");

    private final int flagValue;
    private final String label;
    private final String description;

    private ProcessingPerformedFlag(int flagValue, String label, String description) {
        this.flagValue = flagValue;
        this.label = label;
        this.description = description;
    }

    private static final Map<Integer, ProcessingPerformedFlag> lookupTable = new HashMap<>();

    static {
        for (ProcessingPerformedFlag c : values()) {
            lookupTable.put(c.flagValue, c);
        }
    }

    /**
     * Get the flag value.
     *
     * @return the encoded value of the flag.
     */
    public int getFlagValue() {
        return flagValue;
    }

    /**
     * Get the flag label.
     *
     * @return the human-readable display value for the flag.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get the flag description.
     *
     * @return the human-readable description for the flag.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the processing performed flag corresponding to this encoded value.
     *
     * @param value the encoded value
     * @return the corresponding enumeration value
     * @throws IllegalArgumentException if the encoded value is not valid
     */
    public static ProcessingPerformedFlag lookupValue(int value) {
        if (lookupTable.containsKey(value)) {
            return lookupTable.get(value);
        }
        throw new IllegalArgumentException("Invalid Mode Status Flag encoded value: " + value);
    }
}
