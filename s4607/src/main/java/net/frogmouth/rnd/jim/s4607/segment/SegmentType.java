package net.frogmouth.rnd.jim.s4607.segment;

/**
 * Segment Type.
 *
 * <p>This represents a segment type, which is part of the {@link SegmentHeader} and identifies the
 * Segment that follows.
 *
 * <p>Not every value in this enumeration has a corresponding definition within the library, because
 * of lack of definition within AEDP-7 (and also implementation limitations).
 */
public enum SegmentType {
    /**
     * Unknown.
     *
     * <p>The Segment Type is unknown. This does not correspond to a valid segment type and should
     * not be created.
     */
    Unknown(0, "Unknown"),
    /**
     * Mission Segment.
     *
     * <p>This segment type is encoded as 1.
     */
    MissionSegment(1, "Mission Segment"),
    /**
     * Dwell Segment.
     *
     * <p>This segment type is encoded as 2.
     */
    DwellSegment(2, "Dwell Segment"),
    /**
     * High-Range Resolution (HRR) Segment.
     *
     * <p>This segment type is encoded as 3.
     *
     * <p>Also used for High Range Resolution Range Doppler Maps (RDM).
     */
    HRRSegment(3, "HRR Segment"),
    /**
     * Reserved.
     *
     * <p>This segment type is encoded as 4.
     *
     * <p>The meaning of this segment is not defined.
     */
    Reserved(4, "Reserved"),
    /**
     * Job Definition Segment.
     *
     * <p>This segment type is encoded as 5.
     */
    JobDefinitionSegment(5, "Job Definition Segment"),
    /**
     * Free Text Segment.
     *
     * <p>This segment type is encoded as 6.
     */
    FreeTextSegment(6, "Free Text Segment"),
    /**
     * Low Reflectivity Index Segment.
     *
     * <p>This segment type is encoded as 7.
     *
     * <p>This segment type is reserved for future definition.
     */
    LowReflectivityIndexSegment(7, "Low Reflectivity Index Segment"),
    /**
     * Group Segment.
     *
     * <p>This segment type is encoded as 8.
     *
     * <p>This segment type is reserved for future definition.
     */
    GroupSegment(8, "Group Segment"),
    /**
     * Attached Target Segment.
     *
     * <p>This segment type is encoded as 9.
     *
     * <p>This segment type is reserved for future definition.
     */
    AttachedTargetSegment(9, "Attached Target Segment"),
    /**
     * Test and Status Segment.
     *
     * <p>This segment type is encoded as 10.
     */
    TestAndStatusSegment(10, "Test and Status Segment"),
    /**
     * System-Specific Segment.
     *
     * <p>This segment type is encoded as 11.
     *
     * <p>This segment type is reserved for future definition.
     */
    SystemSpecificSegment(11, "System-Specific Segment"),
    /**
     * Processing History Segment.
     *
     * <p>This segment type is encoded as 12.
     */
    ProcessingHistorySegment(12, "Processing History Segment"),
    /**
     * Platform Location Segment.
     *
     * <p>This segment type is encoded as 13.
     */
    PlatformLocationSegment(13, "Platform Location Segment"),
    /**
     * Reserved for new segments.
     *
     * <p>The range 14-100 is reserved for new segment types. These are mapped to 100 internally.
     */
    ReservedForNewSegments(100, "Reserved for new Segments"),
    /**
     * Job Request Segment.
     *
     * <p>This segment type is encoded as 101.
     */
    JobRequestSegment(101, "Job Request Segment"),
    /**
     * Job Acknowledge Segment.
     *
     * <p>This segment type is encoded as 102.
     */
    JobAcknowledgeSegment(102, "Job Acknowledge Segment"),
    /**
     * Reserved for future use.
     *
     * <p>The range 103-127 is reserved for future use. These are mapped to 127 internally.
     */
    ReservedForFutureUse(127, "Reserved for future use"),
    /**
     * Reserved for extensions.
     *
     * <p>The range 128-255 is reserved for extensions. These are mapped to 255 internally.
     */
    ReservedForExtensions(255, "Reserved for extensions");

    private SegmentType(int key, String displayLabel) {
        this.tag = key;
        this.displayLabel = displayLabel;
    }

    private final int tag;
    private final String displayLabel;

    /**
     * Get the identifier tag value.
     *
     * <p>This is the integer identifier used to encode the segment type in the Segment Header.
     *
     * @return integer value (in the range 0-255) representing the segment type.
     */
    public int getTag() {
        return tag;
    }

    /**
     * Get a human readable display name for this segment type.
     *
     * @return short string containing a human-readable / displayable value for the segment type.
     */
    public String getDisplayLabel() {
        return displayLabel;
    }

    /**
     * Look up a segment type value by identifier.
     *
     * @param identifier the integer identifier for the value type.
     * @return segment type corresponding to the integer identifier.
     */
    public static SegmentType lookupByIdent(int identifier) {
        if ((identifier >= 14) && (identifier <= 100)) {
            return ReservedForNewSegments;
        }
        if ((identifier >= 103) && (identifier <= 127)) {
            return ReservedForFutureUse;
        }
        if ((identifier >= 128) && (identifier <= 255)) {
            return ReservedForExtensions;
        }
        for (SegmentType segmentType : SegmentType.values()) {
            if (identifier == segmentType.getTag()) {
                return segmentType;
            }
        }
        return Unknown;
    }
}
