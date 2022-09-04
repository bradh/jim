package net.frogmouth.rnd.jim.s4676;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Processed Track.
 *
 * <p>The ProcessedTrack class records when one or more tracks (referenced via their UIDs/LIDs) are
 * processed to create a single output track that subsumes the input tracks. There are currently
 * only two ProcessedTrackType (“FUSED” and “SMOOTHED”).
 *
 * <p>This class can also be used to invalidate previously-reported track processes (for example, if
 * the tracker decides – based on some new information – that a previously- reported fused track
 * should not have included track 15 because that track is now moving independently). To do so, the
 * data producer must report a ProcessedTrack with the same UUID as the now-invalid ProcessedTrack,
 * along with an appropriate new confidence value (for example, a confidence value of 0, and a
 * confidence validity of FALSE). There is no need to repeat the LIDs or UUIDs of the tracks
 * involved in the previously-reported ProcessedTrack. This feature can only be used if the data
 * producer utilizes LIDs or UUIDs in the ProcessedTrack class.
 *
 * <p>Regardless, of how it is specified (UID/LID), at least one input and one output must be
 * included.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "confidence", "inputUID", "inputLID", "outputUID", "outputLID"})
public class ProcessedTrack extends IdentifiedElement {

    // TODO: ProcessedTrackType : type
    // TODO:     "confidence",
    // TODO:  "inputUID",
    // TODO: "inputLID",
    // TODO: "outputUID",
    // TODO: "outputLID",

}
