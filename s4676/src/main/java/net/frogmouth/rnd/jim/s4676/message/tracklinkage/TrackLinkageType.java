package net.frogmouth.rnd.jim.s4676.message.tracklinkage;

/**
 * Track Linkage Type.
 *
 * <p>The type of the linkage relationship being documented.
 */
public enum TrackLinkageType implements ITrackLinkageType {
    /**
     * Merge.
     *
     * <p>Two or more tracks are hypothesized to merge into a single track.
     *
     * <p>If the output track is indistinguishable from one of the input tracks (for example, a
     * motorcycle drives up and into the trailer of a tractor trailer), then one of the pre-linkage
     * track UIDs/LIDs may be the same as one of the post-relationship track UIDs/LIDs.
     */
    MERGE,

    /**
     * Split.
     *
     * <p>A single track is hypothesized to split into two separate tracks.
     *
     * <p>If the tracked object that exists before the split looks indistinguishable from one of the
     * tracks that exists after the split, both of these tracks can be given the same UID/LID. For
     * example, this would be the case in which a motorcycle drives off a moving semi-tractor
     * trailer.
     */
    SPLIT,

    /**
     * Stitch.
     *
     * <p>Two or more tracks that do not overlap in time are hypothesized to be the same mover.
     *
     * <p>This relationship may be used to describe tracks generated from different modalities, as
     * long as the tracks do not overlap in time (for example, an EO track terminates and a radar
     * track begins shortly thereafter). If the tracks do overlap in time, then the producer should
     * use the FUSED ProcessedTrack (even if the tracks were generated from a sensor of the same
     * modality).
     */
    STITCH
}
