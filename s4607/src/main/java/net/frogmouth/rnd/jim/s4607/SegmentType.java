package net.frogmouth.rnd.jim.s4607;

public enum SegmentType {
    Unknown(0, "Unknown"),
    MissionSegment(1, "Mission Segment"),
    DwellSegment(2, "Dwell Segment"),
    HRRSegment(3, "HRR Segment"),
    JobDefinitionSegment(5, "Job Definition Segment"),
    FreeTextSegment(6, "Free Text Segment"),
    LowReflectivityIndexSegment(7, "Low Reflectivity Index Segment"),
    GroupSegment(8, "Group Segment"),
    AttachedTargetSegment(9, "Attached Target Segment"),
    TestAndStatusSegment(10, "Test and Status Segment"),
    SystemSpecificSegment(11, "System-Specific Segment"),
    ProcessingHistorySegment(12, "Processing History Segment"),
    PlatformLocationSegment(13, "Platform Location Segment"),
    ReservedForNewSegments(100, "Reserved for new Segments"),
    JobRequestSegment(101, "Job Request Segment"),
    JobAcknowledgementSegment(102, "Job Acknowledge Segment"),
    ReservedForFutureUse(127, "Reserved for future use"),
    ReservedForExtensions(255, "Reserved for extensions");

    SegmentType(int key, String displayLabel) {
        this.tag = key;
        this.displayLabel = displayLabel;
    }

    private final int tag;
    private final String displayLabel;

    public int getTag() {
        return tag;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public static SegmentType lookupByIdent(int identifier) {
        for (SegmentType segmentType : SegmentType.values()) {
            if (identifier == segmentType.getTag()) {
                return segmentType;
            }
        }
        if ((identifier >= 14) && (identifier <= 100)) {
            return ReservedForNewSegments;
        }
        if ((identifier >= 103) && (identifier <= 127)) {
            return ReservedForFutureUse;
        }
        if ((identifier >= 128) && (identifier <= 255)) {
            return ReservedForExtensions;
        }
        return null;
    }
}
